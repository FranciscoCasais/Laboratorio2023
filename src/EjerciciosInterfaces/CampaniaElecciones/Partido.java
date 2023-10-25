package EjerciciosInterfaces.CampaniaElecciones;
import java.util.HashSet;
public class Partido {
    private HashSet<Mensajero> mensajeros;
    private int cantidadAfiliados;
    private String direccionOficinaCentral,nombre;
    public Partido() {
        mensajeros=new HashSet<>();
        cantidadAfiliados=0;
        direccionOficinaCentral="";
        nombre="";
    }
    public Partido(HashSet<Mensajero> mensajeros, int cantidadAfiliados, String direccionOficinaCentral, String nombre) {
        this.mensajeros = mensajeros;
        this.cantidadAfiliados = cantidadAfiliados;
        this.direccionOficinaCentral = direccionOficinaCentral;
        this.nombre = nombre;
    }
    public HashSet<Mensajero> getMensajeros() { return mensajeros; }
    public void setMensajeros(HashSet<Mensajero> mensajeros) { this.mensajeros = mensajeros; }
    public int getCantidadAfiliados() { return cantidadAfiliados; }
    public void setCantidadAfiliados(int cantidadAfiliados) { this.cantidadAfiliados = cantidadAfiliados; }
    public String getDireccionOficinaCentral() { return direccionOficinaCentral; }
    public void setDireccionOficinaCentral(String direccionOficinaCentral) { this.direccionOficinaCentral = direccionOficinaCentral; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}