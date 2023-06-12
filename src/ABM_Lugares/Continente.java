package ABM_Lugares;

import java.util.ArrayList;
import java.util.HashSet;

public class Continente extends Lugar{
    private HashSet<Pais> paises;

    public Continente(String nombre, int codigo, ArrayList<Float> coordenadas, HashSet<Pais> paises) {
        super(nombre, codigo, coordenadas);
        this.paises = paises;
    }

    public Continente() {
        super();
        this.paises = new HashSet<Pais>();
    }

    public HashSet<Pais> getPaises() {
        return paises;
    }

    public void setPaises(HashSet<Pais> paises) {
        this.paises = paises;
    }
    @Override
    public int getPoblacion (){
        int poblacion = 0;
        for (Pais pais : paises){
            poblacion += pais.getPoblacion();
        }
        return poblacion;
    }
}
