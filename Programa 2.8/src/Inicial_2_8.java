/*
2.8. Se ingresa un número entero que representa una fecha con formato (ddmmaa). Se pide transformarlo a un
número con formato (aammdd).
*/

import java.util.Scanner;

public class Inicial_2_8 {

    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner (System.in);
        int día, mes, año, nuevoNúmero;

        System.out.println("\n\nIngrese un número que represente una fecha (ddmmaa) : ");

        int número = scanner.nextInt();

        //Algo de lógica:
        año = número/10000;
        número = número - (año*10000);
        mes = número/100;
        número = número - (mes*100);
        día = número * 10000;
        nuevoNúmero = año + (mes * 100) + día;
        System.out.println("\n\nEgreso (aammdd) : "+ nuevoNúmero);

        scanner.close();
    }
}
