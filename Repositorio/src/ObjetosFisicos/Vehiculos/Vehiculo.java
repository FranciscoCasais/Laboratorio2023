package ObjetosFisicos.Vehiculos;
public class Vehiculo {
    protected int anioFabricacion,cantidadRuedas;
    protected String color,marca,modelo;
    public Vehiculo() {
        anioFabricacion=2007;
        cantidadRuedas=4;
        color="blanco";
        marca="Volkswagen";
        modelo="Gol";
    }
    public int getAnioFabricacion() { return anioFabricacion; }
    public int getCantidadRuedas() { return cantidadRuedas; }
    public String getColor() { return color; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public void setAnioFabricacion(int anioFabricacion) { this.anioFabricacion=anioFabricacion; }
    public void setCantidadRuedas(int cantidadRuedas) { this.cantidadRuedas=cantidadRuedas; }
    public void setColor(String color) { this.color=color; }
    public void setMarca(String marca) { this.marca=marca; }
    public void setModelo(String modelo) { this.modelo=modelo; }
}