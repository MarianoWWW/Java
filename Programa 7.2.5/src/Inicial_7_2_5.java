/*
7.2.5 Se desea desarrollar un sistema de reservas de entradas para un cine. La sala consta de 12 filas numeradas
de la 1 a la 12 y cada fila tiene 9 butacas numeradas a partir de la columna central, con las butacas impares a
la derecha y las pares a la izquierda, como en el siguiente esquema:
8 6 4 2 1 3 5 7 9
Para la carga, se debe mostrar al usuario un esquema con las butacas disponibles y reservadas, marcando
con la letra D las disponibles y con la letra R las reservadas.
Por cada reserva se debe solicitar la fila y número de butaca a reservar. Cada vez que se realice una
reserva se deberá actualizar el esquema que muestra las butacas. Si la butaca seleccionada ya estaba
ocupada se debe informar al usuario para que seleccione otra. El proceso de reserva finaliza con una fila
con un número negativo.
Al finalizar mostrar:
a. la cantidad de asientos disponibles y la cantidad de asientos reservados.
b. los números de filas que quedaron vacías.
c. la o las filas con mayor cantidad de espectadores.
Cátedra: Programación Inicial
Guía Práctica – V2.1 15 / 18
d. un listado con la cantidad de personas que se sentaron en los mismos números de butacas en
todo el cine ordenado de mayor a menor. Por ejemplo:
Butaca Cantidad
1 20
3 15
2 10
 ..............
 */

import java.util.Scanner;

public class Inicial_7_2_5 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        char[][] Matriz = new char[12][9];
        int[] VectorAsientos = {8,6,4,2,1,3,5,7,9};

        InicializarMatriz(Matriz);
        Reservar(Matriz, VectorAsientos, scanner);

    }
    public static void InicializarMatriz(char[][] Matriz){

        for(int i = 0 ; i < 12 ; i++){
            for (int j = 0 ; j < 9 ; j++){
                Matriz[i][j] = 'D';
            }
        }
    }
    public static void Reservar(char[][] Matriz, int[] VectorAsientos, Scanner scanner){

        int fila, columna, butaca, flag = 0;

        MostrarMatriz(Matriz);
        fila = ValidarFila(scanner);
        while (fila > 0){
            if ( flag == 0){
                flag = -1;
            }
            do{
                System.out.println("Ingresar número de butaca (del 1 al 9) : ");
                columna = scanner.nextInt();
                if (columna < 1 || columna > 9){
                    System.out.println("Error en el número de butaca elegido, intente nuevamente.");
                }
            }while (columna < 1 || columna > 9);

            butaca = BuscarButaca(VectorAsientos, columna);
            if (Matriz[fila-1][butaca] == 'D'){
                Matriz[fila-1][butaca] = 'R';
            }
            else {
                System.out.println("Asiento previamente reservado, por favor elija otro.");
                System.out.println("Presione Enter para continuar.");
                scanner.nextLine();
                scanner.nextLine();
            }
            MostrarMatriz(Matriz);
            fila = ValidarFila(scanner);
        }
        scanner.close();
        if ( flag == 0){
            System.out.println("No se vendió ni un solo ticket.");
        }
        else{
            Finalizar(Matriz, VectorAsientos);
        }

    }
    public static void MostrarMatriz(char[][] Matriz){
        
        System.out.println("\n\n\n\n\n\n\n\nButacas disponibles y reservadas : ");
        System.out.println("\t8\t6\t4\t2\t1\t3\t5\t7\t9");
        for(int i = 0 ; i < 12 ; i++){
            System.out.printf("\nFila %d\t", i+1);
            for (int j = 0 ; j < 9 ; j++){
                System.out.printf("%c\t", (Matriz[i][j]));
            }
        }
    }
    public static int ValidarFila(Scanner scanner){

        int fila;
        do{
            System.out.println("\nIngrese número de fila (negativo para salir): ");
            fila = scanner.nextInt();
            if (fila == 0 || fila >12){
                System.out.println("Error en el número de fila elegido, intente nuevamente.");
            }
        }while(fila == 0 || fila >12);
        return fila;
    }
    public static int BuscarButaca (int[] VectorAsientos, int columna){

        int i = 0, pos = -1;
        while (pos == -1) {
            if (VectorAsientos[i] == columna){
                pos = i;
            }
            else{
                i++;
            }
        }
        return pos;
    }
    public static void Finalizar(char[][] Matriz, int[] VectorAsientos){

        int i, j, cantidadAsientosReservados = 0, máximo, auxiliar;
        int[] VectorSumaFilas = new int[12], VectorSumaColumnas = new int[9];

        for(i = 0 ; i < 12 ; i++){
            for (j = 0 ; j < 9 ; j++){
                if (Matriz[i][j] == 'R'){
                    cantidadAsientosReservados++;
                    VectorSumaFilas[i]++;
                }
            }
        }
        System.out.println("Cantidad de asientos disponibles : "+((12*9)-cantidadAsientosReservados));
        System.out.println("Cantidad de asientos reservados : "+(cantidadAsientosReservados));

        System.out.printf("Números de filas que quedaron vacías : ");

        máximo = VectorSumaFilas[0];

        for(i = 0 ; i < 12 ; i++){
            if (VectorSumaFilas[i] == 0){
                System.out.printf(" %d ", i+1);
            }
            if (VectorSumaFilas[i] > máximo){
                máximo = VectorSumaFilas[i];
            }
        }
        System.out.printf("\nFila/s con la mayor cantidad de espectadores : ");

        for(i = 0 ; i < 12 ; i++){
            if (VectorSumaFilas[i] == máximo){
                System.out.printf(" %d ", i+1);
            }
        }
        for(i = 0 ; i < 9 ; i++){
            for (j = 0 ; j < 12 ; j++){
                if (Matriz[j][i] == 'R'){
                    VectorSumaColumnas[i]++;
                }
            }
        }
        for (i = 0 ; i<9-1 ; i++){
            for (j = 0 ; j <9-i-1 ; j++){

                if (VectorSumaColumnas[j] < VectorSumaColumnas[j+1]){
                    auxiliar = VectorSumaColumnas[j];
                    VectorSumaColumnas[j] = VectorSumaColumnas[j+1];
                    VectorSumaColumnas[j+1] = auxiliar;

                    auxiliar = VectorAsientos[j];
                    VectorAsientos[j] = VectorAsientos[j+1];
                    VectorAsientos[j+1] = auxiliar;
                }
            }
        }   
        System.out.println("\n\t\t\tButaca\t\t\tCantidad");
        for(i = 0 ; i < 9 ; i++){
            System.out.printf("\t\t\t%d\t\t\t%d%n", VectorAsientos[i], VectorSumaColumnas[i]);
        }
    }
}
