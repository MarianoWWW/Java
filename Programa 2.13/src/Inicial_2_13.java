/*
2.13. Confeccionar un programa que solicite el ingreso de un número entero positivo de 4 cifras y pueda calcular
e informar la suma de sus dígitos hasta llegar a una sola cifra. Ej:2561 = 5.
*/

import java.util.Scanner;

public class Inicial_2_13 {
    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);

        int número, suma, suma1;

        do {
            System.out.println("\n\nIngresar un número de cuatro cifras positivo y entero : ");
            número = scanner.nextInt();
            if (número < 1000 || número > 9999){
                System.out.println("\n\nError en el número ingresado, intente nuevamente.");
            }
        } while (número < 1000 || número > 9999);

        int unidad = número % 10;
        int decena = (número % 100) /10;
        int centena = (número % 1000) / 100;
        int mil = (número % 10000) / 1000;

        System.out.println("Unidad : "+ (unidad) +"  Decena : "+ (decena) +"  Centena : "+ (centena) +"  Mil : "+ (mil));

        suma = unidad + decena + centena + mil;
        if ((unidad + decena) >= 10) {
            suma1 = unidad + decena;
            unidad = suma1 % 10;
            decena = (suma1 % 100) / 10;
            
        }

        suma = unidad + decena + centena;
        if (suma >= 10) {
            unidad = suma % 10;
            decena = (suma % 100) / 10;
            suma = unidad + decena + mil;
        }
        else {
            suma = suma + mil;
        }
        if (suma >= 10) {
            unidad = suma % 10;
            decena = (suma % 100) / 10;
            suma = unidad + decena;
        }
        System.out.println("\n\nLa suma de sus digitos en una sola cifra es :"+ (suma) );

        scanner.close();
    }
}
