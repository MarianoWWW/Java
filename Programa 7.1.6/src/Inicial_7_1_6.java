/*
7.1.6 Se ingresan DNI, código de sector (1 a 5) y sueldo de los empleados de una empresa. Se sabe que como
máximo la empresa tiene 100 empleados. Se desea:
a. Cargar los datos de los empleados mediante la función CargaEmpleados. La carga finaliza con un
empleado con DNI 99.
b. Generar un vector con la cantidad de empleados en cada sector mediante la función
CuentaPorSector y mostrarlo en forma de listado.
c. Determinar el importe total a pagar de sueldos mediante la función TotalAPagar
 */

import java.util.Scanner;

public class Inicial_7_1_6 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int dni, cantidadEmpleados = 0;
        int[] VectorDNI = new int[100], VectorSectores = new int[5];
        double[] total = new double[1];
        dni = CargaEmpleados(scanner, VectorDNI, cantidadEmpleados, VectorSectores, total);

        while (dni != 99 && cantidadEmpleados < 100) {
            cantidadEmpleados++;
            dni = CargaEmpleados(scanner, VectorDNI, cantidadEmpleados, VectorSectores, total);
        }
        if (cantidadEmpleados != 0) {
            Mostrar(VectorSectores, total);
        } else {
            System.err.println("No se cargaron empleados.");
        }

    }

    public static int CargaEmpleados(Scanner scanner, int[] VectorDNI, int cantidadEmpleados, int[] VectorSectores,
            double[] total) {

        int dni;

        do {
            System.out.println("Ingresar el DNI del empleado (99 para terminar) : ");
            dni = scanner.nextInt();
            if ((dni < 1000000 || dni > 99999999) && dni != 99) {
                System.out.println("Error, DNI inexistente, intente nuevamente.");
            }
        } while ((dni < 1000000 || dni > 99999999) && dni != 99);
        if (dni != 99) {
            VectorDNI[cantidadEmpleados] = dni;
            CuentaPorSector(scanner, VectorSectores, VectorDNI, cantidadEmpleados);
            TotalAPagar(scanner, VectorDNI, cantidadEmpleados, total);
        }
        return dni;
    }

    public static void CuentaPorSector(Scanner scanner, int[] VectorSectores, int[] VectorDNI, int cantidadEmpleados) {

        int cuenta;

        do {
            System.out.println("Ingresar código del empleado DNI " + (VectorDNI[cantidadEmpleados]) + " (1 a 5) :");
            cuenta = scanner.nextInt();
            if (cuenta < 1 || cuenta > 5) {
                System.out.println("Error, código inexistenete, intente nuevamente.");
            }
        } while (cuenta < 1 || cuenta > 5);
        VectorSectores[cuenta-1]++;
    }

    public static void TotalAPagar(Scanner scanner, int[] VectorDNI, int cantidadEmpleados, double[] total) {

        double sueldo;
        do {
            System.out.println("Ingrese el sueldo del empleado DNI " + (VectorDNI[cantidadEmpleados]) + " : ");
            sueldo = scanner.nextDouble();
            if (sueldo < 0) {
                System.out.println("Error, no puede ser una cifra negativa, intente nuevamente.");
            }
        } while (sueldo < 0);

        total[0] = total[0] + sueldo;

    }

    public static void Mostrar(int[] VectorSectores, double[] total) {

        System.out.println("Cantidad de empleados en cada sector : ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Sector : " + (i + 1) + "\tCantidad de empleados : " + (VectorSectores[i]));
        }
        System.out.printf("\n\n Total a pagar : %.2f", (total[0]));
    }
}
