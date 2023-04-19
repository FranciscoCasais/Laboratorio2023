package ObjetosAbstractos.Otros;
import java.util.ArrayList;
public class Materia {
    private ArrayList<Double> notas;
    private String nombre;

    public Materia() {
        notas = new ArrayList<Double>();
        nombre = "";
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}