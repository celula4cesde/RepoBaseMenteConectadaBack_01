package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\u001B[34mSistema de registro de datos sobre salud mental📊");
        System.out.println("\u001B[34m===================================================");

        List<String> tipos = Arrays.asList(
                "Actividad", "Evento", "Cita médica",
                "Cita médica", "Evento", "Actividad"
        );

        Map<String, Integer> contar = new HashMap<>();

        for (String tipo : tipos) {
            contar.put(tipo, contar.getOrDefault(tipo, 0) + 1);
        }

        System.out.println("📋Registros organizados");
        for (String tipo : contar.keySet()) {
            System.out.println(" " + tipo + " " + contar.get(tipo) + " Registros");
        }
    }
}