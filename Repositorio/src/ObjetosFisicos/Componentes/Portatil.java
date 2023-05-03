package ObjetosFisicos.Componentes;
public class Portatil extends Cargador {
    private int numeroCargas;
    public Portatil() {
        super();
        numeroCargas=5;
    }
    public int getNumeroCargas() { return numeroCargas; }
    public void setNumeroCargas(int numeroCargas) { this.numeroCargas=numeroCargas; }
}