package EjerciciosInterfaces.Restaurante;
public class Plato {
    private Chef chefACargo;
    private double precio;
    private String descripcion,nombre;
    private Tipo tipo;
    public Plato() {
        chefACargo=new Chef();
        precio=0;
        descripcion="";
        nombre="";
        tipo=null;
    }
    public Plato(Chef chefACargo, double precio, String descripcion, String nombre, Tipo tipo) {
        this.chefACargo = chefACargo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    public Chef getChefACargo() { return chefACargo; }
    public void setChefACargo(Chef chefACargo) { this.chefACargo = chefACargo; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }
    @Override
    public String toString() { return nombre+" ("+tipo.toString()+"): $"+precio+"\n"+descripcion+"\nChef a cargo: "+chefACargo.getNombre()+" "+chefACargo.getApellido(); }
}