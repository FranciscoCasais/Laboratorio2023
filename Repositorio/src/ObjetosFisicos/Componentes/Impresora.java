package ObjetosFisicos.Componentes;
public class Impresora extends Salida {
    private boolean inyeccion,laser;
    public Impresora() {
        super();
        inyeccion=false;
        laser=false;
    }
    public boolean getInyeccion() { return inyeccion; }
    public boolean getLaser() { return laser; }
    public void setInyeccion(boolean inyeccion) { this.inyeccion=inyeccion; }
    public void setLaser(boolean laser) { this.laser=laser; }
}