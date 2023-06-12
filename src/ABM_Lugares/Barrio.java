package ABM_Lugares;

import java.util.ArrayList;

public class Barrio extends Lugar{
    private int poblacion;

    public Barrio(String nombre, int codigo, ArrayList<Float> coordenadas, int poblacion) {
        super(nombre, codigo, coordenadas);
        this.poblacion = poblacion;
    }

    public Barrio() {
        super();
        this.poblacion = 0;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public int getPoblacion (){
        return this.poblacion;
    }
}
