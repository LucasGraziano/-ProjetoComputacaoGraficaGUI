package TrasformacoesGeometricas;

import GUI.TiposPrimitivos;
import Tipos.Circulo.CircGr;
import Tipos.LinhaPoligonal.LinhaPoligonal;
import Tipos.Poligono.PoligonoGr;
import Tipos.Ponto.Ponto;
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

    Ponto pontoMedio;
    double dist = 0;

    public void GerarRotacao(){
        if(tipo == TiposPrimitivos.PONTOS){

        }else if(tipo == TiposPrimitivos.RETAS){
            RetaGr R = (RetaGr)O;
            double radian = graus * (Math.PI / 180);

            

            if(pontoMedio == null){
                pontoMedio = new Ponto(R.getP2().x - ((R.getP2().x - R.getP1().x) / 2), R.getP1().y - ((R.getP1().y - R.getP2().y) / 2));
                dist = Math.sqrt(((pontoMedio.x - R.getP1().x) * (pontoMedio.x - R.getP1().x)) + ((pontoMedio.y - R.getP1().y) * (pontoMedio.y - R.getP1().y)));
            }

            double x1 = R.getP1().x - pontoMedio.x;
            double y1 = R.getP1().y - pontoMedio.y;

            double x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            double y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            R.setP1(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));

            x1 = R.getP2().x - pontoMedio.x;
            y1 = R.getP2().y - pontoMedio.y;

            x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            R.setP2(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));
            
        }else if(tipo == TiposPrimitivos.CIRCULOS){


        }else if(tipo == TiposPrimitivos.RETANGULO){
            
            RetanguloGr Ret = (RetanguloGr)O;
            double radian = graus * (Math.PI / 180);

            

            if(pontoMedio == null){
                pontoMedio = new Ponto(Ret.getP4().x - ((Ret.getP4().x - Ret.getP1().x) / 2), Ret.getP1().y - ((Ret.getP1().y - Ret.getP4().y) / 2));
                dist = Math.sqrt(((pontoMedio.x - Ret.getP1().x) * (pontoMedio.x - Ret.getP1().x)) + ((pontoMedio.y - Ret.getP1().y) * (pontoMedio.y - Ret.getP1().y)));
            }

            double x1 = Ret.getP1().x - pontoMedio.x;
            double y1 = Ret.getP1().y - pontoMedio.y;

            double x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            double y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            Ret.setP1(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));

            x1 = Ret.getP2().x - pontoMedio.x;
            y1 = Ret.getP2().y - pontoMedio.y;

            x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            Ret.setP2(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));

            x1 = Ret.getP3().x - pontoMedio.x;
            y1 = Ret.getP3().y - pontoMedio.y;

            x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            Ret.setP3(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));

            x1 = Ret.getP4().x - pontoMedio.x;
            y1 = Ret.getP4().y - pontoMedio.y;

            x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            Ret.setP4(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));

        }else if(tipo == TiposPrimitivos.POLIGONO){
            //PoligonoGr Poli = (PoligonoGr)O;
            //for(RetaGr R : Poli.retas)
        }else if(tipo == TiposPrimitivos.LINHAPOLIGONAL){
            
        }
    }
    public void GerarEscala() {
    } 
}
