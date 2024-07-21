/*
5.2.5 De cada uno de los alumnos de un curso se ingresa su número de DNI y las notas de los dos exámenes
parciales confeccionar, un programa que muestre por cada alumno su condición final con el siguiente
mensaje:
“El alumno con DNI: xxxxxxx, obtuvo las notas: xx y xx [condición final]”
La condición final se establece según las siguientes reglas:
 PROMOCIONA: ambas notas > = 7
 RINDE EXAMEN FINAL: ambas notas > = 4
 REPROBO LA MATERIA: alguna nota no cumple lo anterior
El programa finaliza cuando se ingresa un valor negativo como número de DNI. Al finalizar mostrar la nota
promedio de alumnos promocionados.
*/

import java.util.Scanner;

public class Inicial_5_2_5 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int dni, contador = 0;
        double nota1 = 0, nota2 = 0, notaPromedio = 0;

        do {
        System.out.println("Ingresar número de DNI (negativo para terminar): ");
        dni = scanner.nextInt();
        if ((dni >= 0 && dni <= 999999) || dni >99999999) {
            System.out.println("Dudo que ese DNI exista, mejor comience el proceso.");
        }
        }while ((dni >= 0 && dni <= 999999) || dni >99999999);

        while (dni > 0) {
            do {
            System.out.println("Ingresar nota del primer parcial : ");
            nota1 = scanner.nextDouble();
            if (nota1 < 0 || nota1 > 10) {
                System.out.println("Error en la nota , van del cero al diez, vuela a intentarlo.");
            }
            } while (nota1 < 0 || nota1 > 10);
            do {
                System.out.println("Ingresar nota del segundo parcial : ");
                nota2 = scanner.nextDouble();
                if (nota2 < 0 || nota2 > 10) {
                    System.out.println("Error en la nota , van del cero al diez, vuela a intentarlo.");
                }
            } while (nota2 < 0 || nota2 > 10);


        if (nota1 >= 7 && nota2 >= 7){
            System.out.println("El alumno con DNI: "+ (dni) +", obtuvo las notas: "+ (nota1) +" y "+ (nota2) + " [PROMOCIONA]");
            notaPromedio = notaPromedio + nota1 + nota2;
            contador = contador + 2;
        }
        else {
            if (nota1 >= 4 && nota2 >= 4) {
                System.out.println("El alumno con DNI: "+ (dni) +", obtuvo las notas: "+ (nota1) +" y "+ (nota2) + " [RINDE EXAMEN FINAL]");
            }
            else {
                System.out.println("El alumno con DNI: "+ (dni) +", obtuvo las notas: "+ (nota1) +" y "+ (nota2) + " [REPROBÓ LA MATERIA]");
            }
        }

            do {
                System.out.println("Ingresar número de DNI (negativo para terminar): ");
                dni = scanner.nextInt();
                if ((dni >= 0 && dni <= 999999) || dni >99999999) {
                    System.out.println("Dudo que ese DNI exista, mejor comience el proceso.");
                }
            }while ((dni >= 0 && dni <= 999999) || dni >99999999);
        }

        scanner.close();
        
        if (contador == 0) {
            System.out.println("Ningún alumno promocionó.");
        }
        else {
            System.out.println("Nota promedio de alumnos promocionados : "+ (notaPromedio/contador));
        }
    }
}
