/*
4.13. Un fabricante de repuestos para tractores ha descubierto que ciertos artículos identificados por los
números de catálogo 12121 al 18081; 30012 al 45565 y 67000 al 68000 son defectuosos. Se desea
confeccionar un programa al que informándole el número de catálogo indique si el artículo es o no
defectuoso. Los artículos del catálogo van desde el 1200 al 90000. Si se ingresa otro número informar
“FUERA DE CATALOGO”.
 */

import java.util.Scanner;

public class Inicial_4_13 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int número;

        do {
            System.out.println("Ingrese el número del artículo : ");
            número = scanner.nextInt();
            if (número < 1200 || número > 90000) {
                System.out.println("FUERA DE CATALOGO");
            }
        }while (número < 1200 || número > 90000);

        scanner.close();

        if ((número<12121 || número > 18081) && (número < 30012 || número > 45565) && (número < 67000 || número > 68000)) {
            System.out.println("El artículo no es defectuoso.");
        }
        else {
            System.out.println("El artículo es defectuoso.");
        }












    }
}
