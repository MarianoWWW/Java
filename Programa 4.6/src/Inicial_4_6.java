import java.util.Scanner;

public class Inicial_4_6 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int[] Números = new int[4];
        int i, menor;

        for (i=0 ; i < 4 ; i++) {
            System.out.println("Ingresar el número "+ (i+1) +" de 4 : ");
            Números[i] = scanner.nextInt();
        }
        menor = Números[0];

        for (i = 1 ; i < 4 ; i++) {
            if (Números[i] < menor) {
                menor = Números[i];
            }
        }
        System.out.println("\nLos valores ingresados son : ");

        for (i = 0 ; i < 4 ; i++) {
            System.out.println((i+1) +". "+ (Números[i]));
        }
        System.out.printf("\nEl número mas chico es : "+ (menor) +" y se encuentra en la posición/es :");

        for (i = 0 ; i < 4 ; i++) {
            if (Números[i] == menor) {
                System.out.printf(" "+ (i+1) +" ");

            }
        }
        scanner.close();
    }
}
