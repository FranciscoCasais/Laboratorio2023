package SeresHumanos;
import Unidad1.Fecha;
import SeresHumanos.*;
public class Empleado {
    protected String nombreCompleto;
    public Empleado(String nombreCompleto) { this.nombreCompleto=nombreCompleto; }
    public String getNombreCompleto() { return nombreCompleto; }

    public String toString() { return "Empleado "+nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto=nombreCompleto; }
}