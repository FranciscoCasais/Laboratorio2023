package ABM_Mascotas;
import SeresHumanos.Persona;
import Tiempo.Fecha;
public abstract class Pajaro extends Terrestre {
    public Pajaro() { super(); }
    public Pajaro(Fecha fechaNacimiento,int alegria,Persona duenio,String nombre) { super(fechaNacimiento,alegria,duenio,nombre); }
}