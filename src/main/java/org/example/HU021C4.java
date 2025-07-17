package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

import java.util.Scanner;

public class HU021C4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int contador = 0;
        String entrada;

        System.out.println("Responde 'si' si asististe, 'no' si no, o 'salir' para terminar.");

        // Leer la primera entrada
        System.out.println("\n¿Asististe a este evento?");
        entrada = scanner.nextLine().toLowerCase();

        // Ciclo principal
        while (!entrada.equals("salir")) {
            if (entrada.equals("si")) {
                contador++;
            } else if (!entrada.equals("no")) {
                System.out.println("Entrada no válida. Usa 'si', 'no' o 'salir'.");
            }

            // Preguntar de nuevo para el siguiente evento
            System.out.println("\n¿Asististe a este evento?");
            entrada = scanner.nextLine().toLowerCase();
        }

        // Resultado final
        if (contador > 0) {
            System.out.println("\nHas asistido a " + contador + " evento(s).");
        } else {
            System.out.println("\nNo hay registros de asistencia a eventos.");
        }

        scanner.close();
    }
}
