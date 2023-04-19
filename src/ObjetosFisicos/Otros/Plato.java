package ObjetosFisicos.Otros;
public class Plato {
    private double precio;
    private String nombre;
    public Plato() {
        precio=0.00;
        nombre="";
    }
    public double getPrecio() { return precio; }
    public String getNombre() { return nombre; }
    public void setPrecio(double precio) { this.precio=precio; }
    public void setNombre(String nombre) { this.nombre=nombre; }
}