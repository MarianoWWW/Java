/*
6.14. Realizar un programa que ingrese la fecha actual y la fecha de nacimiento de una persona y calcule su edad.
Para validar las fechas utilizar la función del punto 9. Para el cálculo realizar una función que reciba las dos
fechas y retorne la edad de la persona.

*/

import java.util.Scanner;

public class Inicial_6_14 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int díaActual, mesActual, añoActual, díaNacimiento, mesNacimiento, añoNacimiento, edad;
        boolean valida;

        do{
            System.out.println("Ingrese el día actual : ");
            díaActual = scanner.nextInt();
            System.out.println("Ingrese el mes actual : ");
            mesActual = scanner.nextInt();
            System.out.println("Ingrese el año actual : ");
            añoActual = scanner.nextInt();
            valida = Validar(díaActual, mesActual, añoActual);
            if (valida){
                System.out.println("Error en la fecha elegida, intente nuevamente.");
            }
        }while (valida);
        do{
            System.out.println("Ingrese el día de nacimiento : ");
            díaNacimiento = scanner.nextInt();
            System.out.println("Ingrese el mes de nacimiento : ");
            mesNacimiento = scanner.nextInt();
            System.out.println("Ingrese el día de nacimiento (recuerde que el calendario Gregoriano comienza en 1582) : ");
            añoNacimiento = scanner.nextInt();
            valida = Validar(díaNacimiento, mesNacimiento, añoNacimiento);
            if (valida){
                System.out.println("Error en la fecha elegida, intente nuevamente.");
            }
        }while (valida);
        scanner.close();

        edad = CalculoEdad (díaActual, mesActual, añoActual, díaNacimiento, mesNacimiento, añoNacimiento);

        System.out.println("La edad de la persona es : " +(edad));

    }
    public static boolean Validar(int día, int mes, int año){

        int comparar = Calcular(mes, año);

        if (día <= comparar){
            return false;
        }
        return true;
    }
    public static int Calcular (int mes, int año){

        int día;

        switch (mes) {
            case 2:
                if ((año % 4 == 0 && año % 100 != 0) || año % 400 == 0){
                    día = 29;
                    break;
                }
                día = 28;
                break;
            case 4: case 6: case 9: case 11:
                día = 30;
                break;
            default:
                día = 31;
                break;
        }
        return día;
    }
    public static int CalculoEdad(int díaActual, int mesActual, int añoActual, int díaNacimiento, int mesNacimiento, int añoNacimiento){

        int edad = añoActual - añoNacimiento;

        if (mesActual <= mesNacimiento) {
            edad = edad -1;
            
            if (mesActual == mesNacimiento && díaActual >= díaNacimiento){
                edad = edad +1;
            }
        }
        return edad;
    }
}
