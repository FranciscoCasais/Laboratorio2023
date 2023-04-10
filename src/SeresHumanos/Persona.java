package SeresHumanos;
import Unidad1.Fecha;
public class Persona extends SerHumano {
    private String direccion;

    public Persona() {
        super();
        direccion = "";
    }

    public Fecha getFechaNacimiento() {
        return super.fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreCompleto() {
        return super.nombreCompleto;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        super.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombreCompleto(String nombreCompleto) {
        super.nombreCompleto = nombreCompleto;
    }

    public void getDatos() {
        System.out.println("Datos de la persona:\nNombre completo: " + nombreCompleto + "\nFecha de nacimiento: " + fechaNacimiento.getDia()+"/"+fechaNacimiento.getMes()+"/"+fechaNacimiento.getAnio() + "\nDirección: " + direccion);
    }
}