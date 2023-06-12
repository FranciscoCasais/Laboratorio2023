package ABM_Lugares;

import java.util.ArrayList;
import java.util.HashSet;

public class Pais extends Lugar{
    private HashSet<Estado> estados;

    public Pais(String nombre, int codigo, ArrayList<Float> coordenadas, HashSet<Estado> estados) {
        super(nombre, codigo, coordenadas);
        this.estados = estados;
    }

    public Pais() {
        super();
        this.estados = new HashSet<Estado>();
    }

    public HashSet<Estado> getEstados() {
        return estados;
    }

    public void setEstados(HashSet<Estado> estados) {
        this.estados = estados;
    }
    @Override
    public int getPoblacion (){
        int poblacion = 0;
        for (Estado estado : estados){
            poblacion += estado.getPoblacion();
        }
        return poblacion;
    }
}
