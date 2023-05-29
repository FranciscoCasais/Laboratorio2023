package EjerciciosComplejidadAlgoritmica;
import java.util.ArrayList;
import java.util.Scanner;
public class ejercicio10 {
    public static ArrayList<Integer> ordenarElementos1A3(ArrayList<Integer> cadena) {
        ArrayList<Integer> cadenaResultante=new ArrayList<>();
        for(int i=1;i<4;i++) {
            for(int j=0;j<cadena.size();j++) {
                if(cadena.get(j)==i) { cadenaResultante.add(cadena.get(j)); }
            }
        }
        return cadenaResultante;
    }
    public static void main(String[] args) {
        ArrayList<Integer> cadena=new ArrayList<>();
        Scanner entrada=new Scanner(System.in);
        System.out.println("Tamaño de la cadena de enteros:");
        int tamanio=entrada.nextInt();
        for(int i=0;i<tamanio;i++) {
            System.out.println("\nValor de la posición "+(i+1)+":");
            entrada.nextLine();
            int valor=entrada.nextInt();
            while(valor<1 || valor>3) {
                System.out.println("\nIngrese un valor entre 1 y 3:");
                entrada.nextLine();
                valor=entrada.nextInt();
            }
            cadena.add(valor);
        }
        ArrayList<Integer> cadenaResultante=ordenarElementos1A3(cadena);
        System.out.println("\nLa cadena resultante es la siguiente:\n");
        for(Integer valor:cadenaResultante) { System.out.println(valor); }
    }
}