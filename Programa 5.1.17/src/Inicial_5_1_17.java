/*
 5.1.17 Ingresar N artículos (códigos) y sus correspondientes precios. Indicar el código del artículo más caro y el
precio del más barato. NOTA: todos los artículos tienen precios distintos
 */

import java.util.Scanner;

public class Inicial_5_1_17 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int n, código, máximoCódigo = 0, flag = 0, flag1 = 0;
        double precio, máximoPrecio = 0, mínimoPrecio = 0;

        do {
            System.out.println("Ingresar el número N hasta donde vamos a evaluar los artículos :");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Error, N no puede ser cero o negativo. Intente nuevamente.");
            }
        } while (n <= 0);
        
        for (int i = 1 ; i <= n ; i++) {
            
            System.out.println("Ingrese el código (número entero) del artículo "+ (i) +"/"+ (n) +" :");
            código = scanner.nextInt();

            do {
                System.out.println("Ingrese el precio del artículo cuyo código es "+ (código) +" :");
                precio = scanner.nextDouble();
                if (precio <= 0) {
                    System.out.println("Error en el precio ingresado, no puede ser cero o negativo. Intente nuevamente.");
                }
            } while (precio <= 0);

            if (flag == 0 || precio > máximoPrecio) {
                flag = -1;
                máximoPrecio = precio;
                máximoCódigo = código;
            }
            if (flag1 == 0 || precio < mínimoPrecio) {
                flag1 = -1;
                mínimoPrecio = precio;
            }
        }
        scanner.close();
        System.out.println("El código del artículo más caro es : "+ (máximoCódigo));
        System.out.println("El precio del artículo más barato es :"+ (mínimoPrecio));
    }
}
