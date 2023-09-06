package SistemaCine;
public enum Genero {
    ACCION("acción"),AVENTURA("aventura"),ROMANCE("romance"),DRAMA("drama"),COMEDIA("comedia");
    private String nombre;
    Genero(String nombre) { this.nombre=nombre; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre=nombre; }
}