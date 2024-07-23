
// 5.2.11 Se ingresan números enteros, hasta que se ingrese el número cero. Determinar los 2 valores mayores.

import java.util.Scanner;

public class Inicial_5_2_11 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int número, mayor = 0, casiMayor = 0, flag = 1, contador = 0;

        System.out.println("Ingrese un número : ");
        número = scanner.nextInt();
       casiMayor = número;

        while (número != 0) {
            System.out.println("Ingrese un número : ");
            número = scanner.nextInt();
            if (flag == 1 && número !=0){
                if (número > casiMayor) {
                    mayor = número;
                }
                else {
                    mayor = casiMayor;
                    casiMayor = número;
                }
            flag = -1;
            }
            else {
            if (número > casiMayor && número != 0) {
                if (número > mayor) {
                    casiMayor = mayor;
                    mayor = número;
                }
                else {
                    casiMayor = número;
                }
            }
        }
        contador++;

        }
        scanner.close();
        if (contador >= 2) {
        System.out.println("Los valores mayores son : Primero : "+ (mayor) +" Segundo : "+ (casiMayor));
        }
        else {
            System.out.println("No se ingresaron datos suficientes para hacer el cálculo.");
        }

    }
}
