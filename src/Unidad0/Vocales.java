package Unidad0;
public class Vocales {
    public static void main(String[] args) {
        int contadorVocales = 0;
        String oracion = "Ayer me compré muñecos de la marca ‘Colchitas’ por internet";
        for (int i = 0; i < oracion.length(); i++) {
            if (oracion.charAt(i) == 'a' || oracion.charAt(i) == 'A' || oracion.charAt(i) == 'e' || oracion.charAt(i) == 'E' || oracion.charAt(i) == 'i' || oracion.charAt(i) == 'I' || oracion.charAt(i) == 'o' || oracion.charAt(i) == 'O' || oracion.charAt(i) == 'u' || oracion.charAt(i) == 'U') {
                contadorVocales++;
            }
        }
        System.out.println("Oración: \"" + oracion + "\"");
        System.out.println("Cantidad de vocales en la oración: " + contadorVocales);
    }
}