/**
 * Classe do ponto matematico
 * 
 * @author
 * MA4B
 * Julio Cesar Barboza - RA00297586
 * Lucas Costa Pessoa Graziano - RA00297851
 * Gustavo Scacchetti - RA00301499
 * @version 09/08/2022
 */
public class Ponto {
    private double x;
    private double y;
    /**
     * seta ps valores x e y como 0 (ponto 0,0)
     */
    public Ponto() {
        setX(0);
        setY(0);
    }
    /**
     * @param p pega os valores x e y de p
     */
    public Ponto(Ponto p) {
        setX(p.getX());
        setY(p.getY());
    }
    /**
     * @param x define o x do ponto
     * @param y define o y do ponto
     */
    public Ponto(double x, double y) {
        setX(x);
        setY(y);
    }
    
    
    /**
     * @return retorna o valor de x
     */
    public double getX() {
        return x;
    }
    /**
     * @param x seta o valor de x
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * @return retorna o valor de y
     */
    public double getY() {
        return y;
    }
    /**
     * @param y seta o valor de y
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Calcula a distancia entre o ponto que vem como parametro
     * 
     * @param p ponto externo
     * 
     * @return d double valor da distancia
     * 
     */
    public double calcularDistancia(Ponto p) {
        
        double d = Math.sqrt(Math.pow(p.getY()-getY(), 2) + Math.pow(p.getX()-getX(), 2));
        
        return(d);
    
    }

    /**
     * retorna os valores x e y como string
     */
    @Override
    public String toString() {
        return "Ponto [" + getX() + ", " + getY() +  "]";
    }
}
