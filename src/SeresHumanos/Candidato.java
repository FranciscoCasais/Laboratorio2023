package SeresHumanos;
import java.util.*;
import SistemaElecciones.*;
public class Candidato extends Persona {
    int dni;
    HashMap<Provincia,Integer> votosPorProvincia;
    HashMap<Tema,HashSet<String>> propuestasPorTema;
    Partido partidoPolitico;
    public int getDni() { return dni; }
    public HashMap<Provincia,Integer> getVotosPorProvincia() { return votosPorProvincia; }
    public HashMap<Tema,HashSet<String>> getPropuestasPorTema() { return propuestasPorTema; }
    public Partido getPartidoPolitico() { return partidoPolitico; }
    public void setDni(int dni) { this.dni=dni; }
    public void setVotosPorProvincia(HashMap<Provincia,Integer> votosPorProvincia) { this.votosPorProvincia=votosPorProvincia; }
    public void setPropuestasPorTema(HashMap<Tema,HashSet<String>> propuestasPorTema) { this.propuestasPorTema=propuestasPorTema; }
    public void setPartidoPolitico(Partido partidoPolitico) { this.partidoPolitico=partidoPolitico; }
}