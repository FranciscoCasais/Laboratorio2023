package SistemaCine;
import java.util.HashSet;
import SeresHumanos.Persona;
import Tiempo.Fecha;
public class Usuario extends Persona {
    private int id;
    HashSet<Funcion> entradasCompradas;
    private String mail;
    private static int cantidadUsuarios=0;
    public Usuario() {
        super();
        cantidadUsuarios++;
        id=cantidadUsuarios;
        entradasCompradas=new HashSet<>();
        mail="";
    }
    public Usuario(HashSet<Funcion> entradasCompradas,Fecha fechaNacimiento,String apellido,String mail,String nombre) {
        super(nombre,apellido,fechaNacimiento);
        cantidadUsuarios++;
        id=cantidadUsuarios;
        this.entradasCompradas=entradasCompradas;
        this.mail=mail;
    }
    public int getId() { return id; }
    public void setId(int id) {this.id=id; }
    public HashSet<Funcion> getEntradasCompradas() { return entradasCompradas; }
    public void setEntradasCompradas(HashSet<Funcion> entradasCompradas) { this.entradasCompradas=entradasCompradas; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail=mail; }
    public static int getCantidadUsuarios() { return cantidadUsuarios; }
    public static void setCantidadUsuarios(int cantidadUsuarios) { Usuario.cantidadUsuarios=cantidadUsuarios; }
    public int cantidadEntradasCompradas() {
        int i=0;
        for(Funcion funcion:entradasCompradas) i++;
        return i;
    }
}