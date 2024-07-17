//5.1.4 Se ingresan 100 letras. Determinar la cantidad de vocales ingresadas.

import java.util.Scanner;

public class Inicial_5_1_4 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int i, cantidad = 0;
        char letra;

        for (i = 1 ; i <= 100 ; i++) {
            System.out.println("Ingrese una letra (van "+ (i) +"/100) : ");
            letra = Character.toLowerCase(scanner.next().charAt(0));
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                cantidad++;
            }
        }
        scanner.close();

        System.out.println("Cantidad de vocales ingresadas : "+ (cantidad));
    }
}
