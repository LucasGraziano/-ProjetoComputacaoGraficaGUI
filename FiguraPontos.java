import java.awt.*;

/**
 * Classe de controle dos pontos
 * 
 * @author
 * MA4B
 * Julio Cesar Barboza - RA00297586
 * Lucas Costa Pessoa Graziano - RA00297851
 * Gustavo Scacchetti - RA00301499
 * @version 09/08/2022
 */
public class FiguraPontos {

        /**
         * Funcao responsavel para o desenho da reta 
         *
         * @param g - conteudo grafico
         * @param x - coordenada x do ponto
         * @param y - coordenada - do ponto
         * @param nome - nome do ponto
         * @param diametro - diametro do ponto
         */
        public static void desenharPonto(Graphics g, int x, int y, String nome, int diametro) {
                Color cor = new Color((int) (Math.random() * 256),
                                (int) (Math.random() * 256),
                                (int) (Math.random() * 256));
                PontoGr p = new PontoGr(x, y, cor, nome, diametro);
                p.desenharPonto(g);
        }

        /**
         * Funcao responsavel para o desenho do ponto 
         *
         * @param g - conteudo grafico
         * @param qtde - relacionado a cor do ponto
         * @param larg - diametro do ponto
         */
        public static void desenharPontos(Graphics g, int qtde, int larg) {

                for (int i = 0; i < qtde; i++) {
                        int x = (int) (Math.random() * 801);
                        int y = (int) (Math.random() * 801);

                        // R, G e B aleatorio
                        Color cor = new Color((int) (Math.random() * 256),
                                        (int) (Math.random() * 256),
                                        (int) (Math.random() * 256));
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
        public static void desenharReta(Graphics g, int x1, int y1, int x2, int y2, int diametro) {
                Color cor = new Color((int) (Math.random() * 256),
                                (int) (Math.random() * 256),
                                (int) (Math.random() * 256));
                RetaGr p = new RetaGr(x1, y1, x2, y2, cor, diametro);
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
        public static void desenharCirc(Graphics g, int x, int y, int x2, int y2, int diametro) {
                Color cor = new Color((int) (Math.random() * 256),
                                (int) (Math.random() * 256),
                                (int) (Math.random() * 256));
                CircGr p = new CircGr(x, y, cor, diametro);
                p.desenharCirc(g, x2, y2);
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
        public static void desenharRetangulo(Graphics g, int x1, int y1, int x2, int y2, int diametro) {
                Color cor = new Color((int) (Math.random() * 256),
                                (int) (Math.random() * 256),
                                (int) (Math.random() * 256));
                RetanguloGr p = new RetanguloGr(x1, y1, x2, y2, cor, diametro);
                p.desenharRetangulo(g);
        }

}
