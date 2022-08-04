
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JLabel;

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
    int xMouse, yMouse;//pega as coordenadas quando clicar o botao do mouse
    int xMouse2, yMouse2; //pega as coordenadas quando soltar o botao do mouse
    boolean primeiraVez = true;

    /**
     * COnstrutor para objetos da classe PainelDesenho
     */
    public PainelDesenho(JLabel msg, TiposPrimitivos tipo)
    {
        this.tipo = tipo;
        this.msg = msg;
        //       this.setBackground(Color.black);
        this.addMouseListener(this); 
        this.addMouseMotionListener(this);

    }
    public void setTipo(TiposPrimitivos tipo){
        this.tipo = tipo;
    }

    public TiposPrimitivos getTipo(){
        return this.tipo;
    }

    public void paintComponent(Graphics g) {   
        if (! primeiraVez) {
            FiguraPontos.desenharPonto(g, xMouse, yMouse, "p", 10);
        }
    }

    // Capturando os Eventos com o mouse
    public void mousePressed(MouseEvent e) { 
        primeiraVez = false;
        xMouse = e.getX();
        yMouse = e.getY();
        Graphics g = getGraphics();  
        paint(g);
    }     

    public void mouseReleased(MouseEvent e) { 

    }           

    public void mouseClicked(MouseEvent e) {
        this.msg.setText("CLICOU: "+e.getButton());
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        this.msg.setText("("+e.getX() + ", " + e.getY() + ")");

    }

    public void mouseMoved(MouseEvent e) {

        this.msg.setText("("+e.getX() + ", " + e.getY() + ")");
        //System.out.println("("+e.getX() + ", " + e.getY() + ")");

    }

    public void desenharPrimitivos(Graphics g){
        if (tipo==TiposPrimitivos.PONTOS){
            // FiguraPontos.desenharPontos(g, 50, 8);

        }

        if (tipo==TiposPrimitivos.RETAS){

        }
        if (tipo==TiposPrimitivos.CIRCULOS){

        }
        if (tipo==TiposPrimitivos.LETRAS){

        }
    }

}
