package PersistenciaArquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.awt.Color;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JOptionPane;

import org.json.JSONObject;
import org.json.JSONTokener;
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

public class Persistencia {

    public static void salvarArquivo() {
        
        JSONObject jsonPai = new JSONObject();
        JSONArray pontos = new JSONArray();
        JSONArray retas = new JSONArray();
        JSONArray circulos = new JSONArray();
        JSONArray retangulos = new JSONArray();
        JSONArray poligonos = new JSONArray();
        JSONArray linhaspoligonais = new JSONArray();
        
        Armazenamento arm = FiguraPontos.arm;
        try {
            // pega todos os pontos que estão na estrutura de dados
            //percorre a lista dos pontos
            for (PontoGr forma : arm.ArrayPonto) {
                JSONObject pontoObj = new JSONObject();

                JSONObject p1 = new JSONObject();
                p1.put("x", forma.getX()/1000);
                p1.put("y", forma.getY()/600);

                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorPto().getRed());
                cor.put("g", forma.getCorPto().getGreen());
                cor.put("b", forma.getCorPto().getBlue());

                pontoObj.put("p1", p1);
                pontoObj.put("cor", cor);

                pontos.put(pontoObj);
            }
            jsonPai.put("ponto", pontos);

            // pega todas as retas que estão na estrutura de dados
            for (RetaGr forma : arm.ArrayReta) {
                JSONObject retaObj = new JSONObject();

                JSONObject p1 = new JSONObject();
                p1.put("x", forma.getX1()/1000);
                p1.put("y", forma.getY1()/600);

                JSONObject p2 = new JSONObject();
                p2.put("x", forma.getX2()/1000);
                p2.put("y", forma.getY2()/600);

                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorReta().getRed());
                cor.put("g", forma.getCorReta().getGreen());
                cor.put("b", forma.getCorReta().getBlue());

                retaObj.put("p1", p1);
                retaObj.put("p2", p2);
                retaObj.put("cor", cor);

                retas.put(retaObj);
            }
            jsonPai.put("reta", retas);

            // pega todas os circulos que estão na estrutura de dados
            for (CircGr forma : arm.ArrayCirculo) {
                JSONObject circObj = new JSONObject();

                JSONObject p1 = new JSONObject();
                p1.put("x", forma.getX1()/1000);
                p1.put("y", forma.getY1()/600);

                JSONObject p2 = new JSONObject();
                p2.put("x", forma.getX2()/1000);
                p2.put("y", forma.getY2()/600);

                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorCirc().getRed());
                cor.put("g", forma.getCorCirc().getGreen());
                cor.put("b", forma.getCorCirc().getBlue());

                circObj.put("p1", p1);
                circObj.put("p2", p2);
                circObj.put("cor", cor);

                circulos.put(circObj);
            }
            jsonPai.put("circulo", circulos);

            // pega todos os retangulos que estão na estrutura de dados
            for (RetanguloGr forma : arm.ArrayRetangulo) {
                JSONObject retanguloObj = new JSONObject();

                JSONObject p1 = new JSONObject();
                p1.put("x", forma.getX1()/1000);
                p1.put("y", forma.getY1()/600);

                JSONObject p2 = new JSONObject();
                p2.put("x", forma.getX2()/1000);
                p2.put("y", forma.getY1()/600);

                JSONObject p3 = new JSONObject();
                p3.put("x", forma.getX1()/1000);
                p3.put("y", forma.getY2()/600);

                JSONObject p4 = new JSONObject();
                p4.put("x", forma.getX2()/1000);
                p4.put("y", forma.getY2()/600);

                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorPto().getRed());
                cor.put("g", forma.getCorPto().getGreen());
                cor.put("b", forma.getCorPto().getBlue());

                retanguloObj.put("p1", p1);
                retanguloObj.put("p2", p2);
                retanguloObj.put("p3", p3);
                retanguloObj.put("p4", p4);
                retanguloObj.put("cor", cor);

                retangulos.put(retanguloObj);
            }
            jsonPai.put("retangulo", retangulos);

            // pega todos os poligonos que estão na estrutura de dados
            for (PoligonoGr forma : arm.ArrayPoligono) {
                JSONObject poligonoObj = new JSONObject();

                JSONArray ponto = new JSONArray();

                for(Ponto p : forma.getPontos()){
                    JSONObject objPonto = new JSONObject();

                    objPonto.put("x", p.x);
                    objPonto.put("y", p.y);

                    ponto.put(objPonto);
                }
                

                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorReta().getRed());
                cor.put("g", forma.getCorReta().getGreen());
                cor.put("b", forma.getCorReta().getBlue());

                poligonoObj.put("ponto", ponto);
                poligonoObj.put("cor", cor);
                poligonos.put(poligonoObj);
            }
            jsonPai.put("poligono", poligonos);

            // pega todas as linhas poligonais que estão na estrutura de dados
            for (LinhaPoligonalGr forma : arm.ArrayLinhaPoligonal) {
                JSONObject linhapoligonalObj = new JSONObject();

                JSONArray ponto = new JSONArray();
                
                for(Ponto p : forma.getPontos()){
                    JSONObject objPonto = new JSONObject();

                    objPonto.put("x", p.x);
                    objPonto.put("y", p.y);

                    ponto.put(objPonto);
                }
                
                JSONObject cor = new JSONObject();
                cor.put("r", forma.getCorReta().getRed());
                cor.put("g", forma.getCorReta().getGreen());
                cor.put("b", forma.getCorReta().getBlue());
                
                linhapoligonalObj.put("ponto", ponto);
                linhapoligonalObj.put("cor", cor);

                linhaspoligonais.put(linhapoligonalObj);
            }
            jsonPai.put("linha poligonal", linhaspoligonais);

            System.out.println(jsonPai);
            try {
                FileWriter file = new FileWriter(
                        "C:/Users/lucas/Desktop/Teste8000/PersistenciaArquivos/Json/teste.json");
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
        file = new File("C:/Users/lucas/Desktop/Teste8000/PersistenciaArquivos/Json/teste.json");
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

            arm.ArrayPonto.add(new PontoGr((int) (x * 1000), (int) (y * 600), new Color(r, g, b), "p", 15));
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

            arm.ArrayReta.add(new RetaGr((int) (x1 * 1000), (int) (y1 * 600), (int) (x2 * 1000), (int) (y2 * 600), new Color(r, g, b), 15));
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

            arm.ArrayCirculo.add(new CircGr((int) (x1 * 1000), (int) (y1 * 600), (int) (x2 * 1000), (int) (y2 * 600), new Color(r, g, b), 15));
        }

        //adiciona os retangulos
        JSONArray retangulos = jObj.getJSONArray("retangulo");
        for (int i=0; i < retangulos.length(); i++) {
            JSONObject retanguloObj = retangulos.getJSONObject(i);

            JSONObject p1 = retanguloObj.getJSONObject("p1");
            double x1 = p1.getDouble("x");
            double y1 = p1.getDouble("y");

            JSONObject p4 = retanguloObj.getJSONObject("p4");
            double x2 = p4.getDouble("x");
            double y2 = p4.getDouble("y");

            JSONObject cor = retanguloObj.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");

            arm.ArrayRetangulo.add(new RetanguloGr((int) (x1 * 1000), (int) (y1 * 600), (int) (x2 * 1000), (int) (y2 * 600), new Color(r, g, b), 15));
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

        

        System.out.println(jObj.toString());
    }
}
