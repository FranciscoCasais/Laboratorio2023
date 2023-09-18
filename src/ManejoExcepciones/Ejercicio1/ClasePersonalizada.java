package ManejoExcepciones.Ejercicio1;

public class ClasePersonalizada extends Exception{
    public ClasePersonalizada(String s) {
        super(s);
    }

    public static void main(String[] args) {
        String nombre = null;
        try {
            if (nombre == null) throw new ClasePersonalizada("La variable \"nombre\" es nula.");
            System.out.println("El largo del nombre es:"+ nombre.length());
        }catch (ClasePersonalizada exception){
            System.err.println(exception);
            exception.printStackTrace();
        }finally {
            System.out.println("Fran y Chanti");
        }
    }
}