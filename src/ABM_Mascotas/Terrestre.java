package ABM_Mascotas;
import SeresHumanos.Persona;
import Tiempo.Fecha;
public abstract class Terrestre extends Mascota {
    protected int alegria;
    public Terrestre() {
        super();
        int alegria=1;
    }
    public Terrestre(Fecha fechaNacimiento,int alegria,Persona duenio,String nombre) {
        super(fechaNacimiento,duenio,nombre);
        this.alegria=alegria;
    }
    public int getAlegria() { return alegria; }
    public void setAlegria(int alegria) { this.alegria=alegria; }
    @Override
    public void alimentar() { alegria++; }
    abstract String saludo();
}