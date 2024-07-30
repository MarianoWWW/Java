/*
6.2. Se ingresan números enteros comprendidos entre 100 y 2000 (usar función LeerYValidar). Determinar
usando la función EstaDentroDelRango:
a. Cantidad de números ingresados entre 100 y 500
b. Cantidad de números pares ingresados entre 500 y 1200
c. Promedio de números ingresados entre 1200 y 2000
El ingreso de datos finaliza cuando se ingresa un número igual a 99.
Para realizar este programa se deben realizar las siguientes funciones:
 EstaDentroDelRango: que reciba 3 enteros correspondientes a un número a validar y los límites
superior e inferior del rango. La función debe retornar un 1 si el número a validar se encuentra
dentro del rango indicado o un 0 si no lo está.
 LeerYValidar: que reciba los límites superior e inferior de un rango y retorne un número que se
encuentre dentro del mismo. (El ingreso de datos se realiza dentro de la función). Para validar el
rango utilizar la función EstaDentroDelRango realizada en el punto anterior.
*/

import java.util.Scanner;

public class Inicial_6_2 {
    public static void main(String[] args) throws Exception {
        
        int número, cantidad = 0, cantidadIngresados = 0, cantidadPares = 0, cantidadParaPromedio = 0;

        número = LeerYValidar (99, 2000);

        while (número != 99 ) {

            if (número >= 100 && número <= 500){
                cantidadIngresados++;
            }
            if ((número >= 500 && número <= 1200) && número % 2 == 0){
                cantidadPares++;
            }
            if (número >= 1200 && número <= 2000){
                cantidad++;
                cantidadParaPromedio = cantidadParaPromedio + número;
            }

            número = LeerYValidar (99, 2000);
        }
        if (cantidad == 0 && cantidadIngresados == 0 && cantidadPares == 0){
            System.out.println("No se ingresaron datos.");
        }
        else {
            if (cantidadIngresados != 0 ){
                System.out.println("Cantidad de números ingresados entre 100 y 500 : " +(cantidadIngresados));
            }
            if (cantidadPares != 0) {
                System.out.println("Cantidad de números pares ingresados entre 500 y 1200 : " +(cantidadPares));
            }
                if (cantidad != 0) {
                System.out.printf("Promedio de números ingresados entre 1200 y 2000 : %.2f", ((double)cantidadParaPromedio/cantidad));
            }
        }
    }   

    public static int LeerYValidar (int li, int ls) {

        Scanner scanner = new Scanner(System.in);
        
        int rango, pos;

        do {
            System.out.println("Ingresar un número entre 100 y 2.000 (99 para finalizar) :");
            rango = scanner.nextInt();
            pos = EstáDentroDelRango (99, 2000, rango);
            if (pos == 0){
                System.out.println("error en el número elegido, vuelva a intentarlo.");
            }
        }while (pos == 0);
        return rango;

    }

    public static int EstáDentroDelRango (int li, int ls, int bus) {

        if (bus < li || bus > ls) {
            return 0;
        }
        return 1;
    }
}
