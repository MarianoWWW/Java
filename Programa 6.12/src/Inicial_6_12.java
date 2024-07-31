/*
6.12. Realizar una función que permita restar 1 día a una fecha válida mostrando la fecha resultante. Si la fecha
recibida no es válida informarlo con un mensaje (validar utilizando la función del punto 9).
 */

import java.util.Scanner;

public class Inicial_6_12 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int día, mes, año;
        boolean valida;

        do {
            System.out.println("Ingrese un día : ");
            día = scanner.nextInt();
            System.out.println("Ingrese un mes : ");
            mes = scanner.nextInt();
            System.out.println("Ingrese un año (recuerde que el calendario Gregoriano comienza en 1582) : ");
            año = scanner.nextInt();
            valida = Validar(día, mes, año);
            if (valida) {
                System.out.println("Error en la fecha elegida, intente nuevamente.");
            }
        } while (valida);
        scanner.close();
        if (!(día == 1 && mes == 1 && año == 1582)){
            if (día == 1) {
                switch (mes) {
                    case 3:
                        if ((año % 4 == 0 && año % 100 != 0) || año % 400 == 0) {
                            día = 29;
                            mes = 02;
                            } else {
                            día = 28;
                            mes = 02;
                        }
                        break;
                    case 5: case 7: case 10: case 12:
                        día = 30;
                        mes--;
                        break;
                    case 1:
                        día = 31;
                        mes = 12;
                        año--;
                        break;
                    default:
                        día = 31;
                        mes--;   
                        break;
                }
            }   
            else {
                día--;
            }
        }else{
            System.out.println("Te saliste del calendario Gregoriano, ya no puedo ayudarte.");
            System.exit(0);
        }
        
    System.out.println("Restándole un día a la fecha dada, queda : "+(día)+"/"+(mes)+"/"+(año));

    }

    public static boolean Validar(int día, int mes, int año) {

        int comparar = Calcular(mes, año);

        if (día <= comparar) {
            return false;
        }
        return true;
    }

    public static int Calcular(int mes, int año) {

        int día;

        switch (mes) {
            case 2:
                if ((año % 4 == 0 && año % 100 != 0) || año % 400 == 0) {
                    día = 29;
                    break;
                }
                día = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                día = 30;
                break;
            default:
                día = 31;
                break;
        }
        return día;
    }
}
