package ManejoExcepciones.BibliotecaVirtual;

public class LibroElectronico {
    private String titulo;
    private Genero genero;
    private Autor autor;
    private String nombreArchivo;
    private static int descargasDisponibles = 5;

    public LibroElectronico(String titulo, Genero genero, Autor autor, String nombreArchivo) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.nombreArchivo = nombreArchivo;
    }
    public LibroElectronico() {
        this.titulo = "";
        this.genero = null;
        this.autor = new Autor();
        this.nombreArchivo = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public static int getDescargasDisponibles() {
        return descargasDisponibles;
    }

    public static void setDescargasDisponibles(int descargasDisponibles) {
        LibroElectronico.descargasDisponibles = descargasDisponibles;
    }

}
