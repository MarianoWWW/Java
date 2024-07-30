/*
6.3. Se realizó un concurso de tiro al blanco. Por cada participante se ingresa un número que lo identifica y el
resultado de los disparos efectuados. El ingreso finaliza con un número de participante negativo.
Cada participante efectúa 5 disparos, registrándose las coordenadas X-Y de cada disparo.
Cátedra: Programación Inicial
Guía Práctica – V2.1 11 / 18
 No considere disparos sobre los ejes, pero sí en el centro (si es sobre los ejes las coordenadas
deberán volver a ingresarse).
 Para determinar el cuadrante utilizar la función CUADRANTE que reciba las dos coordenadas y
retorne el cuadrante al cual pertenece (1 a 4) y 0 para indicar un tiro en el centro.
Para calcular el puntaje utilizar la función PUNTAJE que reciba 5 parámetros que representan la cantidad
disparos en cada cuadrante y en el centro. La función debe retornar el puntaje obtenido según la siguiente
escala:
 Cuadrantes 1 y 2: 50 puntos
 Cuadrantes 3 y 4: 40 puntos
 Centro: 100 puntos
Determinar:
a. El puntaje obtenido por cada participante, detallando cuantos disparos realizó en cada cuadrante.
b. Mostrar el número del participante ganador y el puntaje obtenido.
c. Calcular y mostrar la cantidad total de disparos en el centro (de todos los participantes)

*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        int i, número, ejeX, ejeY, puntos, máximoNúmero = 0, máximoPuntaje = 0, contadorDisparosCentro = 0;
        int disparo, centro = 0, cuadrante1 = 0, cuadrante2 = 0, cuadrante3 = 0, cuadrante4 = 0;

        System.out.println("Ingrese el número del participante (Negativo para terminar): ");
        número = scanner.nextInt();

        while ( número >= 0 ) {
            for (i = 1 ; i <= 5 ; i++) {
                do{
                    System.out.println("Ingrese las coordenadas del disparo " +(i)+ " .");
                    System.out.println("Sobre el eje X : ");
                    ejeX = scanner.nextInt();
                    System.out.println("Sobre el eje Y : ");
                    ejeY = scanner.nextInt();
                    if ((ejeX == 0 && ejeY != 0) || (ejeX != 0 && ejeY == 0)){
                        System.out.println("Tiro desestimado, repetirlo, por favor.");
                    }
                }while ((ejeX == 0 && ejeY != 0) || (ejeX != 0 && ejeY == 0));

                disparo = CUADRANTE(ejeX, ejeY);
                switch (disparo) {
                    case 0:
                        centro++;
                        break;
                    case 1:
                        cuadrante1++;
                        break;
                    case 2:
                        cuadrante2++;
                        break;
                    case 3:
                        cuadrante3++;
                        break;
                    case 4:
                        cuadrante4++;
                        break;
                
                    default:
                        break;
                }
            }
            contadorDisparosCentro = contadorDisparosCentro + centro;
            puntos = PUNTAJE (centro,cuadrante1,cuadrante2,cuadrante3,cuadrante4);
            if (puntos > máximoPuntaje){
                máximoPuntaje = puntos;
                máximoNúmero = número;
            }

            System.out.println("El participante " +(número)+ " obtuvo "+ (puntos)+ " puntos.");
            System.out.println("Disparos en el centro      : "+ (centro));
            System.out.println("Disparos en el cuadrante 1 : "+ (cuadrante1));
            System.out.println("Disparos en el cuadrante 2 : "+ (cuadrante2));
            System.out.println("Disparos en el cuadrante 3 : "+ (cuadrante3));
            System.out.println("Disparos en el cuadrante 4 : "+ (cuadrante4));
            centro= 0;
            cuadrante1= 0;
            cuadrante2= 0;
            cuadrante3= 0;
            cuadrante4= 0;

            System.out.println("Ingrese el número del participante (Negativo para terminar): ");
            número = scanner.nextInt();
        }
        if (máximoPuntaje != 0){
            System.out.println("Número del participante ganador : " +(máximoNúmero)+ (" con el puntaje : "+ (máximoPuntaje)));
            System.out.println("Cantidad total de disparos en el centro (de todos los participantes) : " + (contadorDisparosCentro));
        }
        else {
            System.out.println("No hubo participantes.");
        }
    }
    public static int CUADRANTE (int ejeX, int ejeY) {

        if (ejeX > 0 && ejeY > 0){
            return 1;
        }
        else {
            if (ejeX > 0 && ejeY < 0){
                return 4;
            }
        }
        if (ejeX < 0 && ejeY > 0){
            return 2;
        }
        else {
            if (ejeX < 0 && ejeY < 0){
                return 3;
            }
        }
        return 0;
    }
    public static int PUNTAJE (int centro, int cuadrante1, int cuadrante2, int cuadrante3, int cuadrante4){

        int total = centro * 100 +((cuadrante1+ cuadrante2) * 50)+((cuadrante3+ cuadrante4) * 40);

        return total;



    }
}
