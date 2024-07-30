/*
 6.5. Confeccionar un programa que permita ingresar varias ternas de valores a punto flotante, que finalice al
ingresar una terna con los valores ORDENADOS en forma creciente. Para cada terna exhibir la siguiente
pantalla:
** OPCIONES POSIBLES **
1 – Mayor valor
2 – Promedio
3 – Suma
4 - Finalizar
** Digite su opción:
Según la opción deseada debe aparecer en pantalla el resultado, sin borrar el menú. No admitir otros
valores de opción. Confeccionar y utilizar una función PARA CADA UNA de las opciones y otra para detectar
la condición final.
*/

import java.util.Scanner;

public class Inicial_6_5 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        double[] terna = new double[3];
        int i, opción;
        boolean condición, finalizar;
        do{
            System.out.println("Ingrese una terna de números reales. (Para salir tienen que estar ordenados de forma creciente).");
            for (i = 0 ; i < 3 ; i++){
                System.out.println("Proceda con el número " +(i+1)+"/3 : ");
                terna[i] = scanner.nextDouble();
            }
            condición = CondiciónFinal(terna);
            finalizar = true;
            if (!condición){
                while (finalizar){
                    opción = Validar();
                    switch (opción) {
                        case 1:
                            Mayor(terna);
                            break;
                        case 2:
                            Promedio(terna);
                            break;
                        case 3:
                            Suma(terna);
                            break;
                
                        default:
                            finalizar = false;
                            break;
                    }
                
                }   
            }
        }while (!condición);
        scanner.close();
    }
    public static boolean CondiciónFinal(double[] terna){

        if ((terna[0] < terna[1] && terna[0] < terna[2]) && (terna[1] < terna[2])){
            return true;
        }
        return false;
    }
    public static int Validar(){
        
        Scanner scanner = new Scanner(System.in);
        int opción;
        do{
            System.out.println("\n** OPCIONES POSIBLES **\n1 - Mayor valor\n2 - Promedio");
            System.out.println("3 - Suma\n4 - Finalizar\n** Digite su opción:");
            opción = scanner.nextInt();
            if (opción < 1 || opción > 4){
                System.out.println("Opción elegida inexistente, por favor intente nuevamente.");
            }
        }while (opción < 1 || opción > 4);
        return opción;
    }
    public static void Mayor (double[] terna){
        double mayor = terna[0];
        for (int i = 1 ; i < 3 ; i++){
            if (terna[i] > mayor){
                mayor = terna[i];
            }
        }
        System.out.printf("\nEl mayor valor de la terna es : %.2f", (mayor));
    }
    public static void Promedio (double[] terna){
        double suma = 0;
        for (int i = 0 ; i < 3 ; i++){
            suma = suma + terna[i];
        }
        System.out.printf("\nEl promedio de la terna es : %.2f", (suma/3));
    }
    public static void Suma (double[] terna){
        double suma = 0;
        for (int i = 0 ; i < 3 ; i++){
            suma = suma + terna[i];
        }
        System.out.printf("\nLa suma de los valores de la terna es : %.2f", (suma));
    }
}
