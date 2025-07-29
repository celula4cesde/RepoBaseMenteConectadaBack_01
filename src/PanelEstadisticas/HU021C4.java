package PanelEstadisticas;
import java.util.Scanner;
import java.util.ArrayList;

public class HU021C4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> asistencias = new ArrayList<>();  // lista para guardar los "si"

        String entrada;
        System.out.println("Responde 'si' si asististe, 'no' si no, o 'salir' para terminar.");

        System.out.println("\n¿Asististe a este evento?");
        entrada = scanner.nextLine().toLowerCase();

        while (!entrada.equals("salir")) {
            if (entrada.equals("si")) {
                asistencias.add("si");  // se almacena un "si" por cada asistencia
            } else if (!entrada.equals("no")) {
                System.out.println("Entrada no válida. Usa 'si', 'no' o 'salir'.");
            }

            System.out.println("\n¿Asististe a este evento?");
            entrada = scanner.nextLine().toLowerCase();
        }

        int total = asistencias.size();  // número total de "si" en la lista

        if (total > 0) {
            System.out.print("\nHas asistido a " + total + " evento(s).");
        } else {
            System.out.print("\nNo hay registros de asistencia a eventos.");
        }

        scanner.close();

    }
}
