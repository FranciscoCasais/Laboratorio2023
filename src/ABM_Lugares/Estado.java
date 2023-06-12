package ABM_Lugares;

import java.util.ArrayList;
import java.util.HashSet;

public class Estado extends Lugar{
    private HashSet<Ciudad> ciudades;

    public Estado(String nombre, int codigo, ArrayList<Float> coordenadas, HashSet<Ciudad> ciudades) {
        super(nombre, codigo, coordenadas);
        this.ciudades = ciudades;
    }

    public Estado() {
        super();
        this.ciudades = new HashSet<Ciudad>();
    }

    public HashSet<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(HashSet<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    @Override
    public int getPoblacion (){
        int poblacion = 0;
        for (Ciudad ciudad : ciudades){
            poblacion += ciudad.getPoblacion();
        }
        return poblacion;
    }
}
