package TrasformacoesGeometricas;

import GUI.TiposPrimitivos;
import Tipos.Circulo.CircGr;
import Tipos.LinhaPoligonal.LinhaPoligonal;
import Tipos.LinhaPoligonal.LinhaPoligonalGr;
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

    public Ponto pontoMedio;
    double dist = 0;

    /**
     * processo de rotacao
     */
    public void GerarRotacao(){
        if(tipo == TiposPrimitivos.PONTOS){

        //caso reta
        }else if(tipo == TiposPrimitivos.RETAS){
            RetaGr R = (RetaGr)O;
            //calculo do angulo
            double radian = graus * (Math.PI / 180);
            
            if(pontoMedio == null){
                pontoMedio = new Ponto(R.getP2().x - ((R.getP2().x - R.getP1().x) / 2), R.getP1().y - ((R.getP1().y - R.getP2().y) / 2));
                dist = Math.sqrt(((pontoMedio.x - R.getP1().x) * (pontoMedio.x - R.getP1().x)) + ((pontoMedio.y - R.getP1().y) * (pontoMedio.y - R.getP1().y)));
            }

            //calculo dos pontos
            double x1 = R.getP1().x - pontoMedio.x;
            double y1 = R.getP1().y - pontoMedio.y;
            //calculo dos pontos
            double x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            double y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);
            //adicionando o novo valor de p1
            R.setP1(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));

            x1 = R.getP2().x - pontoMedio.x;
            y1 = R.getP2().y - pontoMedio.y;

            x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            //adicionando o novo valor de p2
            R.setP2(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));
            
        }else if(tipo == TiposPrimitivos.CIRCULOS){

        //caso retangulo
        }else if(tipo == TiposPrimitivos.RETANGULO){
            
            RetanguloGr Ret = (RetanguloGr)O;
            //calculo do angulo
            double radian = graus * (Math.PI / 180);

            if(pontoMedio == null){
                pontoMedio = new Ponto(Ret.getP4().x - ((Ret.getP4().x - Ret.getP1().x) / 2), Ret.getP1().y - ((Ret.getP1().y - Ret.getP4().y) / 2));
                dist = Math.sqrt(((pontoMedio.x - Ret.getP1().x) * (pontoMedio.x - Ret.getP1().x)) + ((pontoMedio.y - Ret.getP1().y) * (pontoMedio.y - Ret.getP1().y)));
            }
            //calculando os pontos 
            double x1 = Ret.getP1().x - pontoMedio.x;
            double y1 = Ret.getP1().y - pontoMedio.y;

            double x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            double y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            //adicionando o novo valor de p1
            Ret.setP1(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));

            x1 = Ret.getP2().x - pontoMedio.x;
            y1 = Ret.getP2().y - pontoMedio.y;

            x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            //adicionando o novo valor de p2
            Ret.setP2(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));

            x1 = Ret.getP3().x - pontoMedio.x;
            y1 = Ret.getP3().y - pontoMedio.y;

            x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            //adicionando o novo valor de p3
            Ret.setP3(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));

            x1 = Ret.getP4().x - pontoMedio.x;
            y1 = Ret.getP4().y - pontoMedio.y;

            x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
            y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

            //adicionando o novo valor de p4
            Ret.setP4(new Ponto(x2 + pontoMedio.x, y2 + pontoMedio.y));

        //caso poligono
        }else if(tipo == TiposPrimitivos.POLIGONO){
            PoligonoGr pol = (PoligonoGr) O;
            int xMin = 10000000;
            int yMin = 10000000;
            int xMax = 0;
            int yMax = 0;

            //contagem de todos os pontos do poligono
            for(Ponto p : pol.getPontos()){
                if(p.x < xMin) xMin = (int) p.x;
                if(p.y < yMin) yMin = (int) p.y;
                if(p.x > xMax) xMax = (int) p.x;
                if(p.y > yMax) yMax = (int) p.y;
            }

            //angulacao
            double radian = graus * (Math.PI / 180);

            if(pontoMedio == null){
                pontoMedio = new Ponto(xMin - ((xMin - xMax) / 2), yMin - ((yMin - yMax) / 2));
            }

            int i = 0;
            for(Ponto p : pol.getPontos()){
                //calculando as coordenadas
                double x1 = p.x - pontoMedio.x;
                double y1 = p.y - pontoMedio.y;

                double x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
                double y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

                pol.getPontos().get(i).setX(x2 + pontoMedio.x);
                pol.getPontos().get(i).setY(y2 + pontoMedio.y);
                i++;
            }

        //caso da linha poligonal
        }else if(tipo == TiposPrimitivos.LINHAPOLIGONAL){
            LinhaPoligonalGr pol = (LinhaPoligonalGr) O;
            
        
            int xMin = 10000000;
            int yMin = 10000000;
            int xMax = 0;
            int yMax = 0;

            //contagem de todos os pontos da linha poligonal
            for(Ponto p : pol.getPontos()){
                if(p.x < xMin) xMin = (int) p.x;
                if(p.y < yMin) yMin = (int) p.y;
                if(p.x > xMax) xMax = (int) p.x;
                if(p.y > yMax) yMax = (int) p.y;
            }

            //calculo do angulo
            double radian = graus * (Math.PI / 180);

            if(pontoMedio == null){
                pontoMedio = new Ponto(xMin - ((xMin - xMax) / 2), yMin - ((yMin - yMax) / 2));
            }

            int i = 0;
            //passagem de todos os pontos da linha poligonal
            for(Ponto p : pol.getPontos()){
                //calculo das coordenadas
                double x1 = p.x - pontoMedio.x;
                double y1 = p.y - pontoMedio.y;

                double x2 = x1 * Math.cos(radian) - y1 * Math.sin(radian);
                double y2 = x1 * Math.sin(radian) + y1 * Math.cos(radian);

                pol.getPontos().get(i).setX(x2 + pontoMedio.x);
                pol.getPontos().get(i).setY(y2 + pontoMedio.y);
                i++;
            }
            
        }
    }
    
}
