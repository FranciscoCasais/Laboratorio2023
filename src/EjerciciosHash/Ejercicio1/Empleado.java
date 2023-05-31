package EjerciciosHash.Ejercicio1;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
public class Empleado extends Persona {
    private HashSet<DayOfWeek> diasAsistencia;
    private HashSet<LocalDateTime> registroAsistencia;
    private String numeroTelefono;
    public Empleado() {
        super();
        diasAsistencia=new HashSet<>();
        registroAsistencia=new HashSet<>();
        numeroTelefono="";
    }
    public HashSet<DayOfWeek> getDiasAsistencia() { return diasAsistencia; }
    public HashSet<LocalDateTime> getRegistroAsistencia() { return registroAsistencia; }
    public String getNumeroTelefono() { return numeroTelefono; }
    public void setDiasAsistencia(HashSet<DayOfWeek> diasAsistencia) { this.diasAsistencia=diasAsistencia; }
    public void setRegistroAsistencia(HashSet<LocalDateTime> registroAsistencia) { this.registroAsistencia=registroAsistencia; }
    public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono=numeroTelefono; }
    public double porcentajeDeAsistencia(Month mes) {
        int cantidadAsistencias=0;
        for(LocalDateTime asistencia:registroAsistencia) {
            if(asistencia.getMonth().equals(mes) && diasAsistencia.contains(asistencia.getDayOfWeek())) { cantidadAsistencias++; }
        }
        if(mes.equals(Month.FEBRUARY)) { return cantidadAsistencias*100/29; }
        else if(mes.equals(Month.APRIL) || mes.equals(Month.JUNE) || mes.equals(Month.SEPTEMBER) || mes.equals(Month.NOVEMBER)) { return cantidadAsistencias*100/30; }
        else { return cantidadAsistencias*100/31; }
    }
}