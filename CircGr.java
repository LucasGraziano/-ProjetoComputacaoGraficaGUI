
import java.awt.Color;
import java.awt.Graphics;


public class CircGr extends Circ {

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
    public CircGr(int x, int y){
        super((double)x, (double)y);
        setCorPto(Color.black);     
        setCorNomePto(Color.black);     
        setNomePto("");     
    }

    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param cor - cor do circulo
     */
    public CircGr(int x, int y, Color cor){
        super((double)x, (double)y);
        setCorPto(cor);     
        setCorNomePto(Color.black);     
        setNomePto("");     
    }

    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param corPonto - cor do circulo
     * @param diametro - tamanho das bolinhas
     */
    public CircGr(int x, int y, Color corPonto, int diametro) {
        this(x, y, corPonto);
        setDiametro(diametro);
    }
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param corPonto - cor do circulo
     * @param nomePonto - nome do circulo
     * @param diametro - tamanho das bolinhas
     */
    public CircGr(int x, int y, Color corPonto, String nomePonto, int diametro){
        this(x, y, corPonto, diametro);
        setNomePto(nomePonto);
    }
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y- coordenada do y
     * @param cor - cor do circulo
     * @param str - nome do circulo
     */
    public CircGr(int x, int y, Color cor, String str){
        super((double)x, (double)y);
        setCorPto(cor);     
        setCorNomePto(Color.black);     
        setNomePto(str);     
    }

    /**
     * Construtor
     * 
     * @param p2d
     * @param cor - cor do circulo
     */
    public CircGr(CircGr p2d, Color cor){
        super(p2d);     
        setCorPto(cor);     
        setCorNomePto(Color.black);     
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
    public Color getCorNomePto() {
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
     * Desenha o Circulo
     * 
     * @param g - conteudo gráfico
     * @param x2 - coordenada do raio
     * @param y2 - coordenada do raio
     */
    public void desenharCirc(Graphics g, double x2, double y2){
        g.setColor(getCorPto());
        double x = getP().getX(), y = getP().getY(); // x e y do clique
        double ang = 0.0; // angulo a ser encrementado
        double xP = 0, yP = 0; // x e y a serem pintados
        double catAd, catOp; //cateto adjacente e cateto oposto
        double raio = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2) * 1.0); // raio do circulo (distancia entre os pontos dos cliques)
        double dim = raio*2.0; //diametro do circulo
        
        //Esse do-while faz o calculo de todos os pontos do circulo e desenhando com o fillOval
        do{
            //calculo dos pontos angulos do circulo
            catAd = Math.cos(ang) * dim/2.0; 
            catOp = Math.sin(ang) * dim/2.0;
            
            //sao as coordenadas da borda do circulo
            xP = x2 + catAd;
            yP = y2 + catOp;

            //printa os pontos ate completar o circulo
            g.fillOval((int)xP -(getDiametro()/2), (int)yP - (getDiametro()/2), getDiametro(), getDiametro());

            //angulo vai aumentando em 5 em 5
            ang = ang + 0.5;  //passo 0.5 
        }while(ang != 360.0);
        

    }
}
