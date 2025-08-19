import java.util.Scanner;

public class HU029C4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalActividades = 0; // Contador de actividades
        String actividad;         // Variable para guardar lo que ingresa el usuario

        System.out.println("=== Sistema de Registro de Actividades ===");
        System.out.println("Escribe tus actividades una por una.");
        System.out.println("Cuando desees salir, escribe la palabra clave: salir\n");

        while (true) { // Ciclo infinito hasta que el usuario decida salir
            System.out.print("Ingrese una actividad: ");
            actividad = scanner.nextLine(); // Captura lo que escribe el usuario

            if (actividad.equalsIgnoreCase("salir")) {
                // equalsIgnoreCase => ignora mayúsculas/minúsculas (ej: SALIR, salir, Salir)
                break; // Rompe el ciclo principal
            }

            // Cada vez que no se ingresa "salir", se cuenta una actividad
            totalActividades++;
            System.out.println("✅ Actividad registrada: " + actividad);
        }

        // Mensaje final al usuario
        System.out.println("\n=== Programa Finalizado ===");
        System.out.println("Total de actividades registradas hoy: " + totalActividades);
        System.out.println("¡Gracias por usar el sistema, hasta pronto! 👋");

        scanner.close();
    }
}



