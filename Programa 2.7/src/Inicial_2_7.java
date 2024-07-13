/*
2.7. Se ingresa un número entero de 3 cifras. Descomponerlo en unidad, decena y centena.
*/

import java.util.Scanner;

public class Inicial_2_7 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int número;

        do {
            System.out.println("\nIngresar un numero (entero) de tres cifras: ");
            número = scanner.nextInt();
            if (número < 100 || número > 999)
            {
                System.out.println("\n\nError en el numero elegido, intente nuevamente.");
            }
        }while (número < 100 || número > 999);

        int unidad = número % 10;
        int decena = ((número / 10) % 10);
        int centena = (número / 100);
        System.out.println("\n\nUnidad : "+ (unidad) +"\nDecena : "+ (decena) +"\nCentena : "+ (centena));

        scanner.close();

    }
}
