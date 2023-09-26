package EjerciciosInterfaces.SistemaIntercambio;
import java.util.*;
public class Sistema {
    private HashSet<Articulo> articulos;
    public Sistema() { articulos=new HashSet<>(); }
    public Sistema(HashSet<Articulo> articulos) { this.articulos=articulos; }
    public HashSet<Articulo> getArticulos() { return articulos; }
    public void setArticulos(HashSet<Articulo> articulos) { this.articulos=articulos; }
    public static void main(String[] args) {
        
    }
}