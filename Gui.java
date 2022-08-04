
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class Gui extends JFrame {
    TiposPrimitivos tipo = TiposPrimitivos.NENHUM;

    // mensagens
    private JLabel msg = new JLabel("Msg: ");
    
    //botoes
    private JButton jbPontos = new JButton("Pontos");
    private JButton jbReta = new JButton("Reta");

    //USO PARA O FUTURO
    //private JButton jbCirc = new JButton("Ciculo");
    //private JButton jbLetras = new JButton("Letras");
    

    // barra de menu
    private JToolBar barraComandos = new JToolBar();
    
    // Painel de desenho
    private PainelDesenho areaDesenho = new PainelDesenho(msg, tipo);
    
    public Gui(int larg, int alt) {
        /**
         * Definicoes de janela
         */
        super("Testa Primitivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        setVisible(true);

        // Adicionando os componentes
        adicionarBotoes();
        add(barraComandos, BorderLayout.NORTH);                
        add(areaDesenho, BorderLayout.CENTER);                
        add(msg, BorderLayout.SOUTH);

        //eventos dos botoes
        Eventos eventos = new Eventos();
        jbPontos.addActionListener(eventos);
        jbReta.addActionListener(eventos);
        
        //BOTOES PARA O FUTURO
        //jbCirc.addActionListener(eventos);
        //jbLetras.addActionListener(eventos);
    }

    /**
     * adiciona os botoes na toolbar
     */
    public void adicionarBotoes(){

        //adiciona os botoes na toolbar
        barraComandos.add(jbPontos);
        barraComandos.add(jbReta);

        //COMANDO PARA O FUTURO
        //barraComandos.add(jbCirc);
        //barraComandos.add(jbLetras);
    }
    
    private class Eventos implements ActionListener{

        TiposPrimitivos tipo;
        
        public void actionPerformed(ActionEvent event) {            

            if (event.getSource() == jbPontos){
                tipo = TiposPrimitivos.PONTOS;

            } else if(event.getSource() == jbReta) {
                tipo = TiposPrimitivos.RETAS;
            }            

            // Enviando a Forma a ser desenhada e a cor da linha
            areaDesenho.setTipo( tipo );
        }
    } 
}
