package ABM_Mascotas;
import SeresHumanos.Persona;
public class NoCantor extends Pajaro {
    public NoCantor() { super(); }
    public NoCantor(Persona duenio,String nombre) { super(duenio,nombre); }
    @Override
    String saludo() { return "pio"; }
}