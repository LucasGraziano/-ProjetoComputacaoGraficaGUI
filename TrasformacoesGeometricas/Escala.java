/*import GUI.TiposPrimitivos;
import Tipos.Circulo.CircGr;
import Tipos.LinhaPoligonal.LinhaPoligonal;
import Tipos.Poligono.PoligonoGr;
import Tipos.Ponto.PontoGr;
import Tipos.Ponto.Ponto;
import Tipos.Reta.RetaGr;
import Tipos.Retangulo.RetanguloGr;

public class Escala {
    Object O;
    double xT, yT, x, y;
    TiposPrimitivos tipo = TiposPrimitivos.NENHUM;


    //reposicionar um objeto
    public Escala(RetaGr O, double mult){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.RETAS;
    }

    public Escala(PontoGr O, double mult){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.PONTOS;
    } como q ta? me manda foto no whats
    public Escala(CircGr O, double mult){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.CIRCULOS;
    }
    public Escala(RetanguloGr O, double xT, double yT){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.RETANGULO;
    }
    public Escala(PoligonoGr O, double xT, double yT){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.POLIGONO;
    }
    public Escala(LinhaPoligonal O, double xT, double yT){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.LINHAPOLIGONAL;
    }
   public void GerarEscala(){

    Ponto p1 = new Ponto();
    Ponto p2 = new Ponto();
 
        
        if(tipo == TiposPrimitivos.PONTOS){


        }else if(tipo == TiposPrimitivos.RETAS){
            RetaGr R = (RetaGr)O;
            R.getP1().x = R.getP1().x * mult;
            R.getP1().y = R.getP1().y * mult;
            R.getP2().x = R.getP2().x * mult;
            R.getP2().y = R.getP2().y * mult;
        
        chegou a pizza ja volto 
        }else if(tipo == TiposPrimitivos.CIRCULOS){
            CircGr C = (CircGr)O;
            C.getP1().x = C.getP1().x * mult; 
            C.getP1().y = C.getP1().y * mult;
            C.getP2().x = C.getP2().x * mult;
            C.getP2().y = C.getP2().y * mult;
        }else if(tipo == TiposPrimitivos.RETANGULO){
            RetanguloGr Ret = (RetanguloGr)O;
            Ret.getP1().x = Ret.getP1().x + xT;
            Ret.getP1().y = Ret.getP1().y + yT;
            Ret.getP2().x = Ret.getP2().x + xT;
            Ret.getP2().y = Ret.getP2().y + yT;
        }else if(tipo == TiposPrimitivos.POLIGONO){
            PoligonoGr Poli = (PoligonoGr)O;
            for(RetaGr R : Poli.retas){
                R.getP1().x = R.getP1().x + xT;
                R.getP1().y = R.getP1().y + yT;
                R.getP2().x = R.getP2().x + xT;
                R.getP2().y = R.getP2().y + yT; 
            }
        }else if(tipo == TiposPrimitivos.LINHAPOLIGONAL){
            LinhaPoligonalGr LinhaPoli = (LinhaPoligonalGr)O;
            for(RetaGr R : LinhaPoli.retas){
                R.getP1().x = R.getP1().x + xT;
                R.getP1().y = R.getP1().y + yT;
                R.getP2().x = R.getP2().x + xT;
                R.getP2().y = R.getP2().y + yT; 
            }
        }

        
    }
}*/ 