package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JColorChooser;
import javax.swing.JLabel;

import ED.Armazenamento;
import TrasformacoesGeometricas.Escala;
import TrasformacoesGeometricas.Rotacao;
import TrasformacoesGeometricas.Translacao;

import Tipos.Ponto.*;
import Tipos.Reta.*;
import Tipos.Circulo.*;
import Tipos.Retangulo.*;
import Tipos.Poligono.*;
import Tipos.LinhaPoligonal.*;

/**
 * Classe do painel de desenhos
 * 
 * @author
 *         MA4B
 *         Julio Cesar Barboza - RA00297586
 *         Lucas Costa Pessoa Graziano - RA00297851
 *         Gustavo Scacchetti - RA00301499
 * @version 09/08/2022
 */
public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;
    JLabel msg; // mensagem na interface
    int valorEsp; // espessura
    TiposPrimitivos tipo; // tipos primitivos
    int xMouse, yMouse;// pega as coordenadas quando clicar o botao do mouse
    int xMouse2, yMouse2; // pega as coordenadas quando soltar o botao do mouse
    double aresta; //aresta do cobo
    boolean primeiraVez = true; // verificador de primeiro clique
    Color currentColor = Color.BLACK; // cor
    PontoGr aux2 = new PontoGr();
    boolean primeiroPonto = true; // verificador do primeiro ponto
    int xMouseInicial, yMouseInicial; // coordenadas iniciais do mouse (x,y)
    FiguraPontos fg; // variavel de classe (figura pontos)

    Armazenamento arm; // variavel de classe (armazenador)
    boolean verificar = false; // verificador

    String tipoSelecionado = ""; // tipo da seleção
    int indiceSelecionado = -1; // indice da seleção

    /**
     * Construtor do painel desenho
     * 
     * @param msg  - mensagem que sera mostrada na interface
     * @param tipo - Sao os tipos primitivos da funcao
     */
    public PainelDesenho(JLabel msg, TiposPrimitivos tipo, Armazenamento arm) {
        this.tipo = tipo;
        this.msg = msg;
        this.arm = FiguraPontos.arm;
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

    public void setAresta(double aresta){
        this.aresta = aresta;
    }
    
    public double getAresta() {
        return this.aresta;
    }

    // Capturando os Eventos com o mouse
    /**
     * acao de clicar no botao do mouse
     */
    public void mousePressed(MouseEvent e) {
        // logica da reta, circulo e retangulo. ele captura dois pontos no clique do
        // mouse
        if (tipo == TiposPrimitivos.RETAS || tipo == TiposPrimitivos.CIRCULOS || tipo == TiposPrimitivos.RETANGULO) {
            // primeiro ponto da reta
            if (primeiroPonto == true) {
                xMouseInicial = e.getX(); // coordenada incial x
                yMouseInicial = e.getY(); // coordenada incial y

                // coloca todas as coordenada em uma coordenada
                xMouse = e.getX();
                yMouse = e.getY();
                xMouse2 = e.getX();
                yMouse2 = e.getY();
                primeiroPonto = false;
            } else if (primeiraVez == true) {
                // ao clicar com o mouse, pegara o x1 e o y1
                xMouse = e.getX();
                yMouse = e.getY();
                primeiraVez = false;
            } else {
                xMouse2 = e.getX();
                yMouse2 = e.getY();
                primeiraVez = true;
            }

            // logica do poligono e linha poligonal
        } else if (tipo == TiposPrimitivos.POLIGONO || tipo == TiposPrimitivos.LINHAPOLIGONAL) {

            if (primeiroPonto == true) {
                xMouseInicial = e.getX(); // coordenada incial x
                yMouseInicial = e.getY(); // coordenada incial y
                xMouse = e.getX();
                yMouse = e.getY();
                xMouse2 = e.getX();
                yMouse2 = e.getY();
                primeiroPonto = false;
            } else if (primeiraVez == true) {
                xMouse = xMouse2;
                yMouse = yMouse2;
                xMouse2 = e.getX();
                yMouse2 = e.getY();
                primeiraVez = false;
            } else if (primeiraVez == false) {
                xMouse = xMouse2;
                yMouse = yMouse2;
                xMouse2 = e.getX();
                yMouse2 = e.getY();

            }
            // acao para clicar com o botao direito atrelado com um tipo primitivo
            if (SwingUtilities.isRightMouseButton(e) && tipo == TiposPrimitivos.POLIGONO) {
                xMouse2 = xMouseInicial;
                yMouse2 = yMouseInicial;
                FiguraPontos.poligono_fim = true;
                primeiroPonto = true;
            } else if (SwingUtilities.isRightMouseButton(e) && tipo == TiposPrimitivos.LINHAPOLIGONAL) {
                xMouse2 = xMouse;
                yMouse2 = yMouse;
                FiguraPontos.poligono_fim = true;
                primeiroPonto = true;
            }
        } else if (tipo == TiposPrimitivos.CARREGAR || tipo == TiposPrimitivos.COR) {

        } else if (tipo == TiposPrimitivos.SELECIONAR) {
            xMouse = e.getX();
            yMouse = e.getY();
        } else {
            primeiraVez = false;
            xMouse = e.getX();
            yMouse = e.getY();
        }

        // parte grafica
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
     * 
     * @param g - conteudo grafico
     */
    public void desenharPrimitivos(Graphics g) {
        // opcao de desenhar um botao
        if (tipo == TiposPrimitivos.PONTOS) {

            FiguraPontos.desenharPonto(g, xMouse, yMouse, "p", valorEsp, currentColor);

        }

        // opcao de desenhar retas
        else if (tipo == TiposPrimitivos.RETAS) {
            if (primeiraVez == false)
                FiguraPontos.desenharReta(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp, currentColor);
        }

        // opcao de desenhar circulos
        else if (tipo == TiposPrimitivos.CIRCULOS) {

            FiguraPontos.desenharCirc(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp, currentColor);

        }

        // opcao de desenhar Retangulos
        else if (tipo == TiposPrimitivos.RETANGULO) {

            FiguraPontos.desenharRetangulo(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp, currentColor);

        }

        // opcao de desenhar Poligono
        else if (tipo == TiposPrimitivos.POLIGONO) {

            FiguraPontos.desenharPoligono(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp, currentColor);
        }

        // opcao de desenhar LinhaPoligonal
        else if (tipo == TiposPrimitivos.LINHAPOLIGONAL) {

            FiguraPontos.desenharLinhaPoligonal(g, xMouse, yMouse, xMouse2, yMouse2, valorEsp, currentColor);
        }

        else if (tipo == TiposPrimitivos.CUBO) {

            FiguraPontos.desenharCubo(g, xMouse, yMouse, getAresta(), valorEsp, currentColor);
        }

        // opcao de redesenhar formas
        else if (tipo == TiposPrimitivos.CARREGAR) {
            carregarFormas(g);
        } else if (tipo == TiposPrimitivos.COR) {

            currentColor = JColorChooser.showDialog(null, "Escolha uma cor", currentColor);

        } else if (tipo == TiposPrimitivos.SELECIONAR) {

            SelectFormas(g, xMouse, yMouse);

        } else if (tipo == TiposPrimitivos.SALVAR) {
            PersistenciaArquivos.Persistencia.salvarArquivo();
            //repaint();
        }
        else if (tipo == TiposPrimitivos.LER) {
            PersistenciaArquivos.Persistencia.lerArquivo();
            carregarFormas(g);
            //repaint();
        }
        // opcao de nenhuma seleção
        else if (tipo == TiposPrimitivos.NENHUM) {
            if (verificar == false)
                verificar = true;
            else {
                verificar = false;
            }
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

    /**
     * Redesenha as formas
     * 
     * @param g - parte grafica
     */
    public void carregarFormas(Graphics g) {
        // carrega as formas
        // pega todos os pontos que estão na estrutura de dados
        for (PontoGr forma : arm.ArrayPonto) {
            forma.desenharPonto(g);
        }

        // pega todas as retas que estão na estrutura de dados
        for (RetaGr forma : arm.ArrayReta) {
            forma.desenharReta(g);
        }

        // pega todas os circulos que estão na estrutura de dados
        for (CircGr forma : arm.ArrayCirculo) {
            forma.desenharCirc(g);
        }

        // pega todos os retangulos que estão na estrutura de dados
        for (RetanguloGr forma : arm.ArrayRetangulo) {
            forma.desenharRetangulo(g);
        }

        // pega todos os poligonos que estão na estrutura de dados
        for (PoligonoGr forma : arm.ArrayPoligono) {
            forma.desenharPoligono(g);
        }

        // pega todas as linhas poligonais que estão na estrutura de dados
        for (LinhaPoligonalGr forma : arm.ArrayLinhaPoligonal) {
            forma.desenharLinhaPoligonal(g);
        }

    }

    /**
     * Redesenha as formas
     * 
     * @param g - parte grafica
     * @param x - coordenada de x
     * @param y - coordenada de y
     */
    public void SelectFormas(Graphics g, int x, int y) {

        // ponto que foi clicado
        
        
        Ponto aux = new Ponto(x, y);
        

        
        // seleção do ponto
        for (PontoGr ponto : arm.ArrayPonto) {
            if (ponto.calcularDistancia(aux) < 10) {
                if(indiceSelecionado != -1){
                    deselecionarForma(g);
                }
                tipoSelecionado = "Ponto";
                indiceSelecionado = arm.ArrayPonto.indexOf(ponto);
                ponto.setCorPto(Color.RED);
                ponto.desenharPonto(g);
                this.msg.setText("ACHOU UM PONTO");
                return;
            }
        }

        // seleção da reta
        for (RetaGr reta : arm.ArrayReta) {
            if (reta.retaSelect(aux)) {
                if(indiceSelecionado != -1){
                    deselecionarForma(g);
                }
                tipoSelecionado = "Reta";
                indiceSelecionado = arm.ArrayReta.indexOf(reta);
                reta.setCorReta(Color.RED);
                reta.desenharReta(g);
                this.msg.setText("ACHOU UM RETA!");
                return;
            }
        }

        // seleção da circulo
        for (CircGr circulo : arm.ArrayCirculo) {
            if (circulo.circSelect(aux)) {
                if(indiceSelecionado != -1){
                    deselecionarForma(g);
                }
                tipoSelecionado = "Circulo";
                indiceSelecionado = arm.ArrayCirculo.indexOf(circulo);
                circulo.setCorCirc(Color.RED);
                circulo.desenharCirc(g);
                this.msg.setText("ACHOU UM CIRCULO!");
                return;
            }
        }

        // seleção retangulo
        for (RetanguloGr retangulo : arm.ArrayRetangulo) {

            if (retangulo.retanguloSelect(aux)) {
                if(indiceSelecionado != -1){
                    deselecionarForma(g);
                }
                tipoSelecionado = "Retangulo";
                indiceSelecionado = arm.ArrayRetangulo.indexOf(retangulo);
                retangulo.setCorPto(Color.RED);
                retangulo.desenharRetangulo(g);
                this.msg.setText("ACHOU UM RETANGULO!");
                return;
            }
        }

        // seleção poligono
        for (PoligonoGr poligono : arm.ArrayPoligono) {
            if (poligono.poligonoSelect(aux)) {
                if(indiceSelecionado != -1){
                    deselecionarForma(g);
                }
                tipoSelecionado = "Poligono";
                indiceSelecionado = arm.ArrayPoligono.indexOf(poligono);
                poligono.setCorReta(Color.RED);
                poligono.desenharPoligono(g);
                this.msg.setText("ACHOU UM POLIGONO! " + poligono.getCorReta());
                return;
            }
        }

        // seleção linhaPoligonal
        for (LinhaPoligonalGr linhaPoligonal : arm.ArrayLinhaPoligonal) {
            if (linhaPoligonal.linhaPoligonalSelect(aux)) {
                if(indiceSelecionado != -1){
                    deselecionarForma(g);
                }
                tipoSelecionado = "LinhaPoligonal";
                indiceSelecionado = arm.ArrayLinhaPoligonal.indexOf(linhaPoligonal);
                linhaPoligonal.setCorReta(Color.RED);
                linhaPoligonal.desenharLinhaPoligonal(g);
                this.msg.setText("ACHOU UMA LINHA POLIGONAL!");
                return;
            }
        }

        if(indiceSelecionado != -1){
            deselecionarForma(g);
        }

    }

    /**
     * tira a seleçao da forma
     * @param g - conteudo grafico
     */
    public void deselecionarForma(Graphics g){
        switch (tipoSelecionado) {
            // caso para apagar o objeto ponto
            case "Ponto":
                arm.ArrayPonto.get(indiceSelecionado).resetCor();
                arm.ArrayPonto.get(indiceSelecionado).desenharPonto(g);
                break;
            // caso para apagar o objeto reta
            case "Reta":
                arm.ArrayReta.get(indiceSelecionado).resetCor();
                arm.ArrayReta.get(indiceSelecionado).desenharReta(g);
                break;
            // caso para apagar o objeto circulo
            case "Circulo":
                arm.ArrayCirculo.get(indiceSelecionado).resetCor();
                arm.ArrayCirculo.get(indiceSelecionado).desenharCirc(g);
                break;
            // caso para apagar o objeto retangulo
            case "Retangulo":
                arm.ArrayRetangulo.get(indiceSelecionado).resetCor();
                arm.ArrayRetangulo.get(indiceSelecionado).desenharRetangulo(g);
                break;
            // caso para apagar o objeto poligono
            case "Poligono":
                arm.ArrayPoligono.get(indiceSelecionado).resetCor();
                arm.ArrayPoligono.get(indiceSelecionado).desenharPoligono(g);
                break;
            // caso para apagar o objeto Linha Poligonal
            case "LinhaPoligonal":
                arm.ArrayLinhaPoligonal.get(indiceSelecionado).resetCor();
                arm.ArrayLinhaPoligonal.get(indiceSelecionado).desenharLinhaPoligonal(g);
                break;
        }
        indiceSelecionado = -1;
    }

    /**
     * Redesenha as formas
     * 
     * @param g - parte grafica
     */
    public void ApagarFormas() {

        switch (tipoSelecionado) {
            // caso para apagar o objeto ponto
            case "Ponto":
                arm.indexPonto--;
                arm.ArrayPonto.remove(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto reta
            case "Reta":
                arm.indexReta--;
                arm.ArrayReta.remove(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto circulo
            case "Circulo":
                arm.indexCirculo--;
                arm.ArrayCirculo.remove(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto retangulo
            case "Retangulo":
                arm.indexRetangulo--;
                arm.ArrayRetangulo.remove(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto poligono
            case "Poligono":
                arm.indexPoligono--;
                arm.ArrayPoligono.remove(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto Linha Poligonal
            case "LinhaPoligonal":
                arm.indexLinhaPoligonal--;
                arm.ArrayLinhaPoligonal.remove(indiceSelecionado);
                tipoSelecionado = "";
                break;

        }
    }

    /**
     * Respontavel por fazer a translacao
     * @param xT - coordenada de xT
     * @param yT - coordenada de yT
     */
    public void PainelTranslacao(double xT, double yT) {
        switch (tipoSelecionado) {
            // caso para apagar o objeto ponto
            case "Ponto":
                Translacao p = new Translacao(arm.ArrayPonto.get(indiceSelecionado), xT, yT);
                p.GerarTranslacao();
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto reta
            case "Reta":
                Translacao r = new Translacao(arm.ArrayReta.get(indiceSelecionado), xT, yT);
                r.GerarTranslacao();
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto circulo
            case "Circulo":
                Translacao c = new Translacao(arm.ArrayCirculo.get(indiceSelecionado), xT, yT);
                c.GerarTranslacao();
                arm.ArrayCirculo.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto retangulo
            case "Retangulo":
                Translacao rt = new Translacao(arm.ArrayRetangulo.get(indiceSelecionado), xT, yT);
                rt.GerarTranslacao();
                arm.ArrayRetangulo.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto poligono
            case "Poligono":
                Translacao pl = new Translacao(arm.ArrayPoligono.get(indiceSelecionado), xT, yT);
                pl.GerarTranslacao();
                arm.ArrayPoligono.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto Linha Poligonal
            case "LinhaPoligonal":
                Translacao lp = new Translacao(arm.ArrayLinhaPoligonal.get(indiceSelecionado), xT, yT);
                lp.GerarTranslacao();
                arm.ArrayLinhaPoligonal.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
        }
    }

    /**
     * Responsavel pela rotação
     * @param mult - graus
     */
    public void PainelRotacao(double mult) {
        switch (tipoSelecionado) {
            // caso para apagar o objeto ponto
            case "Ponto":
                Rotacao p = new Rotacao(arm.ArrayPonto.get(indiceSelecionado), mult);
                p.GerarRotacao();
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto reta
            case "Reta":
                Rotacao r = new Rotacao(arm.ArrayReta.get(indiceSelecionado), mult);
                r.GerarRotacao();
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto circulo
            case "Circulo":
                Rotacao c = new Rotacao(arm.ArrayCirculo.get(indiceSelecionado), mult); 
                c.GerarRotacao();
                arm.ArrayCirculo.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto retangulo
            case "Retangulo":
                Rotacao rt = new Rotacao(arm.ArrayRetangulo.get(indiceSelecionado), mult);
                rt.GerarRotacao();
                arm.ArrayRetangulo.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto poligono
            case "Poligono":
                Rotacao pl = new Rotacao(arm.ArrayPoligono.get(indiceSelecionado), mult);
                pl.GerarRotacao();
                arm.ArrayPoligono.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto Linha Poligonal
            case "LinhaPoligonal":
                Rotacao lp = new Rotacao(arm.ArrayLinhaPoligonal.get(indiceSelecionado), mult);
                lp.GerarRotacao();
                arm.ArrayLinhaPoligonal.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
        }
    }

    /**
     * Responsavel por fazer a escala
     * @param mult - multiplicacao
     */
    public void PainelEscala(double mult) {
        switch (tipoSelecionado) {
            // caso para apagar o objeto ponto
            case "Ponto":
                Escala p = new Escala(arm.ArrayPonto.get(indiceSelecionado), mult);
                p.GerarEscala();
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto reta
            case "Reta":
                Escala r = new Escala(arm.ArrayReta.get(indiceSelecionado), mult);
                r.GerarEscala();
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto circulo
            case "Circulo":
                Escala c = new Escala(arm.ArrayCirculo.get(indiceSelecionado), mult);
                c.GerarEscala();
                arm.ArrayCirculo.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto retangulo
            case "Retangulo":
                Escala rt = new Escala(arm.ArrayRetangulo.get(indiceSelecionado), mult);
                rt.GerarEscala();
                arm.ArrayRetangulo.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto poligono
            case "Poligono":
                Escala pl = new Escala(arm.ArrayPoligono.get(indiceSelecionado), mult);
                pl.GerarEscala();
                arm.ArrayPoligono.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
            // caso para apagar o objeto Linha Poligonal
            case "LinhaPoligonal":
                Escala lp = new Escala(arm.ArrayLinhaPoligonal.get(indiceSelecionado), mult);
                lp.GerarEscala();
                arm.ArrayLinhaPoligonal.get(indiceSelecionado);
                tipoSelecionado = "";
                break;
        }
    }

    // setters e getters para pegar a cor
    public Color getCurrentColor() {
        return this.currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

}
