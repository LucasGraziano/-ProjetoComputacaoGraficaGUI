package Tipos.Ponto;
import java.awt.*;

public class DoisPontos {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private Color cor;
    private String nome;
    private int espessura;
    /**
     * seta os valores x e y como 0 (ponto 0,0)
     */
    public DoisPontos() {
        setX1(0);
        setY1(0);
        setX2(0);
        setY2(0);
    }
    /**
     * @param p pega os valores x e y de p
     */
    public DoisPontos(DoisPontos p) {
        setX1(p.getX1());
        setY1(p.getY1());
        setX2(p.getX2());
        setY2(p.getY2());
    }
    /**
     * @param x define o x do ponto
     * @param y define o y do ponto
     */
    public DoisPontos(double x1, double y1, double x2, double y2) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
    }
    /**
     * @param x1 define o x do primeiro ponto
     * @param y1 define o y do primeiro ponto
     * @param x2 define o x do segundo ponto
     * @param y2 define o y do segundo ponto
     * @param cor define a cor dos pontos
     * @param espessura define a espessura dos pontos
     */
    public DoisPontos(double x1, double y1, double x2, double y2, Color cor, int espessura) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setCor(cor);
        setEspessura(espessura);
    }
    
    
    /**
     * @return retorna o valor de x
     */
    public double getX1() {
        return x1;
    }
    /**
     * @param x seta o valor de x
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }
    /**
     * @return retorna o valor de y
     */
    public double getY1() {
        return y1;
    }
    /**
     * @param y seta o valor de y
     */
    public void setY1(double y1) {
        this.y1 = y1;
    }

     /**
     * @return retorna o valor de x
     */
    public double getX2() {
        return x2;
    }
    /**
     * @param x seta o valor de x
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }
    /**
     * @return retorna o valor de y
     */
    public double getY2() {
        return y2;
    }
    /**
     * @param y seta o valor de y
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }
    /**
     * @param cor seta a cor
     */
    public void setCor(Color cor){
        this.cor = cor;
    }
    /**
     * @param cor retorna a cor
     */
    public Color getCor(){
        return this.cor;
    }
    /**
     * @param nome seta o nome
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    /**
     * @param nome retorna o nome
     */
    public String getNome(){
        return nome;
    }
    /**
     * @param espessura seta a espessura
     */
    public void setEspessura(int espessura){
        this.espessura = espessura;
    }
    /**
     * @param espessura retorna a espessura
     */
    public int getEspessura(){
        return espessura;
    }

}
