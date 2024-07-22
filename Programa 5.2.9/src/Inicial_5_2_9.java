/*
5.2.9 Se desea realizar un programa para calcular el sueldo final a pagar a cada empleado de una empresa. De
cada uno se tiene, sueldo básico, antigüedad, cantidad de hijos y estudios superiores (‘S’ o ‘N’). Además, se
conocen los porcentajes de aumento del sueldo que dependen de los siguientes factores:
 Si el empleado tiene más de 10 años de antigüedad: aumento del 10%
 Si el empleado tiene más de 2 hijos: aumento del 10%, si solo tiene uno 5%
 Si el empleado posee estudios superiores: aumento del 5%
Luego de ingresar los datos de un empleado se debe preguntar si se desea ingresar otro empleado o no. Se
termina la carga cuando no se deseen ingresar más empleados.
Determinar:
a. Por cada empleado: número de empleado, el sueldo básico y el nuevo sueldo.
b. Sueldo nuevo promedio de la empresa.

*/

import java.util.Scanner;

public class Inicial_5_2_9 {
    public static void main(String[] args) throws Exception {
        
        
        Scanner scanner = new Scanner(System.in);

        int antiguedad, cantidadHijos, número, contador = 0;
        double sueldoBásico, nuevoSueldo, totalNuevo = 0;
        char estudios, seguir;

        do {
            System.out.println("Número de empleado : ");
            número = scanner.nextInt();
            do {
            System.out.println("Ingresar el sueldo básico : ");
            sueldoBásico = scanner.nextDouble();
            if (sueldoBásico < 0) {
                System.out.println("No puede ser un sueldo negativo. Intente nuevamente.");
            } 
            }while (sueldoBásico < 0);
            do {
                System.out.println("Ingresar la antiguedad : ");
                antiguedad = scanner.nextInt();
                if (antiguedad < 0){
                    System.out.println("No puede ser antiguedad negativa. Intente nuevamente");
                }
            }while (antiguedad < 0);
            do {
                System.out.println("Ingresar la cantidad de hijos : ");
                cantidadHijos = scanner.nextInt();
                if (cantidadHijos < 0){
                    System.out.println("No puede ser una cantidad negativa. Intente nuevamente");
                }
            }while (cantidadHijos < 0);
            do {
                System.out.println("Ingrese si tiene estudios superiores (S/N) : ");
                estudios = Character.toUpperCase(scanner.next().charAt(0));
                if (!(estudios == 'S' || estudios == 'N')){
                    System.out.println("Error, intente nuevamente");
                }
            }while (!(estudios == 'S' || estudios == 'N'));

            nuevoSueldo = sueldoBásico;

            if (antiguedad > 10) {
                nuevoSueldo = nuevoSueldo + (sueldoBásico*10/100);
            }
            if (cantidadHijos >= 2) { //Acá el enunciado no es claro para mi, tampoco en el número de empleado.
                nuevoSueldo = nuevoSueldo + (sueldoBásico*10/100);
            }
            else {
                if (cantidadHijos == 1) {
                    nuevoSueldo = nuevoSueldo + (sueldoBásico*5/100);
                }
            }
            if (estudios == 'S') {
                nuevoSueldo = nuevoSueldo + (sueldoBásico*5/100);
            }
            totalNuevo = totalNuevo + nuevoSueldo;
            contador++;

            System.out.println("\n\n Número de empleado : "+ (número));
            System.out.printf("\nSueldo básico : %.2f", (sueldoBásico));
            System.out.printf("\nNuevo sueldo : %.2f", (nuevoSueldo));
            do {
                System.out.println("\n¿Desea ingresar otro empleado? (S/N) : ");
                seguir = Character.toUpperCase(scanner.next().charAt(0));
                if (!(seguir == 'S' || seguir == 'N')){
                    System.out.println("Error, intente nuevamente");
                }
            }while (!(seguir == 'S' || seguir == 'N'));   
        }while (seguir == 'S');
        scanner.close();
        System.out.printf("\nSueldo nuevo promedio de la empresa : %.2f", (totalNuevo/contador));
    }
}
