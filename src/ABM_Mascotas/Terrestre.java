package ABM_Mascotas;
import SeresHumanos.Persona;
public abstract class Terrestre extends Mascota {
    protected int alegria;
    public Terrestre() {
        super();
        int alegria=1;
    }
    public Terrestre(int alegria,Persona duenio,String nombre) {
        super(duenio,nombre);
        this.alegria=alegria;
    }
    public int getAlegria() { return alegria; }
    public void setAlegria(int alegria) { this.alegria=alegria; }
    @Override
    public void alimentar() { alegria++; }
    abstract String saludo();
}