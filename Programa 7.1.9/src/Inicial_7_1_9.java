/*
7.1.9 Confeccionar un programa para:
a. Generar los vectores necesarios para guardar la información ingresada por teclado. Se ingresa los
datos de 300 artículos diferentes. De cada artículo se ingresa los siguientes datos:
 Código de artículo (int, entre 1 y 500).
 Clase de artículo (char, ‘A’ o ‘B’ o ‘C’ o ‘D’).
 Número de depósito donde se encuentra el artículo (int, entre 1 y 100).
 Stock (int, entre o y 2000).
 Punto de reposición (int, entre 500 y 1000).
b. Generar e informar el vector VB, que contenga los códigos de artículos de aquellos que hayan
quedado con el saldo igual a cero.
c. Generar e informar el vector VC, que contengo a los códigos de artículos de aquellos que hayan
quedado con saldo por debajo del punto de reposición.
d. Generar e informar el vector VD, que contengo los códigos de artículos de aquellos que están en los
depósitos entre el 15 y 50.
Informar el/los códigos de el/los artículos que tienen el stock más alto. (puede haber varios artículos que
tienen la misma cantidad de stock).
FUNCIONES:
I. Para generar los vectores del punto a).
II. Para generar el vector VB.
III. Para generar el vector VC.
IV. Para generar el vector VD.

 */

import java.util.ArrayList;
import java.util.Scanner;

public class Inicial_7_1_9 {
    public static void main(String[] args) throws Exception {

        int[] CódigoArtículo = new int[300], NúmeroDepósito = new int[300], Stock = new int[300], PuntoReposición = new int[300];
        char[] ClaseDeArtículo = new char[300];

        ArrayList <Integer> VB = new ArrayList <>(), VC = new ArrayList <>(), VD = new ArrayList <>();

        IngresarDatos(CódigoArtículo, NúmeroDepósito, Stock, PuntoReposición, ClaseDeArtículo);
        GenerarVB (VB, CódigoArtículo, Stock);
        GenerarVC (VC, CódigoArtículo, PuntoReposición, Stock);
        GenerarVD (VD, CódigoArtículo, NúmeroDepósito);
        MostrarStock(CódigoArtículo, Stock);
    }
    public static void IngresarDatos(int[] CódigoArtículo, int[] NúmeroDepósito, int[] Stock, int[] PuntoReposición, char[] ClaseDeArtículo){

        Scanner scanner = new Scanner(System.in);

        boolean pos;

        // volver a colocar 300
        for (int i = 0 ; i < 300 ; i++){
            do{
                System.out.println("Ingrese el código del artículo " + (i+1)+ "/300 (entre 1 y 500) : ");
                CódigoArtículo[i] = scanner.nextInt();
                pos = Valida(1, 500, CódigoArtículo[i]);
            }while (!pos);
            do{
                System.out.println("Ingrese clase de artículo ( A o B o C o D)");
                ClaseDeArtículo[i] = Character.toUpperCase(scanner.next().charAt(0));
                if (ClaseDeArtículo[i] != 'A' && ClaseDeArtículo[i] != 'B' && ClaseDeArtículo[i] != 'C' && ClaseDeArtículo[i] != 'D'){
                    System.out.println("Error en la clase de artículo elegida. Intente nuevamente.");
                }
            }while (ClaseDeArtículo[i] != 'A' && ClaseDeArtículo[i] != 'B' && ClaseDeArtículo[i] != 'C' && ClaseDeArtículo[i] != 'D');

            do{
                System.out.println("Ingrese el número de depósito del artículo " + (i+1)+ "/300 (entre 1 y 100) : ");
                NúmeroDepósito[i] = scanner.nextInt();
                pos = Valida(1, 100, NúmeroDepósito[i]);
            }while (!pos);
            do{
                System.out.println("Ingrese el Stock del artículo " + (i+1)+ "/300 (entre 0 y 2000) : ");
                Stock[i] = scanner.nextInt();
                pos = Valida(0, 2000, Stock[i]);
            }while (!pos);
            do{
                System.out.println("Ingrese el punto de reposición del artículo " + (i+1)+ "/300 (entre 500 y 1000) : ");
                PuntoReposición[i] = scanner.nextInt();
                pos = Valida(500, 1000, PuntoReposición[i]);
            }while (!pos);
        }
        scanner.close();
    }
    public static boolean Valida(int li, int ls, int bus){

        if (bus < li || bus > ls){
            System.out.println("Error en el dato ingresado, intente nuevamente.");
            return false;
        }
        return true;
    }
    public static void GenerarVB(ArrayList<Integer> VB, int[] CódigoArtículo, int[] Stock){

        int i, j, contador = 0;

        for (i = 0 ; i < 300 ; i++){
            if (Stock[i] == 0){
                VB.add(CódigoArtículo[i]);
                contador++;
            }
        }
        if (contador != 0){
            System.out.println("\n\nArtículo\\s con el saldo igual a cero : ");
            for (j = 0 ; j < contador ; j++){
                System.out.println(VB.get(j));
            }
        }
        else{
            System.out.println("Ningún artículo está faltando.");
        }
    }
    public static void GenerarVC(ArrayList<Integer> VC, int[] CódigoArtículo, int[] PuntoReposición, int[] Stock){

        int i, j, contador = 0;

        for (i = 0 ; i < 300 ; i++){
            if (PuntoReposición[i] > Stock[i]){
                VC.add(CódigoArtículo[i]);
                contador++;
            }
        }
        if (contador != 0){
            System.out.println("Artículo\\s con el saldo por debajo del punto de reposición : ");
            for (j = 0 ; j < contador ; j++){
                System.out.println(VC.get(j));
            }
        }
        else{
            System.out.println("Ningún artículo está por debajo del punto de reposición.");
        }
    }
    public static void GenerarVD(ArrayList<Integer> VD, int[] CódigoArtículo, int[] NúmeroDepósito){

        int i, j, contador = 0;

        for (i = 0 ; i < 300 ; i++){
            if (NúmeroDepósito[i] >= 15 && NúmeroDepósito[i] <= 50){
                VD.add(CódigoArtículo[i]);
                contador++;
            }
        }
        if (contador != 0){
            System.out.println("Artículo\\s que se encuentran entre los depósitos 15 y 50 : ");
            for (j = 0 ; j < contador ; j++){
                System.out.println(VD.get(j));
            }
        }
        else{
            System.out.println("Los depósitos 15 a 50 se encuentran vacíos.");
        }
    }
    public static void MostrarStock(int[] CódigoArtículo, int[] Stock){

        int máximo, i;

        máximo = Stock[0];

        for (i = 1 ; i < 300 ; i++){

            if (Stock[i] > máximo){
                máximo = Stock[i];
            }
        }
        System.out.println("Artículo\\s con el stock más alto : ");

        for (i = 0 ; i < 300 ; i++){

            if (Stock[i] == máximo){
                System.out.println(CódigoArtículo[i]);
            }
        }
    }
}
