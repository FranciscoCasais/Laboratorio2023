package ABM_Mascotas;
import SeresHumanos.Persona;
import Tiempo.Fecha;
public abstract class Mascota {
    private Fecha fechaNacimiento;
    private Persona duenio;
    private String nombre;
    public Mascota() {
        fechaNacimiento=new Fecha();
        this.duenio=new Persona();
        nombre="";
    }
    public Mascota(Fecha fechaNacimiento,Persona duenio,String nombre) {
        this.fechaNacimiento=fechaNacimiento;
        this.duenio =duenio;
        this.nombre=nombre;
    }

    public Fecha getFechaNacimiento() { return fechaNacimiento; }
    public Persona getDuenio() { return duenio; }
    public String getNombre() { return nombre; }
    public void setFechaNacimiento(Fecha fechaNacimiento) { this.fechaNacimiento=fechaNacimiento; }
    public void setDuenio(Persona duenio) { this.duenio = duenio; }
    public void setNombre(String nombre) { this.nombre=nombre; }
    abstract String tipoAnimal();
    abstract void alimentar();
}