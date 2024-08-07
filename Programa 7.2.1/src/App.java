//7.2.1 Ingresar una matriz de 3x3 por teclado y un número entero. Realizar el producto de la matriz por la constante.

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
       
        int[][] Matriz = new int[3][3];
        int i, j, número;

        for ( i = 0 ; i < 3 ; i++){
            for (j = 0 ; j < 3 ; j++){
                System.out.println("Ingrese un valor para la fila  "+(i)+" , columna "+(j)+" :");
                Matriz[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Ingrese un número entero para multiplicar la matriz : ");
        número = scanner.nextInt();

        System.out.println("\n\n\n\n\n\n\nMatriz original : ");

        for ( i = 0 ; i < 3 ; i++){
            System.out.printf("\n");
            for (j = 0 ; j < 3 ; j++){
                System.out.printf("%d ", (Matriz[i][j]));
            }
        }
        for ( i = 0 ; i < 3 ; i++){
            for (j = 0 ; j < 3 ; j++){
                Matriz[i][j] = Matriz[i][j] * número;
            }
        }
        System.out.println("\nMatriz resultante : ");

        for ( i = 0 ; i < 3 ; i++){
            System.out.printf("\n");
            for (j = 0 ; j < 3 ; j++){
                System.out.printf("%d ", (Matriz[i][j]));
            }
        }
    }
}
