// 2.2. Se ingresan las notas de dos evaluaciones de un alumno. Determinar la nota promedio.

import java.util.Scanner;

public class Inicial_2_2 {
    public static void main(String[] args) throws Exception {
        

        Scanner scanner = new Scanner(System.in);

        int nota1, nota2;
        double promedio;

        do{
            System.out.println("Ingresar la primera nota (numero entero)");
            nota1 = scanner.nextInt();
            if (nota1 <0 || nota1 >10){
                System.out.println("Error. Esa nota no existe, intente nuevamente.");
            }
        }while (nota1 <0 || nota1 >10);

        do{
            System.out.println("Ingresar la segunda nota (numero entero)");
            nota2 = scanner.nextInt();
            if (nota2 <0 || nota2 >10){
                System.out.println("Error. Esa nota no existe, intente nuevamente.");
            }
        }while (nota2 <0 || nota2 >10);

        promedio = (nota1 + nota2)/2.0; // casteo con el 2.0

        System.out.printf("El promedio es de : %.1f%n", promedio);

        scanner.close();
    }
}
