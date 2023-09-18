package ManejoExcepciones.Ejercicio1;

public class Throws_ {
    public static void imprimirLargoNombre(String nombre) throws NullPointerException {
        System.out.println("El largo del nombre es:"+ nombre.length());
    }
    public static void main(String[] args){
        String nombre = null;
        try {
            imprimirLargoNombre(nombre);
        }catch (NullPointerException exception){
            System.err.println(exception);
            exception.printStackTrace();
        }finally {
            System.out.println("Fran y Chanti");
        }
    }
}
