/*
 7.2.8 Un consorcio desea controlar la cobranza de las expensas en un edificio de 5 pisos donde existen 15
departamentos en cada piso. El valor de las expensas es de $ 1000. Para registrar la cobranza se ingresa el
número de piso (1 a 5) y el número de departamento (correlativo de 1 a 15 en cada piso). El ingreso finaliza
con un piso igual a 99.
Al finalizar mostrar el dinero total recaudado y una tabla con una X indicando aquellos departamentos
deudores de la siguiente manera:

                       TOTAL RECAUDADO
                    DEPARTAMENTOS DEUDORES
PISO       DPTO 1 DPTO2 … DPTO 15
PISO 1       X      X       X
PISO 2       X      X
PISO 3                      X
PISO 4              X       X
PISO 5       X              X
 */

import java.util.Scanner;

public class Inicial_7_2_8 {
    public static void main(String[] args) throws Exception {
        
        double[][] MatrizFloat = new double[5][15];

        Cobranza(MatrizFloat);
        Mostrar(MatrizFloat);
    }
    public static void Cobranza(double[][] MatrizFloat){

        Scanner scanner = new Scanner(System.in);

        int piso, dto;
        double expensas = 1000.00;

        piso = ValidaPiso(scanner);

        while (piso != 99){
            
            do {
                System.out.println("Ingresar número de departamente (del 1 al 15)");
                dto = scanner.nextInt();
                if (dto < 1 || dto > 15){
                    System.out.println("Error en el número de departamento seleccionado, intente nuevamente.");
                }
            }while (dto < 1 || dto > 15);

            MatrizFloat[piso-1][dto-1] = MatrizFloat[piso-1][dto-1] + expensas;

            piso = ValidaPiso(scanner);
        }
        scanner.close();
    }
    public static int ValidaPiso(Scanner scanner){

        int piso;

        do{
            System.out.println("Ingrese número del piso para registrar el pago. (de 1 a 5 y 99 para terminar) :");
            piso = scanner.nextInt();
            if ((piso < 1 || piso > 5) && piso != 99){
                System.out.println("Error en el número de piso elegido, intente nuevamente.");
            }
        }while ((piso < 1 || piso > 5) && piso != 99);

        return piso;
    }
    public static void Mostrar(double[][] MatrizFloat){

        int i, j;
        double total = 0.0;

        for (i = 0 ; i < 5; i++){
            for (j = 0 ; j < 15 ; j++){
                total = total + MatrizFloat[i][j];
            }
        }
        System.out.println("\n\n\n\n\nTotal de dinero recaudado : $ "+ (total));
        System.out.println("\n\t\t\t\t\t\tTOTAL RECAUDADO");
        System.out.println("\t\t\t\t\tDEPARTAMENTOS DEUDORES");
        System.out.printf("PISO");
        for (i= 1 ; i <= 15 ; i++){
            System.out.printf("\tDPTO %d", i);;
        }
        System.out.println("\n");
        for (i = 0 ; i < 5; i++){
            System.out.printf("\nPISO %d", i+1);
            for (j = 0 ; j < 15 ; j++){
                if (MatrizFloat[i][j] == 0.0){
                    System.out.printf("\t  X");
                }
                else{
                    System.out.printf("\t   ");
                }
            }
        }
    }
}
