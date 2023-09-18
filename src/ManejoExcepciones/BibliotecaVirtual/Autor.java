package ManejoExcepciones.BibliotecaVirtual;

import Tiempo.Fecha;
import SeresHumanos.Persona;
import java.util.HashSet;

public class Autor extends Persona {
    private HashSet<LibroElectronico> bibliografia;

    public Autor(String nombre, String apellido, Fecha fechaNacimiento, HashSet<LibroElectronico> bibliografia) {
        super(nombre, apellido, fechaNacimiento);
        this.bibliografia = bibliografia;
    }
    public Autor() {
        super();
        this.bibliografia = new HashSet<>();
    }

    public HashSet<LibroElectronico> getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(HashSet<LibroElectronico> bibliografia) {
        this.bibliografia = bibliografia;
    }

}
