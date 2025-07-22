package org.PanelEstadisticas;

public class HU023C4 {

    public static void main(String[] args) {

        //Porcentaje de participación en eventos

            /* Como usuario, quiero calcular el porcentaje de asistencia a eventos,
            ingresando el número total de eventos programados y la cantidad a los que asistí.
            El sistema debe realizar el cálculo correspondiente y mostrar el resultado en consola,
            redondeado a dos decimales. Esta funcionalidad me permitirá conocer con precisión mi nivel
            de compromiso o participación en los eventos registrados.
             */

        int eventosProgramados = 10; // Número total de eventos programados
        int eventosAsistidos = 7; // Cantidad de eventos a los que asistí
        double porcentajeAsistencia;

        // Validación de entrada
        if (eventosProgramados <= 0) {
            System.out.println("El número total de eventos programados debe ser mayor que cero.");
        } else if (eventosAsistidos < 0 || eventosAsistidos > eventosProgramados) {
            System.out.println("La cantidad de eventos asistidos debe estar entre 0 y el número total de eventos programados.");
        } else {
            // Cálculo del porcentaje de asistencia
            porcentajeAsistencia = ((double) eventosAsistidos / eventosProgramados) * 100;

            // Mostrar el resultado y Redondeo a dos decimales
            System.out.printf("Porcentaje de asistencia: %.2f%%\n", porcentajeAsistencia);
        }
    }
}
