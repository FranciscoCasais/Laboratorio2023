package EjerciciosInterfaces.AplicacionGraduaciones;
import java.time.LocalDate;
public abstract class Examen implements Calificable {
    private LocalDate fecha;
    public Examen() { fecha=null; }
    public Examen(LocalDate fecha) { this.fecha=fecha; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha=fecha; }
    public abstract boolean aprobado();
}