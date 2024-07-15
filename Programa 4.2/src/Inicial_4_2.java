import java.util.Scanner;

public class Inicial_4_2 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int número1, número2, número3;

            System.out.println("\n\nIngrese tres números : ");
            número1 = scanner.nextInt();
            número2 = scanner.nextInt();
            número3 = scanner.nextInt();

            if (número1 < número2) {
                if (número1 < número3){
                    System.out.println("\n\nEl numero "+ (número1) +" es menor a "+ (número2) +" y "+ (número3));
                }
            }
            scanner.close();
    }
}
