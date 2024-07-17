//5.1.3 Se ingresan 50 números enteros. Determinar el promedio de los números pares

import java.util.Scanner;

public class Inicial_5_1_3 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int número, suma = 0, contador = 0, i;

        for (i = 0 ; i < 5 ; i++) {
            System.out.println("Ingresar número (van "+ (i+1)+ "/50) : ");
            número = scanner.nextInt();
            if (número % 2 == 0) {
                suma = suma + número;
                contador++;
            }
        }
        scanner.close();
        
        if (contador == 0) {
            System.out.println("No hubo números pares.");
        }
        else {
            System.out.println("Promedio de números pares : "+ (suma/contador));
        }





    }
}
