package GUI;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

import ED.Armazenamento;
import Tipos.Ponto.DoisPontos;
import Tipos.Ponto.Ponto;


/**
 * Classe do painel de desenhos
 * 
 * @author
 * MA4B
 * Julio Cesar Barboza - RA00297586
 * Lucas Costa Pessoa Graziano - RA00297851
 * Gustavo Scacchetti - RA00301499
 * @version 09/08/2022
 */
public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JLabel msg; //mensagem na interface 
    int valorEsp;
    TiposPrimitivos tipo; //tipos priitivos
    int xMouse = 0, yMouse = 0;// pega as coordenadas quando clicar o botao do mouse
    int xMouse2, yMouse2; // pega as coordenadas quando soltar o botao do mouse
    boolean primeiraVez = true;

    boolean primeiroPonto = true;
    int xMouseInicial, yMouseInicial;

    Armazenamento arm;

    /**
     * Construtor do painel desenho
     * 
     * @param msg  - mensagem que sera mostrada na interface
     * @param tipo - Sao os tipos primitivos da funcao
     */
    public PainelDesenho(JLabel msg, TiposPrimitivos tipo, Armazenamento arm) {
        this.tipo = tipo;
        this.msg = msg;
        this.arm = arm;
        this.setBackground(Color.white);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }

    /**
     * 
     * @param tipo - da o set do tipo primitivo
     */
    public void setTipo(TiposPrimitivos tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @return tipo primitivo
     */
    public TiposPrimitivos getTipo() {
        return this.tipo;
    }

    /**
     * @param g - conteudo grafico
     */
    public void paintComponent(Graphics g) {
        if (!primeiraVez) {
            desenharPrimitivos(g);
        }
    }

    // Capturando os Eventos com o mouse
    /**
     * acao de clicar no botao do mouse 
     */
    public void mousePressed(MouseEvent e) {
        // ao clicar com o mouse, pegara o x1 e o y1
        
        
        
        if(tipo == TiposPrimitivos.RETAS || tipo == TiposPrimitivos.CIRCULOS || tipo == TiposPrimitivos.RETANGULO){
            if(primeiraVez == true){
                xMouse = e.getX();
                yMouse = e.getY();
                primeiraVez = false;
            }
            else{
                xMouse2 = e.getX();
                yMouse2 = e.getY();
                primeiraVez = true;
            }
        
        }else if(tipo == TiposPrimitivos.POLIGONO || tipo == TiposPrimitivos.LINHAPOLIGONAL){

            if(primeiroPonto == true){ 
                xMouseInicial = e.getX();//coordenada incial
                yMouseInicial = e.getY();
                xMouse = e.getX();
                yMouse = e.getY();
                xMouse2 = e.getX();
                yMouse2 = e.getY();
                primeiroPonto = false;
            }else if(primeiraVez == true){
                xMouse = xMouse2;
                yMouse = yMouse2;
                xMouse2 = e.getX();
                yMouse2 = e.getY();
                primeiraVez = false;
            }else if(primeiraVez == false){
                xMouse = xMouse2;
                yMouse = yMouse2;
                xMouse2 = e.getX();
                yMouse2 = e.getY();
                
            }
            
            if (SwingUtilities.isRightMouseButton(e) && tipo == TiposPrimitivos.POLIGONO){
                xMouse2 = xMouseInicial;
                yMouse2 = yMouseInicial;
                primeiroPonto = true;
            }
            else if (SwingUtilities.isRightMouseButton(e) && tipo == TiposPrimitivos.LINHAPOLIGONAL){
                xMouse2 = xMouse;
                yMouse2 = yMouse;
                primeiroPonto = true;
            }
        }else if (tipo == TiposPrimitivos.CARREGAR){
            
        }else{
            primeiraVez = false;
            xMouse = e.getX();
            yMouse = e.getY();
        }
        
        
        
        Graphics g = getGraphics();
        paint(g);
        
        
    }

    /** 
     * Acao de soltar o botao do mouse
     */
    public void mouseReleased(MouseEvent e) {
    }
    

    /**
     * Acao de clicar no botao do mouse 
     */
    public void mouseClicked(MouseEvent e) {
        this.msg.setText("CLICOU: " + e.getButton());
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    /**
     * Acao que segura o botao do mouse
     */
    public void mouseDragged(MouseEvent e) {
        this.msg.setText("(" + e.getX() + ", " + e.getY() + ")");

    }

    /**
     * Acao do mouse andando
     */
    public void mouseMoved(MouseEvent e) {

        this.msg.setText("(" + e.getX() + ", " + e.getY() + ")");

    }

    /**
     * Desenha o que for selecionado pelo tipo primitivo
     * @param g - conteudo grafico
     */
    public void desenharPrimitivos(Graphics g) {
        //opcao de desenhar um botao
        if (tipo == TiposPrimitivos.PONTOS) { 
            
            FiguraPontos.desenharPonto(g, xMouse, yMouse, "p", valorEsp);
            arm.setArrayPonto(xMouse, yMouse);
        }
    
        //opcao de desenhar retas
        else if (tipo == TiposPrimitivos.RETAS) {
           
            FiguraPontos.desenharReta(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp);
            arm.setArrayReta(xMouse, yMouse, xMouse2, yMouse2);
        }
        
        //opcao de desenhar circulos
        else if (tipo == TiposPrimitivos.CIRCULOS) {
            arm.setArrayCirculo(xMouse, yMouse, xMouse2, yMouse2);
            FiguraPontos.desenharCirc(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp);
        
        }
        //opcao de desenhar Retangulos
        else if (tipo == TiposPrimitivos.RETANGULO) {
            arm.setArrayRetangulo(xMouse, yMouse, xMouse2, yMouse2);
            FiguraPontos.desenharRetangulo(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp);
        
        }
        //opcao de desenhar Poligono
        else if (tipo == TiposPrimitivos.POLIGONO){
            arm.setArrayPoligono(xMouse, yMouse, xMouse2, yMouse2);
            FiguraPontos.desenharPoligono(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp);
        }
        //opcao de desenhar LinhaPoligonal
        else if (tipo == TiposPrimitivos.LINHAPOLIGONAL){
            arm.setArrayLinhaPoligonal(xMouse, yMouse, xMouse2, yMouse2);
            FiguraPontos.desenharLinhaPoligonal(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp);
        }

        else if (tipo == TiposPrimitivos.CARREGAR){
            carregarFormas(g);
        }
        //opcao de nenhuma seleção
        else if (tipo == TiposPrimitivos.NENHUM) {
        }
    }

    /**
     * 
     * @param valorEsp - espessura
     */
    public void setEspessura(int valorEsp) {
        this.valorEsp = valorEsp;
    }

    /**
     * 
     * @return espessura
     */
    public int getEspessura() {
        return valorEsp;
    }

    public void carregarFormas(Graphics g){
        
        Ponto p;
        DoisPontos p2;

        do{//Desenha todos os pontos
           p = arm.getArrayPonto();
           if(p.getX() != -1){
                int x = ((int)p.getX());
                int y = ((int)p.getY());

                FiguraPontos.desenharPonto(g, x, y, "p", valorEsp);
           }
           
        }while(p.getX() != -1);//Ponto neutro(controle para verificar se chegou no final do array)

        do{//Desenha todas as retas
            p2 = arm.getArrayReta();
           if(p2.getX1() != -1){
                int x1 = ((int)p2.getX1());
                int y1 = ((int)p2.getY1());
                int x2 = ((int)p2.getX2());
                int y2 = ((int)p2.getY2());

                FiguraPontos.desenharReta(g, x1, y1, x2, y2, valorEsp);
           }
        }while(p2.getX1() != -1);//Ponto neutro(controle para verificar se chegou no final do array)

        do{//Desenha todos os circulos
            p2 = arm.getArrayCirculo();
           if(p2.getX1() != -1){
                int x1 = ((int)p2.getX1());
                int y1 = ((int)p2.getY1());
                int x2 = ((int)p2.getX2());
                int y2 = ((int)p2.getY2());

                FiguraPontos.desenharCirc(g, x1, y1, x2, y2, valorEsp);
           }
        }while(p2.getX1() != -1);//Ponto neutro(controle para verificar se chegou no final do array)

        do{//Desenha todos os retangulos
            p2 = arm.getArrayRetangulo();
           if(p2.getX1() != -1){
                int x1 = ((int)p2.getX1());
                int y1 = ((int)p2.getY1());
                int x2 = ((int)p2.getX2());
                int y2 = ((int)p2.getY2());

                FiguraPontos.desenharRetangulo(g, x1, y1, x2, y2, valorEsp);
           }
        }while(p2.getX1() != -1);//Ponto neutro(controle para verificar se chegou no final do array)

        do{//Desenha todos os poligonos
            p2 = arm.getArrayPoligono();
           if(p2.getX1() != -1){
                int x1 = ((int)p2.getX1());
                int y1 = ((int)p2.getY1());
                int x2 = ((int)p2.getX2());
                int y2 = ((int)p2.getY2());

                FiguraPontos.desenharPoligono(g, x1, y1, x2, y2, valorEsp);
           }
        }while(p2.getX1() != -1);//Ponto neutro(controle para verificar se chegou no final do array)

        do{//Desenha todas as linhas poligonais
            p2 = arm.getArrayLinhaPoligonal();
           if(p2.getX1() != -1){
                int x1 = ((int)p2.getX1());
                int y1 = ((int)p2.getY1());
                int x2 = ((int)p2.getX2());
                int y2 = ((int)p2.getY2());

                FiguraPontos.desenharLinhaPoligonal(g, x1, y1, x2, y2, valorEsp);
            }
        }while(p2.getX1() != -1);//Ponto neutro(controle para verificar se chegou no final do array)
    }
}
