/*
7.1.4 Construir una función que reciba dos vectores enteros de igual tamaño y retorne un 1 si son guales o un
0 sino lo son.
*/

import java.util.Scanner;

public class Inicial_7_1_4 {
    public static void main(String[] args) throws Exception {
        
        int[] Vector1 = {0, 1, 2, 3, 4} , Vector2 = new int[5];
        boolean resultado;
        Generar(Vector2);
        resultado = Comparar(Vector1, Vector2);
        
        System.out.println(resultado);
    }
    public static void Generar (int[] Vector2) {
        Scanner scanner = new Scanner(System.in);
        int i;
        for (i = 0 ; i < 5 ; i++){
            System.out.println("Ingrese un valor para la posición del vector "+ (i+1)+ "/5 : ");
            Vector2[i] = scanner.nextInt();
        }
        scanner.close();
    }
    public static boolean Comparar (int[] Vector1, int[] Vector2){
        int i=0;
        while (i < 5){
            if (Vector1[i] != Vector2[i]){
                return false;
            }
            i++;
        }
        return true;
    }
}
