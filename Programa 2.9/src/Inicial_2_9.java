/*
2.9. Confeccionar un programa que ingrese un valor expresado en Kibibyte (KiB)1 y lo informe expresado en:
TiB, GiB, MiB, con leyendas aclaratorias. (1MiB = 1024 KiB; 1GiB = 1024 MiB; 1TiB = 1024 GiB)
*/

import java.util.Scanner;

public class Inicial_2_9 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner (System.in);

        int número;

        do {
            System.out.println("\nIngrese un valor en Kibibytes : ");
            número = scanner.nextInt();
            if (número < 0 )
            {
                System.out.println("\n\nMMMM ¿Te parece negativos? Mejor intenta de nuevo.");
            }
        } while (número < 0 );

        int mib = número/1024;
        int gib = mib/1024;
        int tib = gib/1024;

        System.out.println("\n\nMiB = "+ (mib) +"\nGiB = "+ (gib) +"\nTiB = "+ (tib));

        scanner.close();
        
    }
}
