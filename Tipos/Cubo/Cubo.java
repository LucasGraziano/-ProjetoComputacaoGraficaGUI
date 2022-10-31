package Tipos.Cubo;
import Tipos.Ponto.Ponto_3D;

/**
 * classe do cubo matematico 
 * 
 */
public class Cubo {
    // Atributos da reta
    private Ponto_3D p1, p2, p3, p4, p5, p6, p7, p8;
    /**
     * Construtor dos objetos da classe Circ
     * @param x - coordenada do x
     * @param y - coordenada do y
     */
    public Cubo(double x1, double y1, double z1) {
        setP1(new Ponto_3D(x1, y1, z1));
        setP2(new Ponto_3D(x1, y1, z1));
        setP3(new Ponto_3D(x1, y1, z1));
        setP4(new Ponto_3D(x1, y1, z1));
        setP5(new Ponto_3D(x1, y1, z1));
        setP6(new Ponto_3D(x1, y1, z1));
        setP7(new Ponto_3D(x1, y1, z1));
        setP8(new Ponto_3D(x1, y1, z1));
    }
    
    /**
     * 
     * @param p - ponto
     */
    public Cubo(Ponto_3D p1) {
        setP1(p1);
        setP2(p1);
        setP3(p1);
        setP4(p1);
        setP5(p1);
        setP6(p1);
        setP7(p1);
        setP8(p1);
    }
    
    /**
     * 
     * @param c - seta o ponto do circulo
     */
    public Cubo (Cubo c){
        setP1(c.getP1());
        setP2(c.getP2());
        setP3(c.getP3());
        setP4(c.getP4());
        setP5(c.getP5());
        setP6(c.getP6());
        setP7(c.getP7());
        setP8(c.getP8());
    }


    /**
     * 
     * @param p - ponto
     */
    public void setP1(Ponto_3D p1){
        this.p1 = p1;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto_3D getP1(){
        return this.p1;
    }

    /**
     * 
     * @param p - ponto
     */
    public void setP2(Ponto_3D p2){
        this.p2 = p2;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto_3D getP2(){
        return this.p2;
    }

    /**
     * 
     * @param p - ponto
     */
    public void setP3(Ponto_3D p3){
        this.p3 = p3;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto_3D getP3(){
        return this.p3;
    }

    /**
     * 
     * @param p - ponto
     */
    public void setP4(Ponto_3D p4){
        this.p4 = p4;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto_3D getP4(){
        return this.p4;
    }

    /**
     * 
     * @param p - ponto
     */
    public void setP5(Ponto_3D p5){
        this.p5 = p5;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto_3D getP5(){
        return this.p5;
    }

    /**
     * 
     * @param p - ponto
     */
    public void setP6(Ponto_3D p6){
        this.p6 = p6;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto_3D getP6(){
        return this.p6;
    }

    /**
     * 
     * @param p - ponto
     */
    public void setP7(Ponto_3D p7){
        this.p7 = p7;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto_3D getP7(){
        return this.p7;
    }

    /**
     * 
     * @param p - ponto
     */
    public void setP8(Ponto_3D p8){
        this.p8 = p8;
    }
    
    /**
     * 
     * @return ponto
     */
    public Ponto_3D getP8(){
        return this.p8;
    }

}