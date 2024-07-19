/*
 5.1.19 Ingresar un número entero mayor a 0. Debe dibujar un triángulo rectángulo con * con tantas filas como
el número indicado. En cada fila se va incrementando la cantidad de asteriscos. Por ejemplo, si se ingresa el
número 6 debe mostrar en pantalla:
*
**
***
****
*****
******
 */

import java.util.Scanner;

public class Inicial_5_1_19 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int i, j, número;

        do {
            System.out.println("Ingresa un número entero mayor a cero, para dibujar el trángulo :");
            número = scanner.nextInt();
            if (número <= 0) {
                System.out.println("Error, elije otro número.");
            }
        } while (número <= 0);

        scanner.close();

        for ( i = 1 ; i <= número ; i++) {
            System.out.println("\n");
            for (j = 1 ; j <= i ; j++) {
                System.out.printf("*");
            }
        }
    }
}
