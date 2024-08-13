/*
Complemento: Modificar el juego para que sea de un solo jugador. Deberá programar la inteligencia
artificial para que la computadora elija donde realizar la jugada para intentar ganar la partida y no perder
completando el espacio correspondiente cuando haga falta.
 */

import java.util.Scanner;

public class TA_TE_TI_uno {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        char[][] Matriz = new char[5][11];
        int contador = 0, ganador = -1, lugar;

        System.out.println("Decime cual cual cual es tu nombre : ");
        String nombre = scanner.nextLine();
        System.out.println("\n" + (nombre) + " ¿Preferís jugar en primer o segundo lugar?");
        do {
            lugar = scanner.nextInt();
            if (lugar != 1 && lugar != 2) {
                System.out.println("Error, tenes que elegir entre 1 o 2. Intenta nuevamente " + (nombre) + " :");
            }
        } while (lugar != 1 && lugar != 2);

        InicializarMatriz(Matriz);
        MostrarTablero(Matriz);

        if (lugar == 1) {
            while (contador < 5 && ganador == -1) {

                System.out.println("\nTurno del jugador " + (nombre) + " ,estas utilizando las X :");
                Elegir(1, scanner, Matriz);
                if (contador > 1) {
                    ganador = ChequeoGanador(Matriz, 'X', 1);
                }
                MostrarTablero(Matriz);
                if (contador != 4 && ganador == -1) {
                    UsarIA(Matriz, contador);
                    if (contador > 1) {
                        ganador = ChequeoGanador(Matriz, 'O', 2);
                    }
                    MostrarTablero(Matriz);
                }
                contador++;
            }
        }
        else{
            while (contador < 5 && ganador == -1) {

                UsarIA(Matriz, contador);
                    if (contador > 1) {
                        ganador = ChequeoGanador(Matriz, 'O', 2);
                    }
                    
                MostrarTablero(Matriz);
                if (contador != 4 && ganador == -1) {
                    System.out.println("\nTurno de " + (nombre) + " :");
                    Elegir(1, scanner, Matriz);
                    if (contador > 1) {
                        ganador = ChequeoGanador(Matriz, 'X', 1);
                    }
                    
                }
                contador++;
            }
        }
        if (ganador == -1) {
            System.out.println("\n\nEl juego terminó como casi siempre, en empate.");
        } else {
            if (ganador == 1){
            System.out.println("\n\nFELICITACIONES !!!!!  " + (nombre) + " , ganaste el juego.");
            }
            else{
                System.out.println("\n\n"+(nombre)+" ,te ganó mi supuesta IA. Suerte en la próxima =)");
            }
        }
    }

    public static void UsarIA(char[][] Matriz, int contador) {

        int i, j, pos = -1;

        if (contador == 0) {
            if (Matriz[2][5] == ' ') {
                Matriz[2][5] = 'O';
                pos = 1;
            }
            if (Matriz[2][5] == 'X') {
                Matriz[0][1] = 'O';
                pos = 1;
            }
        } else {
            for (i = 0; i < 5; i = i + 2) {
                if (Matriz[i][1] == 'O' && Matriz[i][5] == 'O' && Matriz[i][9] == ' ') {
                    Matriz[i][9] = 'O';
                    pos = 1;
                }
            }
            for (i = 1; i < 10; i = i + 4) {
                if (Matriz[0][i] == 'O' && Matriz[2][i] == 'O' && Matriz[4][i] == ' ') {
                    Matriz[4][i] = 'O';
                    pos = 1;
                }
            }
            if (Matriz[0][1] == 'O' && Matriz[2][5] == 'O' && Matriz[4][9] == ' ') {
                Matriz[4][9] = 'O';
                pos = 1;
            }
            if (Matriz[4][1] == 'O' && Matriz[2][5] == 'O' && Matriz[0][9] == ' ') {
                Matriz[0][9] = 'O';
                pos = 1;
            }
            for (i = 0; i < 5; i = i + 2) {
                if (Matriz[i][5] == 'O' && Matriz[i][9] == 'O' && Matriz[i][1] == ' ') {
                    Matriz[i][1] = 'O';
                    pos = 1;
                }
            }
            for (i = 1; i < 10; i = i + 4) {
                if (Matriz[2][i] == 'O' && Matriz[4][i] == 'O' && Matriz[0][i] == ' ') {
                    Matriz[0][i] = 'O';
                    pos = 1;
                }
            }
            if (Matriz[2][5] == 'O' && Matriz[4][9] == 'O' && Matriz[0][1] == ' ') {
                Matriz[0][1] = 'O';
                pos = 1;
            }
            if (Matriz[2][5] == 'O' && Matriz[0][9] == 'O' && Matriz[4][1] == ' ') {
                Matriz[4][1] = 'O';
                pos = 1;
            }
            for (i = 0; i < 5; i = i + 2) {
                if (Matriz[i][1] == 'O' && Matriz[i][9] == 'O' && Matriz[i][5] == ' ') {
                    Matriz[i][5] = 'O';
                    pos = 1;
                }
            }
            for (i = 1; i < 10; i = i + 4) {
                if (Matriz[0][i] == 'O' && Matriz[4][i] == 'O' && Matriz[2][i] == ' ') {
                    Matriz[2][i] = 'O';
                    pos = 1;
                }
            }
            if (Matriz[0][1] == 'O' && Matriz[4][9] == 'O' && Matriz[2][5] == ' ') {
                Matriz[2][5] = 'O';
                pos = 1;
            }
            if (Matriz[4][1] == 'O' && Matriz[0][9] == 'O' &&  Matriz[2][5] == ' ') {
                Matriz[2][5] = 'O';
                pos = 1;
            }
            if (pos == -1) {

                for (i = 0; i < 5; i = i + 2) {
                    if (Matriz[i][1] == 'X' && Matriz[i][5] == 'X' && Matriz[i][9] == ' ') {
                        Matriz[i][9] = 'O';
                        pos = 1;
                    }
                }
                for (i = 1; i < 10; i = i + 4) {
                    if (Matriz[0][i] == 'X' && Matriz[2][i] == 'X' && Matriz[4][i] == ' ') {
                        Matriz[4][i] = 'O';
                        pos = 1;
                    }
                }
                if (Matriz[0][1] == 'X' && Matriz[2][5] == 'X' && Matriz[4][9] == ' ') {
                    Matriz[4][9] = 'O';
                    pos = 1;
                }
                if (Matriz[4][1] == 'X' && Matriz[2][5] == 'X'&& Matriz[0][9] == ' ') {
                    Matriz[0][9] = 'O';
                    pos = 1;
                }
                for (i = 0; i < 5; i = i + 2) {
                    if (Matriz[i][5] == 'X' && Matriz[i][9] == 'X' && Matriz[i][1] == ' ') {
                        Matriz[i][1] = 'O';
                        pos = 1;
                    }
                }
                for (i = 1; i < 10; i = i + 4) {
                    if (Matriz[2][i] == 'X' && Matriz[4][i] == 'X' && Matriz[0][i] == ' ') {
                        Matriz[0][i] = 'O';
                        pos = 1;
                    }
                }
                if (Matriz[2][5] == 'X' && Matriz[4][9] == 'X' && Matriz[0][1] == ' ') {
                    Matriz[0][1] = 'O';
                    pos = 1;
                }
                if (Matriz[2][5] == 'X' && Matriz[0][9] == 'X'&& Matriz[4][1] == ' ') {
                    Matriz[4][1] = 'O';
                    pos = 1;
                }
                for (i = 0; i < 5; i = i + 2) {
                    if (Matriz[i][1] == 'X' && Matriz[i][9] == 'X' && Matriz[i][5] == ' ') {
                        Matriz[i][5] = 'O';
                        pos = 1;
                    }
                }
                for (i = 1; i < 10; i = i + 4) {
                    if (Matriz[0][i] == 'X' && Matriz[4][i] == 'X' && Matriz[2][i] == ' ') {
                        Matriz[2][i] = 'O';
                        pos = 1;
                    }
                }
                if (Matriz[0][1] == 'X' && Matriz[4][9] == 'X' && Matriz[2][5] == ' ') {
                    Matriz[2][5] = 'O';
                    pos = 1;
                }
                if (Matriz[4][1] == 'X' && Matriz[0][9] == 'X' && Matriz[2][5] == ' ') {
                    Matriz[2][5] = 'O';
                    pos = 1;
                }

            }
            if (pos == -1) {
                for (i = 0; i < 5; i = i + 2) {
                    if (Matriz[i][1] == 'O' && Matriz[i][5] == ' ' && Matriz[i][9] == ' ' && pos == -1) {
                        Matriz[i][9] = 'O';
                        pos = 1;
                    }
                }
                for (i = 1; i < 10; i = i + 4) {
                    if (Matriz[0][i] == 'O' && Matriz[2][i] == ' ' && Matriz[4][i] == ' ' && pos == -1) {
                        Matriz[4][i] = 'O';
                        pos = 1;
                    }
                }
                if (Matriz[0][1] == 'O' && Matriz[2][5] == ' ' && Matriz[4][9] == ' ' && pos == -1) {
                    Matriz[4][9] = 'O';
                    pos = 1;
                }
                if (Matriz[4][1] == 'O' && Matriz[2][5] == ' ' && Matriz[0][9] == ' ' && pos == -1) {
                    Matriz[0][9] = 'O';
                    pos = 1;
                }
                for (i = 0; i < 5; i = i + 2) {
                    if (Matriz[i][1] == ' ' && Matriz[i][5] == 'O' && Matriz[i][9] == ' ' && pos == -1) {
                        Matriz[i][9] = 'O';
                        pos = 1;
                    }
                }
                for (i = 1; i < 10; i = i + 4) {
                    if (Matriz[0][i] == ' ' && Matriz[2][i] == 'O' && Matriz[4][i] == ' ' && pos == -1) {
                        Matriz[4][i] = 'O';
                        pos = 1;
                    }
                }
                if (Matriz[0][1] == ' ' && Matriz[2][5] == 'O' && Matriz[4][9] == ' ' && pos == -1) {
                    Matriz[4][9] = 'O';
                    pos = 1;
                }
                if (Matriz[4][1] == ' ' && Matriz[2][5] == 'O' && Matriz[0][9] == ' ' && pos == -1) {
                    Matriz[0][9] = 'O';
                    pos = 1;
                }
                for (i = 0; i < 5; i = i + 2) {
                    if (Matriz[i][1] == ' ' && Matriz[i][5] == ' ' && Matriz[i][9] == 'O' && pos == -1) {
                        Matriz[i][5] = 'O';
                        pos = 1;
                    }
                }
                for (i = 1; i < 10; i = i + 4) {
                    if (Matriz[0][i] == ' ' && Matriz[2][i] == ' ' && Matriz[4][i] == 'O' && pos == -1) {
                        Matriz[2][i] = 'O';
                        pos = 1;
                    }
                }
                if (Matriz[0][1] == ' ' && Matriz[2][5] == ' ' && Matriz[4][9] == 'O' && pos == -1) {
                    Matriz[2][5] = 'O';
                    pos = 1;
                }
                if (Matriz[4][1] == ' ' && Matriz[2][5] == ' ' && Matriz[0][9] == 'O' && pos == -1) {
                    Matriz[2][5] = 'O';
                    pos = 1;
                }

            }
            if (pos == -1) {
                for (i = 0 ; i < 5; i = i + 2){
                    for (j = 1 ; j < 11 ; j = j + 4){
                        if (Matriz[i][j] == ' '){
                            Matriz[i][j] = 'O';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static int ChequeoGanador(char[][] Matriz, char win, int g) {

        int i, ganador = -1;

        for (i = 0; i < 5; i = i + 2) {
            if (Matriz[i][1] == win && Matriz[i][5] == win && Matriz[i][9] == win) {
                ganador = g;
            }
        }
        for (i = 1; i < 10; i = i + 4) {
            if (Matriz[0][i] == win && Matriz[2][i] == win && Matriz[4][i] == win) {
                ganador = g;
            }
        }
        // Cruces
        if (Matriz[0][1] == win && Matriz[2][5] == win && Matriz[4][9] == win) {
            ganador = g;
        }
        if (Matriz[4][1] == win && Matriz[2][5] == win && Matriz[0][9] == win) {
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
                if (chequeo == -1) {
                    Matriz[i][j] = 'X';
                }
            } else {
                i = FunciónFila(fila);
                j = FunciónColumna(columna);
                chequeo = Buscar(Matriz, i, j);
                if (chequeo == -1) {
                    Matriz[i][j] = 'O';
                }
            }
        } while (chequeo != -1);
    }

    public static int FunciónColumna(int columna) {
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

    public static int FunciónFila(int fila) {
        int i;
        if (fila == 1) {
            i = 0;
        } else {
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
        if (Matriz[i][j] != ' ') {
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
        System.out.println("\n\n\n\n\n\n\n\n\t\t\t  TA TE TI versión un jugador.");
        System.out.println("\t\t\tBien jugado, siempre es empate.");
        System.out.println("\t\t\t¿Será cómo jugar contra una IA?\n");
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