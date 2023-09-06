package SistemaCine;
import java.util.HashSet;
import SeresHumanos.Persona;
public class Usuario extends Persona {
    private int id;
    HashSet<Funcion> entradasCompradas;
    private String mail;
    private static int cantidadUsuarios=0;
}