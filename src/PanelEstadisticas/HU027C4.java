package PanelEstadisticas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Pattern;

public class HU027C4 {

    // Clase interna para representar un registro
    static class Registro {
        private String nombre;
        private LocalDate fecha;

        public Registro(String nombre, LocalDate fecha) {
            this.nombre = nombre;
            this.fecha = fecha;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        @Override
        public String toString() {
            return "Registro: " + nombre + " - " + fecha;
        }
    }

    // Constantes para validación de fecha
    static final String REGEX_FECHA = "^\\d{4}-\\d{2}-\\d{2}$";
    static final Pattern PATRON_FECHA = Pattern.compile(REGEX_FECHA);
    static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Registro> lista = new ArrayList<>();

        System.out.println("=== Registro de datos con fecha ===");
        try {
            System.out.print("¿Cuántos registros deseas agregar?: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < cantidad; i++) {
                System.out.println("\nRegistro #" + (i + 1));

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                String fechaStr;
                while (true) {
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    fechaStr = sc.nextLine();

                    // Validación con regex
                    if (!PATRON_FECHA.matcher(fechaStr).matches()) {
                        System.out.println("Formato de fecha inválido. Intenta nuevamente.");
                        continue;
                    }

                    try {
                        LocalDate fecha = LocalDate.parse(fechaStr, FORMATO_FECHA);
                        lista.add(new Registro(nombre, fecha));
                        break;
                    } catch (DateTimeParseException e) {
                        System.out.println("La fecha ingresada no existe. Intenta nuevamente.");
                    }
                }
            }

            // Ordenar lista por fecha
            lista.sort(Comparator.comparing(Registro::getFecha));

            // Mostrar lista ordenada
            System.out.println("\n=== Lista ordenada cronológicamente ===");
            for (Registro r : lista) {
                System.out.println(r);
            }

            // Confirmación
            System.out.println("\nConfirmación: El proceso de ordenamiento se realizó con éxito.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Debes ingresar un número válido para la cantidad de registros.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
