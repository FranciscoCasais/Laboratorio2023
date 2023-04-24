package EjerciciosUnidad0;
import java.util.Scanner;
public class PalabrasIguales {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String palabra1, palabra2;
        System.out.println("Ingrese dos palabras:");
        palabra1 = entrada.nextLine();
        palabra2 = entrada.nextLine();
        if (palabra1.equals(palabra2)) {
            System.out.println("Las palabras son iguales");
        } else {
            System.out.println("Las palabras no son iguales");
        }
    }
}