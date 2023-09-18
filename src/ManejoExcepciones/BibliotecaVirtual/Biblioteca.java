package ManejoExcepciones.BibliotecaVirtual;

import java.util.HashSet;

public class Biblioteca {
    private HashSet<Autor> autores;
    private HashSet<LibroElectronico> librosElectronicos;
    private HashSet<Usuario> usuarios;

    public Biblioteca(HashSet<Autor> autores, HashSet<LibroElectronico> librosElectronicos, HashSet<Usuario> usuarios) {
        this.autores = autores;
        this.librosElectronicos = librosElectronicos;
        this.usuarios = usuarios;
    }
    public Biblioteca() {
        this.autores = new HashSet<>();
        this.librosElectronicos = new HashSet<>();
        this.usuarios = new HashSet<>();
    }

    public HashSet<Autor> getAutores() {
        return autores;
    }

    public void setAutores(HashSet<Autor> autores) {
        this.autores = autores;
    }

    public HashSet<LibroElectronico> getLibrosElectronicos() {
        return librosElectronicos;
    }

    public void setLibrosElectronicos(HashSet<LibroElectronico> librosElectronicos) {
        this.librosElectronicos = librosElectronicos;
    }

    public HashSet<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashSet<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public void pedirLibroPrestado(LibroElectronico libroPedido, Usuario usuarioConTrastornoHistrionicoDeLaPersonalidad) {
        int contador = 0;
        for (Usuario usuario : usuarios) if (usuario.getLibrosPrestados().contains(libroPedido)) contador++;
        try {
            if (contador >= LibroElectronico.getDescargasDisponibles()) throw new LimiteDePrestamosAlcanzadoException("Se alcanzó el límite de préstamos.");
            else if (usuarioConTrastornoHistrionicoDeLaPersonalidad.getMembresia().equals(Membresia.ORO) && usuarioConTrastornoHistrionicoDeLaPersonalidad.getLibrosPrestados().size() >= 50 || usuarioConTrastornoHistrionicoDeLaPersonalidad.getMembresia().equals(Membresia.PLATA) && usuarioConTrastornoHistrionicoDeLaPersonalidad.getLibrosPrestados().size() >= 15 || usuarioConTrastornoHistrionicoDeLaPersonalidad.getMembresia().equals(Membresia.BRONCE) && usuarioConTrastornoHistrionicoDeLaPersonalidad.getLibrosPrestados().size() >= 5) throw new MembresiaException("Se alcanzó el límite de libros que podés tomar prestados con tu membresía.");
            else usuarioConTrastornoHistrionicoDeLaPersonalidad.getLibrosPrestados().add(libroPedido);
        } catch (LimiteDePrestamosAlcanzadoException | MembresiaException e){
            System.err.println(e);
            e.printStackTrace();
        }
    }
    public void devolverLibro(LibroElectronico libroElectronico, Usuario usuarioConTrastornoCleptomano){
        usuarioConTrastornoCleptomano.getLibrosPrestados().remove(libroElectronico);
    }
}
