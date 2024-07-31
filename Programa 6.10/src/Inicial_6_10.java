/*
6.10. Realizar una función que permita sumar 1 día a una fecha válida mostrando la fecha resultante. Si la fecha
recibida no es válida informarlo con un mensaje (validar utilizando la función del punto 9).
 */

import java.util.Scanner;

public class Inicial_6_10 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int día, mes, año;
        boolean valida;

        do{
            System.out.println("Ingrese un día : ");
            día = scanner.nextInt();
            System.out.println("Ingrese un mes : ");
            mes = scanner.nextInt();
            System.out.println("Ingrese un año (recuerde que el calendario Gregoriano comienza en 1582) : ");
            año = scanner.nextInt();
            valida = Validar(día, mes, año);
            if (valida){
                System.out.println("Error en la fecha elegida, intente nuevamente.");
            }
        }while (valida);
        scanner.close();

        switch (mes) {
            case 2:
                if (día == 29){
                        día = 01;
                        mes = 03;
                        break;
                }
                if (día == 28){
                    if ((año % 4 == 0 && año % 100 != 0) || año % 400 == 0){
                        día = 29;
                    }
                    else {
                        día = 01;
                        mes = 03;
                    }
                }
                else {
                    día++;
                }
                break;
            case 4: case 6: case 9: case 11:
                if (día == 30){
                    día = 01;
                    mes++;
                }
                else {
                    día++;
                }
                break;
            default:
                if (día == 31){
                    if (mes == 12){
                        día = 01;
                        mes = 01;
                        año ++;
                    }
                    else {
                        día = 01;
                        mes++;
                    }
                }
                else{
                    día++;
                }
                break;
        }
        System.out.println("Sumándole un día a la fecha dada, queda : " +(día)+ "/" +(mes)+ "/" +(año));
        
    }
    public static boolean Validar(int día, int mes, int año){

        int comparar = Calcular(mes, año);

        if (día <= comparar){
            return false;
        }
        return true;
    }
    public static int Calcular (int mes, int año){

        int día;

        switch (mes) {
            case 2:
                if ((año % 4 == 0 && año % 100 != 0) || año % 400 == 0){
                    día = 29;
                    break;
                }
                día = 28;
                break;
            case 4: case 6: case 9: case 11:
                día = 30;
                break;
            default:
                día = 31;
                break;
        }
        return día;
    }
}

