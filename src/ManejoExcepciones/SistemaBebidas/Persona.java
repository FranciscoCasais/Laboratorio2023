package ManejoExcepciones.SistemaBebidas;
import java.util.HashMap;
public class Persona extends SeresHumanos.Persona {
    private HashMap<Bebida,Integer> bebidasConsumidas;
    private int dni;
    public Persona() { dni=0; }
    public Persona(HashMap<Bebida,Integer> bebidasConsumidas,int dni) {
        this.bebidasConsumidas=bebidasConsumidas;
        this.dni=dni;
    }
    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni=dni; }
    public HashMap<Bebida, Integer> getBebidasConsumidas() { return bebidasConsumidas; }
    public void setBebidasConsumidas(HashMap<Bebida, Integer> bebidasConsumidas) { this.bebidasConsumidas=bebidasConsumidas; }
}