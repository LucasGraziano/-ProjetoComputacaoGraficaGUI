package TrasformacoesGeometricas;

import GUI.TiposPrimitivos;
import Tipos.Circulo.CircGr;
import Tipos.LinhaPoligonal.LinhaPoligonal;
import Tipos.Poligono.PoligonoGr;
import Tipos.Ponto.PontoGr;
import Tipos.Ponto.Ponto;
import Tipos.Reta.RetaGr;
import Tipos.Retangulo.RetanguloGr;

public class Translacao {
    Object O;
    double xT, yT, x, y;
    TiposPrimitivos tipo = TiposPrimitivos.NENHUM;


    //reposicionar um objeto
    public Translacao(RetaGr O, double xT, double yT){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.RETAS;
    }

    public Translacao(PontoGr O, double xT, double yT){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.PONTOS;
    }
    
    public Translacao(CircGr O, double xT, double yT){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.CIRCULOS;
    }
    public Translacao(RetanguloGr O, double xT, double yT){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.RETANGULO;
    }
    public Translacao(PoligonoGr O, double xT, double yT){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.POLIGONO;
    }
    public Translacao(LinhaPoligonal O, double xT, double yT){
        this.O = O;
        this.xT = xT;
        this.yT = yT;
        tipo = TiposPrimitivos.LINHAPOLIGONAL;
    }
   public void GerarTranslacao(){

    Ponto p1 = new Ponto();
    Ponto p2 = new Ponto();
 
        
        if(tipo == TiposPrimitivos.PONTOS){
            PontoGr P = (PontoGr)O;
            P.x = P.x + xT;
            P.y = P.y + yT;
            //E um repaint na classe Gui
        }else if(tipo == TiposPrimitivos.RETAS){
            RetaGr R = (RetaGr)O;
            
            x = R.getP1().x + xT;
            y = R.getP1().y + yT;
            p1.setX(x);
            p1.setY(y);
            R.setP1(p1);
            
            x = R.getP2().x + xT;
            y = R.getP2().y + yT;
            p2.setX(x);
            p2.setY(y);
            R.setP2(p2);
        }else if(tipo == TiposPrimitivos.CIRCULOS){
            CircGr C = (CircGr)O;
            C.getP1().x = C.getP1().x + xT;
            C.getP1().y = C.getP1().y + yT;
            C.getP2().x = C.getP2().x + xT;
            C.getP2().y = C.getP2().y + yT;
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
        /* }else if(tipo == TiposPrimitivos.LINHAPOLIGONAL){
            LinhaPoligonalGr LinhaPoli = (LinhaPoligonalGr)O;
            for(RetaGr R : LinhaPoli.retas){
                R.getP1().x = R.getP1().x + xT;
                R.getP1().y = R.getP1().y + yT;
                R.getP2().x = R.getP2().x + xT;
                R.getP2().y = R.getP2().y + yT; 
            }/* */
        } 


    }
}