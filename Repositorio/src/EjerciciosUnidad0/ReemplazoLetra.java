package EjerciciosUnidad0;
import java.util.Scanner;
public class ReemplazoLetra {
    public static void main(String[] args) {
        char letraReemplazo;
        Scanner entrada = new Scanner(System.in);
        String nuevaOracion = "", oracion = "Ayer me compré muñecos de la marca ‘Colchitas’ por internet";
        System.out.println("Introduzca la letra de reemplazo:");
        letraReemplazo = entrada.next().charAt(0);
        for (int i = 0; i < oracion.length(); i++) {
            if (oracion.charAt(i) == 'e') {
                nuevaOracion += letraReemplazo;
            } else if (oracion.charAt(i) == 'E') {
                nuevaOracion += Character.toUpperCase(letraReemplazo);
            } else {
                nuevaOracion += oracion.charAt(i);
            }
        }
        System.out.println("Oración original: " + "\"" + oracion + "\"");
        System.out.println("Oración resultante: " + "\"" + nuevaOracion + "\"");
    }
}