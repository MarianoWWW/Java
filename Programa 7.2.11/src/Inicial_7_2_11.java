/*
7.2.11 La cadena de supermercados NORTE, tiene 40 sucursales y comercializa 120 rubros de distintas
mercaderías. La Casa Central recibe a diario las notas de pedido de mercaderías emitidas por cada una de las
sucursales.
Se ingresa por teclado las unidades pedidas (estos datos se ingresan hasta que aparece una sucursal igual
a 99, los datos vienen desordenados, y puede venir más de una información de una misma sucursal y el
mismo rubro):
 Número de sucursal (1 a 40).
 Código de rubro (1 a 120).
 Cantidad de unidades pedidas.
Informar:
a. La cantidad de pedidos por sucursal.
b. Cuál fue la sucursal que pidió la menor cantidad en total (puede haber varias sucursales que
tienen el mismo valor mínimo).
FUNCIONES
I. Para inicializar la matriz.
II. Para mostrar el resultado del punto b.
*/

import java.util.Scanner;

public class Inicial_7_2_11 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        int[][] Matriz = new int[120][40];
        int sucursal, rubro, cantidad;

        FunciónIniciaMatriz(Matriz);

        System.out.println("Ingrese el número de sucursal para iniciar el pedido (1 a 40) (99 para terminar): ");
        sucursal = Valida(1, 40, 99, scanner);
        while (sucursal != 99){
            System.out.println("Ingrese el código del rubro (1 a 120) : ");
            rubro = Valida(1, 120, 120, scanner);
            do{
            System.out.println("Ingrese la cantidad de unidades pedidas : ");
            cantidad = scanner.nextInt();
            if (cantidad < 0){
                System.out.println("Error, no puede ser una cantidad negativa. Intente nuevamente.");
            }
            }while (cantidad < 0);

            Matriz [rubro-1][sucursal-1] = Matriz [rubro-1][sucursal-1] + cantidad;

            System.out.println("Ingrese el número de sucursal para iniciar el pedido (1 a 40) (99 para terminar) : ");
            sucursal = Valida(1, 40, 99, scanner);
        }
        scanner.close();

        System.out.println("\nCantidad de pedidos por sucursal : ");
        for (int j = 0 ; j < 40 ; j++){
            for (int i = 0 ; i < 120 ; i++){
                if (Matriz[i][j] != 0){
                    System.out.println("Sucursal "+(j+1)+ " pidió "+(Matriz[i][j])+" del producto : "+(i+1));
                }
            }
        }

        Mostrar(Matriz);
    }
    public static void FunciónIniciaMatriz(int[][] Matriz){
        for (int i = 0 ; i < 120 ; i++){
            for (int j = 0 ; j < 40 ; j++){
                Matriz[i][j] = 0;
            }
        }
    }
    public static int Valida(int li, int ls, int ex, Scanner scanner){
        int número;

        do{
            número = scanner.nextInt();
            if ((número < li || número > ls) && número != ex){
                System.out.println("Error en el dato ingresado, intente nuevamente.");
            }
        }while ((número < li || número > ls) && número != ex);
        return número;
    }
    public static void Mostrar(int[][] Matriz){

        int mínimo = 0, flag = 0;

        for (int i = 0 ; i < 120 ; i++){
            for (int j = 0 ; j < 40 ; j++){
                if (Matriz[i][j] != 0){
                    if (flag == 0 || Matriz[i][j] < mínimo){
                        mínimo = Matriz[i][j];
                        flag = 1;
                    }
                }
            }
        }
        System.out.println("\nMínimo pedido por alguna sucursal/es : ");
        for (int i = 0 ; i < 120 ; i++){
            for (int j = 0 ; j < 40 ; j++){
                if (Matriz[i][j] != 0){
                    if (Matriz[i][j] == mínimo){
                       System.out.println("Sucursal " +(j+1)+ "pidió : "+(Matriz[i][j]));
                    }
                }
            }
        }
    }
}
