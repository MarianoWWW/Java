/*
 5.1.6 Ingresar N y N Números naturales. Determinar e informar:
a. La sumatoria de los valores múltiplos de 3.
b. La cantidad de valores múltiplos de 5.
c. La sumatoria de los valores que se ingresan en orden par.
 */

import java.util.Scanner;

public class Inicial_5_1_6 {
    public static void main(String[] args) throws Exception {
        
        //No entiendo del todo el enunciado, voy a suponer que pide un N para el ciclo for y dentro repetidas veces N hasta completar el ciclo

        Scanner scanner = new Scanner(System.in);
        int número, natural, i, sumatoria = 0, cantidad = 0, esPar = 0;

        do {
            System.out.println("Ingresar un número natural para el ciclo: ");
            número = scanner.nextInt();
            if (número <= 0 ) {
                System.out.println("Error, no puede ser cero o un número negativo. Intente nuevamente.");
            }
            } while (número <= 0 );
 
            for (i = 1 ; i <= número ; i++){

                do {
                    System.out.println("Ingresar un número natural : ");
                    natural = scanner.nextInt();
                    if (natural <= 0 ) {
                        System.out.println("Error, no puede ser cero o un número negativo. Intente nuevamente.");
                    }
                    } while (natural <= 0 );

                if (natural % 3 == 0) {
                    sumatoria = sumatoria + natural;
                }
                if (natural % 5 == 0) {
                    cantidad = cantidad + 1;
                }
                if (i % 2 == 0) {
                    esPar = esPar + natural;
                }
            }

        scanner.close();

        System.out.println("Sumatoria de los valores múltiplos de tres : "+ (sumatoria));
        System.out.println("Cantidad de valores múltiplos de cinco : "+ (cantidad));
        System.out.println("Sumatoria de los valores pares : "+ (esPar));









    }
}
