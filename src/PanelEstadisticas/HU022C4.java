package PanelEstadisticas;

public class HU022C4 {

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public class Main {
        public static void main(String[] args) {

            //Datos entrada
            String [] colaboraciones = new String[5];
            int activo = 0;
            int inactivo = 0;

            colaboraciones[0]="Activo";
            colaboraciones[1]="Inactivo";
            colaboraciones[2]="Inactivo";
            colaboraciones[3]="Activo";
            colaboraciones[4]="Inactivo";

            for (int i=0;i<colaboraciones.length;i++){

                if (colaboraciones[i].equals("Activo")){
                    activo++;

                }else {
                    inactivo++;
                }
            }
            System.out.println("Resumen de colaboraciones");
            System.out.println("El numero de colaboraciones activas son " +activo);
            System.out.println("El numero de colaboraciones inactivas son " + inactivo);
        }
    }
}
