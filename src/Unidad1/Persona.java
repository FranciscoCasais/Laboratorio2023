package Unidad1;
public class Persona {
    private int edad;
    private String direccion, nombreCompleto;

    public Persona() {
        edad = 0;
        direccion = "";
        nombreCompleto = "";
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void getDatos() {
        System.out.println("Datos de la persona:\nNombre completo: " + nombreCompleto + "\nEdad: " + edad + "\nDirección: " + direccion);
    }
}