/*
5.2.14 Se ingresan datos de los empleados de una empresa. Por cada empleado se ingresa:
 Legajo (entero entre 1000 y 5000)
 Sueldo básico (float mayor a 1000)
 Antigüedad en años (mayor o igual a 0)
 Sexo (‘M' o 'F')
 Categoría (entero entre 1 a 5)
Por cada empleado ingresado se debe calcular el sueldo final a abonar sabiendo que:
 Las Categorías 2 y 3 tienen $500 de bonificación.
 La Categoría 4 tiene 10% de bonificación.
 La Categoría 5 tiene 30% de bonificación.
 Si la antigüedad es mayor a 10 años recibe una bonificación del 10% adicional.
Todos los datos ingresados deben ser validados. El ingreso finaliza con un legajo igual a cero.
Informar:
 El sueldo a abonar a cada empleado.
 Cantidad de empleados de más de 10 años de antigüedad.
 El mayor sueldo y el legajo del empleado que cobra dicho sueldo.
 Cantidad de hombres y de mujeres.
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int legajo, antiguedad, categoría, cantidadAntiguedad = 0, mayorLegajo = 0, cantidadMasculino = 0, cantidadFemenino = 0;
        double sueldoBásico, sueldoFinal, mayorSueldo = 0;
        char sexo;
        do {
            do {
            System.out.println("\n\nIngresar número de legajo (entre 1.000 y 5.000) : ");
            legajo = scanner.nextInt();
            if ((legajo <1000 || legajo > 5000) && legajo != 0 ) {
                System.out.println("Error en el número de legajo, intente nuevamente.");
            }
            }while ((legajo <1000 || legajo > 5000) && legajo != 0 );

            if (legajo != 0){
                do {
                    System.out.println("Ingresar Sueldo básico (mayor a $ 1.000) : ");
                    sueldoBásico = scanner.nextDouble();
                    if (sueldoBásico <= 1000){
                        System.out.println("Error en el monto del sueldo básico, intente nuevamente.");
                    }
                }while (sueldoBásico <= 1000);
                do {
                    System.out.println("Ingrese la antiguedad : ");
                    antiguedad = scanner.nextInt();
                    if (antiguedad < 0){
                        System.out.println("Error, no puede ser una antiguedad negativa. Intente nuevamente.");
                    }
                }while (antiguedad < 0);
                do {
                    System.out.println("Ingrese el sexo del empleado : ");
                    sexo = Character.toUpperCase(scanner.next().charAt(0));
                    if (sexo != 'M' && sexo != 'F'){
                        System.out.println("Error en el dato ingresado. Intente nuevamente.");
                    }
                }while (sexo != 'M' && sexo != 'F');
                do {
                    System.out.println("Ingrese categoría del empleado (de 1 a 5) : ");
                    categoría = scanner.nextInt();
                    if (categoría < 1 || categoría > 5){
                        System.out.println("Error en el número de categoría, intente nuevamente.");
                    }
                }while (categoría < 1 || categoría > 5);

                sueldoFinal = sueldoBásico;
                switch (categoría) {
                    case 2:
                    case 3:
                        sueldoFinal = sueldoFinal + 500;
                        break;
                    case 4:
                        sueldoFinal = sueldoFinal + (sueldoBásico*10/100);
                        break;
                    case 5:
                        sueldoFinal = sueldoFinal + (sueldoBásico*30/100);
                        break;
                    default:
                        break;
                }
                if (antiguedad > 10){
                    sueldoFinal = sueldoFinal + (sueldoBásico*10/100);
                    cantidadAntiguedad++;
                }
                if (sueldoFinal > mayorSueldo) {
                    mayorSueldo = sueldoFinal;
                    mayorLegajo = legajo;
                }
                if (sexo == 'M'){
                    cantidadMasculino++;
                }
                else {
                    cantidadFemenino++;
                }
                System.out.printf("\nSueldo a abonar al empleado %d", (legajo));
                System.out.printf(" : $ %.2f", (sueldoFinal));

            }
        }while (legajo != 0);

    scanner.close();

    if (mayorSueldo != 0){
        System.out.println("\nCantidad de empleados de más de 10 años de antigüedad : "+ (cantidadAntiguedad));
        System.out.printf("\nMayor sueldo : $ %.2f", (mayorSueldo));
        System.out.printf(" cobrado por el empleado de legajo : "+ (mayorLegajo));
        System.out.println("\nCantidad de hombres : "+ (cantidadMasculino));
        System.out.println("Cantidad de mujeres : "+ (cantidadFemenino));
    }
    else {
        System.out.println("\nNo se ingresaron datos.");
    }
    }
}
