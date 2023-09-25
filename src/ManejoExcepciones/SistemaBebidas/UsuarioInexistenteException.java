package ManejoExcepciones.SistemaBebidas;
public class UsuarioInexistenteException extends Exception {
    public UsuarioInexistenteException(String mensaje) { super(mensaje); }
}