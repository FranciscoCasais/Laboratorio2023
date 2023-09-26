package EjerciciosInterfaces.SistemaIntercambio;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;
public class Libro extends LibroDeTexto implements Prestable {
    private HashMap<String,Integer> paginasPorCapitulo;
    public Libro() {
        super();
        paginasPorCapitulo=new HashMap<>();
    }
    public Libro(HashMap<String,Integer> paginasPorCapitulo,int codigo,String titulo,Year anioPublicacion) {
        super(codigo,titulo,anioPublicacion);
        this.paginasPorCapitulo=paginasPorCapitulo;
    }
    public HashMap<String,Integer> getPaginasPorCapitulo() { return paginasPorCapitulo; }
    public void setPaginasPorCapitulo(HashMap<String, Integer> paginasPorCapitulo) { this.paginasPorCapitulo=paginasPorCapitulo; }
    @Override
    public boolean cumpleCondicionesPrestar() { return paginasPorCapitulo.size()%2==1; }
    @Override
    public String toString() {
        String paginasPorCapituloString="";
        for(Map.Entry<String,Integer> entrada:paginasPorCapitulo.entrySet()) {
            paginasPorCapituloString+=entrada.getKey()+": "+entrada.getValue()+" páginas\n";
        }
        return "Código: "+getCodigo()+"\nTítulo: "+getTitulo()+"\nAño de publicación: "+getAnioPublicacion().getValue()+"\nPáginas por capítulo:\n"+paginasPorCapituloString;
    }
    @Override
    public void prestar() {
        if(cumpleCondicionesPrestar()) System.out.println("El libro se dará prestado.");
        else System.out.println("El libro no se prestará.");
    }
}