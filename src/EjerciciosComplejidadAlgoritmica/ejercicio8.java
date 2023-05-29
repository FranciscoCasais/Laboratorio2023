package EjerciciosComplejidadAlgoritmica;
import java.util.ArrayList;
import java.util.Scanner;
public class ejercicio8 {
    public static ArrayList<Integer> concatenarOrdenadamente(ArrayList<Integer> cadena1,ArrayList<Integer> cadena2) {
        ArrayList<Integer> cadenaResultante=new ArrayList<>();
        int i=0,j=0;
        do {
            if(i<cadena1.size() && j<cadena2.size()) {
                if(cadena1.get(i)<cadena2.get(j)) {
                    cadenaResultante.add(cadena1.get(i));
                    i++;
                } else {
                    cadenaResultante.add(cadena2.get(j));
                    j++;
                }
            } else if(i==cadena1.size()) {
                cadenaResultante.add(cadena2.get(j));
                j++;
            } else {
                cadenaResultante.add(cadena1.get(i));
                i++;
            }
        } while(cadenaResultante.size()<cadena1.size()+cadena2.size());
        return cadenaResultante;
    }
    public static void main(String[] args) {
        ArrayList<Integer> cadena1=new ArrayList<>(),cadena2=new ArrayList<>();
        Scanner entrada=new Scanner(System.in);
        for(int i=0;i<2;i++) {
            System.out.println("\nTamaño de la cadena "+(i+1)+":");
            int tamanio=entrada.nextInt();
            entrada.nextLine();
            for(int j=0;j<tamanio;j++) {
                System.out.println("\nValor de la cadena "+(i+1)+", posición "+(j+1)+":");
                if(i==0) { cadena1.add(entrada.nextInt()); }
                else { cadena2.add(entrada.nextInt()); }
                entrada.nextLine();
            }
        }
        ArrayList<Integer> cadenaResultante=concatenarOrdenadamente(cadena1,cadena2);
        System.out.println("\nLa cadena resultante es la siguiente:");
        for(Integer valor:cadenaResultante) { System.out.println(valor+" "); }
    }
}