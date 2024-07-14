/*
2.11. Una pizzería vende empanadas por unidad o por docena, la docena cuesta $300 pero si se compra 
individualmente se cobra $30 la unidad. Si se compran más empanadas que no se agrupen en docenas las 
adicionales se cobran como por unidad. Indicar el precio total a abonar.
*/

import java.util.Scanner;

public class Inicial_2_11 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner (System.in);

        int número, número1, total = 0, unidad = 30, docena = 300;

        do {
            System.out.println("\n\nIngrese la cantidad de empanadas : ");
            número = scanner.nextInt();
            if (número < 0) {
                System.out.println("La cantidad de empanadas no puede ser negativa. Intente nuevamente.");
            }
        } while (número < 0);

        if (número < 12)
        {
            total = número * unidad;
        }
        else
        {
            if (número %12 == 0)
            {
                total = (número/12)*docena;
            }
            else
            {
                número1 = (número % 12) * unidad;
                total = ((número/12)*docena) + número1;
            }
        }
        System.out.println("\n\nTotal : "+ (total));

        scanner.close();

    }
}
