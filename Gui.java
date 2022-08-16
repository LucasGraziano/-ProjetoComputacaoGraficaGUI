
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

/**
 * Classe Gui
 * 
 * @author
 * MA4B
 * Julio Cesar Barboza - RA00297586
 * Lucas Costa Pessoa Graziano - RA00297851
 * Gustavo Scacchetti - RA00301499
 * @version 09/08/2022
 */
class Gui extends JFrame {
    TiposPrimitivos tipo = TiposPrimitivos.NENHUM;
    

    // mensagens
    private JLabel msg = new JLabel("Msg: ");
    
    //botoes
    private JButton jbPontos = new JButton("Pontos");
    private JButton jbReta = new JButton("Reta");
    private JButton jbCirc = new JButton("Circulo");
    private JButton jbRetangulo = new JButton("Retangulo");
    private JButton jbPoligono = new JButton("Poligono");
    private JButton jbCor = new JButton("Cor");
    private JButton jbLimpar = new JButton("Limpar");

    //implementacao da barra de deslize
    static final int sMin = 0;
    static final int sMax = 30;
    static final int sInicial = 15;
    int valorEsp;
    private JSlider espessura = new JSlider(JSlider.HORIZONTAL, sMin, sMax, sInicial);
    
    

    // barra de menu
    private JToolBar barraComandos = new JToolBar();
    
    // Painel de desenho
    private PainelDesenho areaDesenho = new PainelDesenho(msg, tipo);
    

    
    
    /**
     * Construtor da interface grafica
     * 
     * @param larg - largura da interface
     * @param alt - altura da interface
     */
    public Gui(int larg, int alt) {
        /**
         * Definicoes de janela
         */
        super("Testa Primitivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        setVisible(true);
        setResizable(false);

        // Adicionando os componentes
        adicionarBotoes();
        add(barraComandos, BorderLayout.NORTH);                
        add(areaDesenho, BorderLayout.CENTER);                
        add(msg, BorderLayout.SOUTH);

        //eventos dos botoes
        evento();

        //faz as configuracoes do Jslider
        configuracaoEspessura();
        
    }

    /**
     * faz as configuracoes do Jslider
     */
    public void configuracaoEspessura(){

        //set do tickSpacing
        espessura.setMinorTickSpacing(1);
        espessura.setMajorTickSpacing(5);
        espessura.setPaintTicks(true);

        //comeca com a espessura 15
        areaDesenho.setEspessura(15);

        //customizacao do jslider
        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(0, new JLabel("0"));
        labels.put(15, new JLabel("Espessura"));
        labels.put(30, new JLabel("30"));
        espessura.setLabelTable(labels);
        espessura.setPaintLabels(true);

    }

    /**
     * adiciona os eventos dos botoes
     */
    public void evento(){
        //eventos dos botoes
        Eventos eventos = new Eventos();
        jbPontos.addActionListener(eventos);
        jbReta.addActionListener(eventos);
        jbCirc.addActionListener(eventos);
        jbRetangulo.addActionListener(eventos);
        jbPoligono.addActionListener(eventos);
        jbCor.addActionListener(eventos);
        jbLimpar.addActionListener(eventos);
        espessura.addChangeListener((ChangeListener)eventos);
    }
    /**
     * adiciona os botoes na toolbar
     */
    public void adicionarBotoes(){

        //adiciona os botoes na toolbar
        barraComandos.add(jbPontos);
        barraComandos.add(jbReta);
        barraComandos.add(jbCirc);
        barraComandos.add(jbRetangulo);
        barraComandos.add(jbPoligono);
        barraComandos.add(jbCor);
        barraComandos.add(jbLimpar);
        barraComandos.add(espessura);
    }

    

    
    private class Eventos implements ActionListener, ChangeListener{

        
        TiposPrimitivos tipo;
        
        public void stateChanged(ChangeEvent e) {
            valorEsp = espessura.getValue();
            areaDesenho.setEspessura(valorEsp);
        }

        public void actionPerformed(ActionEvent event) {
            
            

            if (event.getSource() == jbPontos){ //fazer pontos 
                tipo = TiposPrimitivos.PONTOS;

            } else if(event.getSource() == jbReta) { //fazer reta
                tipo = TiposPrimitivos.RETAS;
            } else if(event.getSource() == jbCirc) { //fazer circulo
                tipo = TiposPrimitivos.CIRCULOS;
            }else if(event.getSource() == jbRetangulo) { //fazer circulo
                tipo = TiposPrimitivos.RETANGULO;
            }  else if(event.getSource() == jbPoligono) { //fazer circulo
                tipo = TiposPrimitivos.POLIGONO;
            } else if(event.getSource() == jbCor) { //fazer circulo
                tipo = TiposPrimitivos.COR;
            } else if(event.getSource() == jbLimpar) { //limpar a tela
                tipo = TiposPrimitivos.NENHUM;
                repaint();

            } 


            // Enviando a Forma a ser desenhada e a cor da linha
            areaDesenho.setTipo(tipo);
            
            
        }

        
        
    } 
}
