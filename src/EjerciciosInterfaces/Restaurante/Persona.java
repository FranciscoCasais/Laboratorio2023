package EjerciciosInterfaces.Restaurante;
import java.time.LocalDate;
public abstract class Persona {
    private LocalDate fechaNacimiento;
    private String apellido,nombre;
    public Persona() {
        fechaNacimiento=null;
        apellido="";
        nombre="";
    }
    public Persona(LocalDate fechaNacimiento, String apellido, String nombre) {
        this.fechaNacimiento = fechaNacimiento;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}