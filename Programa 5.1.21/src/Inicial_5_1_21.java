/*
5.1.21 Tomando como base el ejercicio anterior ingresar un número entero mayor a 0 y dibujar un rombo con
*. Por ejemplo, si se ingresa el número 5 dibuja la pirámide de 5 filas y luego completa el rombo al ir
decrementando la cantidad de asteriscos.
*
***
*****
*******
*********
*******
*****
***
*


NO ENTIENDO QUE LE VIÓ DE ROMBO A ESTO, EL QUE ESCRIBIÓ EL PROBLEMA.
*/

import java.util.Scanner;

public class Inicial_5_1_21 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int I,J,NUM;

        do {
            System.out.println("Ingresar un número entero mayor a cero : ");
            NUM = scanner.nextInt();
            if (NUM <= 0) {
                System.out.println("Error, el número tiene que ser positivo y distinto de cero. Intente nuevamente.");
            }
        }while (NUM <= 0);

        scanner.close();

        for ( I=1 ; I<=NUM*2 ; I=I+2) {
            System.out.println("\n");
        
        for (J=1 ; J<=I ; J=J+1) {
            System.out.printf("*");
        }
        }
        for ( I=NUM*2-2 ; I>=0 ; I=I-2) {
            System.out.println("\n");
            for (J=1 ; J<=I-1 ; J=J+1) {
            System.out.printf("*");
            }
        }
    }
}


