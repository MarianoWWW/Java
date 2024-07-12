import java.util.Scanner;

public class Inicial_2_3 {
    public static void main(String[] args) throws Exception {
         /*
        2.3. Confeccionar un programa que pueda ingresar 2 números enteros y calcule e informe con mensajes
        aclaratorios la suma, el producto, el cociente y el resto.
        */

        Scanner scanner = new Scanner (System.in);

        System.out.println("Ingresar dos numeros (enteros) : ");
        int número1 = scanner.nextInt();
        int número2 = scanner.nextInt();

        System.out.println("Resultados : \n\nSuma : "+ (número1+número2) +"\nProducto : "+ (número1 * número2));

        if (número2 == 0)
        {
            System.out.println("Cociente : No se puede dividir por cero.\nResto : No se puede dividir por cero.");
        }
        else
        {
            System.out.println("Cociente : "+ (número1/número2) +"\nResto : "+ (número1%número2));
        }


        scanner.close();

    }
}
