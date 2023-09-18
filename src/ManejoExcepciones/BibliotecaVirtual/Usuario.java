package ManejoExcepciones.BibliotecaVirtual;

import SeresHumanos.Persona;

import Tiempo.Fecha;
import java.util.HashSet;

public class Usuario extends Persona {
    private HashSet<LibroElectronico> librosPrestados;
    private Membresia membresia;
    private String mail;

    public Usuario(String nombre, String apellido, Fecha fechaNacimiento, HashSet<LibroElectronico> librosPrestados, Membresia membresia, String mail) {
        super(nombre, apellido, fechaNacimiento);
        this.librosPrestados = librosPrestados;
        this.membresia = membresia;
        this.mail = mail;
    }
    public Usuario(Membresia membresia) {
        super();
        this.librosPrestados = new HashSet<>();
        this.membresia = membresia;
        this.mail = "";
    }
    public Usuario() {
        super();
        this.librosPrestados = new HashSet<>();
        this.membresia = null;
        this.mail = "";
    }
    public HashSet<LibroElectronico> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(HashSet<LibroElectronico> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
