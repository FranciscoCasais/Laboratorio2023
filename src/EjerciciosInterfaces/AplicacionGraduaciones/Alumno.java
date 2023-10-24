package EjerciciosInterfaces.AplicacionGraduaciones;
import EjerciciosInterfaces.Restaurante.Persona;
import java.time.LocalDate;
import java.util.HashSet;
public class Alumno extends Persona implements Calificable {
    private HashSet<Examen> examenesRealizados;
    private int dni;
    public Alumno() {
        super();
        examenesRealizados=new HashSet<>();
        dni=0;
    }
    public Alumno(HashSet<Examen> examenesRealizados, int dni, LocalDate fechaNacimiento, String apellido, String nombre) {
        super(fechaNacimiento,apellido,nombre);
        this.examenesRealizados=examenesRealizados;
        this.dni=dni;
    }
    public HashSet<Examen> getExamenesRealizados() { return examenesRealizados; }
    public void setExamenesRealizados(HashSet<Examen> examenesRealizados) { this.examenesRealizados=examenesRealizados; }
    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni=dni; }
    public boolean aprobado() {
        for(Examen examen:examenesRealizados) {
            if(!examen.aprobado()) return false;
        }
        return true;
    }
}