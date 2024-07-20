/*
5.2.2 Escribir las sentencias que permitan el ingreso correcto del valor numérico de un día y un mes
determinado. Por algún error volver a solicitar. 
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        
        int día = 0, mes = 0, flag = 0;

        while (flag == 0) {

            do {
                System.out.println("Ingrese un día en valor numérico :");
                día = scanner.nextInt();
                if (día <1 || día >31) {
                    System.out.println("Error, los días van del 1 al 31. Intente nuevamente.");
                }
            } while (día <1 || día >31);

            do {
                System.out.println("Ingrese un mes en valor numérico :");
                mes = scanner.nextInt();
                if (mes <1 || mes >12) {
                    System.out.println("Error, los meses van del 1 al 12. Intente nuevamente.");
                }
            } while (mes <1 || mes >12);

            switch (mes) {
                case 2:
                    if (día <= 29) {
                        flag = -1;
                    }
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (día <= 31) {
                        flag = -1;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (día <= 30) {
                        flag = -1;
                    }
                    break;
            
                default:
                    
                    break;
            }
            if (flag == 0) {
                System.out.println("Ocurrió algún error en el ingreso de las fechas. Vuelva a intentarlo.");
            }

        }
        scanner.close();
        System.out.println("Fecha correcta. Mes : "+ (mes) +" día : "+ (día));

    }
}
