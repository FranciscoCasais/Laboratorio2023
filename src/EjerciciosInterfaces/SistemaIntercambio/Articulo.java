package EjerciciosInterfaces.SistemaIntercambio;
public abstract class Articulo {
    protected String nombre;
    public Articulo() { nombre=""; }
    public Articulo(String nombre) { this.nombre=nombre; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre=nombre; }
    public abstract boolean cumpleCondicionesPrestar();
}