/*
 5.1.5 Confeccionar un programa para calcular la suma de los primeros N números naturales. El valor de N lo
solicita por teclado el programa. 
 */

import java.util.Scanner;

public class Inicial_5_1_5 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int i , j, suma = 0;

        do {
            System.out.println("Ingresar el valor N (números naturales) para efectuar su suma : ");
            j = scanner.nextInt();
            if (j < 0) {
                System.out.println("Error al elegir el número N. Intente nuevamente.");
            }
        } while (j < 0);

        scanner.close();

        for (i = 1 ; i <= j ; i++) {
            suma = suma + i;
        }

        System.out.println("La suma da : "+ (suma));
    }
}
