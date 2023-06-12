package ABM_Lugares;

import java.util.ArrayList;
import java.util.HashSet;

public class Ciudad extends Lugar{
    private HashSet<Barrio> barrios;

    public Ciudad(String nombre, int codigo, ArrayList<Float> coordenadas, HashSet<Barrio> barrios) {
        super(nombre, codigo, coordenadas);
        this.barrios = barrios;
    }
    public Ciudad() {
        super();
        this.barrios = new HashSet<Barrio>();
    }

    public HashSet<Barrio> getBarrios() {
        return barrios;
    }

    public void setBarrios(HashSet<Barrio> barrios) {
        this.barrios = barrios;
    }
    @Override
    public int getPoblacion (){
        int poblacion = 0;
        for (Barrio barrio : barrios){
            poblacion += barrio.getPoblacion();
        }
        return poblacion;
    }
}
