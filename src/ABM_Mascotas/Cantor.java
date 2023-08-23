package ABM_Mascotas;
import SeresHumanos.Persona;
public class Cantor extends Pajaro {
    private String canto;
    public Cantor() { super(); }
    public Cantor(int alegria,Persona duenio,String canto,String nombre) {
        super(alegria,duenio,nombre);
        this.canto=canto;
    }
    public String getCanto() { return canto; }
    public void setCanto(String canto) { this.canto = canto; }
    @Override
    public String tipoAnimal() { return "Cantor"; }
    @Override
    String saludo() {
        String saludo="";
        for(int i=0;i<alegria;i++) saludo+=canto+" ";
        saludo=saludo.substring(0,saludo.length()-1);
        if(alegria>1) this.setAlegria(alegria-1);
        return saludo;
    }
}