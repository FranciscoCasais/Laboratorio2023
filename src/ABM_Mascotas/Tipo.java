package ABM_Mascotas;
public enum Tipo {
    GATO("Gato"),PAJAROCANTOR("Cantor"),PAJARONOCANTOR("NoCantor"),PERRO("Perro");
    private String nombreClase;
    Tipo(String nombreClase) { this.nombreClase=nombreClase; }
    public String getNombreClase() { return nombreClase; }
    public void setNombreClase(String nombreClase) { this.nombreClase=nombreClase; }
}