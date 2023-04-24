package SeresHumanos;
import Tiempo.Fecha;
public class Persona {
    protected Fecha fechaNacimiento;
    protected String apellido,direccion,nombre;
    public Persona() {
        fechaNacimiento=new Fecha();
        apellido="";
        direccion="";
        nombre="";
    }
    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getApellido() { return apellido; }
    public String getDireccion() {
        return direccion;
    }
    public String getNombre() { return nombre; }
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento=fechaNacimiento;
    }
    public void setApellido(String apellido) { this.apellido=apellido; }
    public void setDireccion(String direccion) {
        this.direccion=direccion;
    }
    public void setNombre(String nombre) { this.nombre=nombre; }
    public void getDatos() { System.out.println("Datos de la persona:\nNombre y apellido: "+nombre+" "+apellido+"\nFecha de nacimiento: "+fechaNacimiento.getDia()+"/"+fechaNacimiento.getMes()+"/"+fechaNacimiento.getAnio()+"\nDirección: "+direccion); }
}