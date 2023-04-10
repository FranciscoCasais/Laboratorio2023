package SeresHumanos;
import Unidad1.Fecha;
public class Persona {
    private Fecha fechaNacimiento;
    private String direccion, nombreCompleto;

    public Persona() {
        fechaNacimiento=new Fecha();
        direccion = "";
        nombreCompleto = "";
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setFechaNacimiento(int edad) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void getDatos() {
        System.out.println("Datos de la persona:\nNombre completo: " + nombreCompleto + "\nFecha de nacimiento: " + fechaNacimiento.getDia()+"/"+fechaNacimiento.getMes()+"/"+fechaNacimiento.getAnio() + "\nDirección: " + direccion);
    }
}