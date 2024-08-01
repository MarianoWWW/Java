/*
7.1.7 Se ingresan DNI y nota de un parcial de los alumnos de un curso. El ingreso de datos finaliza con un DNI
negativo. Se sabe que como máximo pueden presentarse a rendir 60 alumnos. Mostrar:
a. Listado de alumnos con su correspondiente DNI y la nota obtenida (en forma de listado)
b. La máxima nota obtenida y el DNI de los alumnos que la obtuvieron.
 */

import java.util.Scanner;

public class Inicial_7_1_7 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        int[] VectorDni = new int[60];
        double[] VectorNota = new double[60];
        int dni, contador = 0;

        dni = Carga(scanner, VectorDni, VectorNota, contador);

        while (dni >= 0 && contador < 6){
            contador++;
            if (contador <6){
                dni = Carga(scanner, VectorDni, VectorNota, contador);
            }
        }
        scanner.close();
        if (contador != 0){
            Listado(VectorDni, VectorNota, contador);
            Máximo(VectorDni, VectorNota, contador);
        }
        else{
            System.out.println("No se ingresaron alumnos.");
        }
    }
    public static int Carga(Scanner scanner, int[] VectorDni, double[] VectorNota, int contador){

        do{
            System.err.println("Ingresar DNI del alumno (un número negativo para terminar)");
            VectorDni[contador] = scanner.nextInt();
            if (( VectorDni[contador] <= 999999 ||  VectorDni[contador] >= 100000000) &&  VectorDni[contador] >= 0){
                System.out.println("Error en el número de DNI, intente nuevamente.");
            }
        }while (( VectorDni[contador] <= 999999 ||  VectorDni[contador] >= 100000000) &&  VectorDni[contador] >= 0);

        if (VectorDni[contador] > 0){
            do{
                System.out.println("Ingresar nota del alumno : ");
                VectorNota[contador] = scanner.nextDouble();
                if (VectorNota[contador] < 0 || VectorNota[contador] > 10){
                    System.out.println("Nota ingresada fuera de rango (entre 0 y 10). Intente nuevamente.");
                }
            }while (VectorNota[contador] < 0 || VectorNota[contador] > 10);
        }
        return VectorDni[contador];
    }
    public static void Listado(int[] VectorDni, double[] VectorNota, int contador){

        System.out.println("Listado de alumnos y nota obtenida :");
        for (int i = 0 ; i < contador ; i++){
            System.out.printf("\nAlumno %d\tDNI %d", (i+1), (VectorDni[i]));
            System.out.printf(" obtuvo la nota : %.1f", (VectorNota[i]));
        }
    }
    public static void Máximo(int[] VectorDni, double[] VectorNota, int contador){

        int i;
        double máximaNota;
        máximaNota = VectorNota[0];
        for (i = 1 ; i < contador ; i++){
            if (VectorNota[i] > máximaNota){
                máximaNota = VectorNota[i];
            }
        }
        System.out.printf("\n\nLa máxima nota es : %.1f", (máximaNota));
        System.out.printf(" y la obtuvieron los alumnos DNI :\n");
        for (i = 0 ; i < contador ; i++){
            if (VectorNota[i] == máximaNota){
                System.out.println(VectorDni[i]);
            }
        }
    }
}
