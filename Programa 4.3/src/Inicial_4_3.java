/*
4.3. Confeccionar un programa que pueda determinar de 3 números enteros que se ingresan si alguno de ellos
es igual a la suma de los otros dos.
*/

import java.util.Scanner;

public class Inicial_4_3 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nIngresar tres numeros : ");

        int número1 = scanner.nextInt();
        int número2 = scanner.nextInt();
        int número3 = scanner.nextInt();

        if (número1 == número2 + número3) {
            System.out.println("\n\nEl número "+ (número1) +" es suma de "+ (número2) +" + "+ (número3));
        }
        else {
            if (número2 == número1 + número3) {
                System.out.println("\n\nEl número "+ (número2) +" es suma de "+ (número1) +" + "+ (número3));
            }
            else {
                if (número3 == número1 + número2) {
                    System.out.println("\n\nEl número "+ (número3) +" es suma de "+ (número1) +" + "+ (número2));
                }
                else {
                    System.out.println("\n\nNingún número es la suma de los otros dos.");
                }
            }
        }
        scanner.close();
    }
}
