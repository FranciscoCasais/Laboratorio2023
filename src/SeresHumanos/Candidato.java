package SeresHumanos;
import java.util.*;
import SistemaElecciones.*;
public class Candidato extends Persona {
    private int dni;
    private HashMap<Provincia,Integer> votosPorProvincia;
    private HashMap<Tema,HashSet<String>> propuestasPorTema;
    private Partido partidoPolitico;
    public int getDni() { return dni; }
    public HashMap<Provincia,Integer> getVotosPorProvincia() { return votosPorProvincia; }
    public HashMap<Tema,HashSet<String>> getPropuestasPorTema() { return propuestasPorTema; }
    public Partido getPartidoPolitico() { return partidoPolitico; }
    public void setDni(int dni) { this.dni=dni; }
    public void setVotosPorProvincia(HashMap<Provincia,Integer> votosPorProvincia) { this.votosPorProvincia=votosPorProvincia; }
    public void setPropuestasPorTema(HashMap<Tema,HashSet<String>> propuestasPorTema) { this.propuestasPorTema=propuestasPorTema; }
    public void setPartidoPolitico(Partido partidoPolitico) { this.partidoPolitico=partidoPolitico; }
    public void mostrarPropuestas() {
        for(Tema tema:propuestasPorTema.keySet()) {
            System.out.println("\n"+tema.getNombre()+":\n");
            for(String propuesta:propuestasPorTema.get(tema)) System.out.println("- "+propuesta);
        }
    }
    public void mostrarVotos() {
        for(Provincia provincia:votosPorProvincia.keySet()) System.out.println(provincia.getNombre()+": "+votosPorProvincia.get(provincia));
        System.out.println("Total país: "+this.votosTotales());
    }
    public int votosTotales() {
        int votosTotales=0;
        for(Integer cantidadVotos:votosPorProvincia.values()) votosTotales+=cantidadVotos;
        return votosTotales;
    }
}