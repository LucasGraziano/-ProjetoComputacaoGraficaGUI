
/**
 * Classe da Reta Matematica
 * 
 * @author
 * MA4B
 * Julio Cesar Barboza - RA00297586
 * Lucas Costa Pessoa Graziano - RA00297851
 * Gustavo Scacchetti - RA00301499
 * @version 09/08/2022
 */
public class Reta {
 
    // Atributos da reta
    private Ponto p1, p2;

   
    /**
     * @param x1 - coordenada x1
     * @param x2 - coordenada x2
     * @param y1 - coordenada y1
     * @param y2 - coordenada y2
     */
    public Reta(double x1, double y1, double x2, double y2) {
        setP1(new Ponto(x1, y1));
        setP2(new Ponto(x2, y2));
    }
    
    /**
     * construtor de objetos da classe Reta
     * 
     * @param p1 - ponto 1
     * @param p2 -  ponto 2
     */
    public Reta(Ponto p1, Ponto p2) {
        setP1(p1);
        setP2(p2);

    }
    
    /**
     * construtor de objetos da classe Reta
     * 
     * @param r - reta
     */
    public Reta (Reta r){
        setP1(r.getP1());
        setP2(r.getP2());
    }

    /**
     * 
     * @param p - ponto 1
     */
    public void setP1(Ponto p){
        this.p1 = p;
    }
    
    /**
     * 
     * @param p - ponto 2
     */
    public void setP2(Ponto p){
        this.p2 = p;
    }
    
    /**
     * 
     * @param p - ponto 1
     */
    public Ponto getP1(){
        return this.p1;
    }
    
    /**
     * 
     * @param p - ponto 2
     */
    public Ponto getP2(){
        return this.p2;
    }

    /**
     * 
     * @param Dy - delta y
     * @param Dx - delta x
     */
    public double calcularM(double Dy, double Dx){
        // m = (y2-y1)/(x2-x1)
        double m = (getP2().getY() - getP1().getY())/(getP2().getX() - getP1().getX());
        return m;
    }

    /**
     * 
     * @param m - coeficiente 
     */
     public double calcularB(double m){
        //b = y1 - mx1
        double b = getP1().getY() - m * getP1().getX();
        return b;
    }
    
    
    /**
     * Method toString
     *
     * @return s - String
     */
    public String toString(){
        String s = "P1: " + getP1().toString() + " P2: " + getP2().toString();
        //s = s + "\nEq. da reta: y = " + calcularM() + "*x + " + calcularB();
        return s;
    }
   
}
