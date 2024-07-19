/*
5.1.20 Ingresar un número entero mayor a 0. Debe dibujar una pirámide con * con tantas filas como el número
indicado. En cada fila se va incrementando la cantidad de asteriscos de 2 en 2.
Por ejemplo, si se ingresa el número 5 debe mostrar en pantalla:
     *
    ***
   *****
  *******
 *********
*/

import java.util.Scanner;

public class Inicial_5_1_20 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int I,J,K,NUM;

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
        for (K=NUM; K>=I/2 ; K=K-1) {
            System.out.printf(" ");
        }
        for (J=1 ; J<=I ; J=J+1) {
            System.out.printf("*");
        }
        }



        
        
    }
}
