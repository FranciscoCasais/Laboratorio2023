package EjerciciosInterfaces.SistemaIntercambio;
import java.util.*;
public class Sistema {
    private HashMap<Prestable,Coleccionista> devoluciones;
    private HashMap<Prestable,Coleccionista> prestamos;
    private HashSet<Coleccionista> coleccionistas;
    private HashSet<Prestable> prestables;
    public Sistema() {
        devoluciones=new HashMap<>();
        prestables=new HashSet<>();
        coleccionistas=new HashSet<>();
        prestables=new HashSet<>();
    }
    public Sistema(HashMap<Prestable,Coleccionista> devoluciones,HashMap<Prestable,Coleccionista> prestamos,HashSet<Coleccionista> coleccionistas,HashSet<Prestable> prestables) {
        this.devoluciones=devoluciones;
        this.prestamos=prestamos;
        this.coleccionistas=coleccionistas;
        this.prestables=prestables;
    }
    public HashMap<Prestable,Coleccionista> getDevoluciones() { return devoluciones; }
    public void setDevoluciones(HashMap<Prestable, Coleccionista> devoluciones) { this.devoluciones=devoluciones; }
    public HashMap<Prestable, Coleccionista> getPrestamos() { return prestamos; }
    public void setPrestamos(HashMap<Prestable, Coleccionista> prestamos) { this.prestamos=prestamos; }
    public HashSet<Coleccionista> getColeccionistas() { return coleccionistas; }
    public void setColeccionistas(HashSet<Coleccionista> coleccionistas) { this.coleccionistas=coleccionistas; }
    public HashSet<Prestable> getPrestables() { return prestables; }
    public void setPrestables(HashSet<Prestable> prestables) { this.prestables=prestables; }
    public static void main(String[] args) {
        int respuesta;
        Scanner entrada=new Scanner(System.in);
        do {
            System.out.print("1. Prestar artículo\n2. Agregar artículo\n3. Salir\n\nIngrese el dígito correspondiente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
            while(respuesta<1 || respuesta>3) {
                System.out.print("\nEntrada no válida, intente nuevamente: ");
                respuesta=entrada.nextInt();
                entrada.nextLine();
            }
        } while(respuesta!=3);
    }
}