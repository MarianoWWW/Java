/*
 5.1.15 Se realizó un concurso de tiro al blanco. Existen 5 participantes y cada uno de ellos efectúa 3 disparos,
registrándose las coordenadas X-Y de cada disparo. Determinar:
a. Cuantos disparos se efectuaron en cada cuadrante por cada participante
b. Cuantos disparos se efectuaron en total en el centro.
NOTA: no considere disparos sobre los ejes.
 */

import java.util.Scanner;

public class Inicial_5_1_15 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int cuadrante1 = 0, cuadrante2 = 0, cuadrante3 = 0, cuadrante4 = 0, x, y, totalCentro = 0;

        for (int i = 1 ; i <= 5 ; i++) {
            System.out.println("\nParticipante número "+ (i));
            for (int j = 1 ; j <= 3 ; j++) {
                do {
                    System.out.println("Ingrese las coordenadas del tiro "+ (j));
                    System.out.println("Sobre el eje X : ");
                    x = scanner.nextInt();
                    System.out.println("Sobre el eje Y : ");
                    y = scanner.nextInt();
                    if ((x == 0 && y != 0) || (x != 0 && y == 0)) {
                        System.out.println("No se toma en cuenta el disparo, favor de repetirlo.");
                    }
                }while ((x == 0 && y != 0) || (x != 0 && y == 0));

                if (x == 0 && y == 0) {
                    totalCentro++;
                }
                else {
                    if (x > 0 && y > 0) {
                        cuadrante1++;
                    }
                    else {
                        if (x > 0 && y < 0) {
                            cuadrante4++;
                        }
                        else {
                            if (x < 0 && y < 0) {
                                cuadrante3++;
                            }
                            else {
                                cuadrante2++;
                            }
                        }
                    }
                }
                
            }
            System.out.println("Resultado del participante número "+ (i));
            System.out.println("Cuadrante 1 : "+ (cuadrante1) +"\nCuadrante 2 : "+ (cuadrante2));
            System.out.println("Cuadrante 3 : "+ (cuadrante3) +"\nCuadrante 4 : "+ (cuadrante4));
            cuadrante1 = 0;
            cuadrante2 = 0;
            cuadrante3 = 0;
            cuadrante4 = 0;
        }
        scanner.close();
        System.out.println("Total de tiros en el centro : "+ (totalCentro));
    }
}
