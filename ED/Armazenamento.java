package ED;


import java.util.ArrayList;

import Tipos.Ponto.*;
import Tipos.Reta.*;
import Tipos.Circulo.*;
import Tipos.Retangulo.*;
import Tipos.Poligono.*;
import Tipos.LinhaPoligonal.*;

/**
 * Classe de estrutura de dados q utiliza lista para armazenar a informaçâo desejada
 */
public class Armazenamento {
    //Indexadores da lista
    int indexPonto;
    int indexReta;
    int indexCirculo;
    int indexRetangulo;
    int indexPoligono;
    int indexLinhaPoligonal;

    //Ponto criado para indentificar o final da lista
    //PontoGr PontoNeutro = new PontoGr();
    Ponto p = new Ponto();
    DoisPontos PontosNeutro = new DoisPontos();

   

    //Criando uma lista para cada objeto
    ArrayList<PontoGr> ArrayPonto;
    ArrayList<RetaGr> ArrayReta;
    ArrayList<CircGr> ArrayCirculo;
    ArrayList<RetanguloGr> ArrayRetangulo;
    ArrayList<PoligonoGr> ArrayPoligono;
    ArrayList<LinhaPoligonalGr> ArrayLinhaPoligonal;
    
    /**
     * Quando a classe for instanciada os indexadores e as listas serão inicializados
     */
    public Armazenamento(){
        
        indexPonto = 0;
        indexReta = 0;
        indexCirculo = 0;
        indexRetangulo = 0;
        indexPoligono = 0;
        indexLinhaPoligonal = 0;

        ArrayPonto = new ArrayList<PontoGr>();
        ArrayReta = new ArrayList<RetaGr>();;
        ArrayCirculo = new ArrayList<CircGr>();;
        ArrayRetangulo = new ArrayList<RetanguloGr>();;
        ArrayPoligono = new ArrayList<PoligonoGr>();;
        ArrayLinhaPoligonal = new ArrayList<LinhaPoligonalGr>();;

        
        //PontoNeutro.setX(-1);
        //PontoNeutro.setY(-1);

        PontosNeutro.setX1(-1);
        PontosNeutro.setY1(-1);
        PontosNeutro.setX2(-1);
        PontosNeutro.setY2(-1);
    }
    
    /**
     * set do ponto na lista
     * @param ponto - ponto
     */
    public void setArrayPonto(PontoGr ponto){
        ArrayPonto.add(ponto);
        indexPonto++;
        setIndexPonto(indexPonto);
    }
    
    /**
     * Busca o conteudo na lista
     * @return valor - valor referido na lista
     */
    public PontoGr getArrayPonto(){
        indexPonto--;
        setIndexPonto(indexPonto);
        PontoGr valor;
        if(indexPonto >= 0){//Controle para verificar se existem dados no array
            
            valor =  ArrayPonto.get(getIndexPonto());
            ArrayPonto.remove(indexPonto);
        }else valor = null; //(-1,-1);
        
        return valor;
    }

    /**
     * seta uma reta na lista
     * @param reta - reta
     */
    public void setArrayReta(RetaGr reta){
        ArrayReta.add(reta);
        indexReta++;
        setIndexReta(indexReta);
    }

    /**
     * busta a reta na lista
     * @return valor - valor referido na lista
     */
    public RetaGr getArrayReta(){
        indexReta--;
        setIndexReta(indexReta);
        RetaGr valor;
        if(indexReta >= 0){//Controle para verificar se existem dados no array
            valor = ArrayReta.get(getIndexReta());
            ArrayReta.remove(indexReta);
        }else valor = null;

        return valor;
    }

    /**
     * seta um circulo na lista
     * @param circulo - circulo
     */
    public void setArrayCirculo(CircGr circulo){
        ArrayCirculo.add(circulo);
        indexCirculo++;
        setIndexCirculo(indexCirculo);
    }
    
    /**
     * Busca o circulo na lista
     * @return valor - valor referido na lista
     */
    public CircGr getArrayCirculo(){
        indexCirculo--;
        setIndexCirculo(indexCirculo);
        CircGr valor;
        if(indexCirculo >= 0){//Controle para verificar se existem dados no array
            valor = ArrayCirculo.get(getIndexCirculo());
            ArrayCirculo.remove(indexCirculo);
        }else valor = null;

        return valor;
    }

    /**
     * Seta um retangulo na lista
     * @param retangulo - retangulo
     */
    public void setArrayRetangulo(RetanguloGr retangulo){
        ArrayRetangulo.add(retangulo);
        indexRetangulo++;
        setIndexRetangulo(indexRetangulo);
    }

    /**
     * Busca um retangulo na lista
     * @return valor - valor referido na lista
     */
    public RetanguloGr getArrayRetangulo(){
        indexRetangulo--;
        setIndexRetangulo(indexRetangulo);
        RetanguloGr valor;
        if(indexRetangulo >= 0){//Controle para verificar se existem dados no array
            valor = ArrayRetangulo.get(getIndexRetangulo());
            ArrayRetangulo.remove(indexRetangulo);
        }else valor = null;

        return valor;
    }

    /**
     * seta um poligono na lista
     * @param poligono - poligono
     */
    public void setArrayPoligono(PoligonoGr poligono){
        ArrayPoligono.add(poligono);
        indexPoligono++;
        setIndexPoligono(indexPoligono);
    }

    
    /**
     * busca um poligono na lista
     * @return valor - valor referido na lista
     */
    public PoligonoGr getArrayPoligono(){
        indexPoligono--;
        setIndexPoligono(indexPoligono);
        PoligonoGr valor;
        if(indexPoligono >= 0){//Controle para verificar se existem dados no array
            valor = ArrayPoligono.get(getIndexPoligono());
            ArrayPoligono.remove(indexPoligono);
        }else valor = null;

        return valor;
    }

    /**
     * seta uma linhaPoligonal na lista
     * @param linhaPoligonal - linha Poligonal
     */
    public void setArrayLinhaPoligonal(LinhaPoligonalGr linhaPoligonal){
        ArrayLinhaPoligonal.add(linhaPoligonal);
        indexLinhaPoligonal++;
        setIndexLinhaPoligonal(indexLinhaPoligonal);
    }

    /**
     * busca uma linha poligonal na lista
     * @return valor - valor referido na lista
     */
    public LinhaPoligonalGr getArrayLinhaPoligonal(){
        indexLinhaPoligonal--;
        setIndexLinhaPoligonal(indexLinhaPoligonal);
        LinhaPoligonalGr valor;
        if(indexLinhaPoligonal >= 0){//Controle para verificar se existem dados no array
            valor = ArrayLinhaPoligonal.get(getIndexLinhaPoligonal());
            ArrayLinhaPoligonal.remove(indexLinhaPoligonal);
        }else valor = null;

        return valor;
    }

    //setters e getters
    /**
    * pega o contador do IndexPonto
    * @return indexPonto
    */
    public int getIndexPonto() {
        return this.indexPonto;
    }
    /**
     * seta o contador do IndexPonto
     */
    public void setIndexPonto(int indexPonto) {
        this.indexPonto = indexPonto;
    }
    /**
     * seta o contador do IndexReta
     * @return indexReta
     */
    public int getIndexReta() {
        return this.indexReta;
    }
    /**
    * seta o contador do IndexReta
    */    
    public void setIndexReta(int indexReta) {
        this.indexReta = indexReta;
    }
    /**
    * retorna o contador do IndexCirculo
    * @return indexCirculo
    */    
    public int getIndexCirculo() {
        return this.indexCirculo;
    }
    /**
    * seta o contador do IndexCirculo
    */
    public void setIndexCirculo(int indexCirculo) {
        this.indexCirculo = indexCirculo;
    }
    /**
    * retorna o contador do IndexRetangulo
    * @return indexRetangulo
    */
    public int getIndexRetangulo() {
        return this.indexRetangulo;
    }
    /**
    * seta o contador do IndexRetangulo
    */
    public void setIndexRetangulo(int indexRetangulo) {
        this.indexRetangulo = indexRetangulo;
    }
    /**
    * retorna o contador do IndexPoligono
    * @return indexPoligono
    */
    public int getIndexPoligono() {
        return this.indexPoligono;
    }
    /**
    * seta o contador do Poligono
    */
    public void setIndexPoligono(int indexPoligono) {
        this.indexPoligono = indexPoligono;
    }
    
    /**
    * retorna o contador da linha poligonal.
    * @return indexLinhaPoligonal
    */
    public int getIndexLinhaPoligonal() {
        return this.indexLinhaPoligonal;
    }
    /**
    * seta o contador da linha poligonal
    */
    public void setIndexLinhaPoligonal(int indexLinhaPoligonal) {
        this.indexLinhaPoligonal = indexLinhaPoligonal;
    }
    /**
    * retorna o ponto P
    * @return PontosNeutro
    */
    public Ponto getP() {
        return this.p;
    }
    /**
    * seta os pontos neutros
    */
    public void setP(Ponto p) {
        this.p = p;
    }
    /**
    * pega os pontos neutros
    * @return PontosNeutro
    */
    public DoisPontos getPontosNeutro() {
        return this.PontosNeutro;
    }
    /**
    * seta os pontos neutros
    */
    public void setPontosNeutro(DoisPontos PontosNeutro) {
        this.PontosNeutro = PontosNeutro;
    }   

}
