/*
Complementos:
a. Mejorar el juego al no permitir ubicar barcos en casilleros adyacentes teniendo en cuenta que al hundir
un barco se deberán marcar todos los casilleros como agua (letra A).
b. Agregar la posibilidad de poner barcos de distinto tamaño, por ejemplo, 2 barcos de 2 casilleros y 3 de
un casillero, lo que implica que un barco estará hundido solo cuando se alcancen con un disparo en
todas sus partes.
 */

import java.util.Scanner;

public class Batalla_Naval_C {

    private static final int[] VectorFila = { 0, 1, 3, 5, 7, 9 };
    private static final int[] VectorColumna = { 0, 2, 6, 10, 14, 18 };

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        char[][] MatrizEscondida = new char[11][21], MatrizHundir = new char[11][21];
        int ganador = 0, contador = 0;
        int[] Vdoble = new int[4];
        Ingreso ingreso = new Ingreso();

        InicializarMatriz(MatrizEscondida, MatrizHundir);

        System.err.println("Es el turno del desafiante. Debe elegir las coordenadas de los 5 barcos.");
        System.out.println("Sin que el otro competidor vea.");

        Elegir(MatrizEscondida, scanner, ingreso);
        MostrarTablero(MatrizEscondida);

        System.out.println("\nEstas fueron tus selecciones. Presiona Enter y llama al otro Competidor.");
        scanner.nextLine();
        scanner.nextLine();

        System.err.println("Es el turno del competidor.");
        System.out.println("Debe elegir las coordenadas para intentar hundir los 5 barcos.");

        while (ganador < 6) {
            MostrarTablero(MatrizHundir);
            ganador = ganador + Jugar(MatrizHundir, MatrizEscondida, scanner, Vdoble, ingreso);
            contador++;
        }
        scanner.close();
        MostrarTablero(MatrizHundir);
        System.out.println("\nFELICITACIONES!!!!! ganaste en " + (contador) + " disparos.");

    }

    public static void Elegir(char[][] MatrizEscondida, Scanner scanner, Ingreso ingreso) {

        int i, chequeo = -1, fila2, columna2;

        MostrarTablero(MatrizEscondida);
        do {
            System.out.println("\nElegir el barco de dos casilleros 1/2 : ");
            
            ingreso.ingreso(scanner);
            fila2 = ingreso.fila;
            columna2 = ingreso.columna;
            chequeo = Buscar(MatrizEscondida, VectorFila[ingreso.fila], VectorColumna[ingreso.columna]);
            if (chequeo == -1) {
                MatrizEscondida[VectorFila[ingreso.fila]][VectorColumna[ingreso.columna]] = 'B';
            }
        } while (chequeo != -1);
        MostrarTablero(MatrizEscondida);

        do {
            System.out.println("\nElegir el barco de dos casilleros 2/2 : ");
            ingreso.ingreso(scanner);
            chequeo = Buscar(MatrizEscondida, VectorFila[ingreso.fila], VectorColumna[ingreso.columna]);
            if (chequeo == -1) {

                if ((ingreso.fila + 1 == fila2 && ingreso.columna == columna2) || (ingreso.fila - 1 == fila2 && ingreso.columna == columna2) || (ingreso.fila == fila2 && ingreso.columna + 1 == columna2) || (ingreso.fila == fila2 && ingreso.columna - 1 == columna2)) {
                    MatrizEscondida[VectorFila[ingreso.fila]][VectorColumna[ingreso.columna]] = 'B';
                } else {
                    chequeo = 2;
                }
            }  
        } while (chequeo != -1);
        MostrarTablero(MatrizEscondida);
        System.out.println("\nElegir los barcos de un casillero : ");
        for (i = 0; i < 4; i++) {
            MostrarTablero(MatrizEscondida);
            do {
                ingreso.ingreso(scanner);
                chequeo = Buscar(MatrizEscondida, VectorFila[ingreso.fila], VectorColumna[ingreso.columna]);
                if (chequeo == -1) {

                    if (casillaContigua(MatrizEscondida, VectorFila[ingreso.fila], VectorColumna[ingreso.columna])) {
                        MatrizEscondida[VectorFila[ingreso.fila]][VectorColumna[ingreso.columna]] = 'B';
                    } else {
                        System.out.println(
                                "En esta versión, no se pueden ubicar barcos en casillas contiguas, elija  nuevamente.");
                        chequeo = 2;
                    }
                }
            } while (chequeo != -1);
        }
    }

    public static int Jugar(char[][] MatrizHundir, char[][] MatrizEscondida, Scanner scanner,
            int[] Vdoble, Ingreso ingreso) {

        int chequeo = -1, ganador = 0;

        ingreso.ingreso(scanner);
        chequeo = BuscarHundir(MatrizEscondida, VectorFila[ingreso.fila], VectorColumna[ingreso.columna], Vdoble,
                MatrizHundir);
        if (chequeo == -1) {
            MatrizHundir[VectorFila[ingreso.fila]][VectorColumna[ingreso.columna]] = 'A';
        }
        if (chequeo == 2) {
            MatrizHundir[VectorFila[ingreso.fila]][VectorColumna[ingreso.columna]] = 'X';
            ganador = 1;
        }
        return ganador;
    }

    public static boolean casillaContigua(char[][] MatrizEscondida, int i, int j) {

        int k;
        for (k = -4; k < 5; k = k + 4) {
            if (i != 1 && j + k > 0 && j + k < 19) {
                if (MatrizEscondida[i - 2][j + k] != ' ' && MatrizEscondida[i - 2][j + k] != 'A') {
                    return false;
                }
            }
        }
        for (k = -4; k < 5; k = k + 8) {
            if (j + k > 0 && j + k < 19) {
                if (MatrizEscondida[i][j + k] != ' ' && MatrizEscondida[i][j + k] != 'A') {
                    return false;
                }
            }
        }
        for (k = -4; k < 5; k = k + 4) {
            if (i != 9 && j + k > 0 && j + k < 19) {
                if (MatrizEscondida[i + 2][j + k] != ' ' && MatrizEscondida[i + 2][j + k] != 'A') {
                    return false;
                }
            }
        }
        return true;
    }

    public static int BuscarHundir(char[][] MatrizEscondida, int i, int j, int[] Vdoble,
            char[][] MatrizHundir) {

        int chequeo = -1, k;

        if (MatrizEscondida[i][j] == 'b') {
            chequeo = 1;
        }
        if (MatrizEscondida[i][j] == 'B') {
            MatrizEscondida[i][j] = 'b';
            if (casillaContigua(MatrizEscondida, i, j)) {

                Hundido(MatrizHundir, i , j);
                chequeo = 2;

            } else {
                if (Vdoble[0] == 0) {
                    System.out.println("AVERIADO!!!!");
                    Vdoble[0] = Vdoble[0] + 1;
                    Vdoble[1] = i;
                    Vdoble[2] = j;
                    chequeo = 2;
                } else {
                    Hundido(MatrizHundir, i , j);
                    MatrizHundir[Vdoble[1]][Vdoble[2]] = 'X';
                    Hundido(MatrizHundir, Vdoble[1] , Vdoble[2]);
                    MatrizHundir[i][j] = 'X';
                    chequeo = 2;
                }
            }
        }
        return chequeo;
    }
    public static void Hundido(char[][] MatrizHundir,int i,int j){

        int k;

        System.out.println("HUNDIDO!!!!!!");
                for (k = -4; k < 5; k = k + 4) {
                    if (i != 1 && j + k > 0 && j + k < 19) {
                        MatrizHundir[i - 2][j + k] = 'A';
                    }
                }
                for (k = -4; k < 5; k = k + 8) {
                    if (j + k > 0 && j + k < 19) {
                        MatrizHundir[i][j + k] = 'A';
                    }
                }
                for (k = -4; k < 5; k = k + 4) {
                    if (i != 9 && j + k > 0 && j + k < 19) {
                        MatrizHundir[i + 2][j + k] = 'A';
                    }
                }


    }

    public static int Buscar(char[][] Matriz, int i, int j) {

        int chequeo = -1;
        if (Matriz[i][j] == 'B') {
            System.out.println("Error. Esa casilla ya fue elegida. Intente nuevamente.");
            chequeo = 2;
        }
        return chequeo;
    }

    public static void InicializarMatriz(char[][] MatrizEscondida, char[][] MatrizHundir) {

        int i, j;
        
        for (i = 0; i < 11; i++) {
            for (j = 0; j < 21; j++) {
                MatrizEscondida[i][j] = ' ';
                MatrizHundir[i][j] = ' ';
            }
        }
        for (i = 0; i < 11; i++) {
            for (j = 0; j < 21; j = j + 4) {
                MatrizEscondida[i][j] = '\u2502';
                MatrizHundir[i][j] = '\u2502';
            }
        }
        for (i = 0; i < 11; i = i + 2) {
            for (j = 0; j < 21; j++) {
                MatrizEscondida[i][j] = '\u2500';
                MatrizHundir[i][j] = '\u2500';
            }
        }
    }

    public static void MostrarTablero(char[][] Matriz) {
        int i, j, a = 1;
        System.out.println("\n\t\t\t\t    Batalla Naval");
        System.out.println("\n\t\t\tColumnas : 1   2   3   4   5");
        for (i = 0; i < 11; i++) {
            if (i % 2 == 0) {
                System.out.printf("\n\t\t\t         ");
            } else {
                System.out.printf("\n\t\t\tFila: %d  ", a);
                a++;
            }
            for (j = 0; j < 21; j++) {
                System.out.printf("%c", Matriz[i][j]);
            }
        }
    }
}
