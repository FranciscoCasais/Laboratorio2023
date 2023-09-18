package ManejoExcepciones.BibliotecaVirtual;

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario(Membresia.BRONCE);
        Usuario usuario2 = new Usuario(Membresia.ORO);
        Usuario usuario3 = new Usuario(Membresia.PLATA);
        Usuario usuario4 = new Usuario(Membresia.PLATA);
        Usuario usuario5 = new Usuario(Membresia.ORO);
        Usuario usuario6 = new Usuario(Membresia.BRONCE);
        LibroElectronico libroElectronico1 = new LibroElectronico();
        LibroElectronico libroElectronico2 = new LibroElectronico();
        LibroElectronico libroElectronico3 = new LibroElectronico();
        LibroElectronico libroElectronico4 = new LibroElectronico();
        LibroElectronico libroElectronico5 = new LibroElectronico();
        LibroElectronico libroElectronico6 = new LibroElectronico();
        LibroElectronico libroElectronico7 = new LibroElectronico();
        Autor autor1 = new Autor();
        Autor autor2 = new Autor();
        Autor autor3 = new Autor();
        Autor autor4 = new Autor();
        Autor autor5 = new Autor();
        Autor autor6 = new Autor();
        Autor autor7 = new Autor();
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.getAutores().add(autor1);
        biblioteca.getAutores().add(autor2);
        biblioteca.getAutores().add(autor3);
        biblioteca.getAutores().add(autor4);
        biblioteca.getAutores().add(autor5);
        biblioteca.getAutores().add(autor6);
        biblioteca.getAutores().add(autor7);
        biblioteca.getUsuarios().add(usuario1);
        biblioteca.getUsuarios().add(usuario2);
        biblioteca.getUsuarios().add(usuario3);
        biblioteca.getUsuarios().add(usuario4);
        biblioteca.getUsuarios().add(usuario5);
        biblioteca.getUsuarios().add(usuario6);
        biblioteca.getLibrosElectronicos().add(libroElectronico1);
        biblioteca.getLibrosElectronicos().add(libroElectronico2);
        biblioteca.getLibrosElectronicos().add(libroElectronico3);
        biblioteca.getLibrosElectronicos().add(libroElectronico4);
        biblioteca.getLibrosElectronicos().add(libroElectronico5);
        biblioteca.getLibrosElectronicos().add(libroElectronico6);
        biblioteca.getLibrosElectronicos().add(libroElectronico7);

        biblioteca.pedirLibroPrestado(libroElectronico1, usuario1);
        biblioteca.pedirLibroPrestado(libroElectronico6, usuario2);
        biblioteca.pedirLibroPrestado(libroElectronico4, usuario3);
        biblioteca.pedirLibroPrestado(libroElectronico4, usuario4);
        biblioteca.pedirLibroPrestado(libroElectronico5, usuario5);
        biblioteca.pedirLibroPrestado(libroElectronico3, usuario5);
        biblioteca.pedirLibroPrestado(libroElectronico3, usuario4);
        biblioteca.pedirLibroPrestado(libroElectronico3, usuario3);
        biblioteca.pedirLibroPrestado(libroElectronico3, usuario2);
        biblioteca.pedirLibroPrestado(libroElectronico3, usuario1);
        biblioteca.pedirLibroPrestado(libroElectronico3, usuario6);

        System.out.println(usuario1.getLibrosPrestados().size());
        biblioteca.devolverLibro(libroElectronico1, usuario1);
        System.out.println(usuario1.getLibrosPrestados().size());
    }
}
