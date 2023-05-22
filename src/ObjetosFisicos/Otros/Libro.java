package ObjetosFisicos.Otros;
import Tiempo.Fecha;
import SeresHumanos.Persona;
public class Libro {
    private Editorial editorial;
    private Fecha fechaPublicacion;
    private int cantidadPaginas;
    private long isbn;
    private Persona autor;
    private String titulo;
    public Libro() {
        cantidadPaginas=100;
        fechaPublicacion=new Fecha(2023, 15, 3);
        autor=new Persona();
        editorial=Editorial.KAPELUSZ;
        isbn=237982993;
        titulo="El hechizo del agua";
    }
    public Libro(int cantidadPaginas,long ISBN,Fecha fechaPublicacion,Editorial editorial,String titulo) {
        this.cantidadPaginas=cantidadPaginas;
        this.fechaPublicacion=fechaPublicacion;
        this.editorial=editorial;
        this.isbn=ISBN;
        this.titulo=titulo;
    }
    public Libro(Persona autor) {
        this.autor=autor;
    }
    public int getCantidadPaginas() {
        return cantidadPaginas;
    }
    public Fecha getFechaPublicacion() {
        return fechaPublicacion;
    }
    public Persona getAutor() {
        return autor;
    }
    public Editorial getEditorial() {
        return editorial;
    }
    public long getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas=cantidadPaginas;
    }
    public void fechaPublicacion(Fecha fechaPublicacion) {
        this.fechaPublicacion=fechaPublicacion;
    }
    public void setAutor(Persona autor) {
        this.autor=autor;
    }
    public void setEditorial(Editorial editorial) {
        this.editorial=editorial;
    }
    public void setIsbn(int isbn) {
        this.isbn=isbn;
    }
    public void setTitulo(String titulo) {
        this.titulo=titulo;
    }
    public void mostrarInfoLibro() { System.out.println("Título: "+titulo+"\nAutor: "+autor.getNombre()+" "+autor.getApellido()+"\nEditorial: "+editorial+"\nISBN: "+isbn+"\nFecha de publicación: "+fechaPublicacion.getDia()+"/"+fechaPublicacion.getMes()+"/"+fechaPublicacion.getAnio()+"\nCantidad de páginas: "+cantidadPaginas); }
    public boolean compararFechaPublicacion(Fecha fechaPublicacion) {
        if(this.fechaPublicacion.menorQue(fechaPublicacion)) { return true; }
        else { return false; }
    }
}