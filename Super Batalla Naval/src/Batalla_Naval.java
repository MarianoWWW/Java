/*
7.2.15 BATALLA NAVAL: Realizar el juego con un tablero de 5x5.
Inicialmente el retador deberá ingresar la ubicación de sus barcos indicando las coordenadas donde se
encuentra. Los barcos ocupan un solo casillero y se deben ubicar 5 barcos en distintas posiciones. La matriz
a utilizar es de char inicializándola con espacio en blanco y marcando la ubicación de los barcos con la letra
B.
Una vez ubicado los barcos se muestra al jugador una pantalla con las coordenadas para que pueda realizar
su disparo. En caso de no encontrar un barco en la posición indicada se debe poner en la celda de la matriz
una letra A (agua). Si se encuentra un barco se marcará como hundido con la letra X. Cada vez que se realiza
un disparo se debe actualizar la matriz y mostrarla en pantalla pero sin mostrar la ubicación de los barcos
(letra B). Se debe mostrar si el barco fue hundido con la letra X. Contar la cantidad de disparos necesarios
para hundir los 5 barcos de forma que pueda desafiar a la otra persona a resolverlo en menos disparos.
 */

import java.util.Scanner;

public class Batalla_Naval {

    private static final int[] VectorFila = { 0, 1, 3, 5, 7, 9 };
    private static final int[] VectorColumna = { 0, 2, 6, 10, 14, 18 };

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        char[][] MatrizEscondida = new char[11][21], MatrizHundir = new char[11][21];
        int ganador = 0, contador = 0, i;

        InicializarMatriz(MatrizEscondida, MatrizHundir);

        System.err.println("Es el turno del desafiante. Debe elegir las coordenadas de los 5 barcos.");
        System.out.println("Sin que el otro competidor vea.");

        for (i = 0; i < 5; i++) {
            MostrarTablero(MatrizEscondida);
            Elegir(MatrizEscondida, scanner);
        }
        MostrarTablero(MatrizEscondida);
        System.out.println("\nEstas fueron tus selecciones. Presiona Enter y llama al otro Competidor.");
        scanner.nextLine();
        scanner.nextLine();

        System.err.println("Es el turno del competidor.");
        System.out.println("Debe elegir las coordenadas para intentar hundir los 5 barcos.");

        while (ganador < 5) {
            MostrarTablero(MatrizHundir);
            ganador = ganador + Jugar(MatrizHundir, MatrizEscondida, scanner);
            contador++;
        }
        scanner.close();
        MostrarTablero(MatrizHundir);
        System.out.println("\nFELICITACIONES!!!!! ganaste en " + (contador) + " disparos.");

    }

    public static void Elegir(char[][] MatrizEscondida, Scanner scanner) {

        int fila, columna, chequeo = -1;
        do {
            System.out.println("\nIngrese la Fila : ");
            fila = Valida(scanner);
            System.out.println("Ingrese la Columna : ");
            columna = Valida(scanner);
            chequeo = Buscar(MatrizEscondida, VectorFila[fila], VectorColumna[columna]);
            if (chequeo == -1) {
                MatrizEscondida[VectorFila[fila]][VectorColumna[columna]] = 'B';
            }
        } while (chequeo != -1);
    }

    public static int BuscarHundir(char[][] MatrizEscondida, int i, int j) {

        int chequeo = -1;
        if (MatrizEscondida[i][j] == 'b') {
            chequeo = 1;
        }
        if (MatrizEscondida[i][j] == 'B') {
            MatrizEscondida[i][j] = 'b';
            System.out.println("HUNDIDO!!!!!!");
            chequeo = 2;
        }
        return chequeo;
    }

    public static int Jugar(char[][] MatrizHundir, char[][] MatrizEscondida, Scanner scanner) {

        int fila, columna, chequeo = -1, ganador = 0;

        System.out.println("\nIngrese la Fila : ");
        fila = Valida(scanner);
        System.out.println("Ingrese la Columna : ");
        columna = Valida(scanner);
        chequeo = BuscarHundir(MatrizEscondida, VectorFila[fila], VectorColumna[columna]);
        if (chequeo == -1) {
            MatrizHundir[VectorFila[fila]][VectorColumna[columna]] = 'A';
        }
        if (chequeo == 2) {
            MatrizHundir[VectorFila[fila]][VectorColumna[columna]] = 'X';
            ganador = 1;
        }
        return ganador;
    }

    public static int Buscar(char[][] Matriz, int i, int j) {

        int chequeo = -1;
        if (Matriz[i][j] == 'B') {
            System.out.println("Error. Esa casilla ya fue elegida. Intente nuevamente.");
            chequeo = 2;
        }
        return chequeo;
    }

    public static int Valida(Scanner scanner) {
        int número;
        do {
            número = scanner.nextInt();
            if (número < 1 || número > 5) {
                System.out.println("Error en el dato ingresado, solamente puede ser de 1 a 5. Intente nuevamente.");
            }
        } while (número < 1 || número > 5);

        return número;
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
            /*
             * Como me gustan los if XD jajajaa
             * switch (i) {
             * case 1:
             * System.out.printf("\n\t\t\tFila: 1  ");
             * break;
             * case 3:
             * System.out.printf("\n\t\t\tFila: 2  ");
             * break;
             * case 5:
             * System.out.printf("\n\t\t\tFila: 3  ");
             * break;
             * case 7:
             * System.out.printf("\n\t\t\tFila: 4  ");
             * break;
             * case 9:
             * System.out.printf("\n\t\t\tFila: 5  ");
             * break;
             * default:
             * System.out.printf("\n\t\t\t         ");
             * break;
             * }
             */
            for (j = 0; j < 21; j++) {
                System.out.printf("%c", Matriz[i][j]);
            }
        }
    }
}
