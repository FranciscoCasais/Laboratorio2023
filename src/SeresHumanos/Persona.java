package SeresHumanos;
import Tiempo.Fecha;
public class Persona {
    protected Fecha fechaNacimiento;
    protected String apellido,nombre;
    public Persona() {
        fechaNacimiento=new Fecha();
        apellido="";
        nombre="";
    }
    public Persona(String nombre,String apellido,Fecha fechaNacimiento) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaNacimiento=fechaNacimiento;
    }
    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento=fechaNacimiento;
    }
    public void setApellido(String apellido) { this.apellido=apellido; }
    public void setNombre(String nombre) { this.nombre=nombre; }
    public void getDatos() { System.out.println("Datos de la persona:\nNombre y apellido: "+nombre+" "+apellido+"\nFecha de nacimiento: "+fechaNacimiento.getDia()+"/"+fechaNacimiento.getMes()+"/"+fechaNacimiento.getAnio()); }
}