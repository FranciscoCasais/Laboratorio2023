package SeresHumanos;
import Unidad1.Fecha;
public class Jugador extends SerHumano {
    private boolean capitan;
    private int numeroCamiseta;
    public Jugador() {
        super();
        capitan=false;
        numeroCamiseta=1;
    }
    public boolean getCapitan() { return capitan; }
    public Fecha getFechaNacimiento() { return super.fechaNacimiento; }
    public int getNumeroCamiseta() { return numeroCamiseta; }
    public String getNombreCompleto() { return super.nombreCompleto; }
    public void setCapitan(boolean capitan) { this.capitan=capitan; }
    public void setFechaNacimiento(Fecha fechaNacimiento) { super.fechaNacimiento=fechaNacimiento; }
    public void setNumeroCamiseta(int numeroCamiseta) { this.numeroCamiseta=numeroCamiseta; }
    public void setNombreCompleto(String nombreCompleto) { super.nombreCompleto=nombreCompleto; }
}