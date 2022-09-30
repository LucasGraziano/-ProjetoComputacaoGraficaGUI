package TrasformacoesGeometricas;

import GUI.TiposPrimitivos;
import Tipos.Circulo.CircGr;
import Tipos.LinhaPoligonal.LinhaPoligonal;
import Tipos.Poligono.PoligonoGr;
import Tipos.Ponto.PontoGr;
import Tipos.Reta.RetaGr;
import Tipos.Retangulo.RetanguloGr;

public class Rotacao {
    Object O;
    double graus, x, y;
    TiposPrimitivos tipo = TiposPrimitivos.NENHUM;


    //reposicionar um objeto
    public Rotacao(PontoGr O, double graus){
        this.O = O;
        this.graus = graus;
        tipo = TiposPrimitivos.PONTOS;
    }
    public Rotacao(RetaGr O, double graus){
        this.O = O;
        this.graus = graus;
        tipo = TiposPrimitivos.RETAS;
    }
    public Rotacao(CircGr O, double graus){
        this.O = O;
        this.graus = graus;
        tipo = TiposPrimitivos.CIRCULOS;
    }
    public Rotacao(RetanguloGr O, double graus){
        this.O = O;
        this.graus = graus;
        tipo = TiposPrimitivos.RETANGULO;
    }
    public Rotacao(PoligonoGr O, double graus){
        this.O = O;
        this.graus = graus;
        tipo = TiposPrimitivos.POLIGONO;
    }
    public Rotacao(LinhaPoligonal O, double graus){
        this.O = O;
        this.graus = graus;
        tipo = TiposPrimitivos.LINHAPOLIGONAL;
    }

    public void GerarRotacao(){
        if(tipo == TiposPrimitivos.PONTOS){

        }else if(tipo == TiposPrimitivos.RETAS){
            RetaGr R = (RetaGr)O;
            R.getP1().x = R.getP1().x * Math.cos(graus) - R.getP1().y * Math.sin(graus);
            R.getP1().y = R.getP1().x * Math.sin(graus) + R.getP1().y * Math.cos(graus);
            R.getP2().x = R.getP2().x * Math.cos(graus) - R.getP2().y * Math.sin(graus);
            R.getP2().y = R.getP2().x * Math.sin(graus) + R.getP2().y * Math.cos(graus);
        }else if(tipo == TiposPrimitivos.CIRCULOS){


        }else if(tipo == TiposPrimitivos.RETANGULO){
            
            RetanguloGr Ret = (RetanguloGr)O;
            Ret.getP1().x = Ret.getP1().x * Math.cos(graus) - Ret.getP1().y * Math.sin(graus);
            Ret.getP1().y = Ret.getP1().x * Math.sin(graus) + Ret.getP1().y * Math.cos(graus);
            Ret.getP2().x = Ret.getP2().x * Math.cos(graus) - Ret.getP2().y * Math.sin(graus);
            Ret.getP2().y = Ret.getP2().x * Math.sin(graus) + Ret.getP2().y * Math.cos(graus);

        }else if(tipo == TiposPrimitivos.POLIGONO){
            //PoligonoGr Poli = (PoligonoGr)O;
            //for(RetaGr R : Poli.retas)
        }else if(tipo == TiposPrimitivos.LINHAPOLIGONAL){
            
        }
    } 
}
