package EjerciciosInterfaces.CampaniaElecciones;
public class Paloma {
    private boolean mapaAprendido;
    private String color,especie,nombre;
    public Paloma() {
        mapaAprendido=false;
        color="";
        especie="";
        nombre="";
    }
    public Paloma(boolean mapaAprendido, String color, String especie, String nombre) {
        this.mapaAprendido = mapaAprendido;
        this.color = color;
        this.especie = especie;
        this.nombre = nombre;
    }
    public boolean isMapaAprendido() { return mapaAprendido; }
    public void setMapaAprendido(boolean mapaAprendido) { this.mapaAprendido = mapaAprendido; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}