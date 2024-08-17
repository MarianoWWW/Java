import java.util.Scanner;

public class Ingreso {

    public int fila, columna;

    public Ingreso() {
        this.fila = 0;
        this.columna = 0;
    }

    public void ingreso(Scanner scanner){

        System.out.println("\nIngrese la Fila : ");
        this.fila = Valida(scanner);
        System.out.println("Ingrese la Columna : ");
        this.columna = Valida(scanner);
    }
    public int Valida(Scanner scanner) {
        int número;
        do {
            número = scanner.nextInt();
            if (número < 1 || número > 5) {
                System.out.println("Error en el dato ingresado, solamente puede ser de 1 a 5. Intente nuevamente.");
            }
        } while (número < 1 || número > 5);

        return número;
    }
}
