/*
 5.1.10 Confeccionar un programa que solicite el ingreso de un valor entero N < 12 y luego una lista de N números
reales sobre la cual debe calcular:
a. el promedio de los positivos.
b. el promedio de los negativos.
c. la cantidad de ceros.
Si el valor ingresado N es mayor que 12 informar 'VALOR EXCEDIDO” y si es menor o igual a 0 informar
“CANTIDAD INVALIDA”.
 */

import java.util.Scanner;

public class Inicial_5_1_10 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int valor, i, cantidadPositivos = 0, cantidadNegativos =0, cantidadCeros = 0;
        double número, sumaPositivos = 0, sumaNegativos = 0;

        do {
            System.out.println("Ingresar un valor entero (entre 1 y 11) :");
            valor = scanner.nextInt();
            if (valor >= 12) {
                System.out.println("VALOR EXCEDIDO");
            }
            if (valor <= 0) {
                System.out.println("CANTIDAD INVALIDA");
            }
        } while (valor <= 0 || valor >= 12);

        for (i = 0 ; i < valor ; i++) {
            System.out.println("Ingresar el número real de la lista "+ (i+1) +"/"+ (valor));
            número = scanner.nextDouble();

            if (número > 0){
                sumaPositivos = sumaPositivos + número;
                cantidadPositivos++;
            }
            if (número < 0) {
                sumaNegativos = sumaNegativos + número;
                cantidadNegativos++;
            }
            if (número == 0) {
                cantidadCeros++;
            }
        }
        scanner.close();

        if (cantidadPositivos != 0) {
            System.out.println("Promedio de positivos : "+ (sumaPositivos/cantidadPositivos));
        }
        else {
            System.out.println("Promedio de positivos : 0");
        }
        if (cantidadNegativos != 0) {
            System.out.println("Promedio de negativos : "+ (sumaNegativos/cantidadNegativos));
        }
        else {
            System.out.println("Promedio de negativos : 0");
        }
        System.out.println("Cantidad de ceros : "+ (cantidadCeros));
    }
}
