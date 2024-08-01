/*
7.1.5 Una empresa debe registrar los pedidos recibidos de cada uno de sus 10 productos a lo largo del día. Por
cada pedido se recibe:
 Código de producto (de 1 a 10)
 Cantidad de unidades solicitadas
Se puede recibir más de un pedido por producto.
La carga finaliza cuando se ingresa un producto con código igual a cero.
Al finalizar se debe emitir un listado con código y cantidad de unidades solicitadas de cada producto.
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int[] VectorCantidades = new int[10];
        int Código, Cantidad;

        Código = Carga();

        while (Código != 0){

            do{
                System.out.println("Ingrese la cantidad de unidades solicitadas : ");
                Cantidad = scanner.nextInt();
                if (Cantidad < 0){
                    System.out.println("No puede ser una cantidad negativa. Intente nuevamente.");
                }
            }while (Cantidad < 0);

            VectorCantidades[Código-1] = VectorCantidades[Código-1] + Cantidad;

            Código = Carga();
        }
        scanner.close();
        System.out.println("Listado de código y cantidad de unidades solicitadas de cada producto\n");
        for (int i = 0 ; i < 10 ; i++){
            System.out.println("Código : " +(i+1)+ "\tUnidades solicitadas : "+ (VectorCantidades[i]));
        }
        
    }
    public static int Carga(){

        Scanner scanner = new Scanner(System.in);

        int Código;

        do{
            System.out.println("Ingrese el código del producto (Cero para terminar.) : ");
            Código = scanner.nextInt();
            if (Código < 0 || Código > 10){
                System.out.println("Error, código inexistente, elija entre 0 y 10");
            }
        }while(Código < 0 || Código > 10);

        return Código;
    }
}
