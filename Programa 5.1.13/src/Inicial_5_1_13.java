/*
5.1.13 Realizar un programa que:
a. Muestre todos los números primos entre 1 y 100. (Un nro. es primo cuando es divisible solamente
por 1 y por sí mismo)
b. Contar y mostrar la cantidad de primos encontrados.
*/

public class Inicial_5_1_13 {
    public static void main(String[] args) throws Exception {
        
        int cantidad = 0, contador =0;

        for (int i = 2 ; i <= 100 ; i++){
            for (int j = 2 ; j <= 100 ; j++) {

                if (( i % j == 0) && (i % 1 == 0)){
                    contador++;
                }
            }
            if (contador == 1) {
                System.out.printf("  "+ (i));
                cantidad++;
            }
            contador = 0;
        }
        System.out.println("\nCantidad de números primos encontrados : "+ (cantidad));
    }
}
