package SistemaElecciones;
public enum Tema {
    SALUD("Salud"),EDUCACION("Educación"),SEGURIDAD("Seguridad"),ECONOMIA("Economía"),AMBIENTE("Ambiente");
    private String nombre;
    Tema(String nombre) { this.nombre=nombre; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre=nombre; }
}