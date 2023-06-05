package ObjetosAbstractos.Procesos;
import SeresHumanos.Persona;
import Tiempo.Fecha;
import Tiempo.Hora;
import ObjetosFisicos.Otros.Plato;
public class Pedido {
    private boolean entregado;
    private Fecha fechaCreacion;
    private Hora horaEntrega;
    private Persona cliente;
    private Plato plato;
    public Pedido() {
        entregado=false;
        fechaCreacion=new Fecha();
        horaEntrega=new Hora();
        cliente=new Persona();
        plato=new Plato();
    }
    public boolean getEntregado() { return entregado; }
    public Fecha getFechaCreacion() { return fechaCreacion; }
    public Hora getHoraEntrega() { return horaEntrega; }
    public Persona getCliente() { return cliente; }
    public Plato getPlato() { return plato; }
    public void setEntregado(boolean entregado) { this.entregado=entregado; }
    public void setFechaCreacion(Fecha fechaCreacion) { this.fechaCreacion=fechaCreacion; }
    public void setHoraEntrega(Hora horaEntrega) { this.horaEntrega=horaEntrega; }
    public void setCliente(Persona cliente) { this.cliente=cliente; }
    public void setPlato(Plato plato) { this.plato=plato; }
}