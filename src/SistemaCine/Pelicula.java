package SistemaCine;
import java.util.*;
public class Pelicula {
    private Genero genero;
    private int duracionMinutos;
    private int id;
    private String titulo;
    private static int cantidadPeliculas=0;
    public Pelicula() {
        cantidadPeliculas++;
        genero=Genero.ACCION;
        duracionMinutos=0;
        id=cantidadPeliculas;
        titulo="";
    }
    public Pelicula(Genero genero,int duracionMinutos,String titulo) {
        cantidadPeliculas++;
        this.genero=genero;
        this.duracionMinutos=duracionMinutos;
        this.id=cantidadPeliculas;
        this.titulo=titulo;
    }
    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero=genero; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos=duracionMinutos; }
    public int getId() { return id; }
    public void setId(int id) { this.id=id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo=titulo; }
    public static int getCantidadPeliculas() { return cantidadPeliculas; }
    public static void setCantidadPeliculas(int cantidadPeliculas) { Pelicula.cantidadPeliculas=cantidadPeliculas; }
    public String toString() { return getTitulo()+" ("+getGenero().toString()+", "+getDuracionMinutos()+" minutos)"; }
}