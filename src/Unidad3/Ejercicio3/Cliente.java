package Unidad3.Ejercicio3;
public class Cliente {
    private MetodoPago metodoPago;
    private String apellido,nombre,telefono;
    public Cliente() {
        metodoPago=new MetodoPago();
        apellido="";
        nombre="";
        telefono="";
    }
    public MetodoPago getMetodoPago() { return metodoPago; }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago=metodoPago; }
    public void setApellido(String apellido) { this.apellido=apellido; }
    public void setNombre(String nombre) { this.nombre=nombre; }
    public void setTelefono(String telefono) { this.telefono=telefono; }
}