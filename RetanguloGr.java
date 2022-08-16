import java.awt.Color;
import java.awt.Graphics;



public class RetanguloGr extends Retangulo {

    Color corPto = Color.BLACK; // cor do ponto
    String nomePto = ""; // nome do ponto
    Color corNomePto  = Color.BLACK; // cor do nome (string) do ponto  
    int diametro = 1; // diametro do ponto, default = 1

    
    
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
        g.setColor(setCorNomePto());
        double x1 = getP1().getX(), x2 = getP2().getX(), y1 = getP1().getY(), y2 = getP2().getY();
        
            //acho q n vou usar saporra
        //diagonal = ((xMaior - xMenor)^2 + (yMaior - yMenor)^2) / diametro // Pitagoras: c^2 = a^2 + b^2 -> c = (a^2 + b^2) / c

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
    
    
    public void desenharReta(Graphics g, double x1, double y1, double x2, double y2){
        g.setColor(setCorNomePto());

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
}