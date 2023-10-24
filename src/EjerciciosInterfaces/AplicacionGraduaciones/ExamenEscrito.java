package EjerciciosInterfaces.AplicacionGraduaciones;
import java.time.LocalDate;
public class ExamenEscrito extends Examen {
    private int duracionMinutos,nota;
    public ExamenEscrito() {
        super();
        duracionMinutos=0;
        nota=0;
    }
    public ExamenEscrito(int duracionMinutos, int nota, LocalDate fecha) {
        super(fecha);
        this.duracionMinutos=duracionMinutos;
        try {
            if(nota>=0 && nota<=10) this.nota=nota;
            else throw new NotaInvalidaException("Error: no se pudo agregar el examen al sistema porque la nota ingresada no está entre 0 y 10.");
        } catch(NotaInvalidaException e) { System.err.println(e.getMessage()); }
    }
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos=duracionMinutos; }
    public int getNota() { return nota; }
    public void setNota(int nota) { this.nota=nota; }
    public boolean aprobado() { return duracionMinutos<=90 && nota>=6; }
}