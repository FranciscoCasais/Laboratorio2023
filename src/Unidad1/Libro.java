package Unidad1;
public class Libro {
    private int cantidadPaginas;
    private Fecha fechaPublicacion;
    private Persona autor;
    private String editorial,ISBN,titulo;
    public Libro() {
        cantidadPaginas=100;
        fechaPublicacion=new Fecha(2023,15,3);
        autor.setEdad(40);
        autor.setDireccion("Av. de los Constituyentes 5880");
        autor.setNombre("Carlos Fernández");
        editorial="Planeta";
        ISBN="237-982-3753-29-8";
        titulo="El hechizo del agua";
    }
    public Libro(int cantidadPaginas,Fecha fechaPublicacion,String editorial,String ISBN,String titulo) {
        this.cantidadPaginas=cantidadPaginas;
        this.fechaPublicacion=fechaPublicacion;
        this.editorial=editorial;
        this.ISBN=ISBN;
        this.titulo=titulo;
    }
    public Libro(Persona autor) {
        this.autor=autor;
    }
}