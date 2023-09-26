package EjerciciosInterfaces.SistemaIntercambio;
public interface Prestable {
    default void agregarElemento(Articulo articulo) {
        if(articulo.cumpleCondicionesPrestar()) System.out.println("El artículo ingresado puede ingresar al circuito de préstamos.");
        else System.out.println("El articulo ingresado no podrá ingresar a nuestro sistema.");
    }
    void prestar();
}