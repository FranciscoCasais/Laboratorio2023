package SeresHumanos;
import java.time.LocalDate;
import java.util.HashMap;
public class Paciente extends Persona {
    private HashMap<LocalDate,Double> registroAlturas;
    private HashMap<LocalDate,Double> registroPesos;
    public Paciente() {
        super();
        registroAlturas=new HashMap<>();
        registroPesos=new HashMap<>();
    }
    public HashMap<LocalDate,Double> getRegistroAlturas() { return registroAlturas; }
    public HashMap<LocalDate,Double> getRegistroPesos() { return registroPesos; }
    public void setRegistroAlturas(HashMap<LocalDate,Double> registroAlturas) { this.registroAlturas=registroAlturas; }
    public void setRegistroPesos(HashMap<LocalDate,Double> registroPesos) { this.registroPesos=registroPesos; }
    public void mostrarAltura(LocalDate fecha) { System.out.println("La altura de la fecha seleccionada es: "+registroAlturas.get(fecha)); }
    public void mostrarPeso(LocalDate fecha) { System.out.println("El peso de la fecha seleccionada es: "+registroPesos.get(fecha)); }
}