// 5.1.2 Confeccionar un programa para calcular el valor de la siguiente suma: 100 + 95 + 90 + ... + 50

public class Inicial_5_1_2 {
    public static void main(String[] args) throws Exception {
        
        int i, suma = 0;

        for (i = 100 ; i >= 50 ; i = i - 5) {
            suma = suma + i;
        }

        System.out.println(suma);







    }
}
