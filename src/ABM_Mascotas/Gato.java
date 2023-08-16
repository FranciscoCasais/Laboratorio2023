package ABM_Mascotas;
import SeresHumanos.Persona;
public class Gato extends Mascota {
    public Gato() { super(); }
    public Gato(Persona duenio,String nombre) { super(duenio,nombre); }
    @Override
    public String saludo() { return "miau"; }
}