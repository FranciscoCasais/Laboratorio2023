package ABM_Mascotas;

import SeresHumanos.Persona;
public abstract class Mascota {
    private Persona duenio;
    private String nombre;
    public Mascota() {
        this.duenio =new Persona();
        nombre="";
    }
    public Mascota(Persona dueño,String nombre) {
        this.duenio =dueño;
        this.nombre=nombre;
    }
    public Persona getDuenio() { return duenio; }
    public String getNombre() { return nombre; }
    public void setDuenio(Persona duenio) { this.duenio = duenio; }
    public void setNombre(String nombre) { this.nombre=nombre; }
    abstract String saludo();
}