package SeresHumanos;
public class Directivo extends Empleado {
    public Directivo(String nombreCompleto) { super(nombreCompleto); }
    public String toString() { return super.toString()+" -> Directivo"; }
}