/*
6.7. Confeccionar un programa que permita ingresar diversas ternas de valores enteros mayores que 0 y
menores que 99. Finalizar el ingreso cuando se informen 3 valores iguales a 96, 97 y 98. Determinar e
informar para cada terna, el mayor y el menor de los valores. Confeccionar y utilizar una función con
parámetros llamada MayorMenor, que permita calcular el menor o el mayor valor de la terna según un
parámetro de configuración.
*/

import java.util.Scanner;

public class Inicial_6_7 {
    public static void main(String[] args) throws Exception {
    
        Scanner scanner = new Scanner(System.in);
        int valor;
        int[] Terna = new int[3];
        boolean valores, valida;

        valores = Cargar(Terna);
        while (valores){

            valor = Valor();
            while (valor != 3){
                if (valor == 1){
                    MayorMenor(1, Terna);
                }
                else {
                    MayorMenor(2, Terna);
                }
                valor = Valor();
            }
            valores = Cargar(Terna);
        }
        scanner.close();
    }
    public static boolean Cargar(int[] Terna) {
        Scanner scanner = new Scanner(System.in);
        boolean valida;
        int i;
        for (i = 0 ; i < 3 ; i++){
            do {
                System.out.println("Ingresar valor (entre 1 y 98) para la terna " +(i+1)+ "/3 (96,97, 98 para salir)");
                Terna[i] = scanner.nextInt();
                valida = Validar(1, 98, Terna[i]);
                if (valida){
                    System.out.println("Error en el valor ingresado, intente nuevamente.");
                }
            }while (valida);
        }
        if (Terna[0] == 96 && Terna[1] == 97 && Terna[2] == 98){
            return false;
        }
        return true;
    }
    public static boolean Validar(int li, int ls, int bus) {
        
        if (bus < li || bus > ls){
            return true;
        }
        return false;
    }
    public static void MayorMenor (int decidir, int[] Terna){
        int i, primero = Terna[0];
        if (decidir == 1){
            for (i = 1 ; i <=2 ; i++){
                if (Terna[i] > primero){
                    primero = Terna[i];
                }
            }
            System.out.println("El número mayor es : "+ (primero));
        }
        else {
            for (i = 1 ; i <=2 ; i++){
                if (Terna[i] < primero){
                    primero = Terna[i];
                }
            }
            System.out.println("El número menor es : "+ (primero));
        }
    }
    public static int Valor (){
        Scanner scanner = new Scanner(System.in);
        int valor;
        boolean valida;
        do {
            System.out.println("Desea conocer: \n1) Mayor valor de la terna\n2) Menor valor de la terna \n3) Elegir nueva terna de números.");
            valor = scanner.nextInt();
            valida = Validar(1, 3, valor);
            if (valida){
                System.out.println("Valor fuera del rango, elija nuevamente.");
            }
        }while (valida);
        return valor;
    }
}
