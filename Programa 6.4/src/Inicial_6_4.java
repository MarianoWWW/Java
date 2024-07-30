/*
6.4. Se ingresa valores positivos entre 1 y 50, finalizando el ingreso con el valor -10, para ello generar una función
que valide dicho ingreso. Calcular:
a. Cuántos números son primos.
b. Cantidad de números pares.
c. Promedio de los números impares.
Utilizar las siguientes funciones:
 Resto: recibe por parámetro el Dividendo y el Divisor; Retorna el resto.
 EsPar: recibe por parámetro un número; Retorna 1 si es Par, 0 si es Impar; Invoca a la función Resto.
 EsPrimo: recibe por parámetro un número; Retorna 1 si es primo, 0 si no es primo; Invoca a la
función Resto. (un número es primero si solo es divisible por 1 y por sí mismo).
 Promedio: recibe por parámetro la suma y el contador; Retorna el promedio si contador > 0 sino
Retorna 0.

*/

import java.util.Scanner;

public class Inicial_6_4 {
    public static void main(String[] args) throws Exception {

        Scanner scanner= new Scanner(System.in);

        int valor, contador= 0, cantidadPrimos= 0, cantidadPares = 0, cantidadImpares = 0;
        double promedio;
        do{
            System.out.println("Ingresar un valor positivo entre 1 y 50 (-10 para salir) : ");
            valor = scanner.nextInt();
        }while (!Validar(1, 50, -10, valor));

        while (valor !=-10){

            if (EsPrimo(valor)){
                cantidadPrimos++;
            }
            if (EsPar(valor)){
                cantidadPares++;
            }
            else{
                cantidadImpares++;
            }

            contador++;

            do{
                System.out.println("Ingresar un valor positivo entre 1 y 50 (-10 para salir) : ");
                valor = scanner.nextInt();
            }while (!Validar(1, 50, -10, valor));
        }
        scanner.close();
        promedio = Promedio(cantidadImpares,contador);

        if (cantidadPrimos == 0 && cantidadPares == 0 && cantidadImpares == 0){
            System.out.println("No se ingresaron datos.");
        }
        else{
            System.out.println("Números primos son          : "+ (cantidadPrimos));
            System.out.println("Números pares son           : "+ (cantidadPares));
            System.out.printf("Promedio de números impares : %.2f", (promedio));
        }
    }

    public static boolean Validar(int li, int ls, int pos, int bus){

        if ((bus < li || bus > ls) && bus != pos){
            return false;
        }
        return true;
    }

    public static boolean EsPrimo(int valor){

        int resto;
        int i = 2, contar = 0;

        if (valor == 1){
            return false;
        }

        while ( i <= valor ){

            resto = Resto(valor, i);
            if (resto == 0){
                contar++;
            }
            i++;
        }
        if (contar < 2){
            return true;
        }
        return false;
    }
    public static int Resto(int dividendo, int divisor){

        int resto = dividendo % divisor;

        return resto;
    }
    public static boolean EsPar(int valor){

        int par = Resto(valor, 2);
        if (par == 0){
            return true;
        }
        return false;
    }
    public static double Promedio (int cantidadImpares, int contador) {

        if (contador == 0){
            return 0;
        }
        double total = (double)cantidadImpares/contador;
        return total;
    }
}
