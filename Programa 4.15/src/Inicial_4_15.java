import java.util.Scanner;

public class Inicial_4_15 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int dvds;
        
        do {
            System.out.println("ingrese la cantidad de DVDs que desea adquirir (Entre 1 y 500 unidades) : ");
            dvds = scanner.nextInt();
            if (dvds < 1 || dvds >500) {
                System.out.println("Esa cantidad no se puede vender, intente nuevamente.");
            }
        }while (dvds < 1 || dvds >500);

        scanner.close();

        int unidades = dvds % 10;
        int de50 = dvds / 50;
        int decenas = (dvds - (de50 * 50))/10;

        double total = (unidades *15) + (de50 * 500) + (decenas * 120);

        if (dvds > 100) {
            total = total - ((total * 10)/100);
        }

        System.out.println("Importe total a pagar $: "+ (total));





    }
}
