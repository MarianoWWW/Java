/*
7.1.3 Realizar una función que reciba por parámetro dos vectores enteros de 5 elementos cada uno y genere
un vector de 10 posiciones con el contenido de ambos vectores intercalados.
*/

public class Inicial_7_1_3 {
    public static void main(String[] args) throws Exception {
        
        int[] Vector1 = {7, 5, 0, 9, 2} , Vector2 = {22, 45, 76, 87, 11}, VectorTotal = new int[10];

        Generar(Vector1, Vector2, VectorTotal);

        for (int i = 0 ; i < 10 ; i++){
            System.out.printf(" %d", (VectorTotal[i]));
        }
    }
    public static void Generar (int[] Vector1, int[] Vector2, int[] VectorTotal) {
        int i;
        for (i = 0 ; i < 5 ; i++){
            VectorTotal[i*2] = Vector1[i];
            VectorTotal[i*2+1] = Vector2[i];
        }
    }
}
