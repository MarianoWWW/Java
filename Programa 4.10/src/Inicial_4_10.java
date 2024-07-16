
/*
 4.10. Confeccionar un programa que permita convertir grados sexagesimales a radianes y viceversa, según el 
valor de un código que se ingresa junto al valor. Si código = 1 se ingresan grados, si es 2 se ingresan radianes. 
 */

import java.util.Scanner;

public class Inicial_4_10 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int código;
        double grado = 0.0174532, radian = 57.295827;
        do {
            System.out.println("Ingrese el código (1 para convertir de grados a radianes, 2 para convertir de radianes a grados) : ");
            código = scanner.nextInt();
            if (código < 1 || código > 2) {
                System.out.println("\nCódigo erroneo, intente nuevamente.");
            }
        }while (código < 1 || código > 2);

        if (código == 1) {
            System.out.println("Ingrese los grados a convertir : ");
            double grados = scanner.nextDouble();
            System.out.println((grados) +" grados convertidos a radianes son : " +(grados*grado));
        }
        else {
            System.out.println("Ingrese los radianes a convertir : ");
            double radianes = scanner.nextDouble();
            System.out.println((radianes) +" radianes convertidos a grados son : " +(radianes*radian));
        }

        scanner.close();
















    }
}
