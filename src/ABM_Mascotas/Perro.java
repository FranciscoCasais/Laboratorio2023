package ABM_Mascotas;
import SeresHumanos.Persona;
public class Perro extends Mascota {
    public Perro() { super(); }
    public Perro(Persona duenio,String nombre) { super(duenio,nombre); }
    @Override
    public String saludo() { return "guau"; }
}