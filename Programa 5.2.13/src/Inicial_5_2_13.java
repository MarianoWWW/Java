/*
5.2.13 Realizar un programa que le solicite al usuario el ingreso de una vocal (este dato de ingreso se debe
validar). Luego el programa debe dibujar en pantalla la vocal ingresada en cinco líneas y cuatro columnas. La
vocal debe estar formada en cada carácter por la misma letra en mayúscula.
El programa finaliza al ingresar la letra f.
Restricciones: Por cada printf se debe exhibir un solo carácter o salto de línea o espacio.
Ejemplos:
Ingreso del carácter a:
AAAA
A  A
AAAA
A  A
A  A
Ingreso del carácter e:
EEEE
E
EEEE
E
EEEE
Extender el programa para que la vocal se exhiba más grande ingresando un factor de multiplicación.
Por ejemplo si se ingresa un 2 debe dibujarse el doble de grande la letra en pantalla.
*/

import java.util.Scanner;

public class Inicial_5_2_13 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        char vocal;
        int i, múltiplo = 0 , k;

        do {
            do {
                System.out.println("\nIngrese una vocal (F para terminar) : ");
                vocal = Character.toUpperCase(scanner.next().charAt(0));
                if (!(vocal == 'A' || vocal == 'E' || vocal == 'I' || vocal == 'O' || vocal == 'U' || vocal == 'F')){
                    System.out.println("Error con la letra elegida, intente nuevamente.");
                }
            }while (!(vocal == 'A' || vocal == 'E' || vocal == 'I' || vocal == 'O' || vocal == 'U' || vocal == 'F'));
            
            if (vocal != 'F') {
                System.out.println("Ingrese un múltiplo :");
                múltiplo = scanner.nextInt();
            }
            System.out.println("\n\n\n\n");
            switch (vocal) {
                case 'F': 
                    break;
                case 'A':
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 4 * múltiplo ; i++) {
                        System.out.printf("A");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("A");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("A");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 4 * múltiplo ; i++) {
                        System.out.printf("A");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("A");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("A");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("A");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("A");
                    }
                    System.out.printf("\n");
                }
                break;
                case 'E':
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 4 * múltiplo ; i++) {
                        System.out.printf("E");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("E");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 4 * múltiplo ; i++) {
                        System.out.printf("E");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("E");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 4 * múltiplo ; i++) {
                        System.out.printf("E");
                    }
                    System.out.printf("\n");
                }
                break;
                case 'I':
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 4 * múltiplo ; i++) {
                        System.out.printf("I");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf("I");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf("I");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf("I");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 4 * múltiplo ; i++) {
                        System.out.printf("I");
                    }
                    System.out.printf("\n");
                }
                break;
                case 'O':
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 4 * múltiplo ; i++) {
                        System.out.printf("O");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("O");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("O");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("O");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("O");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("O");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("O");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 4 * múltiplo ; i++) {
                        System.out.printf("O");
                    }
                    System.out.printf("\n");
                }
                break;
                case 'U':
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("U");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("U");
                    }
                    System.out.printf("\n");
                }  
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("U");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("U");
                    }
                    System.out.printf("\n");
                }   
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("U");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("U");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("U");
                    }
                    for (i = 0 ; i < 2 * múltiplo ; i++) {
                        System.out.printf(" ");
                    }
                    for (i = 0 ; i < 1 * múltiplo ; i++) {
                        System.out.printf("U");
                    }
                    System.out.printf("\n");
                }
                for (k = 0 ; k < 1 * múltiplo ; k++){
                    for (i = 0 ; i < 4 * múltiplo ; i++) {
                        System.out.printf("U");
                    }
                    System.out.printf("\n");
                }
            }
        }while (vocal != 'F');
        scanner.close();
    }
}
