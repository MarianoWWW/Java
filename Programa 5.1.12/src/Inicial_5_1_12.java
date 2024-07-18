/*
 5.1.12 Calcular el factorial de un número ingresado por teclado. El factorial se calcula como el producto de todos
los enteros positivos desde 1 hasta el número. En matemática el factorial se expresa con el símbolo. Por
ejemplo, el factorial de 5 es 120 ya que 5! = 1 x 2 x 3 x 4 x 5 =120
 */

import java.util.Scanner;

public class Inicial_5_1_12 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int número, i, factorial = 1;

        do {
            System.out.println("Ingresar un número positivo, así le calculo su producto factorial.");
            número = scanner.nextInt();
            if (número < 0){
                System.out.println("Error en el número elegido, intente nuevamente.");
            }
        } while (número < 0);

        scanner.close();

        for (i = 1 ; i <= número ; i++){
            factorial = factorial*i;
        }
        if (número == 0) {
            System.out.println("El factorial de 0! = 1 (Por definición)");
        }
        else {
            System.out.println((número) +"! = "+ (factorial));
        }
    }
}
