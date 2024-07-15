// 4.1. Se ingresan 3 números distintos. Determinar el mayor.

import java.util.Scanner;

public class Inicial_4_1 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int número1, número2, número3;

        do {
            System.out.println("\n\nIngrese tres numeros diferentes : ");
            número1 = scanner.nextInt();
            número2 = scanner.nextInt();
            número3 = scanner.nextInt();

            if (número1==número2 || número1==número3 || número2==número3) {
                System.out.println("\n\nError, escribiste algún número repatido, intenta nuevamente con los tres.");
            }
        } while (número1==número2 || número1==número3 || número2==número3);

        //Parte lógica :

        if (número1 > número2) {
            if (número1 > número3) {
                System.out.println("\n\nEl mayor es : "+ (número1));
            }
            else {
                System.out.println("\n\nEl mayor es : "+ (número3));
            }
        }
        else {
            if (número2 > número3) {
                System.out.println("\n\nEl mayor es : "+ (número2));
            }
            else {
                System.out.println("\n\nEl mayor es : "+ (número3));
            }
        }

        scanner.close();
    }
}
