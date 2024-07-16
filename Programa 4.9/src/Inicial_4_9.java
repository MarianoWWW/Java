/*
4.9. Confeccionar un programa que permita ingresar un carácter alfanumérico y determine e informe si lo 
ingresado corresponde a una vocal, con el mensaje “VOCAL”. y su correspondiente valor numérico en ASCII.
*/

import java.util.Scanner;

public class Inicial_4_9 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un caracter : ");

        char caracter = scanner.next().charAt(0);
        char auxiliar = caracter;

        auxiliar = Character.toLowerCase(auxiliar);
        if (auxiliar == 'a' || auxiliar == 'e' || auxiliar == 'i' || auxiliar == 'o' || auxiliar == 'u') {
            System.out.println("\nEl caracter "+ caracter +" es una VOCAL y su codigo ASCII es : "+(int) caracter);
        }
        else {
            System.out.println("\nEl caracter "+ caracter +" no es una VOCAL.");
        }

        scanner.close();



    }
}
