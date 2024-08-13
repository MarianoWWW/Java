/*
 7.2.13 Realizar el juego de Tatetí para dos jugadores. EL jugador 1 utilizará la letra X y el jugador 2 la letra O para
marcar sus elecciones. El tablero armarlo con una matriz de 3x3 que debe ser visualizada en pantalla en cada
jugada marcando la ubicación elegida por cada jugador. Luego de cada jugada se debe llamar a una función
para verificar si el jugador ganó o no la partida. Si se llega a la última jugada y nadie gana, se debe informar
del empate.
 */

import java.util.Scanner;

public class TA_TE_TI {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        char[][] Matriz = new char[5][11];
        int contador = 0, ganador = -1;
        ;

        InicializarMatriz(Matriz);
        MostrarTablero(Matriz);
        while (contador < 5 && ganador == -1) {

            System.out.println("\nTurno del jugador 1 : ");
            Elegir(1, scanner, Matriz);
            if (contador > 1) {
                ganador = ChequeoGanador(Matriz, 'X', 1);
            }
            MostrarTablero(Matriz);
            if (contador != 4 && ganador == -1) {
                System.out.println("\nTurno del jugador 2 : ");
                Elegir(2, scanner, Matriz);
                if (contador > 1) {
                    ganador = ChequeoGanador(Matriz, 'O', 2);
                }
                MostrarTablero(Matriz);
            }
            contador++;
        }
        if (ganador == -1){
            System.out.println("\n\nEl juego terminó como casi siempre, en empate.");
        }
        else{
            System.out.println("\n\nFELICITACIONES !!!!! Participante número "+(ganador)+ " ganaste el juego.");
        }
    }

    public static int ChequeoGanador(char[][] Matriz, char win, int g) {

        int i, ganador = -1;

        for (i = 0 ; i < 5 ; i = i + 2){
            if (Matriz[i][1] == win && Matriz[i][5] == win && Matriz[i][9] == win){
                ganador = g;
            }
        }
        for (i = 1 ; i < 10 ; i = i + 4){
            if (Matriz[0][i] == win && Matriz[2][i] == win && Matriz[4][i] == win){
                ganador = g;
            }
        }
        /* Cambié los if, por ciclos for
        // Por filas
        if (Matriz[0][1] == win && Matriz[0][5] == win && Matriz[0][9] == win){
            ganador = g;
        }
        if (Matriz[2][1] == win && Matriz[2][5] == win && Matriz[2][9] == win){
            ganador = g;
        }
        if (Matriz[4][1] == win && Matriz[4][5] == win && Matriz[4][9] == win){
            ganador = g;
        }
        // Por columnas
        if (Matriz[0][1] == win && Matriz[2][1] == win && Matriz[4][1] == win){
            ganador = g;
        }
        if (Matriz[0][5] == win && Matriz[2][5] == win && Matriz[4][5] == win){
            ganador = g;
        }
        if (Matriz[0][9] == win && Matriz[2][9] == win && Matriz[4][9] == win){
            ganador = g;
        }
        */
        //Cruces
        if (Matriz[0][1] == win && Matriz[2][5] == win && Matriz[4][9] == win){
            ganador = g;
        }
        if (Matriz[4][1] == win && Matriz[2][5] == win && Matriz[0][9] == win){
            ganador = g;
        }
        return ganador;
    }

    public static void Elegir(int jugador, Scanner scanner, char[][] Matriz) {

        int fila, columna, i, j, chequeo = -1;

        do {
            System.out.println("Ingrese la Fila : ");
            fila = Valida(scanner);
            System.out.println("Ingrese la Columna : ");
            columna = Valida(scanner);
            if (jugador == 1) {
                i = FunciónFila(fila);
                j = FunciónColumna(columna);
                chequeo = Buscar(Matriz, i, j);
                if (chequeo == -1){
                    Matriz[i][j] = 'X';
                }
            } else {
                i = FunciónFila(fila);
                j = FunciónColumna(columna);
                chequeo = Buscar(Matriz, i, j);
                if (chequeo == -1){
                    Matriz[i][j] = 'O';
                }
            }
        } while (chequeo != -1);
    }

    public static int FunciónColumna(int columna){
        int j;
        if (columna == 1) {
            j = 1;
        } else {
            if (columna == 2) {
                j = 5;
            } else {
                j = 9;
            }
        }
        return j;
    }

    public static int FunciónFila(int fila){
        int i;
        if (fila == 1) {
            i = 0;
        } 
        else {
            if (fila == 2) {
                i = 2;
            } else {
                i = 4;
            }
        }
        return i;
    }
    public static int Buscar(char[][] Matriz, int i, int j) {

        int chequeo = -1;
        if (Matriz[i][j] != ' '){
            System.out.println("Error. Esa casilla ya fue elegida. Intente nuevamente.");
            chequeo = 2;
        }
        return chequeo;
    }

    public static int Valida(Scanner scanner) {
        int número;
        do {
            número = scanner.nextInt();
            if (número < 1 || número > 3) {
                System.out.println("Error en el dato ingresado, solamente puede ser de 1 a 3. Intente nuevamente.");
            }
        } while (número < 1 || número > 3);

        return número;
    }

    public static void InicializarMatriz(char[][] Matriz) {

        int i, j;

        for (i = 0; i < 5; i++) {
            System.out.println("");
            for (j = 0; j < 11; j++) {
                Matriz[i][j] = ' ';
            }
        }
        for (i = 1; i < 4; i = i + 2) {
            for (j = 0; j < 11; j++) {
                Matriz[i][j] = '\u2500';
            }
        }
        for (i = 0; i < 5; i++) {
            for (j = 3; j < 8; j = j + 4) {
                Matriz[i][j] = '\u2502';
            }
        }
    }

    public static void MostrarTablero(char[][] Matriz) {
        int i, j;
        System.out.println("\n\n\n\n\n\n\n\n\t\t\tMi primer jueguito : TA TE TI\n\t\t\tDonde uno gana y otro pierde.");
        System.out.println("\t\t\tO uno pierde y el otro gana.\n\t\tEn realidad, bien jugado siempre es empate.");
        System.out.println("\t\t\tEntonces TODOS ganan SIEMPRE.");
        System.out.println("\t\t\t      Col:1 Col:2 Col:3");
        for (i = 0; i < 5; i++) {
            if (i == 0) {
                System.out.printf("\n\t\t\tFila: %d  ", i + 1);
            } else {
                if (i == 2) {
                    System.out.printf("\n\t\t\tFila: 2  ");
                } else {
                    if (i == 4) {
                        System.out.printf("\n\t\t\tFila: 3  ");
                    } else {
                        System.out.printf("\n\t\t\t         ");
                    }
                }
            }
            for (j = 0; j < 11; j++) {
                System.out.printf("%c", Matriz[i][j]);
            }
        }
    }
}
