package Unidad2;
import java.util.ArrayList;
import Unidad1.Fecha;
public class Alumno {
    private ArrayList<Materia> materias;
    private Fecha fechaNacimiento;
    private String apellido,nombre;
    public Alumno() {
        materias=new ArrayList<Materia>();
        fechaNacimiento=new Fecha();
        apellido="";
        nombre="";
    }
    public ArrayList<Double> getNotas(int posicion) { return materias.get(posicion).getNotas(); }
    public Fecha getFechaNacimiento() { return fechaNacimiento; }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public void setNotas(ArrayList<Double> notas,int posicion) { materias.get(posicion).setNotas(notas); }
    public void setFechaNacimiento(Fecha fechaNacimiento) { this.fechaNacimiento=fechaNacimiento; }
    public void setApellido(String apellido) { this.apellido=apellido; }
    public void setNombre(String nombre) { this.nombre=nombre; }
    public void agregarNota(double nota,int posicion) { materias.get(posicion).getNotas().add(nota); }
    public double menorNota(int posicion) {
        double menorNota=materias.get(posicion).getNotas().get(0);
        for(double nota:materias.get(posicion).getNotas()) {
            if(nota<menorNota) { menorNota=nota; }
        }
        return menorNota;
    }
    public double mayorNota(int posicion) {
        double mayorNota=materias.get(posicion).getNotas().get(0);
        for(double nota:materias.get(posicion).getNotas()) {
            if(nota>mayorNota) { mayorNota=nota; }
        }
        return mayorNota;
    }
    public void agregarMateria(Materia materia) { materias.add(materia); }
    public double promedioNotasMateria(int posicion) {
        double promedio=0;
        for(double nota:materias.get(posicion).getNotas()) {
            promedio+=nota;
        }
        promedio/=materias.get(posicion).getNotas().size();
        return promedio;
    }
    public double promedioNotasTotal() {
        double promedioMateria=0,promedioTotal=0;
        for(int i=0;i<materias.size();i++) {
            for(double nota:materias.get(i).getNotas()) {
                promedioMateria+=nota;
            }
            promedioMateria/=materias.get(i).getNotas().size();
            promedioTotal+=promedioMateria;
            promedioMateria=0;
        }
        promedioTotal/=materias.size();
        return promedioTotal;
    }
}