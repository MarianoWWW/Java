/*
5.1.8 Dadas las edades y estaturas de 45 alumnos de un curso. Determinar:
a. Edad promedio.
b. Estatura promedio.
c. Cantidad de alumnos mayores de 10 años.
d. Cantidad de alumnos que miden menos de 1.40 cm.
*/

public class Inicial_5_1_8 {
    public static void main(String[] args) throws Exception {
        
        int [] VectorEdad = {33,7,67,5,12,23,35,9,8,6,24,12,11,79,9,3,46,18,19,24,31,24,46,23,26,11,33,55,24,69,12,1,2,3,4,5,6,7,8,9,23,46,24,55,12};
        double [] VectorEstatura = {1.4,2.0,1.2,1.3,1.1,1.7,1.31,1.66,1.88,1.91,1.56,1.66,1.71,1.8,1.9,1.4,2.0,1.2,1.3,1.1,1.7,1.31,1.66,1.88,1.91,1.56,1.66,1.71,1.8,1.9,1.3,1.1,1.7,1.31,1.66,1.88,1.91,1.56,1.66,1.71,1.8,1.9,1.0,1.77,1.99};
        
        int i, edad = 0, cantidadMayores = 0, cantidadMedida = 0;
        double estatura = 0;
        for (i = 0 ; i < 45 ; i++) {

            edad = edad + VectorEdad[i];
            estatura = estatura + VectorEstatura[i];
            if (VectorEdad[i] > 10) {
                cantidadMayores++;
            }
            if (VectorEstatura[i] < 1.4) {
                cantidadMedida++;
            }

        }
        System.out.printf("Edad promedio : %.2f años", (float)(edad/45.0));
        System.out.printf("\nEstatura promedio : %.2f cm", (estatura/45));
        System.out.println("\nCantidad de alumnos mayores de 10 años : "+ (cantidadMayores));
        System.out.println("Cantidad de alumnos que miden menos de 1.40 : "+ (cantidadMedida));

    }
}
