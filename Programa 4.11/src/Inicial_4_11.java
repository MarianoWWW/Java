import java.util.Scanner;

public class Inicial_4_11 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int año, mes;

        do {
            System.out.println("Ingrese el año (recuerde que el calendario Gregoriano comienza en 1582 DC) : ");
            año = scanner.nextInt();
            if (año < 1582) {
                System.out.println("Error. El programa puede fallar en fechas no Gregorianas, por el tema del año bisiesto. Intente nuevamente.");
            }
        } while (año < 1582);
        do {
            System.out.println("Ingrese el mes (número de 1 a 12): ");
            mes = scanner.nextInt();
            if (mes < 1 || mes > 12) {
                System.out.println("Error, ese mes no existe");
            }
        }while (mes < 1 || mes > 12);

        //busco bisiesto
        if (((año % 4 == 0 && año % 100 !=0) || (año % 400 == 0)) && mes == 2) {
                System.out.println((año) +" es un año bisiesto, entonces febrero tiene 29 días.");    
            }  
        else {
                if (mes == 2) {
                    System.out.println("El mes : "+ (mes) +" tiene 28 días");
                }
                else {
                    if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                        System.out.println("El mes : "+ (mes) +" tiene 30 días");
                    }
                    else {
                        System.out.println("El mes : "+ (mes) +" tiene 31 días");
                    }
                }
            }
          scanner.close();
        


















    }
}
