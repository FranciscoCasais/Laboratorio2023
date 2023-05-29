package EjerciciosComplejidadAlgoritmica;
import java.util.ArrayList;
import java.util.Scanner;
public class ejercicio9 {
    public static ArrayList<Integer> hallarElementoEnComun(ArrayList<Integer> cadena1,ArrayList<Integer> cadena2,ArrayList<Integer> cadena3) {
        ArrayList<Integer> posicionesElementoEnComun=new ArrayList<>();
        int i=0,j=0,k=0;
        while(i<cadena1.size() && j<cadena2.size() && k<cadena3.size()) {
            if(cadena1.get(i)==cadena2.get(j) && cadena2.get(j)==cadena3.get(k)) {
                posicionesElementoEnComun.add(i);
                posicionesElementoEnComun.add(j);
                posicionesElementoEnComun.add(k);
                return posicionesElementoEnComun;
            } else if(cadena1.get(i)<cadena2.get(j) && cadena1.get(i)<cadena3.get(k)) { i++; }
            else if(cadena2.get(j)<cadena1.get(i) && cadena2.get(j)<cadena3.get(k)) { j++; }
            else { k++; }
        }
        posicionesElementoEnComun.add(null);
        return posicionesElementoEnComun;
    }
    public static void main(String[] args) {
        ArrayList<Integer> cadena1=new ArrayList<>(),cadena2=new ArrayList<>(),cadena3=new ArrayList<>();
        Scanner entrada=new Scanner(System.in);
        for(int i=0;i<3;i++) {
            System.out.println("\nTamaño de la cadena "+(i+1)+":");
            int tamanio=entrada.nextInt();
            entrada.nextLine();
            for(int j=0;j<tamanio;j++) {
                System.out.println("\nValor de la cadena "+(i+1)+", posición "+(j+1)+":");
                switch(i) {
                    case 0:
                        cadena1.add(entrada.nextInt());
                        break;
                    case 1:
                        cadena2.add(entrada.nextInt());
                        break;
                    default:
                        cadena3.add(entrada.nextInt());
                        break;
                }
                entrada.nextLine();
            }
        }
        ArrayList<Integer> posicionesElementoEnComun=hallarElementoEnComun(cadena1,cadena2,cadena3);
        if(posicionesElementoEnComun.get(0)==null) { System.out.println("\nLas cadenas no tienen ningún elemento en común."); }
        else {
            System.out.println("\nLas posiciones del elemento en común son las siguientes:");
            for(int i=0;i<3;i++) {
                switch(i) {
                    case 0:
                        System.out.println("\nCadena 1: ");
                        break;
                    case 1:
                        System.out.println("\nCadena 2: ");
                        break;
                    default:
                        System.out.println("\nCadena 3: ");
                        break;
                }
                System.out.println(posicionesElementoEnComun.get(i));
            }
        }
    }
}