package PanelEstadisticas;

public class HU024C5 {
    public static void main(String[] args) {
        int contadorVisitas = 0;

        // Simulación de 10 visitas al perfil
        for (int i = 0; i < 10; i++) {
            contadorVisitas++;
            System.out.println("Visita #" + (i + 1) + " registrada.");
        }

        // Mostrar total al final
        System.out.println("Total de visitas al perfil: " + contadorVisitas);
    }
}
