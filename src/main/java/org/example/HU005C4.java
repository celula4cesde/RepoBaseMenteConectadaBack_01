package org.example;
import java.util.Scanner;

public class HU005C4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;           // cuenta cuántas veces se inició sesión
        String entrada = "";

        System.out.println("Bienvenido. Escribe 'login' para iniciar sesión, 'salir' para terminar.");

        while (true) {
            System.out.print("> ");
            entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("login")) {
                contador++;  // cada login aumenta el contador
                // Mostrar tarjeta con contador destacado
                System.out.println("============================");
                System.out.println("   🟢 Has iniciado sesión");
                System.out.println("   Veces que has iniciado: " + contador);
                System.out.println("============================");
            }
            else if (entrada.equalsIgnoreCase("salir")) {
                System.out.println("🔴 Fin del registro. Total inicios: " + contador);
                break;  // salimos del while
            }
            else {
                System.out.println("Escribe 'login' o 'salir'.");
            }
        }

        sc.close();
    }
}
