package Unidad1;
public class Persona {
    private int edad;
    private String direccion,nombre;
    public int getEdad() { return edad; }
    public String getDireccion() { return direccion; }
    public String getNombre() { return nombre; }
    public void setEdad(int edad) { this.edad=edad; }
    public void setDireccion(String direccion) { this.direccion=direccion; }
    public void setNombre(String nombre) { this.nombre=nombre; }
    public void getDatos() {
        System.out.println("Datos de la persona:\n\nNombre completo: "+nombre+"\nEdad: "+edad+"\nDirección: "+direccion);
    }
}