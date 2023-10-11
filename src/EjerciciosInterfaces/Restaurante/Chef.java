package EjerciciosInterfaces.Restaurante;
import java.time.LocalDate;
public class Chef extends Persona {
    private boolean experienciaCulinariaPrevia;
    private int dni;
    public Chef() {
        super();
        experienciaCulinariaPrevia=false;
    }
    public Chef(String nombre, String apellido, LocalDate fechaNacimiento, boolean experienciaCulinariaPrevia, int dni) {
        super(fechaNacimiento, apellido, nombre);
        this.experienciaCulinariaPrevia = experienciaCulinariaPrevia;
        this.dni=dni;
    }
    public boolean hasExperienciaCulinariaPrevia() { return experienciaCulinariaPrevia; }
    public void setExperienciaCulinariaPrevia(boolean experienciaCulinariaPrevia) { this.experienciaCulinariaPrevia = experienciaCulinariaPrevia; }
    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni = dni; }
}