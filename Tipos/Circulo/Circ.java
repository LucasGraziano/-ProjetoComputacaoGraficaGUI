package Tipos.Circulo;

import Tipos.Ponto.Ponto;

/**
 * classe do circulo matematico 
 * 
 * @author
 * MA4B
 * Julio Cesar Barboza - RA00297586
 * Lucas Costa Pessoa Graziano - RA00297851
 * Gustavo Scacchetti - RA00301499
 * @version 09/08/2022
 */
public class Circ {
    // Atributos da reta
    private Ponto p1, p2;

    /**
     * Construtor dos objetos da classe Circ
     * @param x - coordenada do x
     * @param y - coordenada do y
     */
    public Circ(double x1, double y1, double x2, double y2) {
        setP1(new Ponto(x1, y1));
        setP2(new Ponto(x2, y2));

    }
    
    /**
     * 
     * @param p - ponto
     */
    public Circ(Ponto p1, Ponto p2) {
        setP1(p1);
        setP2(p2);
    }
    
    /**
     * 
     * @param c - seta o ponto do circulo
     */
    public Circ (Circ c){
        setP1(c.getP1());
        setP2(c.getP2());
    }


    /**
     * 
     * @param p - ponto
     */
    public void setP1(Ponto p1){
        this.p1 = p1;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto getP1(){
        return this.p1;
    }


    /**
     * 
     * @param p - ponto
     */
    public void setP2(Ponto p2){
        this.p2 = p2;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto getP2(){
        return this.p2;
    }
}
    

