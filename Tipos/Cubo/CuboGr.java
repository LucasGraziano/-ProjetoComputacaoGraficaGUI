package Tipos.Cubo;

import java.awt.Color;
import java.awt.Graphics;

import Tipos.Reta.RetaGr;
import Tipos.Ponto.Ponto_3D;


public class CuboGr extends Cubo {

    Color corCubo = Color.BLACK; // cor do ponto
    Color corInicial = Color.BLACK;
    String nomeCubo = ""; // nome do ponto
    Color corNomeCubo  = Color.BLACK; // cor do nome (string) do ponto  
    int diametro = 1; // diametro do ponto, default = 1
    private double x1, y1, z1, aresta;
    
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     */
    public CuboGr(int x1, int y1, int aresta){
        super((double)x1, (double)y1, (double)aresta);
        setCorCubo(Color.black);
        setCorNomeCubo(Color.black);     
        setNomeCubo("");  
        setX1(x1);
        setY1(y1);
        setZ1(0);
        setAresta(aresta);   
    }

    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param cor - cor do Cubo
     */
    public CuboGr(int x1, int y1, int aresta, Color cor){
        super((double)x1, (double)y1, (double)aresta);
        setCorCubo(cor);
        corInicial = cor;
        setCorNomeCubo(Color.black);     
        setNomeCubo("");
        setX1(x1);
        setY1(y1);
        setAresta(aresta);   
    }

    public void resetCor(){
        corCubo = corInicial;
    }


    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param corPonto - cor do Cubo
     * @param diametro - tamanho das bolinhas
     */
    public CuboGr(int x1, int y1, int aresta, Color corPonto, int diametro) {
        this(x1, y1, aresta, corPonto);
        setDiametro(diametro);
        setX1(x1);
        setY1(y1);
        setAresta(aresta);
    }
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param corPonto - cor do Cubo
     * @param nomePonto - nome do Cubo
     * @param diametro - tamanho das bolinhas
     */
    public CuboGr(int x1, int y1, int aresta, Color corPonto, String nomePonto, int diametro){
        this(x1, y1, aresta, corPonto, diametro);
        setNomeCubo(nomePonto);
        setX1(x1);
        setY1(y1);
        setAresta(aresta);
    }
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y- coordenada do y
     * @param cor - cor do Cubo
     * @param str - nome do Cubo
     */
    public CuboGr(int x1, int y1, int aresta, Color cor, String str){
        super((double)x1, (double)y1, (double)aresta);
        setCorCubo(cor);     
        setCorNomeCubo(Color.black);     
        setNomeCubo(str); 
        setX1(x1);
        setY1(y1);
        setAresta(aresta);    
    }

    /**
     * Construtor
     * 
     * @param p2d
     * @param cor - cor do Cubo
     */
    public CuboGr(CuboGr p2d, Color cor){
        super(p2d);     
        setCorCubo(cor);     
        setCorNomeCubo(Color.black);     
        setNomeCubo(""); 
        setX1(x1);
        setY1(y1);
        setAresta(aresta);    
    }

    public void setX1(double x1){
        this.x1 = x1;
    }


    public void setY1(double y1){
        this.y1 = y1;
    }

    public void setZ1(double z1){
        this.z1 = z1;
    }

    public void setAresta(double aresta){
        this.aresta = aresta;
    }


    public double getX1() {
        return this.x1;
    }


    public double getY1() {
        return this.y1;
    }

    public double getZ1() {
        return this.z1;
    }

    public double getAresta() {
        return this.aresta;
    }


    /**
     * @return the corCubo
     */
    public Color getCorCubo() {
        return corCubo;
    }

    /**
     * @param corCubo the corCubo to set
     */
    public void setCorCubo(Color corCubo) {
        this.corCubo = corCubo;
    }

    /**
     * @return the nomeCubo
     */
    public String getNomeCubo() {
        return nomeCubo;
    }

    /**
     * @param nomeCubo the nomeCubo to set
     */
    public void setNomeCubo(String nomeCubo) {
        this.nomeCubo = nomeCubo;
    }

    /**
     * @return the corNomeCubo
     */
    public Color getCorNomeCubo() {
        return corNomeCubo;
    }

    /**
     * @param corNomeCubo the corNomeCubo to set
     */
    public void setCorNomeCubo(Color corNomeCubo) {
        this.corNomeCubo = corNomeCubo;
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
     * Desenha o Cubo
     * 
     * @param g - conteudo gráfico
     * @param x2 - coordenada do raio
     * @param y2 - coordenada do raio
     */
    public void desenharCubo(Graphics g){
        g.setColor(getCorCubo());
        double x1 = getX1(), y1 = getY1(), z1 = getZ1(); // x e y do clique, ponto inicial do cubo (esquerda inferior)
        double aresta = getAresta();
        Cubo cubo = new Cubo(x1, y1, z1);
        Ponto_3D novoPonto = new Ponto_3D();
       
       //Quadrado Frente
       novoPonto.setX(x1);
       novoPonto.setY(y1 + aresta);
       novoPonto.setZ(0);
       cubo.setP2(new Ponto_3D(novoPonto.getX(), novoPonto.getY(), novoPonto.getZ())); //ponto esquerda superior do quadrado inicial

       novoPonto.setX(x1 + aresta);
       novoPonto.setY(y1 + aresta);
       novoPonto.setZ(0);
       cubo.setP3(new Ponto_3D(novoPonto.getX(), novoPonto.getY(), novoPonto.getZ())); //ponto direita superior do quadrado inicial

       novoPonto.setX(x1 + aresta);
       novoPonto.setY(y1);
       novoPonto.setZ(0);
       cubo.setP4(new Ponto_3D(novoPonto.getX(), novoPonto.getY(), novoPonto.getZ())); //ponto direita inferior do quadrado inicial

       //Quadrado Atras

       double dif3D = Math.sin(45) * aresta;

       novoPonto.setX(x1 + dif3D);
       novoPonto.setY(y1 - dif3D);
       novoPonto.setZ(aresta);
       cubo.setP5(new Ponto_3D(novoPonto.getX(), novoPonto.getY(), novoPonto.getZ())); //ponto esquerda inferior do quadrado inicial

       novoPonto.setX(x1 + dif3D);
       novoPonto.setY(y1 + aresta - dif3D);
       novoPonto.setZ(aresta);
       cubo.setP6(new Ponto_3D(novoPonto.getX(), novoPonto.getY(), novoPonto.getZ())); //ponto esquerda superior do quadrado de trás

       novoPonto.setX(x1 + aresta + dif3D);
       novoPonto.setY(y1 + aresta - dif3D);
       novoPonto.setZ(aresta);
       cubo.setP7(new Ponto_3D(novoPonto.getX(), novoPonto.getY(), novoPonto.getZ())); //ponto direita superior do quadrado inicial

       novoPonto.setX(x1 + aresta + dif3D);
       novoPonto.setY(y1 - dif3D);
       novoPonto.setZ(aresta);
       cubo.setP8(new Ponto_3D(novoPonto.getX(), novoPonto.getY(), novoPonto.getZ())); //ponto direita inferior do quadrado inicial


       //Quadrado inicial
       int xp = (int)cubo.getP1().getX(), yp = (int)cubo.getP1().getY();
       int xs = (int)cubo.getP2().getX(), ys = (int)cubo.getP2().getY();
       RetaGr gerarReta = new RetaGr(xp, yp, xs, ys, getCorCubo(), getDiametro());
       gerarReta.desenharReta(g);

       xp = (int)cubo.getP2().getX(); yp = (int)cubo.getP2().getY();
       xs = (int)cubo.getP3().getX(); ys = (int)cubo.getP3().getY();
       RetaGr gerarReta1 = new RetaGr(xp, yp, xs, ys, getCorCubo(), getDiametro());
       gerarReta1.desenharReta(g);

       xp = (int)cubo.getP3().getX(); yp = (int)cubo.getP3().getY();
       xs = (int)cubo.getP4().getX(); ys = (int)cubo.getP4().getY();
       RetaGr gerarReta2 = new RetaGr(xp, yp, xs, ys, getCorCubo(), getDiametro());
       gerarReta2.desenharReta(g);

       RetaGr gerarReta3 = new RetaGr((int)cubo.getP4().getX(), (int)cubo.getP4().getY(), (int)cubo.getP1().getX(), (int)cubo.getP1().getY(), getCorCubo(), getDiametro());
       gerarReta3.desenharReta(g);

       //Ligacão entre os quadrados
       RetaGr gerarReta4 = new RetaGr((int)cubo.getP1().getX(), (int)cubo.getP1().getY(), (int)cubo.getP5().getX(), (int)cubo.getP5().getY(), getCorCubo(), getDiametro());
       gerarReta4.desenharReta(g);

       RetaGr gerarReta5 = new RetaGr((int)cubo.getP2().getX(), (int)cubo.getP2().getY(), (int)cubo.getP6().getX(), (int)cubo.getP6().getY(), getCorCubo(), getDiametro());
       gerarReta5.desenharReta(g);

       RetaGr gerarReta6 = new RetaGr((int)cubo.getP3().getX(), (int)cubo.getP3().getY(), (int)cubo.getP7().getX(), (int)cubo.getP7().getY(), getCorCubo(), getDiametro());
       gerarReta6.desenharReta(g);

       RetaGr gerarReta7 = new RetaGr((int)cubo.getP4().getX(), (int)cubo.getP4().getY(), (int)cubo.getP8().getX(), (int)cubo.getP8().getY(), getCorCubo(), getDiametro());
       gerarReta7.desenharReta(g);

       //Quadrado de trás
       RetaGr gerarReta8 = new RetaGr((int)cubo.getP5().getX(), (int)cubo.getP5().getY(), (int)cubo.getP6().getX(), (int)cubo.getP6().getY(), getCorCubo(), getDiametro());
       gerarReta8.desenharReta(g);

       RetaGr gerarReta9 = new RetaGr((int)cubo.getP6().getX(), (int)cubo.getP6().getY(), (int)cubo.getP7().getX(), (int)cubo.getP7().getY(), getCorCubo(), getDiametro());
       gerarReta9.desenharReta(g);

       RetaGr gerarReta10 = new RetaGr((int)cubo.getP7().getX(), (int)cubo.getP7().getY(), (int)cubo.getP8().getX(), (int)cubo.getP8().getY(), getCorCubo(), getDiametro());
       gerarReta10.desenharReta(g);

       RetaGr gerarReta11 = new RetaGr((int)cubo.getP8().getX(), (int)cubo.getP8().getY(), (int)cubo.getP5().getX(), (int)cubo.getP5().getY(), getCorCubo(), getDiametro());
       gerarReta11.desenharReta(g);
        

    }



    /**
     * Desenha o Cubo
     * 
     * @param g - conteudo gráfico
     * @param x2 - coordenada do raio
     * @param y2 - coordenada do raio
     */
     /*
    public boolean CuboSelect(Ponto p){
        
    }
    */
}