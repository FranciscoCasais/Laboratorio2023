package SeresHumanos;

public class Jugador extends Persona {
    private boolean capitan;
    private int numeroCamiseta;
    public Jugador() {
        super();
        capitan=false;
        numeroCamiseta=1;
    }
    public boolean getCapitan() { return capitan; }
    public int getNumeroCamiseta() { return numeroCamiseta; }
    public void setCapitan(boolean capitan) { this.capitan=capitan; }
    public void setNumeroCamiseta(int numeroCamiseta) { this.numeroCamiseta=numeroCamiseta; }
}