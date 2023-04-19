package SeresHumanos;
import SeresHumanos.*;
public class Empleado extends Persona {
    private long DNI;
    private String pais,telefono;
    public Empleado() { super(); }
    public String toString() { return "Empleado "+super.nombre+" "+super.apellido; }
}