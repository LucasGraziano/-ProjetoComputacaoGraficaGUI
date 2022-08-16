public class Retangulo {
    // Atributos da reta
    private Ponto p1, p2, p3, p4;

    /**
     * Construtor dos objetos da classe Retangulo
     * @param x1 - coordenada x do primeiro ponto
     * @param y1 - coordenada y do primeiro ponto
     * @param x2 - coordenada x do segundo ponto
     * @param y2 - coordenada y do segundo ponto
     */
    public Retangulo(double x1, double y1, double x2, double y2) {
        setP1(new Ponto(x1, y1)); //primeiro ponto (vertice inferior esquerdo)
        setP2(new Ponto(x2, y2)); //segundo ponto (vertice superior direito)
        setP3 (new Ponto (x1, y2)); //essa coordenada representa o vertice superior esquerdo
        setP4 (new Ponto (x2, y1)); //essa coordenada representa o vertice inferior direito  
    }
    

    public Retangulo(RetanguloGr p2d) {
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
     * @param p - ponto
     */
    public void setP2(Ponto p2){
        this.p2 = p2;
    }

    public void setP4(Ponto p3) {
        this.p3 = p3;
    }

    public void setP3(Ponto p4) {
        this.p4 = p4;
    }
    
    public Ponto getP1() {
        return this.p1;
    }


    public Ponto getP2() {
        return this.p2;
    }


    public Ponto getP3() {
        return this.p3;
    }


    public Ponto getP4() {
        return this.p4;
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

}