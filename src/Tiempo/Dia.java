package Tiempo;
public enum Dia {
    LUNES("Lunes"),MARTES("Martes"),MIERCOLES("Miércoles"),JUEVES("Jueves"),VIERNES("Viernes"),SABADO("Sábado"),DOMINGO("Domingo");
    String nombre;
    Dia(String nombre) { this.nombre=nombre; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre=nombre; }
}