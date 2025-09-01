package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("\n\u001B[34m Reporte mensual de eventos de salud mental🤪📑📊");
        System.out.println("\u001B[34m===================================================");
        //Instanciar clases

        //Datos entrada
        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };


        //Hashmap
        HashMap<String, Integer> enero = new HashMap<>();
        enero.put("Consultas psicológicas", 23);
        HashMap<String, Integer> febrero = new HashMap<>();
        febrero.put("Grupo de apoyo emocional", 90);
        HashMap<String, Integer> marzo = new HashMap<>();
        marzo.put("Técnicas de mindfulness y meditación", 67);
        HashMap<String, Integer> abril = new HashMap<>();
        abril.put("Taller de prevención del suicidio", 200);
        HashMap<String, Integer> mayo = new HashMap<>();
        mayo.put("Protocolos de intervención post-trauma", 87);
        HashMap<String, Integer> junio = new HashMap<>();
        junio.put("Terapia cognitivo-conductual (TCC)", 70);
        HashMap<String, Integer> julio = new HashMap<>();
        julio.put("Charlas de sensibilización (bullying, ansiedad, etc.)", 48);
        HashMap<String, Integer> agosto = new HashMap<>();
        agosto.put("Orientación individual o familiar", 980);
        HashMap<String, Integer> septiembre = new HashMap<>();
        septiembre.put("Detección de casos en riesgo", 67);
        HashMap<String, Integer> octubre = new HashMap<>();
        octubre.put("Terapia narrativa", 129);
        HashMap<String, Integer> noviembre = new HashMap<>();
        noviembre.put("Aplicación de pruebas psicométricas", 678);
        HashMap<String, Integer> diciembre = new HashMap<>();
        diciembre.put("Observación conductual", 56);

        ArrayList<HashMap<String, Integer>> reportes = new ArrayList<>(
                Arrays.asList(enero, febrero, marzo, abril, mayo, junio, julio, agosto, septiembre, octubre, noviembre, diciembre)
        );

        for (int i = 0; i < reportes.size(); i++) {
            HashMap<String, Integer> eventos = reportes.get(i);
            String mes = meses[i];

            for (String tituloEvento : eventos.keySet()) {
                int cantidad = eventos.get(tituloEvento);
                System.out.println("\u001B[36m 🗓️ Mes: " + mes);
                System.out.println("\u001B[36m 📌 Evento: " + tituloEvento);
                System.out.println("\u001B[36m ✨ Cantidad de casos: " + cantidad);
                System.out.println("\n\u001B[36m=============================");

            }

        }
    }
}