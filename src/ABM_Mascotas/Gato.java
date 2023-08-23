package ABM_Mascotas;
import SeresHumanos.Persona;
public class Gato extends Terrestre {
    public Gato() { super(); }
    public Gato(int alegria,Persona duenio,String nombre) { super(alegria,duenio,nombre); }
    @Override
    public String tipoAnimal() { return "Gato"; }
    @Override
    public String saludo() {
        String saludo="";
        for(int i=0;i<alegria;i++) saludo+="miau ";
        saludo=saludo.substring(0,saludo.length()-1);
        if(alegria>1) this.setAlegria(alegria-1);
        return saludo;
    }
}