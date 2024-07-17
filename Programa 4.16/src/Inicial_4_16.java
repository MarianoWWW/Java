/*
 4.16. Un negocio vende distintos artículos identificados por un código, según se muestra:
 código 1; 10; 100: 10 pesos la unidad.
 código 2; 22; 222: 7 pesos la unidad. La caja de 10 unidades vale 65 pesos.
 código 3; 33: 3 pesos la unidad. Si la compra es por más de 10 unidades se hace un descuento del
10% sobre el total de la compra.
 código 4; 44: 1 peso la unidad.
Confeccionar un programa que ingrese como dato el código de un artículo y la cantidad a comprar y se
informe el importe de la compra, con las siguientes leyendas:

ARTÍCULO xxxxx CANTIDAD xxxx IMPORTE A PAGAR $ xxxx.xx
 */

import java.util.Scanner;

public class Inicial_4_16 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int código, cantidad;
        double total;

        System.out.println("Ingrese el código de un artículo : ");
        código = scanner.nextInt();
        do {
            System.out.println("Ingrese cantidad a comprar del artículo : "+ (código));
            cantidad = scanner.nextInt();
            if (cantidad < 0) {
                System.out.println("No puede ser una cantidad negativa, intente nuevamente.");
            }
        } while (cantidad < 0);

        scanner.close();

        switch (código) {
            case 1:
            case 10:
            case 100:   total = cantidad * 10;  
                break;
            case 2:
            case 22:
            case 222:   
                int unidad = cantidad % 10;
                int decena = cantidad / 10;
                total = (unidad *7) + (decena * 65);
                break;
            case 3:
            case 33: 
                if (cantidad > 10){
                total = (cantidad * 3);
                total = total - ((total * 10)/100);
                }
                else {
                    total = cantidad * 3;
                }
                break;
            case 4:
            case 44:    
                total = cantidad;
                break;
            default:    
                total = -1;
                break;
        }
        if (total == -1) {
            System.out.println("\nError. Ese código no existe.");
        }
        else {
            System.out.println("\nARTÍCULO "+ (código) +" CANTIDAD "+ (cantidad) +" IMPORTE A PAGAR $ "+ (total));
        }








    }
}
