 

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe do ponto grafico
 * 
 * @author
 * MA4B
 * Julio Cesar Barboza - RA00297586
 * Lucas Costa Pessoa Graziano - RA00297851
 * Gustavo Scacchetti - RA00301499
 * @version 09/08/2022
 */
public class PontoGr extends Ponto {
    Color corPto = Color.BLACK; // cor do ponto
    String nomePto = ""; // nome do ponto
    Color corNomePto  = Color.BLACK; // cor do nome (string) do ponto  
    int diametro = 1; // diametro do ponto, default = 1

    /**
     * Construtor
     * @param x - coordenada x
     * @param y - coordenada y
     */
    PontoGr(int x, int y){
        super((double)x, (double)y);
        setCorPto(Color.black);     
        setCorNomePto(Color.black);     
        setNomePto("");     
    }

    /**
     * Construtor
     * @param x - coordenada x
     * @param y - coordenada y
     * @param cor - cor do ponto
     */
    /**
     * Constructor
     * @param x - coordenada x
     * @param y - coordenada y
     * @param cor - cor do ponto
     */
    PontoGr(int x, int y, Color cor){
        super((double)x, (double)y);
        setCorPto(cor);     
        setCorNomePto(Color.black);     
        setNomePto("");     
    }

    /**
     * Constroi um ponto na posicao x, y e com os atributos
     * 
     * @param x coordenada x
     * @param y coordenada y
     * @param corPonto corReta do ponto a ser construido
     * @param diametro diametro do ponto
     */
    public PontoGr(int x, int y, Color corPonto, int diametro){
        this(x, y, corPonto);
        setDiametro(diametro);
    }

    /**
     * Constroi um ponto na posicao x, y e com os atributos
     * 
     * @param x coordenada x
     * @param y coordenada y
     * @param corPonto corReta do ponto a ser construido
     * @param nomePonto nome do ponto
     * @param diametro diametro do ponto
     */
    public PontoGr(int x, int y, Color corPonto, String nomePonto, int diametro){
        this(x, y, corPonto, diametro);
        setNomePto(nomePonto);
    }
    

    /**
     * Construtor 
     * 
     * @param x - coordenada do x
     * @param y - c
     * @param cor- cor do ponto
     * @param str - nome do ponto
     */
    PontoGr(int x, int y, Color cor, String str){
        super((double)x, (double)y);
        setCorPto(cor);     
        setCorNomePto(Color.black);     
        setNomePto(str);     
    }

    /**
     * Construtor 
     * 
     * @param cor - cor do ponto
     * @param p2d - p2d
     */
    PontoGr(PontoGr p2d, Color cor){
        super(p2d);     
        setCorPto(cor);     
        setCorNomePto(Color.black);     
        setNomePto("");     
    }

    /**
     * Construtor 
     */
    PontoGr(){
        super();     
        setCorPto(Color.black);     
        setCorNomePto(Color.black);     
        setNomePto("");     
    }


    /**
     * retorna a cor do ponto
     * @return corPto
     */
    public Color getCorPto() {
        return corPto;
    }

    /**
     * define a cor do ponto
     * @param corPto the corPto to set
     */
    public void setCorPto(Color corPto) {
        this.corPto = corPto;
    }

    /**
     * retorna o nome do ponto
     * @return the nomePto
     */
    public String getNomePto() {
        return nomePto;
    }

    /**
     * define o nome do ponto
     * @param nomePto the nomePto to set
     */
    public void setNomePto(String nomePto) {
        this.nomePto = nomePto;
    }

    /**
     * retorna a cor do nome do ponto
     * @return the corNomePto
     */
    public Color getCorNomePto() {
        return corNomePto;
    }

    /**
     * define a cor do nome do ponto
     * @param corNomePto the corNomePto to set
     */
    public void setCorNomePto(Color corNomePto) {
        this.corNomePto = corNomePto;
    }

    /**
     * retorna o diametro
     * @return diametro
     */
    public int getDiametro() {
        return diametro;
    }

    /**
     * define o diametro
     * @param diametro
     */
    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    /**
     * desenha um ponto utilizando o oval 
     * 
     * @param g contexto grafico
     */
    public void desenharPonto(Graphics g){
        // desenha ponto como um oval
        g.setColor(getCorPto());
        g.fillOval((int)getX() -(getDiametro()/2), (int)getY() - (getDiametro()/2), getDiametro(), getDiametro());

        // desenha nome do ponto
        g.setColor(getCorNomePto());
        g.drawString(getNomePto(), (int)getX() + getDiametro(), (int)getY());
    }
}
