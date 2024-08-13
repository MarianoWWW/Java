/*
 7.2.12 La empresa de turismo GUADALAJARA VIAJES comercializa 10 diferentes tours a través de 15 agencias en
todo el país. Diariamente cada agencia envía la cantidad de ventas efectuadas de cada tour, indicando
agencia, tours y la cantidad de pasajes. Algunas agencias envían o en la cantidad cuando no existen pasajes
para un tour determinado, pero no en todas.
La información que se envía tiene los siguientes datos que se ingresan en forma desordenada:
 Código de agencia (de 1 a 15)
 Código de tour (1 a 10)
 Cantidad de pasajes (0 a 20)
Informar:
a. El total de pasajes vendidos por tour.
b. El número de agencia que obtuvo la máxima cantidad de pasajes vendidos.
FUNCIONES:
I. Para inicializar la matriz
II. Para mostrar el resultado del punto a.
 */
import java.util.Scanner;

public class Inicial_7_2_12 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        int[][] Matriz = new int[10][15];
        int[] VectorTotales = new int[10];
        int i, j, agencia, tour;

        FunciónIniciaMatriz(Matriz);

        for (i = 1 ; i <= 15 ; i++){

            System.out.println("Ingrese el Código de la agencia (1 a 15): ");
            agencia = Valida(1, 15, scanner);
            System.out.println("Ingrese el Código de tour (1 a 10): ");
            tour = Valida(1, 10, scanner);
            System.out.println("Ingrese la cantidad de pasajes vendidos (0 a 20): ");
            Matriz[tour-1][agencia-1] =  Matriz[tour-1][agencia-1] + Valida(0, 20, scanner);

        }
        scanner.close();

        System.out.println("\n\n\n\n\nTotal de pasajes vendidos por tour : ");
        for (i = 0 ; i < 10 ; i++){
            for (j = 0 ; j < 15 ; j++){
                VectorTotales[i] = VectorTotales[i] + Matriz[i][j];
            }
        }
        for (i = 0 ; i < 10 ; i++){
            System.out.println("Del Tour  "+(i+1)+"  se vendieron :  "+(VectorTotales[i]));
        }
        FunciónMáximo(Matriz);

    }
    public static void FunciónIniciaMatriz(int[][] Matriz){
        for (int i = 0 ; i < 10 ; i++){
            for (int j = 0 ; j < 15 ; j++){
                Matriz[i][j] = 0;
            }
        }
    }
    public static int Valida(int li, int ls, Scanner scanner){

        int número;
        do{
            número = scanner.nextInt();
            if (número < li || número > ls){
                System.out.println("Error en el dato ingresado, intente nuevamente.");
            }
        }while (número < li || número > ls);

        return número;
    }
    public static void FunciónMáximo(int[][] Matriz){

        int[] VectorCantidades = new int[15];
        int i, j, máximo;

        for (i = 0 ; i < 15 ; i++){
            for (j = 0 ; j < 10 ; j++){
                VectorCantidades[i] = VectorCantidades[i] + Matriz[j][i];
            }
        }
        máximo = VectorCantidades[0];
        for (i = 1 ; i < 15 ; i++){
            if (VectorCantidades[i] > máximo){
                máximo = VectorCantidades[i];
            }
        }
        System.out.println("\nAgencia/s con la máxima cantidad de pasajes vendidos : ");
        for (i = 0 ; i < 15 ; i++){
            if (VectorCantidades[i] == máximo){
                System.out.println("Agencia  "+(i+1)+ "  vendió  "+(máximo)+"  pasajes.");
            }
        }
    }
}
