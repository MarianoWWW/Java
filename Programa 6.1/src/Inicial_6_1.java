/*
6.1. Realizar un programa que al ingresar solicite el ingreso de dos números enteros y luego muestre por
pantalla el siguiente menú (las xx de los números deben ser reemplazadas con los valores
correspondientes):
Menú de Opciones
---- -- --------
Numero 1: xx Numero 2: xx
1) Sumar
2) Restar
3) Multiplicar
4) Dividir
5) Ingresar Nuevos Números
6) Salir
Ingrese su opción:
Al ingresar el número de la opción del 1 al 4, se realiza la operación y muestra el resultado hasta que se
presione una tecla. Luego vuelve a mostrar el menú para poder realizar otra operación con los mismos
números. La opción 5 pide el ingreso de dos nuevos números de trabajo mientras que la opción 6 sale y
cierra el programa.
El ingreso de la opción debe estar validado y en caso de ingresarse un número no válido debe solicitarlo
nuevamente.
Usar una función para mostrar el menú y retornar el valor elegido.
*/

import java.util.Scanner;

public class Inicial_6_1 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int menú;

        System.out.println("Ingrese el primer número entero : ");
        int número1 = scanner.nextInt();
        System.out.println("Ingrese el segundo número entero : ");
        int número2 = scanner.nextInt();

        menú = Funcion(número1 , número2);
        while (menú != 6 ){

            switch (menú) {
                case 1:
                    System.out.println("La suma es : "+ (número1+número2));
                   break;
                case 2:
                    System.out.println("La resta es : "+ (número1-número2));
                    break;
                case 3:
                    System.out.println("La multiplicación es : "+ (número1*número2));
                    break;
                case 4:
                    if (número2 != 0){
                    System.out.println("La división es : "+ (número1/número2));
                    }
                    else {
                        System.out.println("No se puede dividir por cero.");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el primer número entero : ");
                    número1 = scanner.nextInt();
                    System.out.println("Ingrese el segundo número entero : ");
                    número2 = scanner.nextInt();
                    break;

                default:
                    break;
            }
            menú = Funcion(número1 , número2);
        }
        scanner.close();






    }

    public static int Funcion (int número1, int número2) {

        Scanner scanner = new Scanner(System.in);
        int menú;

        do {
            System.out.println("Menú de Opciones\n---- -- --------\nNúmero 1: " + (número1) + 
            "   Número 2: " + (número2) + "\n1) Sumar\n2) Restar\n3) Multiplicar\n4) Dividir\n5) Ingresar nuevos números\n6) Salir\nIngrese su opción : ");
            menú = scanner.nextInt();
            if (menú < 1 || menú > 6) {
                System.out.println("Error al elegir del menu, intente nuevamente.");
            }
        }while (menú < 1 || menú > 6);
        
        return menú;
    }
}
