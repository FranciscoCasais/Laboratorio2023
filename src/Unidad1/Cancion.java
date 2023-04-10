package Unidad1;

import SeresHumanos.Persona;

public class Cancion {
    private Persona autor;
    private String titulo;

    public Cancion() {
        autor = new Persona();
        titulo = "";
    }

    public Cancion(Persona autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
    }

    public Persona getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}