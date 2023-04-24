package ObjetosAbstractos.Procesos;
import SeresHumanos.Empleado;
import Tiempo.Fecha;
import Tiempo.Hora;
import java.util.ArrayList;
public class Llamada {
    Empleado destino,origen;
    Fecha fechaRealizacion;
    Hora duracion;
    public Empleado getDestino() { return destino; }
    public Empleado getOrigen() { return origen; }
    public Fecha getFechaRealizacion() { return fechaRealizacion; }
    public Hora getDuracion() { return duracion; }
    public void setDestino(Empleado destino) { this.destino=destino; }
    public void setOrigen(Empleado origen) { this.origen=origen; }
    public void setFechaRealizacion(Fecha fechaRealizacion) { this.fechaRealizacion=fechaRealizacion; }
    public void setDuracion(Hora duracion) { this.duracion=duracion; }
    public boolean buscarDestinatario(ArrayList<Empleado> registroEmpleados,String telefono) {
        for(Empleado empleado:registroEmpleados) {
            if(empleado.getTelefono().equals(telefono)) {
                destino=empleado;
                return true;
            }
        }
        return false;
    }
}