package Objetos;
import java.util.ArrayList;
import Unidad1.Cancion;
public class CD {
    private ArrayList<Cancion> canciones;

    public CD() {
        canciones = new ArrayList<Cancion>();
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public int numeroCanciones() {
        return canciones.size();
    }

    public Cancion verCancion(int posicion) {
        return canciones.get(posicion);
    }

    public void grabarCancion(Cancion nuevaCancion, int posicion) {
        canciones.set(posicion, nuevaCancion);
    }

    public void agregar(Cancion cancion) {
        canciones.add(cancion);
    }

    public void eliminar(int posicion) {
        canciones.remove(posicion);
    }
}