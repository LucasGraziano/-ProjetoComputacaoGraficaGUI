package TrasformacoesGeometricas;

import GUI.TiposPrimitivos;
import Tipos.Circulo.CircGr;
import Tipos.LinhaPoligonal.LinhaPoligonal;
import Tipos.LinhaPoligonal.LinhaPoligonalGr;
import Tipos.Poligono.PoligonoGr;
import Tipos.Ponto.PontoGr;
import Tipos.Reta.RetaGr;
import Tipos.Retangulo.RetanguloGr;

public class Escala {
    Object O;
    double mult;
    TiposPrimitivos tipo = TiposPrimitivos.NENHUM;

    //Construtores
    /**
     * Construtor
     * @param O - objeto da reta
     * @param mult - multiplicacao da escala
     */
    public Escala(RetaGr O, double mult) {
        this.O = O;
        this.mult = mult;
        tipo = TiposPrimitivos.RETAS;
    }

    /**
     * Construtor
     * @param O - objeto do ponto
     * @param mult - multiplicacao da escala
     */
    public Escala(PontoGr O, double mult) {
        this.O = O;
        this.mult = mult;
        tipo = TiposPrimitivos.PONTOS;
    }


    /**
     * Construtor
     * @param O - objeto do circulo
     * @param mult - multiplicacao da escala
     */
    public Escala(CircGr O, double mult) {
        this.O = O;
        this.mult = mult;
        tipo = TiposPrimitivos.CIRCULOS;
    }

    /**
     * Construtor
     * @param O - objeto do retangulo
     * @param mult - multiplicacao da escala
     */
    public Escala(RetanguloGr O, double mult) {
        this.O = O;
        this.mult = mult;
        tipo = TiposPrimitivos.RETANGULO;
    }


    /**
     * Construtor
     * @param O - objeto do poligono   
     * @param mult - multiplicacao da escala
     */
    public Escala(PoligonoGr O, double mult) {
        this.O = O;
        this.mult = mult;
        tipo = TiposPrimitivos.POLIGONO;
    }

    /**
     * Construtor
     * @param O - objeto da linha poligonal
     * @param mult - multiplicacao da escala
     */
    public Escala(LinhaPoligonal O, double mult) {
        this.O = O;
        this.mult = mult;
        tipo = TiposPrimitivos.LINHAPOLIGONAL;
    }

    /**
     * faz a escala
     */
    public void GerarEscala() {

        //aumenta todos os pontos de todas as figuras
        //tipo ponto
        if (tipo == TiposPrimitivos.PONTOS) {
        //tipo reta
        } else if (tipo == TiposPrimitivos.RETAS) {
            RetaGr R = (RetaGr) O;
            R.getP1().x = R.getP1().x * mult;
            R.getP1().y = R.getP1().y * mult;
            R.getP2().x = R.getP2().x * mult;
            R.getP2().y = R.getP2().y * mult;

        //tipo circulo
        } else if (tipo == TiposPrimitivos.CIRCULOS) {
            CircGr C = (CircGr) O;
            C.getP1().x = C.getP1().x * mult;
            C.getP1().y = C.getP1().y * mult;
            C.getP2().x = C.getP2().x * mult;
            C.getP2().y = C.getP2().y * mult;

        //tipo retangulo
        } else if (tipo == TiposPrimitivos.RETANGULO) {
            RetanguloGr Ret = (RetanguloGr) O;
            Ret.getP1().x = Ret.getP1().x * mult;
            Ret.getP1().y = Ret.getP1().y * mult;
            Ret.getP2().x = Ret.getP2().x * mult;
            Ret.getP2().y = Ret.getP2().y * mult;
        //tipo poligono
        } else if (tipo == TiposPrimitivos.POLIGONO) {
            PoligonoGr Poli = (PoligonoGr) O;
            for (RetaGr R : Poli.retas) {
                R.getP1().x = R.getP1().x * mult;
                R.getP1().y = R.getP1().y * mult;
                R.getP2().x = R.getP2().x * mult;
                R.getP2().y = R.getP2().y * mult;
            }
        //tipo linha poligonal
        } else if (tipo == TiposPrimitivos.LINHAPOLIGONAL) {
            LinhaPoligonalGr LinhaPoli = (LinhaPoligonalGr) O;
            for (RetaGr R : LinhaPoli.retas) {
                R.getP1().x = R.getP1().x * mult;
                R.getP1().y = R.getP1().y * mult;
                R.getP2().x = R.getP2().x * mult;
                R.getP2().y = R.getP2().y * mult;
            }
        }
    }
}