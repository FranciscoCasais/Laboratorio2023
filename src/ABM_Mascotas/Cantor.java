package ABM_Mascotas;
import SeresHumanos.Persona;
public class Cantor extends Pajaro {
    protected String canto;
    public Cantor() { super(); }
    public Cantor(Persona duenio,String canto,String nombre) {
        super(duenio,nombre);
        this.canto=canto;
    }
    public String getCanto() { return canto; }
    public void setCanto(String canto) { this.canto = canto; }
    @Override
    String saludo() { return canto; }
}