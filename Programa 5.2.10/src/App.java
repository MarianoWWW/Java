

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int contador = 1, posiciónMáximo = 1, posiciónMínimo = 1;
        double temperatura, máximo, mínimo;

        System.out.println("Ingresar valor de temperatura (-50 para terminar) : ");
        temperatura = scanner.nextDouble();
        máximo = temperatura;
        mínimo = temperatura;
        while (temperatura != -50) {
            if (temperatura > máximo) {
                máximo = temperatura;
                posiciónMáximo = contador;
            }
            if (temperatura < mínimo) {
                mínimo = temperatura;
                posiciónMínimo = contador;
            }
            
            contador++;
            System.out.println("Ingresar valor de temperatura (-50 para terminar) : ");
            temperatura = scanner.nextDouble();
        }
        scanner.close();
        if (contador != 1) {
            System.out.printf("\nValor máximo medido : %.2f", (máximo));
            System.out.println(" . En la posición : "+ (posiciónMáximo) + " respecto al ingreso.");
            System.out.printf("\nValor mínimo medido : %.2f", (mínimo));
            System.out.println(" . En la posición : "+ (posiciónMínimo) + " respecto al ingreso.");
        }
        else {
            System.out.println("No se ingresaron datos.");
        }
    }
}
