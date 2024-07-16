// 4.8. Realizar un programa que ingrese dos números e indique si el primer número es divisible por el segundo.

import java.util.Scanner;

public class Inicial_4_8 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        double número1, número2;

        do {
        System.out.println("Ingrese dos números : ");
        número1 = scanner.nextDouble();
        número2 = scanner.nextDouble();

        if (número2 == 0) {
            System.out.println("\nError. No se puede dividir por cero, intente nuevamente.");
        }
    }while (número2 == 0);

    if (número1 % número2 == 0) {
        System.out.println("El número "+ (número1) +" es divisible por "+ (número2));
    }
    else {
        System.out.println("El número "+ (número1) +" no es divisible por "+ (número2));
    }

    scanner.close();


    }
}
