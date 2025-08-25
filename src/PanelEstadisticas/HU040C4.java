public class HU040C4 {
    public static void main(String[] args) {
        //HU040C4 Imprimir los datos de actividad con formato tipo tabla en este caso, datos de ejemplo.

        // Datos de ejemplo
        String[] tipos = {"Puntos por evento", "Maestría", "Lectura"};
        double[] valores = {3.5, 10.0, 2.25};
        String[] fechas = {"2025-08-24", "2025-08-25", "2025-08-26"};

        // Encabezado formateado
        System.out.println(String.format("%-10s | %-7s | %-10s", "Tipo", "Valor", "Fecha"));
        System.out.println("-------------------------------");

        // Bucle while para recorrer los datos
        int i = 0;
        while (i < tipos.length) {
            String tipo = tipos[i];
            double valor = valores[i];
            String fecha = fechas[i];

            // Fila formateada: Tipo (izquierda, ancho 10), Valor (derecha, ancho 7 con 2 decimales), Fecha (izquierda, ancho 10)
            System.out.println(String.format("%-10s | %7.2f | %-10s", tipo, valor, fecha));
            i++;
        }
    }
}
