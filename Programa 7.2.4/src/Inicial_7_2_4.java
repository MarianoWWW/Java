//7.2.4 Ingresar una matriz de 5x4 por teclado. Realizar una función que genere un vector con la suma por columna de dicha matriz

import java.util.Scanner;

public class Inicial_7_2_4 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        int[][] Matriz = new int[5][4];
        int[] VectorSuma = new int[4];

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

        for (int i = 0 ; i < 4 ; i++){
            for (int j = 0 ; j < 5 ; j++){
                VectorSuma[i] =VectorSuma[i] + Matriz[j][i];
            }
        }
    }
    public static void Mostrar(int[][] Matriz, int[] VectorSuma){

        int i, j;
        System.out.println("\n\nLa Matriz : ");

        for (i = 0 ; i < 5 ; i++){
            System.out.printf("\n");
            for (j = 0 ; j < 4 ; j++){
                System.out.printf("%d\t", Matriz[i][j]);
            }
        }
        System.out.println("\nLa suma de las columnas : ");
        for (i = 0 ; i < 4 ; i++){
            System.out.println("Columna "+(i+1)+" resultado : "+(VectorSuma[i]));
        }
    }
}
