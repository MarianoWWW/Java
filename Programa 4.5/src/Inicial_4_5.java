import java.util.Scanner;

public class Inicial_4_5 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese tres numeros enteros: ");

        int número1 = scanner.nextInt();
        int número2 = scanner.nextInt();
        int número3 = scanner.nextInt();
        int auxiliar;

        if (número1 > número2){
            auxiliar = número2;
            número2 = número1;
            número1 = auxiliar;
        }
        if (número1 > número3) {
            auxiliar = número3;
            número3 = número1;
            número1 = auxiliar;
        }
        if (número2 > número3) {
            auxiliar = número3;
            número3 = número2;
            número2 = auxiliar;
        }
        System.out.println("\n\n1. "+ (número1) + "\n2. "+ (número2) + "\n3. "+ (número3));

        scanner.close();
    }
}
