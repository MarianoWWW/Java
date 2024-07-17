/*
4.12. Ingresar el valor de la hora y la cantidad de horas trabajadas por un empleado. Calcular su sueldo tomando
en cuenta que recibe un premio de $500 si trabajo más de 50 horas y, además, si trabajó más de 150 horas
se le otorgan $1000 adicionales.
*/

import java.util.Scanner;

public class Inicial_4_12 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        double valor;
        int horas;

        do {
            System.out.println("Ingresar el valor de la hora : ");
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("Error en el valor ingresado, intente nuevamente.");
            }
        } while (valor <= 0);

        do {
            System.out.println("Ingresar la cantidad de horas trabajadas");
            horas = scanner.nextInt();
            if (horas <= 0) {
                System.out.println("Error en las horas ingresadas, intente nuevamente");
            }
        }while (horas <= 0);
        scanner.close();

        double sueldo = valor * horas;

        if (horas > 50) {
            sueldo = sueldo + 500;
            if (horas > 150) {
                sueldo = sueldo + 1000;
            }
        }
        System.out.println("Salario a cobrar $: "+ (sueldo));

    }
}
