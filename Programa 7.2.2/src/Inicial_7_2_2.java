//7.2.2 Ingresar una matriz de 2x3 por teclado. Calcular la matriz transpuesta.

import java.util.Scanner;

public class Inicial_7_2_2 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
       
        int[][] Matriz = new int[2][3], Transpuesta = new int[3][2];
        int i, j, número;

        for ( i = 0 ; i < 2 ; i++){
            for (j = 0 ; j < 3 ; j++){
                System.out.println("Ingrese un valor para la fila  "+(i)+" , columna "+(j)+" :");
                Matriz[i][j] = scanner.nextInt();
            }
        }
        
        scanner.close();

        System.out.println("\n\n\n\n\n\n\nMatriz original : ");

        for ( i = 0 ; i < 2 ; i++){
            System.out.printf("\n");
            for (j = 0 ; j < 3 ; j++){
                System.out.printf("%d ", (Matriz[i][j]));
            }
        }
        for ( i = 0 ; i < 2 ; i++){
            for (j = 0 ; j < 3 ; j++){
                Transpuesta[j][i] = Matriz[i][j] ;
            }
        }
        System.out.println("\nMatriz transpuesta : ");

        for ( i = 0 ; i < 3 ; i++){
            System.out.printf("\n");
            for (j = 0 ; j < 2 ; j++){
                System.out.printf("%d ", ( Transpuesta[i][j]));
            }
        }

    }
}
