/*
Complemento: Puede agregar al ejercicio anterior distintos niveles para ir aumentando el nivel de
complejidad partiendo de distintas matrices desordenadas. Los primeros niveles pueden ser matrices
parcialmente desordenadas y luego a medida que avanza de nivel ir jugando con distintas matrices de
inicio.
 */
import java.util.Random;
import java.util.Scanner;

public class Rompecabezas_con_niveles {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        char[][] Matriz = new char[7][13];
        int ganador = -1, contador = 0, nivel;
        char número;

        InicializarMatriz(Matriz);
       
        
        do {
            System.out.println("\n\nElegir nivel del juego (1. Fácil)  (2. Intermedio) (3. Aleatorio) :");
            nivel = scanner.nextInt();
            if (nivel < 1 || nivel > 3){
                System.out.println("Error en el nivel elegido, intenta nuevamente.");
            }
        }while (nivel < 1 || nivel > 3);
        switch (nivel) {
            case 1:
                TableroNivel1(Matriz);
                break;
            case 2:
                TableroNivel2(Matriz);
                break;
            default:
                TableroNivel3(Matriz);
                break;
        }
        while (ganador == -1){
            MostrarTablero(Matriz);
            do{
                System.out.println("\n\nEscriba el número que desea mover (del 1 al 8): ");
                número = scanner.next().charAt(0);
                if (número !='1' && número !='2' && número !='3' && número !='4' && número !='5' && número !='6' && número !='7' && número !='8'){
                    System.out.println("Error. Ese número no pertenece al juego. Intente nuevamente.");
                }
            }while (número !='1' && número !='2' && número !='3' && número !='4' && número !='5' && número !='6' && número !='7' && número !='8');
            contador ++;
            FunciónBuscarYMover(Matriz, número);
            ganador = ChequearGanador(Matriz);
        }
        scanner.close();
        MostrarTablero(Matriz);
        System.out.println("\n\n\t\t\tFELICITACIONES !!! GANASTE !!!");
        System.out.println("\t\t\tLo hiciste en "+(contador)+" movimientos.");
    }
    public static int ChequearGanador(char[][] Matriz){

        int ganador = -1;

        if (Matriz[1][2] == '1' && Matriz[1][6] == '2' && Matriz[1][10] == '3' && Matriz[3][2] == '4' && Matriz[3][6] == '5' && Matriz[3][10] == '6' && Matriz[5][2] == '7' && Matriz[5][6] == '8'){
            ganador = 2;
        }

        return ganador;
    }
    public static void FunciónBuscarYMover(char[][] Matriz, char número){

        int i, j, coordenadaX = 0, coordenadaY = 0;

        for (i = 1 ; i < 6 ; i = i + 2){
            for (j = 2 ; j < 11 ; j = j + 4){
                if (Matriz[i][j] == número){
                    coordenadaX = i;
                    coordenadaY = j;
                }
            }
        }
        for (i = -2 ; i <3 ; i = i + 4){
            try{
                if (Matriz[coordenadaX-i][coordenadaY] == ' '){
                    Matriz[coordenadaX-i][coordenadaY] = Matriz[coordenadaX][coordenadaY];
                    Matriz[coordenadaX][coordenadaY] = ' ';
                }
            }catch(ArrayIndexOutOfBoundsException e){}
        }
        for ( i = -4 ; i < 5 ; i = i +8){
            try{
                if (Matriz[coordenadaX][coordenadaY-i] == ' '){
                    Matriz[coordenadaX][coordenadaY-i] = Matriz[coordenadaX][coordenadaY];
                    Matriz[coordenadaX][coordenadaY] = ' ';
                }
            }catch(ArrayIndexOutOfBoundsException e){}
        }
    }
    public static void InicializarMatriz(char[][] Matriz) {

        int i, j;

        for (i = 0; i < 7; i++) {
            for (j = 0; j < 13; j++) {
                Matriz[i][j] = ' ';
            }
        }
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 13; j = j + 4) {
                Matriz[i][j] = '\u2502';
            }
        }
        for (i = 0; i < 7; i = i + 2) {
            for (j = 0; j < 13; j++) {
                Matriz[i][j] = '\u2500';
            }
        }
    }

    public static void MostrarTablero(char[][] Matriz) {
        int i, j;
        System.out.println("\n\n\n\n\n\n\n\n\t\t\t       Rompecabezas de 8");
        System.out.println("\tEl objetivo del juego es lograr que los números queden ordenados.");
        for (i = 0; i < 7; i++) {
            System.out.printf("\n\t\t\t         ");
            for (j = 0; j < 13; j++) {
                System.out.printf("%c", Matriz[i][j]);
            }
        }
    }

    public static void TableroNivel1(char[][] Matriz) {
        Matriz[1][2] = '6';
        Matriz[1][6] = '8';
        Matriz[1][10] = '1';
        Matriz[3][2] = '5';
        Matriz[3][6] = '7';
        Matriz[3][10] = '2';
        Matriz[5][2] = '4';
        Matriz[5][10] = '3';
    }
    public static void TableroNivel2(char[][] Matriz) {
        Matriz[1][2] = '3';
        Matriz[1][6] = '1';
        Matriz[1][10] = '5';
        Matriz[3][2] = '4';
        Matriz[3][6] = '6';
        Matriz[3][10] = '2';
        Matriz[5][2] = '8';
        Matriz[5][10] = '7';
    }
    public static void TableroNivel3(char[][] Matriz) {

        Random random = new Random();

        int[] VectorRandom = new int[8];
        int i, pos, número = 0;

        for (i = 0 ; i < 8 ; i++){
            pos = 2;
            while (pos != -1){
                número = random.nextInt(8) + 1;
                pos = FunciónBuscar(VectorRandom, número, i);
            }
            VectorRandom[i] = número;
        }
        for (i = 0 ; i < 8 ; i++){
            System.out.printf("  %d  ", VectorRandom[i]);

        }
        Matriz[1][2] = (char)('0' + VectorRandom[0]);
        Matriz[1][6] = (char)('0' + VectorRandom[1]);
        Matriz[1][10] = (char)('0' + VectorRandom[2]);
        Matriz[3][2] = (char)('0' + VectorRandom[3]);
        Matriz[3][6] = (char)('0' + VectorRandom[4]);
        Matriz[3][10] = (char)('0' + VectorRandom[5]);
        Matriz[5][2] = (char)('0' + VectorRandom[6]);
        Matriz[5][10] = (char)('0' + VectorRandom[7]);         
    }
    public static int FunciónBuscar(int[] VectorRandom, int bus, int ce){

        int i = 0, pos = -1;
        while (pos == -1 && i < ce){
            if (VectorRandom[i] == bus){
                pos = i;
            }
            else{
                i++;
            }
        }
        return pos;
    }

}