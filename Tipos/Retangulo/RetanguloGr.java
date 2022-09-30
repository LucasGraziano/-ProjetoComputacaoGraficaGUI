package Tipos.Retangulo;
import java.awt.Color;
import java.awt.Graphics;
import Tipos.Ponto.Ponto;



public class RetanguloGr extends Retangulo {

    Color corPto = Color.BLACK; // cor do ponto
    String nomePto = ""; // nome do ponto
    Color corNomePto  = Color.BLACK; // cor do nome (string) do ponto  
    int diametro = 1; // diametro do ponto, default = 1
    private double x1, x2, y1, y2;
    
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     */
    public RetanguloGr(int x1, int y1, int x2, int  y2){
        super((double)x1, (double)y1, (double)x2, (double)y2);    
        setCorNomePto(Color.black);     
        setNomePto(""); 
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
     * @param cor - cor do Retangulo
     */
    public RetanguloGr(int x1, int y1, int x2, int  y2, Color cor){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorPto(cor);     
        setCorNomePto(cor);     
        setNomePto("");
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
     * @param corPonto - cor do Retangulo
     * @param diametro - tamanho das bolinhas
     */
    public RetanguloGr(int x1, int y1, int x2, int  y2, Color corPonto, int diametro) {
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
     * @param corPonto - cor do Retangulo
     * @param nomePonto - nome do Retangulo
     * @param diametro - tamanho dos desenhos
     */
    public RetanguloGr(int x1, int y1, int x2, int  y2, Color corPonto, String nomePonto, int diametro){
        this(x1, y1, x2, y2, corPonto, diametro);
        setNomePto(nomePonto);
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
     * @param cor - cor do Retangulo
     * @param str - nome do Retangulo
     */
    public RetanguloGr(int x1, int y1, int x2, int  y2, Color cor, String str){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorPto(cor);     
        setCorNomePto(cor);     
        setNomePto(str);
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);       
    }

    /**
     * Construtor
     * 
     * @param p2d
     * @param cor - cor do Retangulo
     */
    public RetanguloGr(RetanguloGr p2d, Color cor){
        super(p2d);     
        setCorPto(cor);     
        setCorNomePto(cor);     
        setNomePto(""); 
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
     * @return the corPto
     */
    public Color getCorPto() {
        return corPto;
    }

    /**
     * @param corPto the corPto to set
     */
    public void setCorPto(Color corPto) {
        this.corPto = corPto;
    }

    /**
     * @return the nomePto
     */
    public String getNomePto() {
        return nomePto;
    }

    /**
     * @param nomePto the nomePto to set
     */
    public void setNomePto(String nomePto) {
        this.nomePto = nomePto;
    }

    /**
     * @return the corNomePto
     */
    public Color setCorNomePto() {
        return corNomePto;
    }

    /**
     * @param corNomePto the corNomePto to set
     */
    public void setCorNomePto(Color corNomePto) {
        this.corNomePto = corNomePto;
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
     * Desenha o Retangulo
     * 
     * @param g - conteudo gráfico
     * 
     */
    public void desenharRetangulo(Graphics g){
        g.setColor(getCorPto());
        double x1 = getP1().getX(), x2 = getP2().getX(), y1 = getP1().getY(), y2 = getP2().getY();

        //Construindo as 4 retas do retangulo. 
        //primeira reta -> (x1,y1), (x2,y1) 

        desenharReta(g, x1, y1, x2,y1);

        //segunda reta -> (x2,y1), (x2,y2)
        desenharReta(g, x2, y1, x2, y2);

        //terceira reta -> (x2,y2), (x1,y2)
        desenharReta(g, x2, y2, x1, y2);

        //quarta reta -> (x1,y2), (x1,y1)
        desenharReta(g, x1,y2,x1,y1);

    }   
    
   
    /**
     * 
     * Desenha as retas do retangulo
     *
     * @param g - conteudo grafico
     * @param x1 - coordenada do x1
     * @param y1 - coordenada do y1
     * @param x2 - coordenada do x2
     * @param y2 - coordenada do y2
     */
    public void desenharReta(Graphics g, double x1, double y1, double x2, double y2){
        g.setColor(getCorPto());

        double Dx=0, Dy=0;// Delta x; Delata y
        double m=0, b=0;// Coeficinete angular; b
        double c1, c2; //Variaveis utilizadas para identificar e armazenar qual delta é maior para realizar o loop de criacao de uma reta mais precisa
        double xMaior=0, xMenor=0, yMaior=0,yMenor=0;
        double x, y;

        //Identifica qual ponto tem o eixo x com maior valor e realiza a conta do delta x
        if(x2 > x1){
            Dx = x2 - x1;
            xMaior = x2;
            xMenor = x1;
        }else if(x2 < x1){
            Dx = x1 - x2;
            xMaior = x1;
            xMenor = x2;
        }

        //Identifica qual ponto tem o eixo y com maior valor e realiza a conta do delta y
        if(y2 >= y1){
            Dy = y2 - y1;
            yMaior = y2;
            yMenor = y1;
        }else if(y2 < y1){
            Dy = y1 - y2;
            yMaior = y1;
            yMenor = y2;
        }
        
        //Identifica qual delta é maior, com intuito de definir qual dos eixos possui maior variação 
        if(Dx > Dy) {
            c1 = xMenor;
            c2 = xMaior;
        }else{
            c1 = yMenor;
            c2 = yMaior;
        } 

        

        //delta x for igual a 0
        if(Dx == 0){
            for(double i = c1; i <= c2; i++){

                g.fillOval((int)x1 -(getDiametro()/2), (int)i - (getDiametro()/2), getDiametro(), getDiametro());
            }
        //delta y for igual a 0
        }else if(Dy == 0){ //Neste caso, a reta será horizontal
            for(double i = c1; i <= c2; i++){

                g.fillOval((int)i -(getDiametro()/2), (int)y1 - (getDiametro()/2), getDiametro(), getDiametro());
            }
        }else{
            m = calcularM(Dy, Dx);
            b = calcularB(m);

            for(double i = c1; i <= c2; i++){
                if(Dx > Dy){
                    y = i*m + b; //equacao reduzida da reta
                    g.fillOval((int)i -(getDiametro()/2), (int)y - (getDiametro()/2), getDiametro(), getDiametro());
                }else{
                    x = (i - b)/m;// equacao reduzida da reta com o x isolado
                    g.fillOval((int)x -(getDiametro()/2), (int)i - (getDiametro()/2), getDiametro(), getDiametro());
                }
            }         
        }
    }

    /**
     * Verifica se o ponto clicado na tela pertece ao retangulo
     *
     * @param p - coordenada do ponto
     * @return - true ou false
     */
    public boolean retanguloSelect(Ponto p){
        boolean pVeri = false, pVeri1 = false, pVeri2 = false, pVeri3 = false, pVeri4 = false;
        double x1 = getP1().getX(), x2 = getP2().getX(), y1 = getP1().getY(), y2 = getP2().getY();

        //Construindo as 4 retas do retangulo. 
        //primeira reta -> (x1,y1), (x2,y1) 

        pVeri1 = retaSelect(p, x1, y1, x2,y1);

        //segunda reta -> (x2,y1), (x2,y2)
        pVeri2 = retaSelect(p, x2, y1, x2, y2);

        //terceira reta -> (x2,y2), (x1,y2)
        pVeri3 = retaSelect(p, x2, y2, x1, y2);

        //quarta reta -> (x1,y2), (x1,y1)
        pVeri4 = retaSelect(p, x1,y2,x1,y1);

        if(pVeri1 == true || pVeri2 == true|| pVeri3 == true|| pVeri4 == true) pVeri = true;

        return pVeri;
    }   
    
    /**
     * Verifica se o ponto clicado na tela pertence a uma das retas do triangulo
     *
     * @param p - coordenada do ponto
     * @param x1 - coordenada do x1
     * @param y1 - coordenada do y1
     * @param x2 - coordenada do x2
     * @param y2 - coordenada do y2
     * @return - true ou false
     */
    public boolean retaSelect(Ponto p, double x1, double y1, double x2, double y2){

        double Dx=0, Dy=0;// Delta x; Delata y
        double m=0, b=0;// Coeficinete angular; b
        double c1, c2; //Variaveis utilizadas para identificar e armazenar qual delta é maior para realizar o loop de criacao de uma reta mais precisa
        double xMaior=0, xMenor=0, yMaior=0,yMenor=0;
        double x, y;
        double xP = p.getX(), yP = p.getY();

        //Identifica qual ponto tem o eixo x com maior valor e realiza a conta do delta x
        if(x2 > x1){
            Dx = x2 - x1;
            xMaior = x2;
            xMenor = x1;
        }else if(x2 < x1){
            Dx = x1 - x2;
            xMaior = x1;
            xMenor = x2;
        }

        //Identifica qual ponto tem o eixo y com maior valor e realiza a conta do delta y
        if(y2 >= y1){
            Dy = y2 - y1;
            yMaior = y2;
            yMenor = y1;
        }else if(y2 < y1){
            Dy = y1 - y2;
            yMaior = y1;
            yMenor = y2;
        }
        
        //Identifica qual delta é maior, com intuito de definir qual dos eixos possui maior variação 
        if(Dx > Dy) {
            c1 = xMenor;
            c2 = xMaior;
        }else{
            c1 = yMenor;
            c2 = yMaior;
        } 

        

        //delta x for igual a 0
        if(Dx == 0){
            for(double i = c1; i <= c2; i++){
                double dist = Math.sqrt(((xP - x1) * (xP - x1)) + ((yP - i) * (yP - i)));
                if(dist <= 10){
                    return true;
                }
            }
        //delta y for igual a 0
        }else if(Dy == 0){ //Neste caso, a reta será horizontal
            for(double i = c1; i <= c2; i++){
                double dist = Math.sqrt(((xP - i) * (xP - i)) + ((yP - y1) * (yP - y1)));
                if(dist <= 10){
                    return true;
                }
            }
        }else{
            m = calcularM(Dy, Dx);
            b = calcularB(m);

            for(double i = c1; i <= c2; i++){
                if(Dx > Dy){
                    y = i*m + b; //equacao reduzida da reta
                    double dist = Math.sqrt(((xP - i) * (xP - i)) + ((yP - y) * (yP - y)));
                    if(dist <= 10){
                        return true;
                    }
                }else{
                    x = (i - b)/m;// equacao reduzida da reta com o x isolado
                    double dist = Math.sqrt(((xP - x) * (xP - x)) + ((yP - i) * (yP - i)));
                    if(dist <= 10){
                        return true;
                    }
                }
            }         
        }
        return false;
    }
}