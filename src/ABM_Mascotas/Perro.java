package ABM_Mascotas;
import SeresHumanos.Persona;
import Tiempo.Fecha;
public class Perro extends Terrestre {
    public Perro() { super(); }
    public Perro(Fecha fechaNacimiento,int alegria,Persona duenio,String nombre) { super(fechaNacimiento,alegria,duenio,nombre); }
    @Override
    public String tipoAnimal() { return "Perro"; }
    @Override
    public String saludo() {
        String saludo="";
        for(int i=0;i<alegria;i++) saludo+="guau ";
        saludo=saludo.substring(0,saludo.length()-1);
        if(alegria>1) this.setAlegria(alegria-1);
        return saludo;
    }
}