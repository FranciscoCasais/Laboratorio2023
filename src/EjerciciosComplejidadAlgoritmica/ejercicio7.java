package EjerciciosComplejidadAlgoritmica;
import java.util.ArrayList;
import java.util.Scanner;
public class ejercicio7 {
    public static ArrayList<Boolean> hallarFilaNoRepetida(ArrayList<ArrayList<Boolean>> matriz) {
        int cantidadCeros=0;
        for(int i=0;i<matriz.get(0).size();i++) {
            cantidadCeros=0;
            for(int j=0;j<matriz.size();j++) {
                if(!(matriz.get(j).get(i))) { cantidadCeros++; }
            }
            if(cantidadCeros%2!=0) { matriz.get(0).set(i,false); }
            else { matriz.get(0).set(i,true); }
        }
        return matriz.get(0);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Boolean>> matriz=new ArrayList<>();
        Scanner entrada=new Scanner(System.in);
        for(int i=0;i<5;i++) {
            ArrayList<Boolean> fila=new ArrayList<>();
            for(int j=0;j<5;j++) {
                System.out.println("\nIngresar valor booleano para fila "+(i+1)+", columna "+(j+1)+":");
                fila.add(entrada.nextBoolean());
            }
            matriz.add(fila);
        }
        ArrayList<Boolean> filaNoRepetida=hallarFilaNoRepetida(matriz);
        System.out.println("\nLa fila que no está repetida es la siguiente: \n");
        for(Boolean valor:filaNoRepetida) { System.out.println(valor+" "); }
    }
}