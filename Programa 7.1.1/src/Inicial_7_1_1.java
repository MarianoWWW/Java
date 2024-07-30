/*
7.1.1 Ingresar un vector de 10 unidades reales mediante una función llamada CARGA. Luego mediante una
segunda función llamada INVERTIR, generar un segundo vector del mismo tamaño con los elementos ubicados
en el orden inverso al del vector original. Mostrar el vector invertido con una función llamada MOSTRAR
*/

import java.util.Scanner;

public class Inicial_7_1_1 {
    public static void main(String[] args) throws Exception {
        
        double[] VectorOriginal = new double[10], VectorInvertido = new double[10];

        Carga(VectorOriginal);
        Invertir(VectorOriginal, VectorInvertido);
        Mostrar(VectorInvertido);

    }
    public static void Carga(double[] VectorOriginal){

        Scanner scanner = new Scanner(System.in);

        for (int i = 0 ; i < 10 ; i++){
            System.out.println("Ingrese un valor para la posición " + (i+1)+ "/10");
            VectorOriginal[i] = scanner.nextDouble();
        }
        scanner.close();
    }
    public static void Invertir(double[] VectorOriginal, double[] VectorInvertido){
        for (int i = 0 ; i < 10 ; i++){
            
            VectorInvertido[i] = VectorOriginal[9-i];
        }
    }
    public static void Mostrar (double[] VectorInvertido){
        for (int i = 0 ; i < 10 ; i++){
            System.out.printf("%f ", (VectorInvertido[i]));
        }
    }
}
