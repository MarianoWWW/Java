/*
 2.6. El precio para un vuelo es de $8800 en clase turista y se aplica un incremento del 30% en primera clase.
Se ingresan la cantidad de pasajes vendidos de clase turista y de primera clase.
Obtener la recaudación total del vuelo.
 */

import java.util.Scanner;

public class Inicial_2_6 {
    public static void main(String[] args) throws Exception {
        
        int cantTurista, cantPrimera, turista = 8800, primera = turista + (turista*30/100);

        Scanner scanner = new Scanner (System.in);

        do {
            System.out.println("\n\nIngresar la cantidad de pasajeros de clase turista : ");
            cantTurista = scanner.nextInt();
            if (cantTurista < 0){
                System.out.println("\n\nNo pueden haber cantidades negativas, intente nuevamente.");
            }
        }while (cantTurista < 0);


        do {
            System.out.println("\n\nIngresar la cantidad de pasajeros de primera clase : ");
            cantPrimera = scanner.nextInt();
            if (cantPrimera < 0){
                System.out.println("\n\nNo pueden haber cantidades negativas, intente nuevamente.");
            }
        }while (cantPrimera < 0);

        System.out.println("\n\nRecaudacion total del vuelo $ : "+ ((turista*cantTurista) + (primera*cantPrimera)));

        scanner.close();

    }
}
