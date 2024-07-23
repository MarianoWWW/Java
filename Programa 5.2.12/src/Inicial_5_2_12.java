/*
5.2.12 Confeccionar un programa que permita el ingreso de 6 ternas de valores enteros.
a. de cada terna informar el mayor valor y su orden en la terna.
b. de cada terna informar cuantos valores son múltiplos de 7.
c. de las 6 ternas determinar e informar el promedio de los primeros valores de cada una.
*/

import java.util.Scanner;

public class Inicial_5_2_12 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        
        int i ,máximo, terna1 = 0, terna2 = 0, terna3 = 0, contador = 0, total = 0, posición = 1;

        for (i = 1 ; i <= 6 ; i++) {
            System.out.println("Ingresar la terna : "+ (i));
            System.out.println("Valor 1/3 : ");
            terna1 = scanner.nextInt();
            System.out.println("Valor 2/3 : ");
            terna2 = scanner.nextInt();
            System.out.println("Valor 3/3 : ");
            terna3 = scanner.nextInt();

            máximo = terna1;
            posición = 1;
            if (terna2 > máximo){
                máximo = terna2;
                posición = 2;
            }
            if (terna3 > máximo) {
                máximo = terna3;
                posición = 3;
            }
            if (terna1 % 7 == 0) {
                contador++;
            }
            if (terna2 % 7 == 0) {
                contador++;
            }
            if (terna3 % 7 == 0) {
                contador++;
            }
            total = total + terna1;

            System.out.println("Mayor valor de la terna "+ (i) +" es : "+ (máximo) +" y está en la posición : "+ (posición));
            System.out.println("Valores núltiplos de 7 en esta terna : "+ (contador));
            contador = 0;
        }
        scanner.close();
        System.out.printf("\nPromedio de los primeros valores : %.2f", ((double)total/6));












    }
}
