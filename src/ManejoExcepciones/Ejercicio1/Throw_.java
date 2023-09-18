package ManejoExcepciones.Ejercicio1;

public class Throw_ {
    public static void main(String[] args){
        String nombre = null;
        try {
            if (nombre == null) throw new NullPointerException("La variable \"nombre\" es nula.");
            System.out.println("El largo del nombre es:"+ nombre.length());
        }catch (NullPointerException exception){
            //System.out.println(exception.getMessage());
            System.err.println(exception);
            exception.printStackTrace();
        }finally {
            System.out.println("Fran y Chanti");
        }
    }
}

