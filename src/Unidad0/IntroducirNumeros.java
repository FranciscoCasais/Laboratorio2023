package Unidad0;
import java.util.Scanner;
public class IntroducirNumeros {
    public static void main(String[] args) {
        int cantidadNumeros = 0, mayorNumero = 0, menorNumero = 0, numero, sumaNumerosNegativos = 0, sumaNumerosPositivos = 0, sumaTodosNumeros = 0;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("Ingrese un número:");
            cantidadNumeros++;
            numero = entrada.nextInt();
            sumaTodosNumeros += numero;
            if (numero > mayorNumero) {
                mayorNumero = numero;
            } else if (numero < menorNumero) {
                menorNumero = numero;
            }
            if (numero > 0) {
                sumaNumerosPositivos += numero;
            } else if (numero < 0) {
                sumaNumerosNegativos += numero;
            }
        } while (numero != -1);
        System.out.println("Cantidad de números ingresados: " + cantidadNumeros + "\nMayor número introducido: " + mayorNumero + "\nMenor número ingresado: " + menorNumero + "\nSuma de todos los números: " + sumaTodosNumeros + "\nSuma de los números positivos: " + sumaNumerosPositivos + "\nSuma de los números negativos: " + sumaNumerosNegativos);
    }
}