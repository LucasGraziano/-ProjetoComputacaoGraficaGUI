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
    private Ponto p;

    /**
     * Construtor dos objetos da classe Circ
     * @param x - coordenada do x
     * @param y - coordenada do y
     */
    public Circ(double x, double y) {
        setP(new Ponto(x, y));

    }
    
    /**
     * 
     * @param p - ponto
     */
    public Circ(Ponto p) {
        setP(p);
    }
    
    /**
     * 
     * @param c - seta o ponto do circulo
     */
    public Circ (Circ c){
        setP(c.getP());
    }

    /**
     * 
     * @param p - ponto
     */
    public void setP(Ponto p){
        this.p = p;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto getP(){
        return this.p;
    }
}
    

