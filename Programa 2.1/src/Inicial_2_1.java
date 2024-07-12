import java.util.Scanner;

public class Inicial_2_1 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner (System.in);

        int hora;
        double valor;

        do {
            System.out.println("Ingrese cantidad de horas trabajadas (Numero entero) : ");
            hora = scanner.nextInt();
            if (hora <= 0)
            {
                System.out.println("Error en la cantidad de horas, intente nuevamente.");
            }
        }while (hora <= 0);

        do {
            System.out.println("Ingrese el valor de la hora : ");
            valor = scanner.nextDouble();
            if (valor <= 0)
            {
                System.out.println("Error. Ese valor no deberia tomarse en cuenta. Intente nuevamente.");
            }
        }while (valor <= 0);
        System.out.printf("El sueldo es de $ : %.2f%n", (valor * hora));
        scanner.close();
    }
    
}