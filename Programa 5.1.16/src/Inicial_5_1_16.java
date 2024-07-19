/*
 5.1.16 Se ingresan DNI y la nota promedio de 10 alumnos. Determinar el DNI del alumno de mayor nota
 promedio (considerar único).
 */


import java.util.Scanner;

public class Inicial_5_1_16 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int i, dni, máximoDni = 0;
        double nota, máximaNota = 0;

        
        for (i = 1 ; i <= 10 ; i++) {

            do {
                System.out.println("Ingresar del alumno "+ (i) +" , el DNI :");
                dni = scanner.nextInt();
                if (dni < 1000000 || dni > 99999999) {
                    System.out.println("Error. los DNIs deberían ser entre 1.000.000 y 99.999.999. Intente nuevamente.");

                }
            } while (dni < 1000000 || dni > 99999999);
            do {
                System.out.println("Ingresar del alumno "+ (i) +" , su nota promedio :");
                nota = scanner.nextDouble();
                if (nota <0 || nota >10) {
                    System.out.println("Error en la nota, intente nuevamente.");
                }
            }while (nota <0 || nota >10);

            if (nota > máximaNota) {
                máximaNota = nota;
                máximoDni = dni;
            }
        }
        scanner.close();
        System.out.println("DNI del alumno con mejor nota promedio : "+ (máximoDni));
    }
}
