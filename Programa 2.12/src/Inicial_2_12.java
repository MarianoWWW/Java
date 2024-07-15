/*
2.12. Una farmacia vende algunos artículos sin descuento y a otros con descuento del 20%. Confeccionar un
programa que recibiendo el precio original y un código que indica si es o no con descuento, informe el
precio final (0 no aplica el descuento y 1 aplica el descuento).
*/

import java.util.Scanner;

public class Inicial_2_12 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int código;
        double precio, total, descuento = .2;

        do {
            System.out.println("\n\nIngrese el precio (para los decimales, utilizar la coma): ");
            precio = scanner.nextDouble();
            if (precio < 0)
            {
                System.out.println("\n\n¿Es chiste? ¿Precio negativo?");
            }
        } while (precio < 0);

        do {
            System.out.println("\nIngrese el Código  (0 no aplica el descuento y 1 aplica el descuento): ");
            código = scanner.nextInt();
            if (código < 0 || código > 1)
            {
                System.out.println("\n\nCódigo erróneo, intente nuevamente.");
            }
        } while (código < 0 || código > 1);

        //mini lógica :

        if (código == 0) {
            total = precio;
        }
        else {
            total = precio - (precio * descuento);
        }
        System.out.printf("\n\nPrecio final $ %.2f%n ", (total));

        scanner.close();
    }
}
