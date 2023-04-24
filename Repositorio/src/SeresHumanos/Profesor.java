package SeresHumanos;
import SeresHumanos.Persona;
public class Profesor extends Persona {
    private int porcentajeDescuento;
    public Profesor() {
        super();
        porcentajeDescuento=0;
    }
    public int getPorcentajeDescuento() { return porcentajeDescuento; }
    public void setPorcentajeDescuento(int porcentajeDescuento) { this.porcentajeDescuento=porcentajeDescuento; }
}