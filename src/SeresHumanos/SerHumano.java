package SeresHumanos;
import Unidad1.Fecha;
public class SerHumano {
    protected Fecha fechaNacimiento;
    protected String nombreCompleto;
    public SerHumano() {
        fechaNacimiento=new Fecha();
        nombreCompleto="";
    }
    public Fecha getFechaNacimiento() { return fechaNacimiento; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setFechaNacimiento(Fecha fechaNacimiento) { this.fechaNacimiento=fechaNacimiento; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto=nombreCompleto; }
}