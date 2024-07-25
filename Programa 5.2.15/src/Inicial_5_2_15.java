/*
5.2.15 El gobierno de la Ciudad de Buenos Aires realiza una encuesta a los estudiantes de los colegios
secundarios. Los primeros datos a ingresar son la fecha (día, mes y año) y la cantidad de colegios de la ciudad
en que se realizó la encuesta.
De cada colegio se conoce: número de escuela, la cantidad de alumnos inscriptos y la especialidad (‘T’:
técnico, ‘N’: no técnico).
De cada alumno del colegio que respondió la encuesta se conoce: DNI, fecha de nacimiento (día, mes y
año), sexo (‘M’ o ‘F’), opinión con respecto a los conocimientos adquiridos (‘B’: buenos, ‘M’: malos). Se
identifica el fin de ingreso de datos de los alumnos que respondieron la encuesta por cada colegio con
ingreso 0 en el DNI del estudiante.
Validar todos los datos que se ingresan por teclado.
Informar:
a. Por cada colegio, el porcentaje de alumnos que contestaron la encuesta sobre la cantidad de
alumnos inscriptos del colegio.
b. Cantidad de estudiantes de colegio no técnicos que respondieron la encuesta.
c. Porcentaje de mujeres de escuelas técnicas sobre la cantidad de estudiantes que respondieron
la encuesta.
d. Porcentaje de estudiantes que respondieron que los conocimientos adquiridos eran malos,
sobre el total de encuestados.
e. Mayor edad de los estudiantes encuestados.
f. Número del colegio con mayor opinión buena sobre los conocimientos adquiridos.
*/

import java.util.Scanner;

public class Inicial_5_2_15 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int i, j, díaHoy, mesHoy, añoHoy, cantidadColegios, númeroEscuela, cantidadAlumnos, bisiesto = 0, bien = 0, mayorOpinión = 0, mayorColegio = 0, mayorEdad = 0, mayorOpiniónBuena = 0, mayorOpiniónBuenaTotal = 0;
        int día, mes, año, dni, edad, cantidadRespuestas = 0, cantidadEstudiantesNoTécnicos = 0, mujeresTécnicas = 0, cantidadRespuestasTotal = 0, contador = 0;
        char especialidad, sexo, opinión;

        do {
            System.out.println("ENCUESTA A ESTUDIANTES SECUNDARIOS");
            System.out.println("Ingrese día de la encuesta : ");
            díaHoy = scanner.nextInt();
            System.out.println("Ingrese mes de la encuesta : ");
            mesHoy = scanner.nextInt();
            System.out.println("Ingrese año de la encuesta : ");
            añoHoy = scanner.nextInt();
            if ((añoHoy % 4 == 0 && añoHoy % 100 !=0) || (añoHoy % 400 == 0)) {
                 bisiesto = 1;
            }
            switch (mesHoy) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (díaHoy <=31){
                        bien = 1;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (díaHoy <=30){
                        bien = 1;
                    }
                    break;
                case 2:
                    if (bisiesto == 1 && díaHoy <=29) {
                        bien = 1;
                    }
                    else {
                        if (díaHoy <= 28){
                            bien = 1;
                        }
                    }
        
                default:
                    break;
            }
            if (bien == 0){
                System.out.println("Error en la fecha ingresada. Intente nuevamente");
            }
        }while (bien == 0);

        do {
            System.out.println("Cantidad de colegios donde se realizó la encuesta : ");
            cantidadColegios = scanner.nextInt();
            if (cantidadColegios <= 0){
                System.out.println("Error, no pueden ser negativos o cero. Intente nuevamente.");
            }
        }while (cantidadColegios <= 0);

        for (i = 1  ; i <= cantidadColegios ; i++) {
            
            do {
                System.out.println("\nIngresar número de escuela : ");
                númeroEscuela = scanner.nextInt();
            if (númeroEscuela <= 0){
                System.out.println("Error, no puede ser negativo o cero. Intente nuevamente.");
            }
            }while (númeroEscuela <= 0);
            do {
                System.out.println("Ingrese cantidad de alumnos inscriptos : ");
                cantidadAlumnos = scanner.nextInt();
            if (cantidadAlumnos <= 0){
                System.out.println("Error, no puede ser negativo o cero. Intente nuevamente.");
            }
            }while (cantidadAlumnos <= 0);
            do {
                System.out.println("Ingresar especialidad ( T = Técnico , N = no Técnico) : ");
                especialidad = Character.toUpperCase(scanner.next().charAt(0));
                if (especialidad != 'T' && especialidad !='N'){
                    System.out.println("Error eligiendo la especialidad del colegio. Intente nuevamente.");
                }
            }while (especialidad != 'T' && especialidad !='N');
                System.out.println("Ahora viene la encuesta a los alumnos.");
                contador = 0;
                cantidadRespuestas = 0;
                mayorOpiniónBuena = 0;
                
                do {
                    System.out.println("Ingresar DNI del alumno (cero para salir) :");
                    dni = scanner.nextInt();
                    if ((dni < 1000000 || dni > 99999999) && dni != 0){
                        System.out.println("Número de DNI fuera de rango. Intente nuevamente.");
                    }
                }while ((dni < 1000000 || dni > 99999999) && dni != 0);

                while (dni !=0 && contador < cantidadAlumnos) {
                     cantidadRespuestas++;
                     bien = 0;
                     bisiesto = 0;
                     do {
                        System.out.println("Ingrese día del alumno : ");
                        día = scanner.nextInt();
                        System.out.println("Ingrese mes del alumno : ");
                         mes = scanner.nextInt();
                        System.out.println("Ingrese año del alumno : ");
                        año = scanner.nextInt();
                        if ((año % 4 == 0 && año % 100 !=0) || (año % 400 == 0)) {
                            bisiesto = 1;
                        }
                        switch (mes) {
                            case 1:
                            case 3:
                            case 5:
                            case 7:
                            case 8:
                            case 10:
                            case 12:
                                if (día <=31){
                                    bien = 1;
                                }
                                break;
                            case 4:
                            case 6:
                            case 9:
                            case 11:
                                if (día <=30){
                                    bien = 1;
                                }
                                break;
                            case 2:
                                if (bisiesto == 1 && día <=29) {
                                    bien = 1;
                                }
                                else {
                                    if (día <= 28){
                                        bien = 1;
                                    }
                                }
                    
                            default:
                                break;
                        }
                        if (bien == 0){
                            System.out.println("Error en la fecha ingresada. Intente nuevamente");
                        }
                        }while (bien == 0);
                    do {
                        System.out.println("Ingrese el sexo del alumno ( M / F )");
                        sexo = Character.toUpperCase(scanner.next().charAt(0));
                    if (sexo != 'M' && sexo !='F'){
                        System.out.println("Error eligiendo el sexo. Intente nuevamente.");
                    }
                    }while (sexo != 'M' && sexo !='F');
                    do {
                        System.out.println("Ingrese opinión con respecto a los conocimientos adquiridos ( B = buenos , M = malos) : ");
                        opinión = Character.toUpperCase(scanner.next().charAt(0));
                        if (opinión != 'M' && opinión !='B'){
                            System.out.println("Error eligiendo la opinión. Intente nuevamente.");
                        }
                    }while (opinión != 'M' && opinión !='B');

                    if (especialidad == 'N'){
                        cantidadEstudiantesNoTécnicos++;
                     }
                    if (sexo == 'F' && especialidad == 'T') {
                        mujeresTécnicas++;
                    }
                    if (opinión == 'M' ) {
                        mayorOpinión++;
                    }

                    // Hora de calcular la edad :
                    edad = añoHoy - año;
                    if (mesHoy <= mes) {
                        edad = edad -1;
                        if (díaHoy >= día){
                            edad = edad +1;
                        }
                    }
                    if (edad > mayorEdad) {
                        mayorEdad = edad;
                    }
                    if (opinión == 'B' ) {
                        mayorOpiniónBuena++;
                    }

                    contador ++;
                    cantidadRespuestasTotal = cantidadRespuestasTotal + cantidadRespuestas;
                    do {
                        System.out.println("Ingresar DNI del alumno (cero para salir) :");
                        dni = scanner.nextInt();
                        if ((dni < 1000000 || dni > 99999999) && dni != 0){
                            System.out.println("Número de DNI fuera de rango. Intente nuevamente.");
                        }
                    }while ((dni < 1000000 || dni > 99999999) && dni != 0);

                    
                    if (mayorOpiniónBuena > mayorOpiniónBuenaTotal) {
                        mayorOpiniónBuenaTotal = mayorOpiniónBuena;
                        mayorColegio = númeroEscuela;
                        }
                          
                }
                System.out.printf("\n\n Resultados por Colegios :\nPorcentaje de alumnos que contestaron la encuesta : %.2f%%", ((double)cantidadRespuestas/cantidadAlumnos)*100);
        }
        scanner.close();
        System.out.println("\nResultados Generales : \nCantidad de estudiantes de colegio no técnicos que respondieron la encuesta : "+ (cantidadEstudiantesNoTécnicos));
        System.out.printf("\nPorcentaje de mujeres de escuelas técnicas que respondieron la encuesta : %.2f%%", ((double)mujeresTécnicas/cantidadRespuestasTotal)*100);
        System.out.printf("\nPorcentaje de estudiantes que respondieron que los conocimientos adquiridos eran malos : %.2f%%", ((double)mayorOpinión/cantidadRespuestasTotal)*100);
        System.out.println("Mayor edad de los estudiantes encuestados : "+ (mayorEdad));
        System.out.println("Colegio con mayor opinión buena sobre los conocimientos adquiridos : "+ (mayorColegio));
        















    }
}
