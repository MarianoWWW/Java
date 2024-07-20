/*
5.2.1 Confeccionar un programa que calcule e informe los valores de las potencias de 2 cuyo resultado sean
menores que 600. (1 2 4 8 16 …)
*/

public class Inicial_5_2_1 {
    public static void main(String[] args) throws Exception {
        
        int potencia = 1;

        while (potencia < 600) {

            System.out.printf(" "+ (potencia));
            potencia = potencia * 2;
        }
    }
}
