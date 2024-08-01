/*
7.1.8 Realizar los siguientes vectores con 10 valores reales. Confeccionar un programa para:
a. Generar el vector VA con la información ingresada por teclado.
b. Generar el vector VB, donde cada elemento es la raíz cuadrada del respectivo elemento de VA.
(para el cálculo de la raíz cuadrada utilizar la función sqrt disponible en la biblioteca math.h). Si el
número es negativo poner un 0 ya que no se puede calcular la raíz
c. Calcular el vector VC como VA+VB.
d. Copiar el vector VC en orden inverso en otro vector llamado VD.
e. Hallar el valor máximo del vector VA y en qué posición se halló (el mayor es único).
f. Hallar el valor mínimo del vector VB y en qué posiciones se hallaron (el mínimo se pude repetir).
g. Dado un valor ingresado por teclado, indicar en qué posición se encontró del vector VC.
h. Mostrar el contenido de todos los vectores.
FUNCIONES:
I.   Para el ingreso del vector AA, del punto a).
II.  Para generar el vector CC, del punto c).
III. Para realizar la búsqueda del punto g).
IV.  Para generar el vector VE del punto i).
V.   Para mostrar los valores de todos los vectores del punto j).
 */

import java.util.Scanner;

public class Inicial_7_1_8 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        double[] VA = new double[10], VB = new double[10], VC = new double[10], VD = new double[10];
        int posición;
        double mínimo;

        GenerarVA(scanner, VA);
        GenerarVB(VA, VB);
        CalcularVC(VA, VB, VC);
        CopiarVC(VC, VD);
        posición = ValorMáximo(VA);
        mínimo = ValorMínimo(VB);
        System.out.printf("\nEl valor máximo hallado en el Vector VA es : %f en la posición del Vector VA : %d%n", (VA[posición]), (posición+1));
        System.out.println("El valor mínimo hallado en el vector VB es : " +(mínimo)+ " y se encuentra en :");
        BuscarMínimo(VB, mínimo);
        BuscarEnVC(scanner, VC);
        scanner.close();
        Mostrar(VA,VB,VC,VD);
    }
    public static void GenerarVA(Scanner scanner, double[] VA){

        for (int i = 0 ; i < 10 ; i++){
            System.out.println("Ingresar un valor real para la posición " +(i+1)+ "/10 del Vector VA : ");
            VA[i] = scanner.nextDouble();
        }
    }
    public static void GenerarVB(double[] VA, double[] VB){

        double raíz;

        for (int i = 0 ; i < 10 ; i++){
            raíz = Math.sqrt(VA[i]);

            if (Double.isNaN(raíz)) {
                raíz = 0;
            }
            VB[i] = raíz;
        }
    }
    public static void CalcularVC(double[] VA, double[] VB, double[] VC){

        for (int i = 0 ; i < 10 ; i++){
            VC[i] = VA[i] + VB[i];
        }
    }
    public static void CopiarVC(double[] VC, double[] VD){

        for (int i = 0 ; i < 10 ; i++){
            VD[i] = VC[9 - i];
        }
    }
    public static int ValorMáximo(double[] VA){

        int posición = 0, i;
        double máximo;
        máximo = VA[0];
        for (i = 1 ; i < 10 ; i++){
            if (VA[i] > máximo){
                máximo = VA[i];
                posición = i;
            }
        }
        return posición;
    }
    public static double ValorMínimo(double[] VB){

        double mínimo;
        mínimo = VB[0];

        for (int i = 1 ; i < 10 ; i++){
            if (VB[i] < mínimo){
                mínimo = VB[i];
            }
        }
        return mínimo;
    }
    public static void BuscarMínimo(double[] VB, double mínimo){

        for (int i = 0 ; i < 10 ; i++){
            if (VB[i] == mínimo){
                System.out.println("Posición : "+ (i+1));
            }
        }
    }
    public static void BuscarEnVC(Scanner scanner, double[] VC){

        int i = 0, pos = 0;
        double bus;

        System.out.println("Ingresar un valor para buscarlo en el Vector VC : ");
        bus = scanner.nextDouble();

        while (pos == 0 && i <10){
            if (bus == VC[i]){
                System.out.println("El valor fue hallado en la posición : " +(i+1));
                pos = -1;
            }
            else {
                i++;
            }
        }
        if (pos == 0){
            System.out.println("El valor no fue hallado en el vector VC.");
        }
    }
    public static void Mostrar(double[] VA, double[] VB, double[] VC, double[] VD){
        System.out.printf("%-15s %-15s %-15s %-15s%n", "VA", "VB", "VC", "VD");
        for (int i = 0 ; i < 10 ; i++){
            System.out.printf("%-15f %-15f %-15f %-15f%n", VA[i], VB[i], VC[i], VD[i]);
        }
    }
}
