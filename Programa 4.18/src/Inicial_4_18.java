/*
 4.18. Confeccionar un programa que permita ingresar la fecha actual (día, mes y año) y la fecha de nacimiento
de una persona (día, mes y año). Con ambos datos debe calcular la edad de dicha persona.
 */

import java.util.Scanner;

public class Inicial_4_18 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la fecha de hoy (formato ddmmaaaa) : ");
        int hoy = scanner.nextInt();

        System.out.println("\nIngrese la fecha de nacimiento (formato ddmmaaaa) : ");
        int nacimiento = scanner.nextInt();

        scanner.close();

        int edad = (hoy % 10000) - (nacimiento % 10000);
        

        hoy = hoy - (hoy % 10000);
        nacimiento = nacimiento - (nacimiento % 10000);

        int mes = (hoy % 1000000) / 10000;
        int mesNacimiento = (nacimiento % 1000000) / 10000;
        
        if (mes <= mesNacimiento) {
            edad = edad -1;
            int día = (hoy % 100000000) / 1000000;
            int díaNacimiento = (nacimiento % 100000000) / 1000000;
            
            if (mes == mesNacimiento && día >= díaNacimiento){
                edad = edad +1;
            }
        }
        System.out.println(edad);
    }
}
