package SeresHumanos;
public class Operario extends Empleado {
    public Operario(String nombreCompleto) { super(nombreCompleto); }
    public String toString() { return super.toString()+" -> Operario"; }
}