//7.2.3 Ingresar una matriz de 5x4 por teclado. Realizar una función que genere un vector con la suma por fila de dicha matriz.

import java.util.Scanner;

public class Inicial_7_2_3 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
       
        int[][] Matriz = new int[5][4];
        int[] VectorSuma = new int[5];

        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; j < 4 ; j++){
                System.out.println("Ingrese un valor para la fila  "+(i+1)+" , columna "+(j+1)+" :");
                Matriz[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        FunciónSuma(Matriz, VectorSuma);
        Mostrar(Matriz, VectorSuma);
    }
    public static void FunciónSuma(int[][] Matriz, int[] VectorSuma){

        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; j < 4 ; j++){
                VectorSuma[i] =VectorSuma[i] + Matriz[i][j];
            }
        }
    }
    public static void Mostrar(int[][] Matriz, int[] VectorSuma){

        int i, j;
        System.out.println("\n\nLa Matriz : ");

        for (i = 0 ; i < 5 ; i++){
            System.out.printf("\n");
            for (j = 0 ; j < 4 ; j++){
                System.out.printf(" %d", Matriz[i][j]);
            }
        }
        System.out.println("\nLa suma de las filas : ");
        for (i = 0 ; i < 5 ; i++){
            System.out.println("Fila "+(i+1)+" resultado : "+(VectorSuma[i]));
        }
    }
}
