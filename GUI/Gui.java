package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

import ED.Armazenamento;



/**
 * Classe Gui
 * 
 */

public class Gui extends JFrame {
    TiposPrimitivos tipo = TiposPrimitivos.NENHUM;

    //Local de armazenamento de totas as formas
    Armazenamento arm = new Armazenamento();
    

    // mensagens
    JPanel barraSul = new JPanel();
    
    
    private JLabel msg = new JLabel("Msg: ");
    private JLabel info = new JLabel();
    
    //botoes
    private JButton jbPontos = new JButton("Pontos");
    private JButton jbReta = new JButton("Reta");
    private JButton jbCirc = new JButton("Circulo");
    private JButton jbRetangulo = new JButton("Retangulo");
    private JButton jbPoligono = new JButton("Poligono");
    private JButton jbLinhaPoligonal = new JButton("LinhaPoligonal");
    private JButton jbCubo = new JButton("Cubo");
    private JButton jbCor = new JButton("Cor");
    private JButton jbCarregar = new JButton("Carregar");
    private JButton jbLimpar = new JButton("Limpar");
    private JButton jbSelecionar = new JButton("Selecionar");
    private JButton jbTranslacao = new JButton("Translacao");
    private JButton jbRotacao = new JButton("Rotacao"); 
    private JButton jbEscala = new JButton("Escala"); 
    private JButton jbApagar = new JButton("Apagar");
    private JButton jbSalvar = new JButton("Salvar");
    private JButton jbLer = new JButton("Ler");
    

    
    
    //implementacao da barra de deslize
    static final int sMin = 0;
    static final int sMax = 30;
    static final int sInicial = 15;
    Color currentColor = Color.BLACK;
    int valorEsp;
    private JSlider espessura = new JSlider(JSlider.HORIZONTAL, sMin, sMax, sInicial);
    
    

    // barra de menu
    private JToolBar barraComandos = new JToolBar();
    
    // Painel de desenho
    private PainelDesenho areaDesenho = new PainelDesenho(msg, tipo, arm);
    

    
    
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
        //Coloca cor de fundo branco
        getContentPane().setBackground(Color.white);
        
 
        setSize(larg, alt);
        setVisible(true);
        setResizable(false);
        barraSul.setLayout(new BorderLayout());

        // Adicionando os componentes
        adicionarBotoes();
        add(barraComandos, BorderLayout.NORTH);                
        add(areaDesenho, BorderLayout.CENTER);      
        add(barraSul, BorderLayout.SOUTH);          
        barraSul.add(msg, BorderLayout.WEST);
        barraSul.add(info, BorderLayout.EAST);
        
    

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
        jbLinhaPoligonal.addActionListener(eventos);
        jbCubo.addActionListener(eventos);
        jbCor.addActionListener(eventos);
        jbCarregar.addActionListener(eventos);
        jbLimpar.addActionListener(eventos);
        jbSelecionar.addActionListener(eventos);
        jbSalvar.addActionListener(eventos);
        jbLer.addActionListener(eventos);
        jbTranslacao.addActionListener(eventos);
        jbRotacao.addActionListener(eventos);
        jbEscala.addActionListener(eventos);
        jbApagar.addActionListener(eventos);
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
        barraComandos.add(jbLinhaPoligonal);
        barraComandos.add(jbCubo);
        barraComandos.add(jbCor);
        barraComandos.add(jbCarregar);
        barraComandos.add(jbSelecionar);
        barraComandos.add(jbTranslacao);
        barraComandos.add(jbRotacao);
        barraComandos.add(jbEscala); 
        barraComandos.add(jbApagar);
        barraComandos.add(jbSalvar);
        barraComandos.add(jbLer); 
        barraComandos.add(jbLimpar);
        barraComandos.add(espessura); 
          
    }
    

    
    private class Eventos implements ActionListener, ChangeListener{
        TiposPrimitivos tipo;
        
        /**
         * construtor responsavel pela espessura
         */
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

            }else if(event.getSource() == jbRetangulo) { // fazer retangulo
                tipo = TiposPrimitivos.RETANGULO;

            }  else if(event.getSource() == jbPoligono) { // fazer poligono
                tipo = TiposPrimitivos.POLIGONO;
                
            } else if(event.getSource() == jbLinhaPoligonal) { // fazer linha poligonal
                tipo = TiposPrimitivos.LINHAPOLIGONAL;

            } else if(event.getSource() == jbCubo) { // fazer cubo
                tipo = TiposPrimitivos.CUBO;
                JFrame f = new JFrame();
                String c = JOptionPane.showInputDialog(f,"Tamanho da aresta:");
                areaDesenho.setAresta(Double.parseDouble(c));

            }else if(event.getSource() == jbCor) {  // mudar a cor
                tipo = TiposPrimitivos.COR;

            }else if(event.getSource() == jbSelecionar) { //selecionar um primitivo
                tipo = TiposPrimitivos.SELECIONAR;


            }else if(event.getSource() == jbTranslacao) { //translacao nos primitivos
                tipo = TiposPrimitivos.TRANSLACAO;
                JFrame f = new JFrame();
                String xT = JOptionPane.showInputDialog(f,"Enter X");
                String yT = JOptionPane.showInputDialog(f,"Enter Y");
                areaDesenho.PainelTranslacao(Double.parseDouble(xT), Double.parseDouble(yT));
                //repaint();
                
            }
            else if(event.getSource() == jbRotacao) { //rotacao nos prmitivos
                tipo = TiposPrimitivos.ROTACAO;
                JFrame f = new JFrame();
                String g = JOptionPane.showInputDialog(f,"Enter Graus");
                areaDesenho.PainelRotacao(Double.parseDouble(g));

            }else if(event.getSource() == jbEscala) { //rotacao nos prmitivos
                tipo = TiposPrimitivos.ROTACAO;
                JFrame f = new JFrame();
                String e = JOptionPane.showInputDialog(f,"Enter Multiplicador de Escala");
                areaDesenho.PainelEscala(Double.parseDouble(e));

            }
            else if(event.getSource() == jbApagar) { //apagar prmitivos
                tipo = TiposPrimitivos.CARREGAR;
                areaDesenho.ApagarFormas();
                repaint();

            } else if(event.getSource() == jbCarregar) { //carregar
                tipo = TiposPrimitivos.CARREGAR;
                repaint();
            }
            else if(event.getSource() == jbSalvar) { //salvar
                tipo = TiposPrimitivos.SALVAR;
                repaint();
            }
            else if(event.getSource() == jbLer) { //ler
                tipo = TiposPrimitivos.LER;
                repaint();
            } 
            else if(event.getSource() == jbLimpar) { //limpar a tela
                tipo = TiposPrimitivos.NENHUM;
                repaint();

            }  


            // Enviando a Forma a ser desenhada e a cor da linha
            areaDesenho.setTipo(tipo);


        }

        
    } 


    
}
