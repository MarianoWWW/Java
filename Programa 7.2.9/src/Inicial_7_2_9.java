/*
7.2.9 Se desea contabilizar los votos recibidos en las elecciones de un club de fútbol. Existen 10 candidatos cada
uno representado por un número de lista diferente (número de 3 cifras no correlativo). La votación se realiza
en 15 sedes distintas codificadas del 1 al 15. Se ingresan los votos registrados en cada una de las sedes
registrando:
 Número de lista
 Número de sede
 Cantidad de votos
(Solo se informan candidatos que recibieron votos).
La carga de votos finaliza con un número de lista igual a 0
Mostrar:
a. Cantidad de votos recibidos por cada candidato en cada sede.
LISTA    SEDE1     SEDE2    SEDE3…    SEDE15
873       36         78       99…       XX
735       XX         XX      XXX…       XX
b. Listado ordenado por cantidad de votos totales en formar decreciente, con el siguiente formato:

TOTAL DE VOTOS        PORCENTAJE         LISTA
      800                80%              873
      200                20%              735
c. Candidatos que NO recibieron votos en la sede 5.
 */

import java.util.Scanner;

public class Inicial_7_2_9 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        int[] VectorListas = new int[10];
        int[][] Matriz = new int[10][15];

        GenerarListas(VectorListas, scanner);
        IngresaVotos(VectorListas, Matriz, scanner);
        scanner.close();
        Mostrar(VectorListas, Matriz);
    }
    public static void GenerarListas(int[] VectorListas, Scanner scanner){

        int i, pos, lista;

        for ( i = 0 ; i < 10 ; i++){
            do{
                System.out.println("Ingresar el número de lista (tres dígitos). Posición "+(i+1)+"/10 : ");
                lista = scanner.nextInt();
                pos = ValidaDuplicados(VectorListas, lista, i);
                if (pos != -1 ){
                    System.out.println("Error, número de lista repetido. Intente nuevamente");
                }
                if (lista < 100 || lista > 999){
                    System.out.println("Error, número de lista fuera de rango (de 100 a 999). Intente nuevamente");
                }
            }while (pos != -1 || (lista < 100 || lista > 999));
            VectorListas[i] = lista;
        }
    }
    public static int ValidaDuplicados(int[] VectorListas, int bus, int ce){

        int pos = -1, i = 0;

        while (pos == -1 && i < ce){

            if (VectorListas[i] == bus){
                pos = i;
            }
            else{
                i++;
            }
        }
        return pos;
    }
    public static void IngresaVotos(int[] VectorListas,int[][] Matriz,Scanner scanner){

        int número, sede, cantidad;
        System.out.println("\n\n\n\n\nAhora vamos con los votos.");
        número = ValidaExistencia(VectorListas, scanner);

        while (número != -1) {
            do{
                System.out.println("Ingresar el número de sede (del 1 al 15) : ");
                sede = scanner.nextInt();
                if (sede < 1 || sede > 15){
                    System.out.println("Error, en el número de sede. Intente nuevamente");
                }
            }while (sede < 1 || sede > 15);
            do{
                System.out.println("Ingresar la cantidad de votos (sólo se informan candidatos que recibieron votos) : ");
                cantidad = scanner.nextInt();
                if (cantidad <= 0 ){
                    System.out.println("Error en la cantidad de votos ingresada. Intente nuevamente");
                }
            }while (cantidad <= 0 );

            Matriz[número][sede-1] = Matriz[número][sede-1] + cantidad;

            número = ValidaExistencia(VectorListas, scanner);
        }
        
    }
    public static int ValidaExistencia(int[] VectorListas, Scanner scanner){

        int número, pos;

        do{
            System.out.println("Ingresar el número de lista (tres dígitos o cero para salir) : ");
            número = scanner.nextInt();
            pos = ValidaDuplicados(VectorListas, número, 10);
            if (pos == -1 && número != 0){
                System.out.println("Error, número de lista inexistente. Intente nuevamente");
            }
        }while (pos == -1 && número != 0);
        return pos;
    }
    public static void Mostrar(int[] VectorListas,int[][] Matriz){

        int i, j, totalParaPromedio = 0, auxiliar;
        int[] VectorTotales = new int[10];

        System.out.printf("LISTA");
        for (i= 1 ; i <= 15 ; i++){
            System.out.printf("\tSEDE %d", i);;
        }
        for (i = 0 ; i < 10; i++){
            System.out.printf("\n %d", VectorListas[i]);
            for (j = 0 ; j < 15 ; j++){
                
                System.out.printf("\t  %d", Matriz[i][j]);
            }
        }
        for (i = 0 ; i < 10; i++){
            for (j = 0 ; j < 15 ; j++){
                
                VectorTotales[i] = VectorTotales[i] + Matriz[i][j];
            }
        }
        for (i = 0 ; i < 10; i++){
            totalParaPromedio = totalParaPromedio + VectorTotales[i];
        }
        for (i = 0 ; i < 10-1; i++){
            for (j = 0 ; j < 10-i-1 ; j++){
                if (VectorTotales[j] < VectorTotales[j+1]){
                    auxiliar = VectorTotales[j];
                    VectorTotales[j] = VectorTotales[j+1];
                    VectorTotales[j+1] = auxiliar;

                    auxiliar = VectorListas[j];
                    VectorListas[j] = VectorListas[j+1];
                    VectorListas[j+1] = auxiliar;
                }
            }
        }
        System.out.println("\n\t\t\tTOTAL DE VOTOS\t\t\t\tPORCENTAJE\t\t\tLISTA");
        for (i= 0 ; i < 10 ; i++){
            System.out.printf("\n%30d %38.2f %% %28d", VectorTotales[i], ((double)VectorTotales[i]/totalParaPromedio)*100, VectorListas[i]);
        }
        System.out.printf("\nCandidato/s que no recibieron votos en la Sede 5 : ");
        for (i= 0 ; i < 10 ; i++){
            if (Matriz[i][4] == 0){
                System.out.printf("  Lista %d.", VectorListas[i]);
            }
        }
    }
}
