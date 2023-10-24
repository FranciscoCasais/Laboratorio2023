package EjerciciosInterfaces.AplicacionGraduaciones;
import java.time.LocalDate;
public class ExamenOral extends Examen {
    private NivelSatisfaccion nivelSatisfaccion;
    public ExamenOral() {
        super();
        nivelSatisfaccion=NivelSatisfaccion.EXCELENTE;
    }
    public ExamenOral(LocalDate fecha, NivelSatisfaccion nivelSatisfaccion) {
        super(fecha);
        this.nivelSatisfaccion=nivelSatisfaccion;
    }
    public NivelSatisfaccion getNivelSatisfaccion() { return nivelSatisfaccion; }
    public void setNivelSatisfaccion(NivelSatisfaccion nivelSatisfaccion) { this.nivelSatisfaccion=nivelSatisfaccion; }
    public boolean aprobado() { return !nivelSatisfaccion.equals(NivelSatisfaccion.INSUFICIENTE); }
}