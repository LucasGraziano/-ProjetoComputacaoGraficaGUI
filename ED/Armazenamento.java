package ED;
import Tipos.Ponto.Ponto;

import java.util.ArrayList;

import Tipos.Ponto.DoisPontos;

public class Armazenamento {
    int indexPonto;
    int indexReta;
    int indexCirculo;
    int indexRetangulo;
    int indexPoligono;
    int indexLinhaPoligonal;

    Ponto PontoNeutro = new Ponto();
    Ponto p = new Ponto();
    DoisPontos PontosNeutro = new DoisPontos();

    ArrayList<Ponto> ArrayPonto;
    ArrayList<DoisPontos> ArrayReta;
    ArrayList<DoisPontos> ArrayCirculo;
    ArrayList<DoisPontos> ArrayRetangulo;
    ArrayList<DoisPontos> ArrayPoligono;
    ArrayList<DoisPontos> ArrayLinhaPoligonal;

    public Armazenamento(){//Quando a classe for instanciada os indexadores serão inicializados
        indexPonto = 0;
        indexReta = 0;
        indexCirculo = 0;
        indexRetangulo = 0;
        indexPoligono = 0;
        indexLinhaPoligonal = 0;

        ArrayPonto = new ArrayList<Ponto>();
        ArrayReta = new ArrayList<DoisPontos>();;
        ArrayCirculo = new ArrayList<DoisPontos>();;
        ArrayRetangulo = new ArrayList<DoisPontos>();;
        ArrayPoligono = new ArrayList<DoisPontos>();;
        ArrayLinhaPoligonal = new ArrayList<DoisPontos>();;

        
        PontoNeutro.setX(-1);
        PontoNeutro.setY(-1);

        PontosNeutro.setX1(-1);
        PontosNeutro.setY1(-1);
        PontosNeutro.setX2(-1);
        PontosNeutro.setY2(-1);
    }

    

    

    public void setArrayPonto(double x1, double y1){
        ArrayPonto.add(new Ponto(x1, y1));
        indexPonto++;
    }
    public Ponto getArrayPonto(){
        indexPonto--;
        Ponto valor;
        if(indexPonto >= 0){//Controle para verificar se existem dados no array
            
            valor =  ArrayPonto.get(indexPonto);
            ArrayPonto.remove(indexPonto);
        }else valor = PontoNeutro; //(-1,-1);
        
        return valor;
    }

    public void setArrayReta(double x1, double y1, double x2, double y2){
        ArrayReta.add(new DoisPontos(x1, y1, x2, y2));
        indexReta++;
    }
    public DoisPontos getArrayReta(){
        indexReta--;
        DoisPontos valor;
        if(indexReta >= 0){//Controle para verificar se existem dados no array
            valor = ArrayReta.get(indexReta);
            ArrayReta.remove(indexReta);
        }else valor = PontosNeutro;

        return valor;
    }

    public void setArrayCirculo(double x1, double y1, double x2, double y2){
        ArrayCirculo.add(new DoisPontos(x1, y1, x2, y2));
        indexCirculo++;
    }
    public DoisPontos getArrayCirculo(){
        indexCirculo--;
        DoisPontos valor;
        if(indexCirculo >= 0){//Controle para verificar se existem dados no array
            valor = ArrayCirculo.get(indexCirculo);
            ArrayCirculo.remove(indexCirculo);
        }else valor = PontosNeutro;

        return valor;
    }

    public void setArrayRetangulo(double x1, double y1, double x2, double y2){
        ArrayRetangulo.add(new DoisPontos(x1, y1, x2, y2));
        indexRetangulo++;
    }
    public DoisPontos getArrayRetangulo(){
        indexRetangulo--;
        DoisPontos valor;
        if(indexRetangulo >= 0){//Controle para verificar se existem dados no array
            valor = ArrayRetangulo.get(indexRetangulo);
            ArrayRetangulo.remove(indexRetangulo);
        }else valor = PontosNeutro;

        return valor;
    }

    public void setArrayPoligono(double x1, double y1, double x2, double y2){
        ArrayPoligono.add(new DoisPontos(x1, y1, x2, y2));
        indexPoligono++;
    }
    public DoisPontos getArrayPoligono(){
        indexPoligono--;
        DoisPontos valor;
        if(indexPoligono >= 0){//Controle para verificar se existem dados no array
            valor = ArrayPoligono.get(indexPoligono);
            ArrayPoligono.remove(indexPoligono);
        }else valor = PontosNeutro;

        return valor;
    }

    public void setArrayLinhaPoligonal(double x1, double y1, double x2, double y2){
        ArrayLinhaPoligonal.add(new DoisPontos(x1, y1, x2, y2));
        indexLinhaPoligonal++;
    }
    public DoisPontos getArrayLinhaPoligonal(){
        indexLinhaPoligonal--;
        DoisPontos valor;
        if(indexLinhaPoligonal >= 0){//Controle para verificar se existem dados no array
            valor = ArrayLinhaPoligonal.get(indexLinhaPoligonal);
            ArrayLinhaPoligonal.remove(indexLinhaPoligonal);
        }else valor = PontosNeutro;

        return valor;
    }

}
