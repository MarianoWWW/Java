/*
6.9. Realizar una función que reciba 3 números enteros correspondientes al día, mes y año de una fecha y valide
si la misma es correcta. En caso de que la fecha es correcta debe retornar un 1 y si es incorrecta debe
retornar un 0. Para la validación usar la función del punto 8 que retorna la cantidad de días de un mes.
*/

import java.util.Scanner;

public class Inicial_6_9 {
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
        System.out.println("Fecha correcta.");
    }
    public static boolean Validar(int día, int mes, int año){

        int comparar = Calcular(mes, año);

        if (día == comparar){
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
