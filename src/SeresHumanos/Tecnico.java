package SeresHumanos;
public class Tecnico extends Operario {
    public Tecnico(String nombreCompleto) { super(nombreCompleto); }
    public String toString() { return super.toString()+" -> Tecnico"; }
}