/*
 5.1.11 Ingresar 18 valores de temperatura distintos de cero. Se pide determinar e informar cuantas ternas (tres
valores seguidos) de valores positivos y cuantas de negativos hay.
 */

import java.util.Scanner;

public class Inicial_5_1_11 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        double temperatura;
        int contadorPositivo = 0, contadorNegativo = 0, ternaPositiva = 0, ternaNegativa = 0;

        for (int i = 1 ; i <= 18 ; i++) {
            do {
            System.out.println("Ingresa el valor de temperatura "+ (i) +"/18 (distinto de cero) : ");
            temperatura = scanner.nextDouble();
        }while (temperatura == 0);

        if (temperatura > 0){
            contadorPositivo++;
            contadorNegativo = 0;
            if (contadorPositivo == 3){
                ternaPositiva++;
                contadorPositivo =0;
            }
        }
        else {
            contadorNegativo++;
            contadorPositivo = 0;
            if (contadorNegativo == 3) {
                ternaNegativa++;
                contadorNegativo = 0;
            }
        }


        }
        scanner.close();
        System.out.println("Ternas positivas : "+ (ternaPositiva));
        System.out.println("Ternas negativas : "+ (ternaNegativa));
    }
}
