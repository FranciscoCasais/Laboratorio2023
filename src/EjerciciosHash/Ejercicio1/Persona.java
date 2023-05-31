package EjerciciosHash.Ejercicio1;
import java.util.Date;
public class Persona {
    protected Date fechaNacimiento;
    protected String apellido,nombre;
    public Persona() {
        fechaNacimiento=new Date();
        apellido="";
        nombre="";
    }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento=fechaNacimiento; }
    public void setApellido(String apellido) { this.apellido=apellido; }
    public void setNombre(String nombre) { this.nombre=nombre; }
}