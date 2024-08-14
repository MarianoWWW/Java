
/*
7.2.14 Realizar el juego del rompecabezas de 8, dicho juego comienza con una matriz de 3x3 de números del 1
al 8 desordenados y un espacio en blanco. Como, por ejemplo:
2 5 1
7 6 3
8   4
El objetivo del juego es lograr que los números queden ordenados de la siguiente forma:
1 2 3
4 5 6
7 8
Para ello, el jugador puede mover un número a la vez al casillero libre, solo puedo mover alguno de los
números adyacentes al casillero en blando y solo en forma horizontal o vertical. Por ejemplo tomando
como partida la primera matriz desordenada se podría mover el 6 hacia abajo, el 4 hacia la izquierda o el
8 hacia la derecha.
El jugador deberá ingresar el número que quiere mover y automáticamente moverlo, si es posible, al
casillero libre. Luego cada movimiento se debe controlar si se llega al objetivo de ordenar los números e
informar que se ha ganado la partida. Puede ir contando la cantidad de movimientos que se llevó al
jugador lograr llegar a ordenar el rompecabezas y mostrarlos al finalizar para que pueda volver a jugarlo
y superarse.

 */
import java.util.Scanner;

public class Rompecabezas {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        char[][] Matriz = new char[7][13];
        int ganador = -1, contador = 0;
        char número;

        InicializarMatriz(Matriz);
        TableroNivel1(Matriz);
       
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
        Matriz[1][2] = '2';
        Matriz[1][6] = '5';
        Matriz[1][10] = '1';
        Matriz[3][2] = '7';
        Matriz[3][6] = '6';
        Matriz[3][10] = '3';
        Matriz[5][2] = '8';
        Matriz[5][10] = '4';
    }
}
