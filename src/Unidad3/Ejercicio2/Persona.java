package Unidad3.Ejercicio2;
public class Persona {
    protected String apellido,nombre;
    public Persona() {
        apellido="";
        nombre="";
    }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public void setApellido(String apellido) { this.apellido=apellido; }
    public void setNombre(String nombre) { this.nombre=nombre; }
}