
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Escreva a descrição da classe PainelDesenho aqui.
 * 
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JLabel msg;
    TiposPrimitivos tipo;
    int divisoes;
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
  
    public void mousePressed(MouseEvent e) {
        // ao clicar com o mouse, pegara o x1 e o y1
        primeiraVez = false;
        xMouse = e.getX();
        yMouse = e.getY();
        Graphics g = getGraphics();
        paint(g); 
    }

    public void mouseReleased(MouseEvent e) {
        // quando o botao do mouse for solto, pegara o x2 e o y2
            //primeiraVez = false;
            xMouse2 = e.getX();
            yMouse2 = e.getY();
            //Graphics g = getGraphics();
            //paint(g);
    }

    public void mouseClicked(MouseEvent e) {
        this.msg.setText("CLICOU: " + e.getButton());
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        this.msg.setText("(" + e.getX() + ", " + e.getY() + ")");

    }

    public void mouseMoved(MouseEvent e) {

        this.msg.setText("(" + e.getX() + ", " + e.getY() + ")");
        // System.out.println("("+e.getX() + ", " + e.getY() + ")");

    }

    /**
     * Desenha o que for selecionado pelo tipo primitivo
     * @param g - conteudo grafico
     */
    public void desenharPrimitivos(Graphics g) {
        if (tipo == TiposPrimitivos.PONTOS) {
            FiguraPontos.desenharPonto(g, xMouse, yMouse, "p", 20);

        }

        else if (tipo == TiposPrimitivos.RETAS) {
            FiguraPontos.desenharReta(g, xMouse, yMouse, xMouse2, yMouse2, 10);
        
        }
        
        else if (tipo == TiposPrimitivos.CIRCULOS) {
            FiguraPontos.desenharCirc(g, xMouse, yMouse, 5);
        
        }
        
        else if (tipo == TiposPrimitivos.LETRAS) {
            JOptionPane.showMessageDialog(null, "Em Manutencao", "ERRO", JOptionPane.WARNING_MESSAGE);
        
        }
        
        else if (tipo == TiposPrimitivos.NENHUM) {
        }
    }



}
