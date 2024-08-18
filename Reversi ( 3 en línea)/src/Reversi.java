/*
7.2.16 Realizar el juego de 3 líneas con un tablero de 6 filas por 10 columnas. El juego será para dos jugadores,
uno utilizará fichas redondas representadas por la letra O y el otro jugador marcará sus fichas con la letra X.
El juego se desarrolla de a un turno por vez donde el jugador elije sobre que columna tirar su ficha
(numerarlas del 1 al 10). La ficha debe “caer” hasta la primera posición libre. Cada vez que ponga una
ficha en el tablero deberá verificarse si se ha ganado la partida al tener 3 fichas del mismo tipo
consecutivas. Si se llena todo el tablero y ningún participante gana, se mostrará “empate”.
a. Chequear si se ganó el juego teniendo en cuenta si se forma 3 en línea solo en forma vertical.
b. Chequear si se ganó el juego teniendo en cuenta si se forma 3 en línea tanto en forma vertical como
horizontal.
c. Chequear si se ganó el juego teniendo en cuenta si se forma 3 en cualquier dirección (vertical,
horizontal, o diagonal)
 */

import java.util.Scanner;

public class Reversi {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        char[][] Matriz = new char[13][42];
        int[] VectorColumnas = { 0, 2, 6, 10, 14, 18, 22, 26, 30, 34, 38 };
        int contador = 0;

        InicializarMatriz(Matriz);

        while (contador < 60) {
            Jugar(Matriz, scanner, VectorColumnas);
            contador++;
        }
        scanner.close();
        System.out.println("\n\nEmpate !!!!");
    }

    public static int Jugar(char[][] Matriz, Scanner scanner, int[] VectorColumnas) {

        int i, col, columna, llena = 0;
        char letra = ' ';

        for (i = 1; i <= 2; i++) {
            do {
                MostrarTablero(Matriz);
                if (llena == -1) {
                    System.out.println("\nColumna llena, por favor elija otra.");
                }
                if (i == 1) {
                    letra = 'O';
                } else {
                    letra = 'X';
                }
                System.out.println("\nParticipante número " + i + " , el que usa '" + letra + "' elija columna :");
                col = Valida(scanner);
                columna = VectorColumnas[col];
                llena = ColumnaLlena(Matriz, columna, letra);
                if (llena == 1) {
                    MostrarTablero(Matriz);
                    System.out.println("\nEL PARTICIPANTE " + i + " GANÓ!!!!!!");
                    System.exit(0);
                }
            } while (llena == -1);

        }
        return 0;
    }

    public static int ColumnaLlena(char[][] Matriz, int columna, char letra) {

        int i = 11;

        while (i > 0) {
            if (Matriz[i][columna] == ' ') {
                Matriz[i][columna] = letra;
                if (FunCheqA(Matriz, i, columna, letra) || FunCheqB(Matriz, i, columna, letra) || FunCheqC(Matriz, i, columna, letra)) {
                    return 1;
                }
                return 0;
            } else {
                i = i - 2;
            }
        }
        return -1;
    }

    public static boolean FunCheqC(char[][] Matriz, int fila, int columna, char letra) {
        
        if (fila - 2 >= 0 && columna - 4 >= 0 && fila + 2 <= 12 && columna + 4 <= 41) {
            if (Matriz[fila - 2][columna - 4] == letra && Matriz[fila + 2][columna + 4] == letra) {
                return true;
            }
            if (Matriz[fila + 2][columna - 4] == letra && Matriz[fila - 2][columna + 4] == letra) {
                return true;
            }
        }
        if (fila - 4 >= 1 && columna + 8 <= 38) {
            if (Matriz[fila - 2][columna + 4] == letra && Matriz[fila - 4][columna + 8] == letra) {
                return true;
            }
        }
        if (fila + 4 <= 11 && columna - 8 >= 2) {
            if (Matriz[fila + 2][columna - 4] == letra && Matriz[fila + 4][columna - 8] == letra) {
                return true;
            }
        }
        if (fila + 4 <= 11 && columna + 8 <= 38) {
            if (Matriz[fila + 2][columna + 4] == letra && Matriz[fila + 4][columna + 8] == letra) {
                return true;
            }
        }if (fila - 4 >= 1 && columna - 8 >= 2) {
            if (Matriz[fila - 2][columna - 4] == letra && Matriz[fila - 4][columna - 8] == letra) {
                return true;
            }
        }
        return false;
    }

    public static boolean FunCheqB(char[][] Matriz, int i, int columna, char letra) {

        int j;

        for (j = 2; j <= 30; j = j + 4) {
            if (Matriz[i][j] == letra && Matriz[i][j + 4] == letra && Matriz[i][j + 8] == letra) {
                return true;
            }
        }
        return false;
    }

    public static boolean FunCheqA(char[][] Matriz, int i, int columna, char letra) {

        int j;

        for (j = 1; j <= 7; j = j + 2) {
            if (Matriz[j][columna] == letra && Matriz[j + 2][columna] == letra && Matriz[j + 4][columna] == letra) {
                return true;
            }
        }
        return false;
    }

    public static int Valida(Scanner scanner) {

        int columna;
        do {
            columna = scanner.nextInt();
            if (columna < 1 || columna > 10) {
                System.err.println("Columna fuera del rango, debe elegir entre 1 y 10. Intente nuevamente :");
            }
        } while (columna < 1 || columna > 10);
        return columna;
    }

    public static void InicializarMatriz(char[][] Matriz) {

        int i, j;

        for (i = 0; i < 13; i++) {
            for (j = 0; j < 42; j++) {
                Matriz[i][j] = ' ';
            }
        }
        for (i = 0; i < 13; i++) {
            for (j = 0; j < 42; j = j + 4) {
                Matriz[i][j] = '\u2502';
            }
        }
        for (j = 0; j < 41; j++) {
            Matriz[12][j] = '\u2500';
        }
    }

    public static void MostrarTablero(char[][] Matriz) {
        int i, j;
        System.out.println("\n\t\t\t\t\t\tReversi");
        System.out.println("\n\t\t\tColumnas : 1   2   3   4   5   6   7   8   9   10");
        for (i = 0; i < 13; i++) {
            System.out.printf("\n\t\t\t         ");
            for (j = 0; j < 42; j++) {
                System.out.printf("%c", Matriz[i][j]);
            }
        }
    }
}
