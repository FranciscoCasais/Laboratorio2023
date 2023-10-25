package EjerciciosInterfaces.CampaniaElecciones;
import java.time.LocalDate;
public class Trabajador extends EjerciciosInterfaces.Restaurante.Persona implements Mensajero {
    private double sueldo;
    private long cuil,dni;
    private String direccion;
    public Trabajador() {
        super();
        sueldo=0;
        cuil=0;
        dni=0;
        direccion="";
    }
    public Trabajador(LocalDate fechaNacimiento, String apellido, String nombre, double sueldo, long cuil, long dni, String direccion) {
        super(fechaNacimiento, apellido, nombre);
        this.sueldo = sueldo;
        this.cuil = cuil;
        this.dni = dni;
        this.direccion = direccion;
    }
    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }
    public long getCuil() { return cuil; }
    public void setCuil(long cuil) { this.cuil = cuil; }
    public long getDni() { return dni; }
    public void setDni(long dni) { this.dni = dni; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}