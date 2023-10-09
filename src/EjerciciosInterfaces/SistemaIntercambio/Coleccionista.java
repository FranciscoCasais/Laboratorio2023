package EjerciciosInterfaces.SistemaIntercambio;
import SeresHumanos.Persona;
import Tiempo.Fecha;
import java.util.HashSet;
public class Coleccionista extends Persona {
    private HashSet<Prestable> inventario;
    public Coleccionista() {
        super();
        inventario =new HashSet<>();
    }
    public Coleccionista(Fecha fechaNacimiento,HashSet<Prestable> inventario,String apellido,String nombre) {
        super(nombre,apellido,fechaNacimiento);
        this.inventario=inventario;
    }
    public HashSet<Prestable> getInventario() { return inventario; }
    public void setInventario(HashSet<Prestable> inventario) { this.inventario=inventario; }
}