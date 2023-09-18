package ManejoExcepciones.Ejercicio1;

public class Try_Catch {
    public static void main(String[] args){
        String nombre = null;
        try {
            System.out.println("El largo del nombre es:"+ nombre.length());
        }catch (NullPointerException exception){
            System.err.println(exception);
            exception.printStackTrace();
        }finally {
            System.out.println("Fran y Chanti");
        }
    }
}