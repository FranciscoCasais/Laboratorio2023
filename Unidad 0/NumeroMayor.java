package unidad0;
import java.util.Scanner;
public class NumeroMayor {
    public static void main(String[] args) {
        int numero1,numero2;
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduzca valor para el primer número: ");
        numero1=entrada.nextInt();
        System.out.println("Introduzca valor para el segundo número: ");
        numero2=entrada.nextInt();
        if(numero1>numero2) {
            System.out.println("El primer número es mayor");
        } else if(numero2>numero1) {
            System.out.println("El segundo número es mayor");
        } else {
            System.out.println("Ambos números son equivalentes");
        }
    }
}