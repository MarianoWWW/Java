/*
5.2.6 Un negocio de perfumería efectúa descuentos en sus ventas según el importe de las mismas, con la
siguiente escala:
 menor a 50 pesos el 3.5 %
 entre 50 y 150 pesos el 10 %
 entre 151 y 300 pesos el 20 %.
 mayor a 300 pesos el 25 %
Confeccionar un programa que:
a. Solicite un importe y calcule el descuento a efectuar y el importe neto a cobrar, con mensajes
aclaratorios.
b. Informe el importe promedio de todas las ventas realizadas.

Se debe contemplar que se puedan ingresar varios importes y para finalizar se ingresa un valor negativo o
cero
*/

import java.util.Scanner;

public class Inicial_5_2_6 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int contador = 0;
        double importe, descuento = 0, importeTotal = 0;

        System.out.println("Ingrese el importe (creo o negativo para terminar): ");
        importe = scanner.nextDouble();

        while (importe > 0) {
            if (importe < 50) {
                descuento = ((importe*3.5)/100);
                importe = importe - descuento;
            }
            if (importe >= 50 && importe <= 150) {
                descuento = ((importe*10)/100);
                importe = importe - descuento;
            }
            if (importe >= 151 && importe <= 300) {
                descuento = ((importe*20)/100);
                importe = importe - descuento;
            }
            if (importe > 300) {
                descuento = ((importe*25)/100);
                importe = importe - descuento;
            }
            contador++;

            System.out.printf("\nDescuento a efectuar  : %.2f", (descuento));
            System.out.printf("\nImporte neto a cobrar  : %.2f ", (importe));
            importeTotal = importeTotal + importe;

            System.out.println("\nIngrese el importe (creo o negativo para terminar): ");
            importe = scanner.nextDouble();
        }
        scanner.close();
        if (contador != 0) {
        System.out.printf("\nImporte promedio de todas las ventas realizadas : %.2f", (importeTotal/contador));
        }
        else {
            System.out.println("No hubo ventas.");
        }
    }
}
