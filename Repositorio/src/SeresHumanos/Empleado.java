package SeresHumanos;
import ObjetosAbstractos.Procesos.Llamada;
import Tiempo.Fecha;
import Tiempo.Hora;
import java.util.ArrayList;
import java.util.Scanner;
public class Empleado extends Persona {
    private long dni;
    private String pais,telefono;
    public Empleado() { super(); }
    public long getDNI() { return dni; }
    public String getTelefono() { return telefono; }
    public String getPais() { return pais; }
    public void setDNI(long dni) { this.dni=dni;}
    public void setPais(String pais) { this.pais=pais; }
    public void setTelefono(String telefono) { this.telefono=telefono; }
    public String toString() { return "Empleado "+super.nombre+" "+super.apellido; }
    public void realizarLlamada(ArrayList<Empleado> registroEmpleados,ArrayList<Llamada> registroLlamadas,Scanner entrada,String telefono) {
        Llamada llamada=new Llamada();
        llamada.setOrigen(this);
        if(llamada.buscarDestinatario(registroEmpleados,telefono)) {
            Fecha fechaRealizacion=new Fecha();
            Hora hora=new Hora();
            System.out.println("\nLlamada realizada, por favor ingrese la fecha actual:\n\nAño:");
            fechaRealizacion.setAnio(entrada.nextInt());
            System.out.println("\nMes:");
            fechaRealizacion.setMes(entrada.nextInt());
            System.out.println("\nDía:");
            fechaRealizacion.setDia(entrada.nextInt());
            llamada.setFechaRealizacion(fechaRealizacion);
            System.out.println("\nIngrese la duración de la llamada:\n\nMinutos:");
            hora.setMinutos(entrada.nextInt());
            System.out.println("\nHoras:");
            hora.setHoras(entrada.nextInt());
            llamada.setDuracion(hora);
            registroLlamadas.add(llamada);
        } else { System.out.println("\nNo se encontró al destinatario."); }
    }
}