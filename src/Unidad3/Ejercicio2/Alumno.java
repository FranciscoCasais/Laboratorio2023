package Unidad3.Ejercicio2;
public class Alumno extends Persona {
    private String division;
    public Alumno() {
        super();
        division="";
    }
    public String getDivision() { return division; }
    public void setDivision(String division) { this.division=division; }
}