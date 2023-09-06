package SeresHumanos;
import java.util.*;
import SistemaElecciones.*;
import Tiempo.Fecha;
public class Candidato extends Persona {
    private int dni;
    private HashMap<Provincia,Integer> votosPorProvincia;
    private HashMap<Tema,HashSet<String>> propuestasPorTema;
    private Partido partidoPolitico;
    public Candidato() {
        super();
        votosPorProvincia=new HashMap<>();
        propuestasPorTema=new HashMap<>();
        partidoPolitico=Partido.FRENTECONST;
    }
    public Candidato(Fecha fechaNacimiento,int dni,HashMap<Tema,HashSet<String>> propuestasPorTema,Partido partidoPolitico,String apellido,String nombre) {
        super(nombre,apellido,fechaNacimiento);
        this.dni=dni;
        this.propuestasPorTema=propuestasPorTema;
        this.partidoPolitico=partidoPolitico;
        HashMap<Provincia,Integer> votosPorProvincia=new HashMap<>();
        votosPorProvincia.put(Provincia.CABA,0);
        votosPorProvincia.put(Provincia.BUENOSAIRES,0);
        votosPorProvincia.put(Provincia.CORDOBA,0);
        votosPorProvincia.put(Provincia.CHACO,0);
        votosPorProvincia.put(Provincia.CATAMARCA,0);
        votosPorProvincia.put(Provincia.CHUBUT,0);
        votosPorProvincia.put(Provincia.CORRIENTES,0);
        votosPorProvincia.put(Provincia.ENTRERIOS,0);
        votosPorProvincia.put(Provincia.FORMOSA,0);
        votosPorProvincia.put(Provincia.JUJUY,0);
        votosPorProvincia.put(Provincia.LAPAMPA,0);
        votosPorProvincia.put(Provincia.LARIOJA,0);
        votosPorProvincia.put(Provincia.MENDOZA,0);
        votosPorProvincia.put(Provincia.MISIONES,0);
        votosPorProvincia.put(Provincia.NEUQUEN,0);
        votosPorProvincia.put(Provincia.RIONEGRO,0);
        votosPorProvincia.put(Provincia.SALTA,0);
        votosPorProvincia.put(Provincia.SANJUAN,0);
        votosPorProvincia.put(Provincia.SANLUIS,0);
        votosPorProvincia.put(Provincia.SANTACRUZ,0);
        votosPorProvincia.put(Provincia.SANTAFE,0);
        votosPorProvincia.put(Provincia.SANTIAGOESTERO,0);
        votosPorProvincia.put(Provincia.TIERRAFUEGO,0);
        votosPorProvincia.put(Provincia.TUCUMAN,0);
        this.votosPorProvincia=votosPorProvincia;
    }
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