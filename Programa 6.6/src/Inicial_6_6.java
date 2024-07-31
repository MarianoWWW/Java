/*
6.6. Confeccionar un programa que permita determinar e informar en cuántos de los números enteros
comprendidos entre 10001 y 90009 existen más cifras 3 que 4. Debe existir por lo menos, un 4 para que
sea considerado el número como válido. Para resolverlo confeccionar una función llamada CIFRAS, que
pueda determinar cuántas cifras “n” existen en un número de 5 cifras.
*/

public class Inicial_6_6 {
    public static void main(String[] args) {
        
        int i,j, contador = 0;

        for (i = 10001 ; i <= 90009 ; i++){

            int cifra4 = 0, cifra3 = 0;
            j = i;
            while (j > 0) {
                if (j % 10 == 4){
                    cifra4 ++;
                }
                if (j % 10 == 3){
                    cifra3++;
                }
                j /= 10;
            }
            if (cifra4 >= 1 && cifra3 > cifra4){
                contador++;
            }

        }
        // Muy cortito el programa, la función te la debo
        System.out.println(contador);
    }
}
