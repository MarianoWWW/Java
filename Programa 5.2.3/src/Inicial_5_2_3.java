/*
5.2.3 Confeccionar un programa que pueda ingresar una secuencia de caracteres hasta que se digite un *. Se
desea obtener e informar cuantos caracteres ingresados son numéricos y cuantos alfabéticos. Estos últimos
tienen que mostrarse separados por mayúsculas y minúsculas. También informar la cantidad de otros
símbolos que no sean ni letras ni números.
*/

import java.util.Scanner;

public class Inicial_5_2_3 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int ascii, sumaNúmeros = 0, sumaMayúsculas = 0, sumaMinúsculas = 0, sumaSímbolos = 0;

        char caracter;

        do {
            System.out.println("Ingresar un caracter : ");
            caracter = scanner.next().charAt(0);

            ascii = (int)(caracter);

            if (ascii >= 48 && ascii <= 57) {
                sumaNúmeros++;
            }
            else {
                if (ascii >= 65 && ascii <= 90) {
                    sumaMayúsculas++;
                }
                else {
                    if (ascii >= 97 && ascii <= 122) {
                        sumaMinúsculas++;
                    }
                    else {
                        sumaSímbolos ++;
                    }
                }
            }


        } while (caracter != '*');

        scanner.close();

        System.out.println("Cantidad de caracteres numéricos ingesados : "+ (sumaNúmeros));
        System.out.println("Cantidad de mayúsculuas ingesadas : "+ (sumaMayúsculas));
        System.out.println("Cantidad de minúsculas ingesadas : "+ (sumaMinúsculas));
        System.out.println("Cantidad de símbolos ingesados : "+ (sumaSímbolos));

    }
    
}
