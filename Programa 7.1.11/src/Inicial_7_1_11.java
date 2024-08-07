/*
7.1.11 Para una carrera de automóviles, se toman los tiempos de clasificación (real, mayor que 0 en segundos y
centésimos de segundo) de como máximo 60 autos de carrera inscriptos para la competencia.
Los autos se identifican con números correlativos del 1 al 60, quedando sin información aquellos que no
participan de la presente carrera.
Cuando ya no hay más tiempos de clasificación para cargar, se ingresa un auto con número negativo.
Se solicita determinar:
a. El número de auto que clasificó en primer lugar.
b. El número de auto que obtuvo el peor tiempo de clasificación.
c. La cantidad de autos que superaron el promedio de tiempo de clasificación.
d. El o los números de autos que no participan de la carrera actual.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Inicial_7_1_11 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
    
        ArrayList<Integer> VectorAuto = new ArrayList<>();
        ArrayList<Double> VectorTiempo = new ArrayList<>();

        int cantidadElementos = 0;

        Carga(VectorAuto, scanner, cantidadElementos);

        if (VectorAuto.get(0) < 0){
            System.out.println("No se ingresaron datos de la Carrera.");
        }
        else{
            while (VectorAuto.get(cantidadElementos) > 0 && cantidadElementos < 60){
                do{
                    System.out.println("Ingrese el tiempo obtenido por el auto "+(VectorAuto.get(cantidadElementos)+" :"));
                    VectorTiempo.add(scanner.nextDouble());
                    if (VectorTiempo.get(cantidadElementos) <= 0){
                        System.out.println("Error en el tiempo escrito. Intente nuevamente.");
                    }
                }while (VectorTiempo.get(cantidadElementos) <= 0);

                cantidadElementos++;
                Carga(VectorAuto, scanner, cantidadElementos);
            }
            scanner.close();
            Primero(VectorAuto, VectorTiempo);
            Ultimo(VectorAuto, VectorTiempo);
            Promedio(VectorAuto, VectorTiempo);
            Participantes(VectorAuto);
            
        }
    }
    public static void Carga(ArrayList<Integer> VectorAuto, Scanner scanner, int cantidadElementos){

        int número , pos = 0;

        do {
            System.out.println("Ingrese el número del auto (negativo para terminar) : ");
            número = scanner.nextInt();
            if (número != 0 && número <= 60){
                pos = ValidaDuplicados(número, VectorAuto, cantidadElementos);
                if (pos == -1){
                    VectorAuto.add(número);
                }
                else{
                    System.out.println("Número de auto repetido.");
                }
            }
            else{
                System.out.println("Error en el número del auto. Intente nuevamente.");
            }
        }while (número == 0 || pos != -1 || número > 60);
    }
    public static int ValidaDuplicados(int número, ArrayList<Integer> VectorAuto, int cantidadElementos){

        int contador = 0, pos = -1;
        while ( pos == -1 && contador < cantidadElementos){

            if (número == VectorAuto.get(contador)){
                pos = número;
            }
            else{
                contador++;
            }
        }
        return pos;
    }
    public static void Primero(ArrayList<Integer> VectorAuto, ArrayList<Double> VectorTiempo){

        int i, j;
        double mínimo = VectorTiempo.get(0);

        for (i = 1 ; i < VectorTiempo.size() ; i++){

            if (VectorTiempo.get(i) < mínimo){
                mínimo = VectorTiempo.get(i);
            }
        }
        System.out.printf("\nClasificó en Primer lugar el auto/s con un tiempo de %.3f : %n", (mínimo));

        for (j = 0 ; j < VectorTiempo.size() ; j++){
            if (VectorTiempo.get(j) == mínimo){
                System.out.println(VectorAuto.get(j));
            }
        }
    }
    public static void Ultimo(ArrayList<Integer> VectorAuto, ArrayList<Double> VectorTiempo){

        int i;
        double máximo = VectorTiempo.get(0);

        for (i = 1 ; i < VectorTiempo.size() ; i++){

            if (VectorTiempo.get(i) > máximo){
                máximo = VectorTiempo.get(i);
            }
        }
        System.out.printf("\nClasificó en el último lugar el auto/s con un tiempo de %.3f: ", (máximo));

        for (i = 0 ; i < VectorTiempo.size() ; i++){

            if (VectorTiempo.get(i) == máximo){
                System.out.println(VectorAuto.get(i));
            }
        }
    }
    public static void Promedio(ArrayList<Integer> VectorAuto, ArrayList<Double> VectorTiempo){

        int i, cantidadAutos = 0;
        Double cantidadPromedio = 0.0, promedio;

        for (i = 0 ; i < VectorTiempo.size() ; i++){

            cantidadPromedio = cantidadPromedio + VectorTiempo.get(i);
            }
        promedio = cantidadPromedio/VectorTiempo.size();

        for (i = 0 ; i < VectorTiempo.size() ; i++){

            if (VectorTiempo.get(i) > promedio){
                cantidadAutos++;
            }
        }
        System.out.println("Cantidad de autos que superaron el promedio de tiempo de clasificación : "+ (cantidadAutos));
    }
    public static void Participantes(ArrayList<Integer> VectorAuto){

        System.out.println("Auto/s que no participan en la carrera : ");

        int i, pos;

        for ( i = 1 ; i <= 60 ; i++){

            pos = ValidaDuplicados(i, VectorAuto, VectorAuto.size()-1);
            if (pos == -1){
                System.out.printf(" %d ", (i));
            }
        }
    }
}
