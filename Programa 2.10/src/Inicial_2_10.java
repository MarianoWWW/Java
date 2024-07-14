/*
2.10. Confeccionar un programa que solicite el ingreso del valor del radio (r) de un círculo y con dicho valor calcule 
la superficie del círculo, la longitud de la circunferencia (perímetro) y el volumen de la esfera.
*/

import java.util.Scanner;

public class Inicial_2_10 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner (System.in);

        double radio, pi=3.14159;
        
        do {
            System.out.println("\n\nIngrese valor del radio : ");
            radio = scanner.nextFloat();
            if (radio < 0)
            {
                System.out.println("\n\nNo puede existir un radio negativo. Intente nuevamente.");
            }
        } while (radio < 0);

        System.out.println("\n\nSuperficie del circulo : "+ (radio*radio*pi) +"\nPerimetro : "+ (2*pi*radio) +"\nVolumen : "+ ((4.0/3.0)*pi*radio*radio*radio));

        scanner.close();

    }
}
