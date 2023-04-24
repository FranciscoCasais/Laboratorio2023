package ObjetosFisicos.Vehiculos;

public class Camioneta extends Motorizado {
    private double capacidadCargaKG,cargaActualKG;
    public Camioneta() {
        super();
        capacidadCargaKG=2000.00;
        cargaActualKG=0.00;
    }
    public double getCapacidadCargaKG() { return capacidadCargaKG; }
    public double getCargaActualKG() { return cargaActualKG; }
    public void setCapacidadCargaKG(double capacidadCargaKG) { this.capacidadCargaKG=capacidadCargaKG; }
    public void setCargaActualKG(double cargaActualKG) { this.cargaActualKG+=cargaActualKG; }
}