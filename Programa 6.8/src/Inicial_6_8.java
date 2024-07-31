/*
6.8. Realizar una función que, dado un mes y un año, calcule la cantidad de días de dicho mes. El año se utilizará
en el caso de que el mes sea febrero ya que los años bisiestos tienen 29 días en lugar de 28.
Un año es bisiesto cuando: (el año es divisible por 4 y NO por 100) o (el año es divisible por 400).
*/

import java.util.Scanner;

public class Inicial_6_8 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int día, mes, año;

        do {
            System.out.println("Ingrese un mes (su número) : ");
            mes = scanner.nextInt();
            if (mes <1 || mes > 12){
                System.out.println("Error, ese mes no existe, intenta nuevamente.");
            }
        }while (mes <1 || mes > 12);
        do {
            System.out.println("Ingrese un año, el calendario Gregoriano inicia en 1582 (su número) : ");
            año = scanner.nextInt();
            if (año <1582){
                System.out.println("Error, ese año no puede computarse, intenta nuevamente.");
            }
        }while (año <1582);
        día = Calcular(mes, año);

        System.out.println("El mes " +(mes)+ " del año " +(año)+ " tiene : " + (día) + " días.");
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
