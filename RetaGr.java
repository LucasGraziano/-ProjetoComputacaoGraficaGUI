import java.awt.Color;
import java.awt.Graphics;

public class RetaGr extends Reta {
    
    Color corReta = Color.BLACK; // cor do Reta
    String nomeReta = ""; // nome do Reta
    Color corNomeReta  = Color.BLACK; // cor do nome (string) do Reta  
    int diametro = 1; // diametro do Reta, default = 1

    RetaGr(int x1, int y1, int x2, int  y2){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorReta(Color.black);     
        setCorNomeReta(Color.black);     
        setNomeReta("");     
    }

    RetaGr(int x1, int y1, int x2, int  y2, Color cor){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorReta(cor);     
        setCorNomeReta(Color.black);     
        setNomeReta("");     
    }

    /**
     * Constroi um Reta na posicao x, y e com os atributos
     * 
     * @param x coordenada x
     * @param y coordenada y
     * @param corReta corReta do Reta a ser construido
     * @param diametro diametro do Reta
     */
    public RetaGr(int x1, int y1, int x2, int  y2, Color corReta, int diametro){
        this(x1, y1, x2, y2, corReta);
        setDiametro(diametro);
    }

    /**
     * Constroi um Reta na posicao x, y e com os atributos
     * 
     * @param x coordenada x
     * @param y coordenada y
     * @param corReta corReta do Reta a ser construido
     * @param nomeReta nome do Reta
     * @param diametro diametro do Reta
     */
    public RetaGr(int x1, int y1, int x2, int  y2, Color corReta, String nomeReta, int diametro){
        this(x1, y1, x2, y2, corReta, diametro);
        setNomeReta(nomeReta);
    }
    RetaGr(int x1, int y1, int x2, int  y2, Color cor, String str){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorReta(cor);     
        setCorNomeReta(Color.black);     
        setNomeReta(str);     
    }

    RetaGr(RetaGr p2d, Color cor){
        super(p2d);     
        setCorReta(cor);     
        setCorNomeReta(Color.black);     
        setNomeReta("");     
    }

    /*
    RetaGr(){
        super();     
        setCorReta(Color.black);     
        setCorNomeReta(Color.black);     
        setNomeReta("");     
    }
    */


    /**
     * @return the corReta
     */
    public Color getCorReta() {
        return corReta;
    }

    /**
     * @param corReta the corReta to set
     */
    public void setCorReta(Color corReta) {
        this.corReta = corReta;
    }

    /**
     * @return the nomeReta
     */
    public String getNomeReta() {
        return nomeReta;
    }

    /**
     * @param nomeReta the nomeReta to set
     */
    public void setNomeReta(String nomeReta) {
        this.nomeReta = nomeReta;
    }

    /**
     * @return the corNomeReta
     */
    public Color getCorNomeReta() {
        return corNomeReta;
    }

    /**
     * @param corNomeReta the corNomeReta to set
     */
    public void setCorNomeReta(Color corNomeReta) {
        this.corNomeReta = corNomeReta;
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
     * desenha um Reta utilizando o oval 
     * 
     * @param g contexto grafico
     */
    public void desenharReta(Graphics g){
        g.setColor(getCorReta());

        double Dx=0, Dy=0;
        double m=0, b=0;
        boolean test = false; //teste para verificar se o delta x nao é 0
        double c1, c2, c3; //Variaveis utilizadas para identificar e armazenar qual delta é maior para realizar o loop de criacao de uma reta mais precisa
        double xMaior=0, xMenor=0, yMaior=0,yMenor=0;
        double x1 = getP1().getX(), x2 = getP2().getX(), y1 = getP1().getY(), y2 = getP2().getY();
        double x, y;

        if(x2 > x1){
            Dx = x2 - x1;
            xMaior = x2;
            xMenor = x1;
        }else if(x2 < x1){
            Dx = x1 - x2;
            xMaior = x1;
            xMenor = x2;
        }else test = true;// delta x é 0

        if(y2 >= y1){
            Dy = y2 - y1;
            yMaior = y2;
            yMenor = y1;
        }else if(y2 < y1){
            Dy = y1 - y2;
            yMaior = y1;
            yMenor = y2;
        }

        if(Dx > Dy) {
            c1 = xMenor;
            c2 = xMaior;
        }else{
            c1 = yMenor;
            c2 = yMaior;
        } 

        if(Dx == 0){
            for(double i = c1; i <= c2; i++){

                g.fillOval((int)x1 -(getDiametro()/2), (int)i - (getDiametro()/2), getDiametro(), getDiametro());
            }
        }else if(Dy == 0){
            for(double i = c1; i <= c2; i++){

                g.fillOval((int)i -(getDiametro()/2), (int)y1 - (getDiametro()/2), getDiametro(), getDiametro());
            }
        }else{
            m = calcularM(Dy, Dx);
            b = calcularB(m);

            for(double i = c1; i <= c2; i++){
                if(Dx > Dy){
                    y = c1*m +b; //equacao reduzida da reta
                    g.fillOval((int)c1 -(getDiametro()/2), (int)y - (getDiametro()/2), getDiametro(), getDiametro());
                }else{
                    x = (c1 - b)/m;// equacao reduzida da reta com o x isolado
                    g.fillOval((int)x -(getDiametro()/2), (int)c1 - (getDiametro()/2), getDiametro(), getDiametro());
                }
            }         
        }
        
        
        
        
        /*
        for(double i = c1; i <= c2; i++){

            g.fillOval((int)getX() -(getDiametro()/2), (int)getY() - (getDiametro()/2), getDiametro(), getDiametro());
        }
        */
        


        /* 
        // desenha nome do Reta
        g.setColor(getCorNomeReta());
        g.drawString(getNomeReta(), (int)getX() + getDiametro(), (int)getY());
        */
    }
}
