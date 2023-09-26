package EjerciciosInterfaces.SistemaIntercambio;
import java.time.Year;
public abstract class LibroDeTexto extends Articulo {
    private int codigo;
    private String titulo;
    private Year anioPublicacion;
    public LibroDeTexto() {
        codigo=0;
        titulo="";
        anioPublicacion=null;
    }
    public LibroDeTexto(int codigo,String titulo,Year anioPublicacion) {
        this.codigo=codigo;
        this.titulo=titulo;
        this.anioPublicacion=anioPublicacion;
    }
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo=codigo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo=titulo; }
    public Year getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(Year anioPublicacion) { this.anioPublicacion=anioPublicacion; }
}