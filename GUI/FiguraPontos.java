package GUI;
import java.awt.*;

import ED.Armazenamento;
import Tipos.Circulo.CircGr;
import Tipos.LinhaPoligonal.LinhaPoligonalGr;
import Tipos.Poligono.PoligonoGr;
import Tipos.Ponto.PontoGr;
import Tipos.Reta.RetaGr;
import Tipos.Retangulo.RetanguloGr;


/**
 * Classe de controle dos pontos
 */
public class FiguraPontos {
        static Armazenamento arm = new Armazenamento();
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

        /*public static void redesenharPonto(Graphics g, int x, int y, String nome, Color cor, int diametro) {
                PontoGr p = new PontoGr(x, y, cor, nome, diametro);
                p.desenharPonto(g);
        }*/

        /**
         * Funcao responsavel para o desenho do ponto 
         *
         * @param g - conteudo grafico
         * @param qtde - relacionado a cor do ponto
         * @param larg - diametro do ponto
         */
        public static void desenharPontos(Graphics g, int qtde, int larg, Color cor) {

                for (int i = 0; i < qtde; i++) {
                        int x = (int) (Math.random() * 801);
                        int y = (int) (Math.random() * 801);

                        PontoGr p = new PontoGr(x, y, cor, larg);
                        p.desenharPonto(g);
                }
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

        /*public static void redesenharReta(Graphics g, int x1, int y1, int x2, int y2, Color cor, int diametro) {
                RetaGr p = new RetaGr(x1, y1, x2, y2, cor, diametro);
                p.desenharReta(g);
        }*/

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

        /*public static void redesenharCirc(Graphics g, int x, int y, int x2, int y2, Color cor,  int diametro) {
                CircGr p = new CircGr(x, y, x2, y2, cor, diametro);
                p.desenharCirc(g);
        }*/

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
        public static void desenharRetangulo(Graphics g, int x1, int y1, int x2, int y2, int diametro, Color cor) {
                
                RetanguloGr p = new RetanguloGr(x1, y1, x2, y2, cor, diametro);
                arm.setArrayRetangulo(p);
                p.desenharRetangulo(g);
        }

        /*public static void redesenharRetangulo(Graphics g, int x1, int y1, int x2, int y2, Color cor, int diametro) {
                RetanguloGr p = new RetanguloGr(x1, y1, x2, y2, cor, diametro);
                p.desenharRetangulo(g);
        }*/
        
        public static void desenharPoligono(Graphics g, int x1, int y1, int x2, int y2, int diametro, Color cor) {
                PoligonoGr p = new PoligonoGr(x1, y1, x2, y2, cor, diametro);
                arm.setArrayPoligono(p);
                p.desenharPoligono(g);
        }

        /*public static void redesenharPoligono(Graphics g, int x1, int y1, int x2, int y2, Color cor, int diametro) {

                PoligonoGr p = new PoligonoGr(x1, y1, x2, y2, cor, diametro);
                p.desenharPoligono(g);
        }*/

        public static void desenharLinhaPoligonal(Graphics g, int x1, int y1, int x2, int y2, int diametro, Color cor) {
                
                LinhaPoligonalGr p = new LinhaPoligonalGr(x1, y1, x2, y2, cor, diametro);
                arm.setArrayLinhaPoligonal(p);
                p.desenharLinhaPoligonal(g);
        }

        /*public static void redesenharLinhaPoligonal(Graphics g, int x1, int y1, int x2, int y2, Color cor, int diametro) {
                LinhaPoligonalGr p = new LinhaPoligonalGr(x1, y1, x2, y2, cor, diametro);
                p.desenharLinhaPoligonal(g);
        }*/

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
        }
}
