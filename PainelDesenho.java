
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JLabel;

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
    int xMouse, yMouse;// pega as coordenadas quando clicar o botao do mouse
    int xMouse2, yMouse2; // pega as coordenadas quando soltar o botao do mouse
    boolean primeiraVez = true;
    

    /**
     * Construtor do painel desenho
     * 
     * @param msg  - mensagem que sera mostrada na interface
     * @param tipo - Sao os tipos primitivos da funcao
     */
    public PainelDesenho(JLabel msg, TiposPrimitivos tipo) {
        this.tipo = tipo;
        this.msg = msg;
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
        }else{
            primeiraVez = false;
            xMouse = e.getX();
            yMouse = e.getY();
            Graphics g = getGraphics();
            paint(g); 
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

        }
    
        //opcao de desenhar retas
        else if (tipo == TiposPrimitivos.RETAS) {
            FiguraPontos.desenharReta(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp);
        
        }
        
        //opcao de desenhar circulos
        else if (tipo == TiposPrimitivos.CIRCULOS) {
            FiguraPontos.desenharCirc(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp);
        
        }
        //opcao de desenhar Retangulos
        else if (tipo == TiposPrimitivos.RETANGULO) {
            FiguraPontos.desenharRetangulo(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp);
        
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

}
