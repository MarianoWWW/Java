import java.util.Scanner;

public class Inicial_4_17 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int histClínica;
        double importe;
        

        do {
            System.out.println("Ingresar el número de hisotria clínica : ");
            histClínica = scanner.nextInt();
            if (histClínica <=0) {
                System.out.println("Hay un error en el número de historia clínica, intente nuevamente.");
        } 
        }while (histClínica <=0);
        System.out.println("Ingresar código de la prestación (A, D, F, M, T)");
        char código = Character.toUpperCase(scanner.next().charAt(0));
        scanner.close();

        switch (código) {
            case 'A':
                importe = 20;
                break;
            case 'D':
                importe = 40;
                break;
            case 'F':
                importe = 60;
                break;
            case 'M':
                importe = 150;
                break;
            case 'T':
                importe = 150;
                break;
            default:
                importe = -1;
                break;
        }
        if (importe == -1) {
            System.out.println("\nCódigo inexistente.");
        }
        else {
            System.out.println("Número de Historia Clínica : "+ (histClínica) +"\nCódigo : "+ (código) +"\nImporte a pagar $ : "+ (importe));
        }

    }
}
