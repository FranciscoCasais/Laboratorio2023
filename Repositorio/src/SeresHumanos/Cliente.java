package SeresHumanos;
import ObjetosFisicos.MetodosPago.MetodoPago;

public class Cliente extends Persona {
    private MetodoPago metodoPago;
    private String telefono;
    public Cliente() {
        super();
        metodoPago=new MetodoPago();
        telefono="";
    }
    public MetodoPago getMetodoPago() { return metodoPago; }
    public String getTelefono() { return telefono; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago=metodoPago; }
    public void setTelefono(String telefono) { this.telefono=telefono; }
}