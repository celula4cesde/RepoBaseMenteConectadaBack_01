import java.util.ArrayList;
import java.util.List;

public class HU034C4 {

    public static void main(String[] args) {
        //Comparar la actividad actual con la del mes anterior mi pez

        // 1. Listas con datos de ejemplo
        List<Integer> mesActual = new ArrayList<>();
        mesActual.add(120);
        mesActual.add(90);
        mesActual.add(150);

        List<Integer> mesAnterior = new ArrayList<>();
        mesAnterior.add(100);
        mesAnterior.add(80);
        mesAnterior.add(140);

        // 2. Variables primitivas para totales
        int totalActual = 0;
        int totalAnterior = 0;

        // 3. Suma con ciclo while para mesActual
        int index = 0;
        while (index < mesActual.size()) {
            totalActual += mesActual.get(index);
            index++;
        }

        // 4. Suma con ciclo while para mesAnterior
        index = 0;
        while (index < mesAnterior.size()) {
            totalAnterior += mesAnterior.get(index);
            index++;
        }

        // 5. Calcular diferencia
        int diferencia = totalActual - totalAnterior;

        // 6. Mostrar resultados
        System.out.println("Total mes actual: " + totalActual);
        System.out.println("Total mes anterior: " + totalAnterior);
        System.out.println("Diferencia (actual - anterior): " + diferencia);
    }
}
