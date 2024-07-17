/*
 4.14. La farmacia Sindical efectúa descuentos a sus afiliados según el importe de la compra con la siguiente
escala:
a. menor de $55 el descuento es del 4.5%
b. entre $55 y $100 el descuento es del 8%
c. más de $100 el descuento es del 10.5%
Confeccionar un programa que reciba un importe e informe: el descuento y el precio neto a cobrar, con
mensajes aclaratorios.
 */

import java.util.Scanner;

public class Inicial_4_14 {
    public static void main(String[] args) throws Exception {

    Scanner scanner = new Scanner(System.in);
    
    double importe;
    
    do {
    System.out.println("Ingresa el importe : ");
    importe = scanner.nextDouble();
    if (importe < 0){
        System.out.println("Error, no se puede pagar un importe negativo, intente nuevamente.");
    }
    } while (importe < 0);

    scanner.close();

    if (importe < 55) {
        importe = importe - ((importe*4.5)/100);
        System.out.println("Descuento del 4,5 %. Importe neto a cobrar $: "+ (importe));
    }
    else {
        if (importe <= 100) {
            importe = importe - ((importe*8.0)/100);
            System.out.println("Descuento del 8 %. Importe neto a cobrar $: "+ (importe));
        }
        else {
            importe = importe - ((importe*10.5)/100);
            System.out.println("Descuento del 10,5 %. Importe neto a cobrar $: "+ (importe));
        }
    }


    }
}
