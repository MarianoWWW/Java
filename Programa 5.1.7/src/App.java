/*
5.1.7 Dadas 20 notas y legajos de alumnos de un curso. Determinar:
a. Cantidad de alumnos aplazados.
b. Cuando la nota sea mayor a 7, mostrar el mensaje: “El alumno con legajo xxx ha Promocionado”.
*/

public class App {
    public static void main(String[] args) throws Exception {
        
        int i, aplazados = 0;
        int [] VectorNotas = {4,6,1,0,10,9,9,8,6,4,3,6,8,2,3,5,7,8,5,10};
        int [] VectorLegajos = {234,546,845,245,865,356,348,334,111,549,001,101,110,111,138,043,203,476,007,303};

        // Tomando como ejemplo a la UNLAM, con 4 ya es aprobado.

        for (i = 0 ; i < 20 ; i++) {

            if (VectorNotas[i] < 4) {
                aplazados++;
            }
            if (VectorNotas[i] > 7) {
                System.out.println("El alumno con legajo "+ (VectorLegajos[i]) +" ha Promocionado");
            }
        }
        System.out.println("Cantidad de alumnos aplazados : "+ (aplazados));
    }
}
