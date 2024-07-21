/*
5.2.7 Ingresar diversos quintetos de números positivos de 1 cifra c/u, finalizando cuando las cinco cifras leídas
sean iguales a cero. Determinar e informar cuantos de los quintetos ingresados han formado números
capicúas 'triples' y cuantos 'quíntuples'. 
*/

import java.util.Scanner;

public class Inicial_5_2_7 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int i, triples = 0, quíntuples = 0;
        int [] números = new int [5];

        System.out.println("Ingresar un quinteto de números positivos de una cifra cada uno ( cinco ceros para salir).");
        for (i = 0 ; i < 5 ; i++) {
            do {
            System.out.println("Ingresar la cifra "+ (i+1) +"/5 :");
            números[i] = scanner.nextInt();
            if (números[i] < 0 || números[i] > 9) {
                System.out.println("Error en la cifra ingresada, intente nuevamente.");
            }
        }while (números[i] < 0 || números[i] > 9);
        }
        while ( ! (números[0] == 0 && números[1] == 0 && números[2] == 0 && números[3] == 0 && números[4] == 0)) {

            if ((números[0] == números[4]) && (números[1] == números[3])) {
                quíntuples++;
            }
            else {
                // No tengo idea de como buscar capicuas triples en cinco cifras
                if (números[1] == números[3]){
                    triples++;
                }
            }
            System.out.println("Ingresar un quinteto de números positivos de una cifra cada uno ( cinco ceros para salir).");
            for (i = 0 ; i < 5 ; i++) {
                do {
                System.out.println("Ingresar la cifra "+ (i+1) +"/5 :");
                números[i] = scanner.nextInt();
                if (números[i] < 0 || números[i] > 9) {
                    System.out.println("Error en la cifra ingresada, intente nuevamente.");
                }
            }while (números[i] < 0 || números[i] > 9);
            }
        }
        scanner.close();
        System.out.println("Números capicúas 'triples' : "+ (triples));
        System.out.println("Números capicúas 'quíntuples' : "+ (quíntuples));
    }
}
