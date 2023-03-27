package Unidad2;
import java.util.ArrayList;
import Unidad1.Fecha;
public class Alumno {
    private ArrayList<Double> notas;
    private Fecha fechaNacimiento;
    private String apellido,nombre;
    public Alumno() {
        notas=new ArrayList<Double>();
        fechaNacimiento=new Fecha();
        apellido="";
        nombre="";
    }
    public ArrayList<Double> getNotas() { return notas; }
    public Fecha getFechaNacimiento() { return fechaNacimiento; }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public void setNotas(ArrayList<Double> notas) { this.notas=notas; }
    public void setFechaNacimiento(Fecha fechaNacimiento) { this.fechaNacimiento=fechaNacimiento; }
    public void setApellido(String apellido) { this.apellido=apellido; }
    public void setNombre(String nombre) { this.nombre=nombre; }
    public void agregarNota(double nota) { notas.add(nota); }
    public double menorNota() {
        double menorNota=0.0;
        for(double nota:notas) {
            if(nota<menorNota) { menorNota=nota; }
        }
        return menorNota;
    }
    public double mayorNota() {
        double mayorNota=0.0;
        for(double nota:notas) {
            if(nota<mayorNota) { mayorNota=nota; }
        }
        return mayorNota;
    }
}