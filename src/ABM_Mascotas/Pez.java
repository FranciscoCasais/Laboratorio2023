package ABM_Mascotas;
import SeresHumanos.Persona;
public class Pez extends Mascota {
    private int vidas;
    public Pez() {
        super();
        vidas=10;
    }
    public Pez(Persona duenio,String nombre) {
        super(duenio,nombre);
        vidas=10;
    }
    public int getVidas() { return vidas; }
    public void setVidas(int vidas) { this.vidas=vidas; }
    @Override
    public String tipoAnimal() { return "Pez"; }
    @Override
    public void alimentar() { vidas++; }
}