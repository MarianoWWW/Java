/*
5.2.8 Confeccionar un programa que me permita calcular y mostrar una cantidad de números primos que se
solicita por la pantalla. Los números se calculan a partir del 2. Ejemplo: Si ingreso 6, genero los números: 2 –
3 - 5 - 7 - 11 - 13. El algoritmo para el cálculo de si un número es primo o no, debe estar optimizado para que
si encuentra un divisor no seguir buscando ya que se sabe que no es primo.
*/

import java.util.Scanner;

public class Inicial_5_2_8 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int número, i = 2, j = 2, cantidad = 0, contador =0, salida = 0;

        do {
            System.out.println("Ingresar la cantidad de números primos que se desean ver (a partir del número 2): ");
            número = scanner.nextInt();
            if (número < 0) {
                System.out.println("Error, no puede ser una cantidad negativa. Intente nuevamente.");
            }
        }while (número < 0);

        scanner.close();

        while (cantidad < número) {
    
            while (salida < 2) {

                if (( i % j == 0) && (i % 1 == 0)){
                    contador++;
                    salida ++;
                }
                if (i == j){
                    salida++;    
                    }
            j++;
            }
            if (contador == 1) {
               System.out.printf("  "+ (i));
                cantidad++;
            }
            contador = 0;
            salida = 0;
            i++;
            j = 2;
        }
        System.out.println("\nCantidad de números primos encontrados : "+ (cantidad));


        /* 
        int cantidad = 0, contador =0;

        for (i = 2 ; i <= 100 ; i++){
            for (j = 2 ; j <= 100 ; j++) {

                if (( i % j == 0) && (i % 1 == 0)){
                    contador++;
                }
            }
            if (contador == 1) {
                System.out.printf("  "+ (i));
                cantidad++;
            }
            contador = 0;
        }
        System.out.println("\nCantidad de números primos encontrados : "+ (cantidad));
        */
    }
}
