package ManejoExcepciones.SistemaBebidas;
import java.util.HashMap;
import java.util.HashSet;
public class Sistema {
    private HashMap<Bebida,Integer> stockBebidas;
    private HashSet<Bebida> bebidas;
    private HashSet<Persona> personas;
    public Sistema() {
        stockBebidas=new HashMap<>();
        bebidas=new HashSet<>();
        personas=new HashSet<>();
    }
    public Sistema(HashMap<Bebida,Integer> stockBebidas,HashSet<Bebida> bebidas,HashSet<Persona> personas) {
        this.stockBebidas=stockBebidas;
        this.bebidas=bebidas;
        this.personas=personas;
    }
    public HashMap<Bebida, Integer> getStockBebidas() { return stockBebidas; }
    public void setStockBebidas(HashMap<Bebida, Integer> stockBebidas) { this.stockBebidas=stockBebidas; }
    public HashSet<Bebida> getBebidas() { return bebidas; }
    public void setBebidas(HashSet<Bebida> bebidas) { this.bebidas=bebidas; }
    public HashSet<Persona> getPersonas() { return personas; }
    public void setPersonas(HashSet<Persona> personas) { this.personas=personas; }
}