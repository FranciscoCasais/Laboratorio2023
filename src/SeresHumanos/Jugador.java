package SeresHumanos;
import Unidad1.Fecha;
public class Jugador {
    private boolean capitan;
    private Fecha fechaNacimiento;
    private int numeroCamiseta;
    private String nombreCompleto;
    public Jugador() {
        capitan=false;
        fechaNacimiento=new Fecha();
        numeroCamiseta=1;
        nombreCompleto="";
    }
    public boolean getCapitan() { return capitan; }
    public Fecha getFechaNacimiento() { return fechaNacimiento; }
    public int getNumeroCamiseta() { return numeroCamiseta; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setCapitan(boolean capitan) { this.capitan=capitan; }
    public void setFechaNacimiento(Fecha fechaNacimiento) { this.fechaNacimiento=fechaNacimiento; }
    public void setNumeroCamiseta(int numeroCamiseta) { this.numeroCamiseta=numeroCamiseta; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto=nombreCompleto; }
}