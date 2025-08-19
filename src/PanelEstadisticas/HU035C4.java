package PanelEstadisticas;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HU035C4 {

    // Registro simple
    static class Record {
        int id;
        String name;
        double value;

        Record(int id, String name, double value) {
            this.id = id;
            this.name = name;
            this.value = value;
        }

        public String toString() {
            return String.format("ID: %d | Nombre: %s | Valor: %.2f", id, name, value);
        }
    }

    // Usamos un array para almacenar los registros:
    static final int CAPACITY = 100;
    static Record[] records = new Record[CAPACITY];
    static int count = 0; // cuántos registros tenemos actualmente

    static Scanner sc = new Scanner(System.in);

    // Validación con regex
    static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ \\-]{2,40}$");
    static final Pattern NUMBER_PATTERN = Pattern.compile("^-?\\d+(\\.\\d+)?$");
    static final Pattern ID_PATTERN = Pattern.compile("^\\d{1,5}$");

    public static void main(String[] args) {
        System.out.println("Bienvenido al Panel de Estadísticas (consola)");
        menuLoop();
    }

    static void menuLoop() {
        boolean running = true;
        while (running) {
            try {
                showMenu();
                String opt = sc.nextLine().trim();
                switch (opt) {
                    case "1":
                        createRecord();
                        break;
                    case "2":
                        searchRecord();
                        break;
                    case "3":
                        modifyRecord();
                        break;
                    case "4":
                        viewStatistics();
                        break;
                    case "5":
                        listAll();
                        break;
                    case "6":
                        addSampleElement();
                        break;
                    case "0":
                        running = false;
                        System.out.println("Saliendo... hasta la próxima. 😉");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception ex) {
                System.out.println("Ocurrió un error: " + ex.getMessage());
            }
        }
    }

    static void showMenu() {
        System.out.println("\n=== Menú - Panel de Estadísticas ===");
        System.out.println("1) Crear registro");
        System.out.println("2) Buscar registro (por ID o nombre)");
        System.out.println("3) Modificar registro (por ID)");
        System.out.println("4) Ver estadísticas (conteo, suma, promedio, min, max)");
        System.out.println("5) Listar todos");
        System.out.println("6) Añadir elemento de ejemplo rápido");
        System.out.println("0) Salir");
        System.out.print("Selecciona una opción: ");
    }

    static void createRecord() {
        if (count >= CAPACITY) {
            System.out.println("Capacidad máxima alcanzada. No se pueden añadir más registros.");
            return;
        }

        try {
            int id = readId("Introduce el ID (número entero, 1-99999): ");
            if (findIndexById(id) != -1) {
                System.out.println("Ya existe un registro con ese ID.");
                return;
            }

            String name = readName();
            double value = readDouble();

            records[count++] = new Record(id, name, value);
            System.out.println("Registro creado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error al crear registro: " + ex.getMessage());
        }
    }

    static void searchRecord() {
        System.out.print("Buscar por (1) ID o (2) Nombre? ");
        String opt = sc.nextLine().trim();
        if (opt.equals("1")) {
            try {
                int id = readId("Introduce el ID a buscar: ");
                int idx = findIndexById(id);
                if (idx == -1) System.out.println("No se encontró registro con ID " + id);
                else System.out.println(records[idx]);
            } catch (Exception ex) {
                System.out.println("Error en búsqueda por ID: " + ex.getMessage());
            }
        } else if (opt.equals("2")) {
            System.out.print("Introduce parte o el nombre completo: ");
            String q = sc.nextLine().trim();
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (records[i].name.toLowerCase().contains(q.toLowerCase())) {
                    System.out.println(records[i]);
                    found = true;
                }
            }
            if (!found) System.out.println("No se encontraron coincidencias para '" + q + "'.");
        } else {
            System.out.println("Opción inválida para búsqueda.");
        }
    }

    static void modifyRecord() {
        try {
            int id = readId("Introduce el ID del registro a modificar: ");
            int idx = findIndexById(id);
            if (idx == -1) {
                System.out.println("Registro no encontrado.");
                return;
            }
            System.out.println("Registro encontrado: " + records[idx]);
            System.out.println("Dejar en blanco para mantener el valor actual.");

            System.out.print("Nuevo nombre: ");
            String newName = sc.nextLine().trim();
            if (!newName.isEmpty()) {
                if (!NAME_PATTERN.matcher(newName).matches()) {
                    System.out.println("Nombre no válido. Se mantiene el anterior.");
                } else {
                    records[idx].name = newName;
                }
            }

            System.out.print("Nuevo valor: ");
            String newValStr = sc.nextLine().trim();
            if (!newValStr.isEmpty()) {
                if (!NUMBER_PATTERN.matcher(newValStr).matches()) {
                    System.out.println("Valor no válido. Se mantiene el anterior.");
                } else {
                    records[idx].value = Double.parseDouble(newValStr);
                }
            }

            System.out.println("Registro modificado: " + records[idx]);
        } catch (Exception ex) {
            System.out.println("Error al modificar: " + ex.getMessage());
        }
    }

    static void viewStatistics() {
        if (count == 0) {
            System.out.println("No hay registros para calcular estadísticas.");
            return;
        }
        double sum = 0;
        double min = records[0].value;
        double max = records[0].value;
        for (int i = 0; i < count; i++) {
            double v = records[i].value;
            sum += v;
            if (v < min) min = v;
            if (v > max) max = v;
        }
        double avg = sum / count;
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Total de registros: " + count);
        System.out.printf("Suma: %.2f\n", sum);
        System.out.printf("Promedio: %.2f\n", avg);
        System.out.printf("Mínimo: %.2f\n", min);
        System.out.printf("Máximo: %.2f\n", max);
    }

    static void listAll() {
        if (count == 0) {
            System.out.println("No hay registros que mostrar.");
            return;
        }
        System.out.println("\n--- Lista de registros ---");
        for (int i = 0; i < count; i++) {
            System.out.println(records[i]);
        }
    }

    static void addSampleElement() {
        if (count >= CAPACITY) {
            System.out.println("Capacidad alcanzada.");
            return;
        }
        int sampleId = (count + 1) * 10;
        records[count++] = new Record(sampleId, "ElementoEjemplo" + sampleId, Math.round(Math.random() * 1000) / 10.0);
        System.out.println("Elemento de ejemplo añadido (ID=" + sampleId + ").");
    }

    static int findIndexById(int id) {
        for (int i = 0; i < count; i++) if (records[i].id == id) return i;
        return -1;
    }

    static int readId(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!ID_PATTERN.matcher(s).matches()) {
                System.out.println("ID inválido. Debe ser un número entero entre 0 y 99999.");
                continue;
            }
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException nfe) {
                System.out.println("Formato de número incorrecto.");
            }
        }
    }

    static String readName() {
        while (true) {
            System.out.print("Introduce el nombre (2-40 letras): ");
            String name = sc.nextLine().trim();
            if (!NAME_PATTERN.matcher(name).matches()) {
                System.out.println("Nombre inválido. Usa solo letras, espacios y guiones, 2-40 caracteres.");
                continue;
            }
            return name;
        }
    }

    static double readDouble() {
        while (true) {
            System.out.print("Introduce el valor numérico (puede ser decimal): ");
            String s = sc.nextLine().trim();
            if (!NUMBER_PATTERN.matcher(s).matches()) {
                System.out.println("Número inválido. Usa dígitos y opcionalmente un punto decimal.");
                continue;
            }
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException nfe) {
                System.out.println("No se pudo convertir a número.");
            }
        }
    }
}
