import java.util.Random;

public class HU028C4 {


        // Constante que define el umbral máximo de sesiones
        public static final int UMBRAL_SESIONES = 20;

        public static void main(String[] args) {

            Random random = new Random();

            // Simular cantidad de sesiones (entre 1 y 40)
            int sesiones = random.nextInt(40) + 1;

            // Llamar al metodo para verificar si se supera el umbral
            verificarSesiones(sesiones);
        }

        // Metodo que evalua si se supero el umbral de sesiones
        public static void verificarSesiones(int cantidadSesiones) {
            if (cantidadSesiones > UMBRAL_SESIONES) {
                System.out.println("⚠️ ADVERTENCIA: SE SUPERÓ EL UMBRAL DE SESIONES (" + cantidadSesiones + ")");
            } else {
                System.out.println("✅ Sesiones dentro del límite (" + cantidadSesiones + ")");
            }
        }
    }


