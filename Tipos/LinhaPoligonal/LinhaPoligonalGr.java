package Tipos.LinhaPoligonal;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Tipos.Ponto.Ponto;
import Tipos.Reta.RetaGr;

/**
 * Classe da Reta Grafica 
 * 
 * @author
 * MA4B
 * Julio Cesar Barboza - RA00297586
 * Lucas Costa Pessoa Graziano - RA00297851
 * Gustavo Scacchetti - RA00301499
 * @version 09/08/2022
 */
public class LinhaPoligonalGr extends LinhaPoligonal {
    
    Color corReta = Color.BLACK; // cor do Reta
    String nomeReta = ""; // nome do Reta
    Color corNomeReta  = Color.BLACK; // cor do nome (string) do Reta  
    int diametro = 1; // diametro do Reta, default = 1

    public ArrayList<RetaGr> retas = new ArrayList<RetaGr>();


    /**
     * Construtor
     * 
     * @param x1 - coordenada do x1
     * @param y1 - coordenada do y1
     * @param x2 - coordenada do x2
     * @param y2 - coordenada do y2
     */
    LinhaPoligonalGr(int x1, int y1, int x2, int  y2){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorReta(Color.black);     
        setCorNomeReta(Color.black);     
        setNomeReta("");     
    }

    /**
     * Construtor
     * 
     * @param x1 - coordenada do x1
     * @param y1 - coordenada do y1
     * @param x2 - coordenada do x2
     * @param y2 - coordenada do y2
     * @param cor - cor da Reta 
     */
    LinhaPoligonalGr(int x1, int y1, int x2, int  y2, Color cor){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorReta(cor);     
        setCorNomeReta(Color.black);     
        setNomeReta("");     
    }

    /**
     * Construtor
     * 
     * @param x1 - coordenada do x1
     * @param y1 - coordenada do y1
     * @param x2 - coordenada do x2
     * @param y2 - coordenada do y2
     * @param corReta corReta do Reta a ser construido
     * @param diametro diametro do Reta
     */
    public LinhaPoligonalGr(int x1, int y1, int x2, int  y2, Color corReta, int diametro){
        this(x1, y1, x2, y2, corReta);
        setDiametro(diametro);
    }

    /**
     * Construtor
     * 
     * @param x1 - coordenada do x1
     * @param y1 - coordenada do y1
     * @param x2 - coordenada do x2
     * @param y2 - coordenada do y2
     * @param corReta - corReta do Reta a ser construido
     * @param nomeReta - nome dos pontos da reta
     * @param diametro diametro do Reta
     */
    public LinhaPoligonalGr(int x1, int y1, int x2, int  y2, Color corReta, String nomeReta, int diametro){
        this(x1, y1, x2, y2, corReta, diametro);
        setNomeReta(nomeReta);
    }

    /**
     * Construtor
     * 
     * @param x1 - coordenada do x1
     * @param y1 - coordenada do y1
     * @param x2 - coordenada do x2
     * @param y2 - coordenada do y2
     * @param cor - cor da reta
     * @param str - nome dos pontos da reta
     */
    LinhaPoligonalGr(int x1, int y1, int x2, int  y2, Color cor, String str){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorReta(cor);     
        setCorNomeReta(Color.black);     
        setNomeReta(str);     
    }


    /**
     * retorna a cor da reta
     * @return the corReta
     */
    public Color getCorReta() {
        return corReta;
    }

    /**
     * define a cor da reta
     * @param corReta the corReta to set
     */
    public void setCorReta(Color corReta) {
        this.corReta = corReta;
    }

    /**
     * retorna o nome da reta
     * @return the nomeReta
     */
    public String getNomeReta() {
        return nomeReta;
    }

    /**
     * define o nome da reta
     * @param nomeReta the nomeReta to set
     */
    public void setNomeReta(String nomeReta) {
        this.nomeReta = nomeReta;
    }

    /**
     *retorna a cor do nome da reta
     * @return the corNomeReta
     */
    public Color getCorNomeReta() {
        return corNomeReta;
    }

    /**
     * define a cor do nome da reta
     * @param corNomeReta the corNomeReta to set
     */
    public void setCorNomeReta(Color corNomeReta) {
        this.corNomeReta = corNomeReta;
    }

    /**
     * retorna o diametro
     * @return the diametro
     */
    public int getDiametro() {
        return diametro;
    }

    /**
     * define o diametro 
     * @param diametro the diametro to set
     */
    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }


    public void desenharLinhaPoligonal(Graphics g){
        for(RetaGr reta : retas){
            reta.setCorReta(corReta);
            reta.desenharReta(g);
        }
    }
    
    public void adicionarReta(Graphics g, Ponto p1, Ponto p2){
        RetaGr reta_aux = new RetaGr((int) p1.getX(),(int) p1.getY(),(int)  p2.getX(),(int)  p2.getY(), corReta, "", diametro);
        retas.add(reta_aux);
        desenharLinhaPoligonal(g);
    }

    public boolean linhaPoligonalSelect(Ponto p){
        for(RetaGr reta : retas){
            if(reta.retaSelect(p)){
                return true;
            }
        }

        return false;
    }

    /**
     * desenha um Reta utilizando o oval 
     * 
     * @param g contexto grafico
     * @param cor
     * @param y2
     * @param x2
     * @param y1
     * @param x1
     */
    public void desenharReta(Graphics g, double x1, double y1, double x2, double y2){
        g.setColor(getCorReta());

        
        double Dx=0, Dy=0;// Delta x; Delata y
        double m=0, b=0;// Coeficinete angular; b
        double c1, c2; //Variaveis utilizadas para identificar e armazenar qual delta é maior para realizar o loop de criacao de uma reta mais precisa
        double xMaior=0, xMenor=0, yMaior=0,yMenor=0;
        double x, y;

        //Identifica qual ponto tem o eixo x com maior valor e realiza a conta do delta x
        if(x2 > x1){
            Dx = x2 - x1;
            xMaior = x2;
            xMenor = x1;
        }else if(x2 < x1){
            Dx = x1 - x2;
            xMaior = x1;
            xMenor = x2;
        }

        //Identifica qual ponto tem o eixo y com maior valor e realiza a conta do delta y
        if(y2 >= y1){
            Dy = y2 - y1;
            yMaior = y2;
            yMenor = y1;
        }else if(y2 < y1){
            Dy = y1 - y2;
            yMaior = y1;
            yMenor = y2;
        }
        
        //Identifica qual delta é maior, com intuito de definir qual dos eixos possui maior variação 
        if(Dx > Dy) {
            c1 = xMenor;
            c2 = xMaior;
        }else{
            c1 = yMenor;
            c2 = yMaior;
        } 

        

        //delta x for igual a 0
        if(Dx == 0){
            for(double i = c1; i <= c2; i++){

                g.fillOval((int)x1 -(getDiametro()/2), (int)i - (getDiametro()/2), getDiametro(), getDiametro());
            }
        //delta y for igual a 0
        }else if(Dy == 0){ //Neste caso, a reta será horizontal
            for(double i = c1; i <= c2; i++){

                g.fillOval((int)i -(getDiametro()/2), (int)y1 - (getDiametro()/2), getDiametro(), getDiametro());
            }
        }else{
            m = calcularM(Dy, Dx);
            b = calcularB(m);

            for(double i = c1; i <= c2; i++){
                if(Dx > Dy){
                    y = i*m + b; //equacao reduzida da reta
                    g.fillOval((int)i -(getDiametro()/2), (int)y - (getDiametro()/2), getDiametro(), getDiametro());
                }else{
                    x = (i - b)/m;// equacao reduzida da reta com o x isolado
                    g.fillOval((int)x -(getDiametro()/2), (int)i - (getDiametro()/2), getDiametro(), getDiametro());
                }
            }         
        }
    }
}

