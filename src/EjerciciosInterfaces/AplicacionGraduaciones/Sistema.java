package EjerciciosInterfaces.AplicacionGraduaciones;
import java.util.HashSet;
public class Sistema {
    private HashSet<Alumno> alumnos;
    public Sistema() { alumnos=new HashSet<>(); }
    public Sistema(HashSet<Alumno> alumnos) { this.alumnos=alumnos; }
    public HashSet<Alumno> getAlumnos() { return alumnos; }
    public void setAlumnos(HashSet<Alumno> alumnos) { this.alumnos=alumnos; }
    public int cantidadAprobados() {
        int cantidadAprobados=0;
        for(Alumno alumno:alumnos) {
            if(alumno.aprobado()) cantidadAprobados++;
        }
        return cantidadAprobados;
    }
}