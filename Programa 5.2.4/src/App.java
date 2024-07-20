/*
5.2.4 Un negocio de venta de granos desea controlar las ventas realizadas. De cada una ingresa el importe total
y un código que indica la forma de pago. El código puede ser:
 C: cheque, 20% de recargo.
 E: efectivo, 10% de descuento.
 T: con tarjeta, 12% de recargo.
Se debe ingresar una F para finalizar el día de venta y arrojar los siguientes totales.
Efectivo en Caja: $ xxxx.xx
Ventas con Tarjeta de Crédito: $ xxxx.xx
Ventas con cheque: $ xxxx.xx
Total de Venta: $ xxxx.xx
Importe del IVA: $ xxxx.xx
Nota: El IVA corresponde al 21% del total de ventas.
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        char código;
        double importeTotal, cheque = 0, efectivo = 0, tarjeta = 0;
        
        do {
            do {
                System.out.println("Ingrese el importe total : ");
                importeTotal = scanner.nextDouble();
                if (importeTotal <= 0 ) {
                    System.out.println("Error en el importe. Intente nuevamente:");
                }
            }while (importeTotal <= 0 );
            do {
                System.out.println("Ingrese el código de pago ( C, E, T sino F para terminar)");
                código = Character.toUpperCase(scanner.next().charAt(0));
            }while (código != 'C' && código != 'E' && código != 'T' && código != 'F');

            switch (código) {
                case 'C':
                    cheque = cheque + importeTotal + ((importeTotal*20)/100);
                    break;
                case 'E':
                    efectivo = efectivo + importeTotal - ((importeTotal*10)/100);
                    break;
                case 'T':
                    tarjeta = tarjeta + importeTotal + ((importeTotal*12)/100);
            
                default:
                    break;
            }
        } while (código != 'F');

        scanner.close();

        System.out.printf("Efectivo en caja:\t\t$ %4.2f", (efectivo));
        System.out.printf("\nVentas con tarjetas de crédito:\t$ %4.2f", (tarjeta));
        System.out.printf("\nVentas con cheque:\t\t$ %4.2f", (cheque));
        System.out.printf("\nTotal de venta:\t\t\t$ %4.2f", (efectivo+tarjeta+cheque));
        System.out.printf("\nImporte del IVA:\t\t$ %4.2f", (((efectivo+tarjeta+cheque)*21)/100));

    }
}
