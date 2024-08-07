/*
7.1.10 Dados los legajos y sueldos de los empleados de una empresa (máximo 100 empleados). Se pide
determinar el/los empleados/as de máximo sueldo. El fin de carga de sueldos está dado por un legajo igual a
cero.
a. Los números de legajo son números correlativos de 1 a 100.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Inicial_7_1_10 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> VectorLegajos = new ArrayList<>();
        ArrayList<Double> VectorSueldos = new ArrayList<>();

        Carga(VectorLegajos, VectorSueldos, scanner);
        scanner.close();

        if (VectorSueldos.isEmpty()) {
            System.out.println("No se ingresaron sueldos.");
        }
        else {
            double máximo = Determinar(VectorSueldos);
            Mostrar(VectorLegajos, VectorSueldos, máximo);
        }

    }
    public static void Carga(ArrayList<Integer> VectorLegajos, ArrayList<Double> VectorSueldos, Scanner scanner){

        int contador = 0;

        Valida(VectorLegajos, contador, scanner);
        while (contador < 100 && VectorLegajos.get(contador) != 0){
            do{
                System.out.println("Ingrese el sueldo del empleado con el número de legajo : "+(VectorLegajos.get(contador)));
                VectorSueldos.add (scanner.nextDouble());
                if (VectorSueldos.get(contador) < 0){
                    System.out.println("No puede ser un sueldo negativo. Intente nuevamente.");
                }
            }while (VectorSueldos.get(contador) < 0);
        
            contador++;
            Valida(VectorLegajos, contador, scanner);
        }
    }
    public static void Valida(ArrayList<Integer> VectorLegajos, int contador, Scanner scanner){

        do {
            System.out.println("Ingrese el legajo del empleado número "+(contador+1)+" (Cero para terminar.) : ");
            VectorLegajos.add(scanner.nextInt());
            if (VectorLegajos.get(contador) < 0 || VectorLegajos.get(contador) > 100){
                System.out.println("Error. Los números de legajo son números correlativos de 1 a 100. Intente nuevamente.");
            }
        }while (VectorLegajos.get(contador) < 0 || VectorLegajos.get(contador) > 100);
    }
    public static double Determinar(ArrayList<Double> VectorSueldos){

        double máximo = VectorSueldos.get(0);

        for (int i = 1 ; i < VectorSueldos.size() ; i++){
            if (VectorSueldos.get(i) > máximo){
                máximo = VectorSueldos.get(i);
            }
        }
        return máximo;
    }
    public static void Mostrar(ArrayList<Integer> VectorLegajos, ArrayList<Double> VectorSueldos, double máximo){

        System.out.printf("El empleado/s con mejor remuneración ($ %.2f): %n", (máximo));
         for(int i = 0 ; i < VectorSueldos.size() ; i++){
             if (máximo == VectorSueldos.get(i)){
                System.out.println("Legajo : "+(VectorLegajos.get(i)));
            }
        }
    }
}
