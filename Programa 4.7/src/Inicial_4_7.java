/*
4.7. Confeccionar un programa que solicite e ingrese 3 valores reales positivos, mayores que cero y determine
e informe si forman o no triángulo. Para ello utilizar el teorema de la desigualdad del triángulo que establece
que la suma de las longitudes de cualesquiera de dos lados de un triángulo es mayor que la longitud del
tercer lado.
*/

import java.util.Scanner;

public class Inicial_4_7 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        double número1, número2, número3;

        do {
            System.out.println("Ingrese tres valores reales positivos mayores a cero : ");
            número1 = scanner.nextDouble();
            número2 = scanner.nextDouble();
            número3 = scanner.nextDouble();

            if ((número1 <= 0) || (número2 <= 0) || (número3 <= 0)) {
                System.out.println("Error. No pueden ser valores menores o iguales a cero, intente nuevamente.");
            }
        } while ((número1 <= 0) || (número2 <= 0) || (número3 <= 0));

        if ((número1 + número2 > número3) && (número1 + número3 > número2) && (número2 + número3 > número1)) {
            System.out.println("\nSi forman un triángulo.");
        }
        else {
            System.out.println("\nNo forman un triángulo.");
        }
        scanner.close();


    }
}
