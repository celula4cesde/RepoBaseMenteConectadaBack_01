package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Datos entrada
        int interaccionUno, interaccionDos, diasRegistrados;

        System.out.println("📊 \n\u001B[33m Estadísticas de interacción por semana de MenteConectada");
        System.out.println("===========================================================");

        try {
            System.out.print("👋📌Por favor ingrese el primer valor de interacción: ");
            interaccionUno = sc.nextInt();
            System.out.print("📌 Por favor ingrese el segundo valor de interacción: ");
            interaccionDos = sc.nextInt();
            System.out.print("📌 Por favor ingrese los días registrados: ");
            diasRegistrados = sc.nextInt();

            //Lamar función
            float calculo = Promedio.calcular(interaccionUno, interaccionDos, diasRegistrados);

            System.out.println("✅ \n\u001B[35m Este es el promedio de las interacciones: " + calculo);

        } catch (Exception e) {

            System.out.println("❌ error por favor ingresa solo números.");
        }

        System.out.println(" \n\u001B[35m Gracias por visitar MenteConectada 🌟");
    }
}
