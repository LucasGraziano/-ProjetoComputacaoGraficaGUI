package PersistenciaArquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.json.JSONArray;
import ED.Armazenamento;
import GUI.FiguraPontos;
import Tipos.Circulo.CircGr;
import Tipos.LinhaPoligonal.LinhaPoligonalGr;
import Tipos.Poligono.PoligonoGr;
import Tipos.Ponto.Ponto;
import Tipos.Ponto.PontoGr;
import Tipos.Reta.RetaGr;
import Tipos.Retangulo.RetanguloGr;
import org.json.JSONException;

/*
 * construtor para salvar e ler arquivo em json
 */
public class Persistencia {

    /**
     * salva um arquivo em json
     */
    public static void salvarArquivo() {
        
        //objects e arrays do json
        JSONObject jsonPai = new JSONObject(); //objeto principal
        JSONArray pontos = new JSONArray(); //array onde armazena os pontos
        JSONArray retas = new JSONArray(); //array onde armazena as retas
        JSONArray circulos = new JSONArray(); //array onde armazena os circulos
        JSONArray retangulos = new JSONArray(); //array onde armazena os retangulos
        JSONArray poligonos = new JSONArray(); //array onde armazena os poligonos
        JSONArray linhaspoligonais = new JSONArray(); //array onde armazena as linhas poligonais
        
        Armazenamento arm = FiguraPontos.arm; //armazenamento
        try {
            // pega todos os pontos que estão na estrutura de dados
            //percorre a lista dos pontos
            for (PontoGr forma : arm.ArrayPonto) {
                JSONObject pontoObj = new JSONObject();
                
                //adicionando p1
                JSONObject p1 = new JSONObject();
                p1.put("x", forma.getX()/1300);
                p1.put("y", forma.getY()/800);
                
                //adicicionando cor
                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorPto().getRed());
                cor.put("g", forma.getCorPto().getGreen());
                cor.put("b", forma.getCorPto().getBlue());

                //colocando informacoes no pontoObj
                pontoObj.put("p1", p1);
                pontoObj.put("cor", cor);

                //colocando informacoes em pontos
                pontos.put(pontoObj);
            }
            
            //colocando no Objeto pai
            jsonPai.put("ponto", pontos);

            // pega todas as retas que estão na estrutura de dados
            for (RetaGr forma : arm.ArrayReta) {
                JSONObject retaObj = new JSONObject();

                //adicionando p1
                JSONObject p1 = new JSONObject();
                p1.put("x", forma.getX1()/1300);
                p1.put("y", forma.getY1()/800);

                //adicionando p2
                JSONObject p2 = new JSONObject();
                p2.put("x", forma.getX2()/1300);
                p2.put("y", forma.getY2()/800);

                //adicionando cor
                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorReta().getRed());
                cor.put("g", forma.getCorReta().getGreen());
                cor.put("b", forma.getCorReta().getBlue());

                //colocando informacoes na retaObj
                retaObj.put("p1", p1);
                retaObj.put("p2", p2);
                retaObj.put("cor", cor);

                //colocando informacoes em retas
                retas.put(retaObj);
            }
            //colocando no Objeto pai
            jsonPai.put("reta", retas);

            // pega todas os circulos que estão na estrutura de dados
            for (CircGr forma : arm.ArrayCirculo) {
                JSONObject circObj = new JSONObject();
                
                //adicionando p1
                JSONObject p1 = new JSONObject();
                p1.put("x", forma.getX1()/1300);
                p1.put("y", forma.getY1()/800);

                //adicionando p2
                JSONObject p2 = new JSONObject();
                p2.put("x", forma.getX2()/1300);
                p2.put("y", forma.getY2()/800);

                //adicionando cor
                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorCirc().getRed());
                cor.put("g", forma.getCorCirc().getGreen());
                cor.put("b", forma.getCorCirc().getBlue());

                //colocando informacoes no circObj
                circObj.put("p1", p1);
                circObj.put("p2", p2);
                circObj.put("cor", cor);

                //colocando informacoes em circulo
                circulos.put(circObj);
            }
            //colocando no Objeto pai
            jsonPai.put("circulo", circulos);

            // pega todos os retangulos que estão na estrutura de dados
            for (RetanguloGr forma : arm.ArrayRetangulo) {
                JSONObject retanguloObj = new JSONObject();

                //adicionando p1
                JSONObject p1 = new JSONObject();
                p1.put("x", forma.getX1()/1300);
                p1.put("y", forma.getY1()/800);

                //adicionando p2
                JSONObject p2 = new JSONObject();
                p2.put("x", forma.getX2()/1300);
                p2.put("y", forma.getY2()/800);

                //adicionando p3
                JSONObject p3 = new JSONObject();
                p3.put("x", forma.getX3()/1300);
                p3.put("y", forma.getY3()/800);

                //adicionando p4
                JSONObject p4 = new JSONObject();
                p4.put("x", forma.getX4()/1300);
                p4.put("y", forma.getY4()/800);

                //adicionando cor
                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorPto().getRed());
                cor.put("g", forma.getCorPto().getGreen());
                cor.put("b", forma.getCorPto().getBlue());

                //colocando informacoes no retanguloObj
                retanguloObj.put("p1", p1);
                retanguloObj.put("p2", p2);
                retanguloObj.put("p3", p3);
                retanguloObj.put("p4", p4);
                retanguloObj.put("cor", cor);

                //colocando informacoes em retangulo
                retangulos.put(retanguloObj);
            }
            //colocando no Objeto pai
            jsonPai.put("retangulo", retangulos);

            // pega todos os poligonos que estão na estrutura de dados
            for (PoligonoGr forma : arm.ArrayPoligono) {
                JSONObject poligonoObj = new JSONObject();

                JSONArray ponto = new JSONArray();

                //adiciona todos os pontos do poligono
                for(Ponto p : forma.getPontos()){
                    JSONObject objPonto = new JSONObject();

                    objPonto.put("x", p.x);
                    objPonto.put("y", p.y);

                    ponto.put(objPonto);
                }
                
                //adicionando cor
                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorReta().getRed());
                cor.put("g", forma.getCorReta().getGreen());
                cor.put("b", forma.getCorReta().getBlue());

                //colocando informacoes no poligonoObj
                poligonoObj.put("ponto", ponto);
                poligonoObj.put("cor", cor);

                //colocando informacoes em poligonos
                poligonos.put(poligonoObj);
            }
            //colocando no Objeto pai
            jsonPai.put("poligono", poligonos);

            // pega todas as linhas poligonais que estão na estrutura de dados
            for (LinhaPoligonalGr forma : arm.ArrayLinhaPoligonal) {
                JSONObject linhapoligonalObj = new JSONObject();

                JSONArray ponto = new JSONArray();
                //adiciona todos os pontos da linha poligonal
                for(Ponto p : forma.getPontos()){
                    JSONObject objPonto = new JSONObject();

                    objPonto.put("x", p.x);
                    objPonto.put("y", p.y);

                    ponto.put(objPonto);
                }

                //adicionando cor
                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorReta().getRed());
                cor.put("g", forma.getCorReta().getGreen());
                cor.put("b", forma.getCorReta().getBlue());
                
                //colocando informacoes na linhapoligonalObj
                linhapoligonalObj.put("ponto", ponto);
                linhapoligonalObj.put("cor", cor);

                //colocando informacoes em linha poligonal
                linhaspoligonais.put(linhapoligonalObj);
            }
            //colocando no Objeto pai
            jsonPai.put("linha poligonal", linhaspoligonais);

            System.out.println(jsonPai);
            try {
                FileWriter file = new FileWriter(
                        "C:/Users/ra00297851/Desktop/-ProjetoComputacaoGraficaGUI/-ProjetoComputacaoGraficaGUI/PersistenciaArquivos/Json/teste.json");
                file.write(jsonPai.toString());
                file.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void lerArquivo() {
        Armazenamento arm = FiguraPontos.arm;
        File file = null;
        BufferedReader br = null;
        FileReader fr = null;
        
        //caminho do arquivo
        file = new File("C:/Users/ra00297851/Desktop/-ProjetoComputacaoGraficaGUI/-ProjetoComputacaoGraficaGUI/PersistenciaArquivos/Json/teste.json");
        if (!file.exists()) { //testa para ver se o arquivo existe
            JOptionPane.showInputDialog("Arquivo inexistente");
        }

        String teste1 = "";
        String teste = "";
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            
            while ((teste1 = br.readLine()) != null){
                teste += teste1;
                System.out.println(teste1);
            }
            

        } catch(FileNotFoundException ex) {
            JOptionPane.showInputDialog("Arquivo inexistente:");
            return;
        } catch(Exception ex) {
            JOptionPane.showInputDialog("Erro inesperado ao tentar abrir o arquivo: ");
            ex.printStackTrace();
            return;
        }
        
        JSONObject jObj = new JSONObject(teste);

        //adiciona os pontos
        JSONArray pontos = jObj.getJSONArray("ponto");
        for (int i=0; i < pontos.length(); i++) {
            JSONObject pontoObj = pontos.getJSONObject(i);

            JSONObject p1 = pontoObj.getJSONObject("p1");
            double x = p1.getDouble("x");
            double y = p1.getDouble("y");

            JSONObject cor = pontoObj.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");

            arm.ArrayPonto.add(new PontoGr((int) (x * 1300), (int) (y * 800), new Color(r, g, b), "p", 15));
        }

        //adiciona as retas
        JSONArray retas = jObj.getJSONArray("reta");
        for (int i=0; i < retas.length(); i++) {
            JSONObject retaObj = retas.getJSONObject(i);

            JSONObject p1 = retaObj.getJSONObject("p1");
            double x1 = p1.getDouble("x");
            double y1 = p1.getDouble("y");

            JSONObject p2 = retaObj.getJSONObject("p2");
            double x2 = p2.getDouble("x");
            double y2 = p2.getDouble("y");

            JSONObject cor = retaObj.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");

            arm.ArrayReta.add(new RetaGr((int) (x1 * 1300), (int) (y1 * 800), (int) (x2 * 1300), (int) (y2 * 800), new Color(r, g, b), 15));
        }

        //adiciona os circulos
        JSONArray circulos = jObj.getJSONArray("circulo");
        for (int i=0; i < circulos.length(); i++) {
            JSONObject circuloObj = circulos.getJSONObject(i);

            JSONObject p1 = circuloObj.getJSONObject("p1");
            double x1 = p1.getDouble("x");
            double y1 = p1.getDouble("y");

            JSONObject p2 = circuloObj.getJSONObject("p2");
            double x2 = p2.getDouble("x");
            double y2 = p2.getDouble("y");

            JSONObject cor = circuloObj.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");

            arm.ArrayCirculo.add(new CircGr((int) (x1 * 1300), (int) (y1 * 800), (int) (x2 * 1300), (int) (y2 * 800), new Color(r, g, b), 15));
        }

        //adiciona os retangulos
        JSONArray retangulos = jObj.getJSONArray("retangulo");
        for (int i=0; i < retangulos.length(); i++) {
            JSONObject retanguloObj = retangulos.getJSONObject(i);

            JSONObject p1 = retanguloObj.getJSONObject("p1");
            double x1 = p1.getDouble("x");
            double y1 = p1.getDouble("y");

            JSONObject p2 = retanguloObj.getJSONObject("p2");
            double x2 = p2.getDouble("x");
            double y2 = p2.getDouble("y");

            JSONObject p3 = retanguloObj.getJSONObject("p3");
            double x3 = p3.getDouble("x");
            double y3 = p3.getDouble("y");

            JSONObject p4 = retanguloObj.getJSONObject("p4");
            double x4 = p4.getDouble("x");
            double y4 = p4.getDouble("y");

            JSONObject cor = retanguloObj.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");

            arm.ArrayRetangulo.add(new RetanguloGr((int) (x1 * 1300), (int) (y1 * 800), (int) (x2 * 1300), (int) (y2 * 800), (int) (x3 * 1300), (int) (y3 * 800), (int) (x4 * 1300), (int) (y4 * 800), new Color(r, g, b)));
        }

        JSONArray poligonos = jObj.getJSONArray("poligono");
        for (int i=0; i < poligonos.length(); i++) {
            JSONObject poligonoObj = poligonos.getJSONObject(i);

            JSONObject cor = poligonoObj.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");

            JSONArray pontoPoligono = poligonoObj.getJSONArray("ponto");

            int indexPol = arm.ArrayPoligono.size();
            arm.ArrayPoligono.add(new PoligonoGr((int) (0), (int) (0), (int) (0), (int) (0), new Color(r, g, b), 15));

            for (int j=1; j < pontoPoligono.length(); j++) {
                double x1 = pontoPoligono.getJSONObject(j - 1).getDouble("x");
                double y1 = pontoPoligono.getJSONObject(j - 1).getDouble("y");
                double x2 = pontoPoligono.getJSONObject(j).getDouble("x");
                double y2 = pontoPoligono.getJSONObject(j).getDouble("y");

                arm.ArrayPoligono.get(indexPol).adicionarReta(new Ponto(x1, y1), new Ponto(x2, y2));
            }
            
            if(pontoPoligono.length() > 0)
                arm.ArrayPoligono.get(indexPol).adicionarRetaFinal();
        }

        JSONArray linha_poligonal = jObj.getJSONArray("linha poligonal");
        for (int i=0; i < linha_poligonal.length(); i++) {
            JSONObject linha_poligonalObj = linha_poligonal.getJSONObject(i);

            JSONObject cor = linha_poligonalObj.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");

            JSONArray pontoPoligono = linha_poligonalObj.getJSONArray("ponto");

            int indexPol = arm.ArrayLinhaPoligonal.size();
            arm.ArrayLinhaPoligonal.add(new LinhaPoligonalGr((int) (0), (int) (0), (int) (0), (int) (0), new Color(r, g, b), 15));

            for (int j=1; j < pontoPoligono.length(); j++) {
                double x1 = pontoPoligono.getJSONObject(j - 1).getDouble("x");
                double y1 = pontoPoligono.getJSONObject(j - 1).getDouble("y");
                double x2 = pontoPoligono.getJSONObject(j).getDouble("x");
                double y2 = pontoPoligono.getJSONObject(j).getDouble("y");

                arm.ArrayLinhaPoligonal.get(indexPol).adicionarReta(new Ponto(x1, y1), new Ponto(x2, y2));
            }
        }
    }
}
