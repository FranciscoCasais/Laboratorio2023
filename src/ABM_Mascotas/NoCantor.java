package ABM_Mascotas;
import SeresHumanos.Persona;
import Tiempo.Fecha;
public class NoCantor extends Pajaro {
    public NoCantor() { super(); }
    public NoCantor(Fecha fechaNacimiento,int alegria,Persona duenio,String nombre) { super(fechaNacimiento,alegria,duenio,nombre); }
    @Override
    public String tipoAnimal() { return "No cantor"; }
    @Override
    String saludo() {
        String saludo="";
        for(int i=0;i<alegria;i++) saludo+="pio ";
        saludo=saludo.substring(0,saludo.length()-1);
        if(alegria>1) this.setAlegria(alegria-1);
        return saludo;
    }
}