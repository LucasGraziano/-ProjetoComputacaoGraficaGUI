package GUI;
import java.awt.*;

import ED.Armazenamento;
import Tipos.Circulo.CircGr;
import Tipos.LinhaPoligonal.LinhaPoligonalGr;
import Tipos.Poligono.PoligonoGr;
import Tipos.Ponto.Ponto;
import Tipos.Ponto.PontoGr;
import Tipos.Reta.RetaGr;
import Tipos.Retangulo.RetanguloGr;
import Tipos.Cubo.CuboGr;


/**
 * Classe de controle dos pontos
 */
public class FiguraPontos {
        public static Armazenamento arm = new Armazenamento();

        static int poligono_aux = -1;
        static boolean poligono_fim = false;
        /**
         * Funcao responsavel para o desenho da reta 
         *
         * @param g - conteudo grafico
         * @param x - coordenada x do ponto
         * @param y - coordenada - do ponto
         * @param nome - nome do ponto
         * @param diametro - diametro do ponto
         */
        public static void desenharPonto(Graphics g, int x, int y, String nome, int diametro, Color cor) {
                PontoGr p = new PontoGr(x, y, cor, nome, diametro);
                arm.setArrayPonto(p);
                p.desenharPonto(g);
        }  

        /**
         * Funcao responsavel para o desenho da reta 
         * 
         * @param g - conteudo grafico
         * @param x1 - primeiro x da coordenada
         * @param y1 - primeiro y da coordenada
         * @param x2 - segundo x da coordenada
         * @param y2 - segundo y da coordenada
         * @param nome - nome dos pontos da reta
         * @param diametro - diametro da bolinha
         */
        public static void desenharReta(Graphics g, int x1, int y1, int x2, int y2, int diametro, Color cor) {
                
                RetaGr p = new RetaGr(x1, y1, x2, y2, cor, diametro);
                arm.setArrayReta(p);
                p.desenharReta(g);
        }

        /**
         * Funcao responsavel para o desenho do Circulo
         * 
         * @param g - conteudo grafico
         * @param x - primeiro x da coordenada
         * @param y - primeiro y da coordenada
         * @param nome - nome dos pontos da reta
         * @param diametro - diametro da bolinha
         */
        public static void desenharCirc(Graphics g, int x, int y, int x2, int y2, int diametro, Color cor) {
                
                CircGr p = new CircGr(x, y, x2, y2, cor, diametro);
                arm.setArrayCirculo(p);
                p.desenharCirc(g); 
        }

        /**
         * Funcao responsavel para o desenho do retangulo 
         * 
         * @param g - conteudo grafico
         * @param x1 - primeiro x da coordenada
         * @param y1 - primeiro y da coordenada
         * @param x2 - segundo x da coordenada
         * @param y2 - segundo y da coordenada
         * @param diametro - diametro
         * @param color - cor da reta
         */
        public static void desenharRetangulo(Graphics g, int x1, int y1, int x2, int y2, int diametro, Color cor) {
                
                RetanguloGr p = new RetanguloGr(x1, y1, x2, y2, cor, diametro);
                arm.setArrayRetangulo(p);
                p.desenharRetangulo(g);
        }
        /**
         * Funcao responsavel para o desenho do retangulo 
         * 
         * @param g - conteudo grafico
         * @param x1 - primeiro x da coordenada
         * @param y1 - primeiro y da coordenada
         * @param x2 - segundo x da coordenada
         * @param y2 - segundo y da coordenada
         * @param diametro - diametro
         * @param color - cor da reta
         */
        public static void desenharPoligono(Graphics g, int x1, int y1, int x2, int y2, int diametro, Color cor) {
                if(poligono_aux == -1){
                        PoligonoGr p = new PoligonoGr(x1, y1, x2, y2, cor, diametro);
                        poligono_aux = arm.ArrayPoligono.size();
                        arm.setArrayPoligono(p);
                        p.desenharPoligono(g);
                }else if(poligono_fim == true){
                        PoligonoGr p = arm.ArrayPoligono.get(poligono_aux);
                        p.adicionarRetaFinal(g);
                        poligono_aux = -1;
                        poligono_fim = false;
                }else{
                        PoligonoGr p = arm.ArrayPoligono.get(poligono_aux);
                        p.adicionarReta(g, new Ponto(x1, y1), new Ponto(x2, y2));
                }
        }
        /**
         * Funcao responsavel para o desenho do retangulo 
         * 
         * @param g - conteudo grafico
         * @param x1 - primeiro x da coordenada
         * @param y1 - primeiro y da coordenada
         * @param x2 - segundo x da coordenada
         * @param y2 - segundo y da coordenada
         * @param diametro - diametro da bolinha
         * @param color - cor da reta
         */
        public static void desenharLinhaPoligonal(Graphics g, int x1, int y1, int x2, int y2, int diametro, Color cor) {
                if(poligono_aux == -1){
                        LinhaPoligonalGr p = new LinhaPoligonalGr(x1, y1, x2, y2, cor, diametro);
                        poligono_aux = arm.ArrayLinhaPoligonal.size();
                        arm.setArrayLinhaPoligonal(p);
                        p.desenharLinhaPoligonal(g);
                }else if(poligono_fim == true){
                        poligono_aux = -1;
                        poligono_fim = false;
                }else{
                        LinhaPoligonalGr p = arm.ArrayLinhaPoligonal.get(poligono_aux);
                        p.adicionarReta(g, new Ponto(x1, y1), new Ponto(x2, y2));
                }      
        }

        /**
         * Funcao responsavel para o desenho o cubo 
         * 
         * @param g - conteudo grafico
         * @param x1 - primeiro x da coordenada
         * @param y1 - primeiro y da coordenada
         * @param diametro - diametro da bolinha
         * @param color - cor da reta
         */
        public static void desenharCubo(Graphics g, int x1, int y1, double aresta, int diametro, Color cor) {
                
                CuboGr p = new CuboGr(x1, y1, (int)aresta, cor, diametro);
                arm.setArrayCubo(p);
                p.desenharCubo(g);
                
        }

        /**
         * Funcao responsavel para zerar todos os objetos
         */
        public static void zerar(){
                arm.setIndexPonto(0);
                arm.setIndexCirculo(0);
                arm.setIndexRetangulo(0);
                arm.setIndexReta(0);
                arm.setIndexPoligono(0);
                arm.setIndexLinhaPoligonal(0);
                arm.setIndexCubo(0);
        }
}
