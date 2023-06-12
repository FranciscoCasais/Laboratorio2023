package ABM_Lugares;

import java.util.ArrayList;

public class Lugar {
    private String nombre;
    private int codigo;
    private ArrayList<Float> coordenadas;

    public Lugar(String nombre, int codigo, ArrayList<Float> coordenadas) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.coordenadas = coordenadas;
    }
    public Lugar() {
        this.nombre = "";
        this.codigo = 0;
        this.coordenadas = new ArrayList<Float>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Float> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<Float> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getPoblacion (){
        return 0;
    }
}
