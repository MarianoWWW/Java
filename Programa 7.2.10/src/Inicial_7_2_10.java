
/*7.2.10 Ingresar por teclado valores enteros y generar una matriz de 5x3 (5 filas y 3 por columnas). Informar:
a. La suma de los elementos de las columnas.
b. Las sumas de los elementos de las filas.
c. La suma total de los elementos.
d. El valor promedio de toda la matriz.
e. El valor promedio por columna.
f. El máximo valor de la matriz y en qué posición se encuentra (el máximo es único).
g. El mínimo valor de cada columna y en qué posición se encuentra (el mínimo es único).
Utilizar funciones para la carga y para resolver cada uno de los puntos.
*/

import java.util.Scanner;

public class Inicial_7_2_10 {
    public static void main(String[] args) throws Exception {

        int[][] Matriz = new int[5][3];

        FunciónCarga(Matriz);
        FunciónSumaColumnas(Matriz);
        FunciónSumaFilas(Matriz);
        FunciónSumaTotal(Matriz);
        FunciónPromedio(Matriz);
        FunciónPromedioColumnas(Matriz);
        FunciónMáximo(Matriz);
        FunciónMínimo(Matriz);
    }
    public static void FunciónCarga(int[][] Matriz){

        Scanner scanner = new Scanner(System.in);

        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                System.out.println("Ingrese un valor para la fila  "+(i+1)+" , columna "+(j+1)+" :");
                Matriz[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }
    public static void FunciónSumaColumnas(int[][] Matriz){
    
            int i, j;
            int[] VectorSumaColumnas = new int[3];
            System.out.println("\n\nLa Matriz : ");
    
            for (i = 0 ; i < 5 ; i++){
                System.out.printf("\n");
                for (j = 0 ; j < 3 ; j++){
                    System.out.printf(" %5d", Matriz[i][j]);
                }
            }
            for (j = 0 ; j < 3 ; j++){
                for (i = 0 ; i < 5 ; i++){
                    VectorSumaColumnas[j] =VectorSumaColumnas[j] + Matriz[i][j];
                }
            }
            System.out.println("\nLa suma de las columnas : ");
            for (i = 0 ; i < 3 ; i++){
                System.out.println("Columna "+(i+1)+" resultado : "+(VectorSumaColumnas[i]));
            }
    }
    public static void FunciónSumaFilas(int[][] Matriz){
        int i, j;
        int[] VectorSumaFilas = new int[5];

        for (i = 0 ; i < 5 ; i++){
            for (j = 0 ; j < 3 ; j++){
                VectorSumaFilas[i] =VectorSumaFilas[i] + Matriz[i][j];
            }
        }
        System.out.println("\nLa suma de las filas : ");
        for (i = 0 ; i < 5 ; i++){
            System.out.println("Fila "+(i+1)+" resultado : "+(VectorSumaFilas[i]));
        }
    }
    public static void FunciónSumaTotal(int[][] Matriz){
        int i, j, suma = 0;
        for (i = 0 ; i < 5 ; i++){
            for (j = 0 ; j < 3 ; j++){
                suma =suma + Matriz[i][j];
            }
        }
        System.out.println("\nLa suma total es : "+(suma));
    }
    public static void FunciónPromedio(int[][] Matriz){
        int i, j;
        double suma = 0.0;
        for (i = 0 ; i < 5 ; i++){
            for (j = 0 ; j < 3 ; j++){
                suma =suma + Matriz[i][j];
            }
        }
        System.out.println("\nEl valor promedio de la matriz es : "+(suma/15));
    }
    public static void FunciónPromedioColumnas(int[][] Matriz){
        int i, j;
        double suma = 0.0;
        System.out.println("\nEl valor promedio de las columnas : ");
        for (j = 0 ; j < 3 ; j++){
            for (i = 0 ; i < 5 ; i++){
                suma =suma + Matriz[i][j];
            }
            System.out.println("Columna "+(j+1)+" resultado : "+(suma/5));
            suma = 0.0;
        }
    }
    public static void FunciónMáximo(int[][] Matriz){
        int i, j, fila = 0, columna = 0, máximo = 0, flag = 0;
        for (i = 0 ; i < 5 ; i++){
            for (j = 0 ; j < 3 ; j++){
                if (flag == 0 || Matriz[i][j] > máximo ){
                    flag = 1;
                    máximo = Matriz[i][j];
                    fila = i+1;
                    columna = j+1;
                }
            }
        }
        System.out.printf("\nEl máximo valor de la matriz es %d y se encuentra en la posición Fila : %d Columna : %d ", máximo, fila, columna);
    }
    public static void FunciónMínimo(int[][] Matriz){

        int i, j, fila = 0, columna = 0, mínimo = 0, flag = 0;
        System.out.printf("\n\nLos mínimos de las columnas : ");
        for (j = 0 ; j < 3 ; j++){
            for (i = 0 ; i < 5 ; i++){
                if (flag == 0 || Matriz[i][j] < mínimo){
                    flag = 1;
                    mínimo = Matriz[i][j];
                    fila = i+1;
                    columna = j+1;
                }
            }
            System.out.printf("\nColumna %d resultado : %d   y se encuentra en la posición Fila : %d Columna : %d ",j+1, mínimo, fila, columna);
            flag = 0;
        }
    }
}