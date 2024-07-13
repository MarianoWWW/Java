import java.util.Scanner;

public class Inicial_2_4 {
    public static void main(String[] args) throws Exception {
    
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar una medida (en pies) : ");

        double medida = scanner.nextDouble();

        System.out.printf("\n\nConversiones :\nYardas : %.2f%n", medida/3);
        System.out.printf("Pulgadas : %.2f%n", medida*12);
        System.out.printf("Centímetros : %.2f%n", medida*12*2.54);
        System.out.printf("Metros : %.2f%n", (medida*12*2.54)/100);

        scanner.close();


    }
}
