/*
4.4. Ingresar 3 valores reales y:
a. Si los dos primeros son mayores al tercero informar “MAYORES AL TERCERO”.
b. Si los tres son iguales informar “TRES IGUALES .
c. Si alguno de los dos primeros es menor al tercero informar “ALGUNO ES MENOR”.
*/

import java.util.Scanner;

public class Inicial_4_4 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nIngresar tres numeros: ");

        double número1 = scanner.nextDouble();
        double número2 = scanner.nextDouble();
        double número3 = scanner.nextDouble();

        if ((número1 == número2) && (número2 == número3)) {
            System.out.println("\n\nTRES IGUALES.");
        }
        if ((número1 > número3) && (número2 > número3)) {
            System.out.println("\n\nMAYORES AL TERCERO.");
        }
        if ((número1 < número3) || (número2 < número3)){
            System.out.println("\n\nALGUNO ES MENOR.");
        }
        scanner.close();
        
    }
}
