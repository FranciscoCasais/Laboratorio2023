package Unidad2;
import java.util.ArrayList;
public class Partido {
    private int equipo1,equipo2;
    private String equipo1Nombre,equipo2Nombre;
    public Partido() {
        equipo1=0;
        equipo2=1;
        equipo1Nombre="";
        equipo2Nombre="";
    }
    public Partido(int equipo1,int equipo2,String equipo1Nombre,String equipo2Nombre) {
        this.equipo1=equipo1;
        this.equipo2=equipo2;
        this.equipo1Nombre=equipo1Nombre;
        this.equipo2Nombre=equipo2Nombre;
    }
    public int getEquipo1() { return equipo1; }
    public int getEquipo2() { return equipo2; }
    public String getEquipo1Nombre() { return equipo1Nombre; }
    public String getEquipo2Nombre() { return equipo2Nombre; }
    public void setEquipo1(int equipo1) { this.equipo1=equipo1; }
    public void setEquipo1Nombre(String nombre) { equipo1Nombre=nombre; }
    public void setEquipo2Nombre(String nombre) { equipo2Nombre=nombre; }
    public void setEquipo2(int equipo2) { this.equipo2=equipo2; }
}