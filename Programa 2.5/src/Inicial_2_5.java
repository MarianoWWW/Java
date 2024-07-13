import java.util.Scanner;

public class Inicial_2_5 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner (System.in);

        int total;

        do{
            System.out.println("\n\nIngrese la cantidad de tarros de pintura : ");
            total = scanner.nextInt();
            if (total < 0){
                System.out.println("\n\nNo podes tener una cantidad negativa de existencias, intente nuevamente.");
            }
        }while (total < 0);

        //la parte lógica, necesito enteros porque no se pueden dividir latas por la mitad
        int litro = (int)(total * 0.5);
        int litros4 = (int)(total * 0.3);
        int litros20 = total - litro - litros4;

        System.out.println("Cantidad de tarros de 1 Litro :"+ (litro) +"\nCantidad de tarros de 4 Litros : "+ (litros4) +"\nCantidad de tarros de 20 Litros : "+ (litros20));
        
        scanner.close();
    }
}
