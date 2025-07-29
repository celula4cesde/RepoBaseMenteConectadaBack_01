package PanelEstadisticas;

import java.util.ArrayList;

public class HU025C4 {

    public static void HU025C4() {
        ArrayList<String> dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Martes");
        dias.add("Miércoles");
        dias.add("Jueves");
        dias.add("Viernes");
        dias.add("Sábado");
        dias.add("Domingo");

        ArrayList<Integer> sesiones = new ArrayList<>();
        sesiones.add(45);
        sesiones.add(3);
        sesiones.add(7);
        sesiones.add(22);
        sesiones.add(5);
        sesiones.add(24);
        sesiones.add(18);

        // Título con marco
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║ 📊 Reporte semanal de sesiones     ║");
        System.out.println("╠════════════════════════════════════╣");

        // Contenido del reporte
        for (int i = 0; i < dias.size(); i++) {
            String linea = String.format("║ %-10s: %2d inicios de sesión   ║", dias.get(i), sesiones.get(i));
            System.out.println(linea);
        }

        // Pie del marco
        System.out.println("╚════════════════════════════════════╝");
    }

    public static void main(String[] args) {
        HU025C4();
    }
}

