/*
 5.1.14 Confeccionar un programa que determine e informe los números perfectos comprendidos entre 1 y 9000.
Un número es perfecto cuando es igual a la suma de sus divisores positivos menores que él.
 */

public class Inicial_5_1_14 {
    public static void main(String[] args) throws Exception {
        
        int suma = 0;

        for (int i = 1 ; i <= 9000 ; i++){

            for (int j = 1 ; j <= 9000 ; j++) {

                if ((i % j == 0) && (i != j)) {
                    suma = suma + j;
                }
            }
            if (suma == i){
                System.out.printf("  "+ (suma));
            }
            suma =0;
        }

    }
}
