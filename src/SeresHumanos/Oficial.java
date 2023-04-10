package SeresHumanos;
public class Oficial extends Operario {
    public Oficial(String nombreCompleto) { super(nombreCompleto); }
    public String toString() { return super.toString()+" -> Oficial"; }
}