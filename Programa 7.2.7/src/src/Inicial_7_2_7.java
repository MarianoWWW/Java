package src;
/*
7.2.7 Una empresa desea registrar las ventas realizadas de cada uno de sus 20 productos a lo lardo del año. Los
productos están identificados por un código numérico correlativo del 1 al 20. Como primera información se
ingresa el precio unitario de cada uno de los productos. Luego por cada venta se ingresa:
 Código de producto
 Día de venta
 Mes de venta
 Cantidad de unidades vendidas
El ingreso de datos finaliza con un código de producto igual a 0. Informar:
a. El detalle de unidades vendidas de cada producto en cada uno de los 12 meses.
b. El producto con el cual se obtuvo la mayor recaudación.
c. El trimestre de menor recaudación del año.
 */

import java.util.Scanner;

public class Inicial_7_2_7 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int[][] Matriz = new int [12][20];
        double[] VectorPrecios = new double[20];
        int flag;

        CargaPrecios(VectorPrecios, scanner);
        flag = CargaVentas(Matriz, scanner);
        scanner.close();
        if (flag == 0){
            System.out.println("\n\n\n\n\nNo hubieron ventas en el año.");
        }
        else{
            MostrarUnidadesVendidas(Matriz);
            MostrarRecaudación(Matriz, VectorPrecios);
        }
    }
    public static void CargaPrecios(double[] VectorPrecios, Scanner scanner){

        for (int i = 0 ; i < 20 ; i++){

            do{
                System.out.println("Ingresar el precio del producto "+(i+1)+" /20 : ");
                VectorPrecios[i] = scanner.nextDouble();
                if (VectorPrecios[i] <= 0){
                    System.out.println("Error en el precio elegido, intente nuevamente.");
                }
            }while (VectorPrecios[i] <= 0);
        }
    }
    public static int CargaVentas(int[][] Matriz, Scanner scanner){

        int código, flag = 0, mes, cantidadVendida;

        System.out.println("\n\n\n\n\n");
        código = ValidaCódigo(scanner);
        while (código != 0){
            if (flag == 0){
                flag = 1;
            }
            System.out.println("Ingrese el día de la venta : ");
            scanner.nextInt();
            do{
            System.out.println("Ingrese el mes de la venta : ");
            mes = scanner.nextInt();
                if (mes < 1 || mes > 12){
                    System.out.println("Error, ese mes no existe, intente nuevamente.");
                }


            }while (mes < 1 || mes > 12);
            do{
                System.out.println("Ingrese la cantidad de unidades vendidas : ");
                cantidadVendida=scanner.nextInt();
                if (cantidadVendida <= 0){
                    System.out.println("Error en la cantidad elegida, intente nuevamente.");
                }
            }while (cantidadVendida <= 0);

            Matriz [mes-1][código-1] = Matriz [mes-1][código-1] + cantidadVendida;

            código = ValidaCódigo(scanner);
        }
        return flag;
    }
    public static int ValidaCódigo(Scanner scanner){

        int código;

        do{

            System.out.println("Ingresar el Código del producto vendido. (cero para finalizar)");
            código = scanner.nextInt();
            if (código < 0 || código > 20){
                System.out.println("Código inexistente, intente nuevamente.");
            }

        }while (código < 0 || código > 20);
        return código;
    }
    public static void MostrarUnidadesVendidas(int[][] Matriz){

        int i, j;
        System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t\t\t\tPRODUCTOS");
        for (i = 1 ; i <= 20 ; i++){
        System.out.printf("\t%d", i);
        }
        System.out.println("\n");
        for (i = 0 ; i < 12 ; i++){
            System.out.printf("\nMes "+(i+1)+ ":");
            for (j= 0 ; j< 20 ; j++){
                System.out.printf("\t%d", Matriz[i][j]);
            }
        }
    }
    public static void MostrarRecaudación(int[][] Matriz, double[] VectorPrecios){

        int i, j, flag = 0;
        double máximo = 0, mínimo;
        double[][] MatrizFloat = new double[12][20];
        double[] VectorTrimestre = new double[4];
        for (i = 0 ; i < 20 ; i++){
            for (j= 0 ; j< 12 ; j++){
                MatrizFloat[j][i] = Matriz[j][i] * VectorPrecios[i];
            }
        }
        for (i = 0 ; i < 12 ; i++){
            for (j= 0 ; j< 20 ; j++){
                if (flag == 0 || MatrizFloat[i][j]  > máximo){
                    flag = 1;
                    máximo = MatrizFloat[i][j];
                }
            }
        }
        System.out.printf("\nProducto/s con la recaudación máxima de $ %.2f : ",máximo);
        for (i = 0 ; i < 12 ; i++){
            for (j= 0 ; j< 20 ; j++){
                if (MatrizFloat[i][j] == máximo){
                    System.out.printf("%d ", (j+1));
                }
            }
        }

        for (i = 0 ; i < 12 ; i++){
            for (j= 0 ; j< 20 ; j++){
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                        VectorTrimestre[0] = VectorTrimestre[0] + MatrizFloat[i][j];
                        break;
                    case 3:
                    case 4:
                    case 5:
                        VectorTrimestre[1] = VectorTrimestre[1] + MatrizFloat[i][j];
                        break;
                
                    case 6:
                    case 7:
                    case 8:
                        VectorTrimestre[2] = VectorTrimestre[2] + MatrizFloat[i][j];
                        break;
                    default:
                        VectorTrimestre[3] = VectorTrimestre[3] + MatrizFloat[i][j];
                        break;
                }
            }
        }
        mínimo = VectorTrimestre[0];
        for (i =1 ; i < 4 ; i++){
            if (VectorTrimestre[i] < mínimo){
                mínimo = VectorTrimestre[i];
            }
        }
        System.out.printf("\nTrimestre/s con menor recaudación : ");
        for (i = 0 ; i < 4 ; i++){
            if (VectorTrimestre[i] == mínimo){
                System.out.printf("%d ", (i+1));
            }
        }
    }
}
