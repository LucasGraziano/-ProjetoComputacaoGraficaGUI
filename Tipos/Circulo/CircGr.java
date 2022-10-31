package Tipos.Circulo;

import java.awt.Color;
import java.awt.Graphics;

import Tipos.Ponto.Ponto;


public class CircGr extends Circ {

    Color corCirc = Color.BLACK; // cor do ponto
    Color corInicial = Color.BLACK;
    String nomeCirc = ""; // nome do ponto
    Color corNomeCirc  = Color.BLACK; // cor do nome (string) do ponto  
    int diametro = 1; // diametro do ponto, default = 1
    private double x1, x2, y1, y2;
    
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     */
    public CircGr(int x1, int y1, int x2, int y2){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorCirc(Color.black);
        setCorNomeCirc(Color.black);     
        setNomeCirc("");  
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);   
    }

    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param cor - cor do circulo
     */
    public CircGr(int x1, int y1, int x2, int y2, Color cor){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorCirc(cor);
        corInicial = cor;
        setCorNomeCirc(Color.black);     
        setNomeCirc("");
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);   
    }

    public void resetCor(){
        corCirc = corInicial;
    }


    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param corPonto - cor do circulo
     * @param diametro - tamanho das bolinhas
     */
    public CircGr(int x1, int y1, int x2, int y2, Color corPonto, int diametro) {
        this(x1, y1, x2, y2, corPonto);
        setDiametro(diametro);
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
    }
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param corPonto - cor do circulo
     * @param nomePonto - nome do circulo
     * @param diametro - tamanho das bolinhas
     */
    public CircGr(int x1, int y1, int x2, int y2, Color corPonto, String nomePonto, int diametro){
        this(x1, y1, x2, y2, corPonto, diametro);
        setNomeCirc(nomePonto);
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
    }
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y- coordenada do y
     * @param cor - cor do circulo
     * @param str - nome do circulo
     */
    public CircGr(int x1, int y1, int x2, int y2, Color cor, String str){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorCirc(cor);     
        setCorNomeCirc(Color.black);     
        setNomeCirc(str); 
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);    
    }

    /**
     * Construtor
     * 
     * @param p2d
     * @param cor - cor do circulo
     */
    public CircGr(CircGr p2d, Color cor){
        super(p2d);     
        setCorCirc(cor);     
        setCorNomeCirc(Color.black);     
        setNomeCirc(""); 
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);    
    }

    public void setX1(double x1){
        this.x1 = x1;
    }

    public void setX2(double x2){
        this.x2 = x2;
    }

    public void setY1(double y1){
        this.y1 = y1;
    }

    public void setY2(double y2){
        this.y2 = y2;
    }

    public double getX1() {
        return this.x1;
    }

    public double getX2() {
        return this.x2;
    }

    public double getY1() {
        return this.y1;
    }

    public double getY2() {
        return this.y2;
    }

    /**
     * @return the corCirc
     */
    public Color getCorCirc() {
        return corCirc;
    }

    /**
     * @param corCirc the corCirc to set
     */
    public void setCorCirc(Color corCirc) {
        this.corCirc = corCirc;
    }

    /**
     * @return the nomeCirc
     */
    public String getNomeCirc() {
        return nomeCirc;
    }

    /**
     * @param nomeCirc the nomeCirc to set
     */
    public void setNomeCirc(String nomeCirc) {
        this.nomeCirc = nomeCirc;
    }

    /**
     * @return the corNomeCirc
     */
    public Color getCorNomeCirc() {
        return corNomeCirc;
    }

    /**
     * @param corNomeCirc the corNomeCirc to set
     */
    public void setCorNomeCirc(Color corNomeCirc) {
        this.corNomeCirc = corNomeCirc;
    }

    /**
     * @return the diametro
     */
    public int getDiametro() {
        return diametro;
    }

    /**
     * @param diametro the diametro to set
     */
    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }
    
    /**
     * Desenha o Circulo
     * 
     * @param g - conteudo gráfico
     * @param x2 - coordenada do raio
     * @param y2 - coordenada do raio
     */
    public void desenharCirc(Graphics g){
        g.setColor(getCorCirc());
        double x = getP1().getX(), y = getP1().getY(); // x e y do clique
        double x2 = getP2().getX(), y2 = getP2().getY(); // x e y do clique
        double ang = 0.0; // angulo a ser incrementado
        double xP = 0, yP = 0; // x e y a serem pintados
        double catAd, catOp; //cateto adjacente e cateto oposto
        double raio = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2) * 1.0); // raio do circulo (distancia entre os pontos dos cliques)
        double dim = raio*2.0; //diametro do circulo
        
        //Esse do-while faz o calculo de todos os pontos do circulo e desenhando com o fillOval
        do{
            //calculo dos pontos angulos do circulo
            catAd = Math.cos(ang) * dim/2.0; 
            catOp = Math.sin(ang) * dim/2.0;
            
            //sao as coordenadas da borda do circulo
            xP = x2 + catAd;
            yP = y2 + catOp;

            //printa os pontos ate completar o circulo
            g.fillOval((int)xP -(getDiametro()/2), (int)yP - (getDiametro()/2), getDiametro(), getDiametro());

            //angulo vai aumentando em 0.01 em 0.01
            ang = ang + 0.01;  //passo 0.01
        }while(ang <= 360.0);
        

    }

    /**
     * Desenha o Circulo
     * 
     * @param g - conteudo gráfico
     * @param x2 - coordenada do raio
     * @param y2 - coordenada do raio
     */
    public boolean circSelect(Ponto p){
        double x = getP1().getX(), y = getP1().getY(); // x e y do clique
        double x2 = getP2().getX(), y2 = getP2().getY(); // x e y do clique
        double ang = 0.0; // angulo a ser incrementado
        double xP = 0, yP = 0; // x e y a serem pintados
        double catAd, catOp; //cateto adjacente e cateto oposto
        double raio = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2) * 1.0); // raio do circulo (distancia entre os pontos dos cliques)
        double dim = raio*2.0; //diametro do circulo
        double xPonto = p.getX(), yPonto = p.getY();
        
        //Esse do-while faz o calculo de todos os pontos do circulo e desenhando com o fillOval
        do{
            //calculo dos pontos angulos do circulo
            catAd = Math.cos(ang) * dim/2.0; 
            catOp = Math.sin(ang) * dim/2.0;
            
            //sao as coordenadas da borda do circulo
            xP = x2 + catAd;
            yP = y2 + catOp;


            double dist = Math.sqrt(((xPonto - xP) * (xPonto - xP)) + ((yPonto - yP) * (yPonto - yP)));
                if(dist <= 10){
                    return true;
                }

            //angulo vai aumentando em 0.01 em 0.01
            ang = ang + 0.01;  //passo 0.01
        }while(ang <= 360.0);
        
        return false;
    }
}
