package ABM_Mascotas;
import java.util.HashSet;
import SeresHumanos.Persona;
public class Sistema {
    private HashSet<Mascota> mascotas;
    public Sistema() { mascotas=new HashSet<>(); }
    public HashSet<Mascota> getMascotas() { return mascotas; }
    public void setMascotas(HashSet<Mascota> mascotas) { this.mascotas=mascotas; }
    public void altaMascota(Persona duenio,String canto,String nombre,Tipo tipo) throws ClassNotFoundException,IllegalAccessException,InstantiationException {
        Class clase=Class.forName(tipo.getNombreClase());
        Mascota nuevaMascota=(Mascota)clase.newInstance();
        if(nuevaMascota instanceof Cantor) { nuevaMascota=new Cantor(duenio,canto,nombre); }
        else if(nuevaMascota instanceof Gato) { nuevaMascota=new Gato(duenio,nombre); }
        else if(nuevaMascota instanceof NoCantor) { nuevaMascota=new NoCantor(duenio,nombre); }
        else { nuevaMascota=new Perro(duenio,nombre); }
        mascotas.add(nuevaMascota);
    }
    public void eliminarMascota(Mascota mascota) {
        for(Mascota m:mascotas) {
            if(m.equals(mascota)) { mascotas.remove(m); }
        }
    }
    public void modificarMascota(Mascota nuevaMascota,Mascota mascotaAnterior) {
        for(Mascota m:mascotas) {
            if(m.equals(mascotaAnterior)) {
                mascotas.remove(m);
                mascotas.add(nuevaMascota);
            }
        }
    }
}