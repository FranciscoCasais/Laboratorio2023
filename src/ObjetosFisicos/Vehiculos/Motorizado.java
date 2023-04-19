package ObjetosFisicos.Vehiculos;

public class Motorizado extends Vehiculo {
    protected String patente;
    public Motorizado() {
        super();
        patente="AA000AA";
    }
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente=patente; }
}