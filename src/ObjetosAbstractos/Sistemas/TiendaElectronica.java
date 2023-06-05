package ObjetosAbstractos.Sistemas;
import ObjetosFisicos.Componentes.Componente;
import ObjetosFisicos.Componentes.EquipoSonido;
import ObjetosFisicos.Componentes.Portatil;
import ObjetosFisicos.Componentes.Televisor;
import java.util.ArrayList;
import java.util.Scanner;
public class TiendaElectronica {
    private ArrayList<Componente> productos;
    public TiendaElectronica() { productos=new ArrayList<>(); }
    public ArrayList<Componente> getProductos() { return productos; }
    public void setProductos(ArrayList<Componente> productos) { this.productos=productos; }
    public void agregarProducto(Componente producto) { productos.add(producto); }
    public void eliminarProducto(Componente producto) {
        int indice=hallarProducto(productos,producto);
        if(indice==-1) { System.out.println("\nNo se encontró el producto a eliminar."); }
        else { productos.remove(indice); }
    }
    public void modificarProducto(Componente producto) {
        int cantidadOpciones,indice=hallarProducto(productos,producto),respuesta;
        Scanner entrada=new Scanner(System.in);
        if(indice==-1) {
            System.out.println("\nNo se encontró el producto a modificar.");
            return;
        }
        do {
            System.out.println("\nIngrese el dígito correspondiente al campo a modificar:\n\n1. Precio\n2. Stock\n3. Modelo\n4. Nombre de fabricante");
            if(producto instanceof Portatil) {
                cantidadOpciones=6;
                System.out.println("5. Número de cargas");
            } else if(producto instanceof EquipoSonido) {
                cantidadOpciones=6;
                System.out.println("5. Bluetooth");
            } else {
                cantidadOpciones=7;
                System.out.println("5. Resolución (pixeles)\n6. Tecnología");
            }
            System.out.println(cantidadOpciones+". Terminar\n");
            respuesta=entrada.nextInt();
            while(respuesta<1 || respuesta>cantidadOpciones) {
                System.out.println("\nDígito no válido, intente nuevamente:");
                respuesta=entrada.nextInt();
            }
            switch(respuesta) {
                case 1:
                    productos.get(indice).setPrecio(modificarPrecio(entrada));
                    break;
                case 2:
                    productos.get(indice).setStock(modificarStock(entrada));
                    break;
                case 3:
                    productos.get(indice).setModelo(modificarModelo(entrada));
                    break;
                case 4:
                    productos.get(indice).setNombreFabricante(modificarNombreFabricante(entrada));
                    break;
                case 5:
                    if(producto instanceof Portatil) {
                        ((Portatil)productos.get(indice)).setNumeroCargas(modificarNumeroCargas(entrada));
                    } else if(producto instanceof EquipoSonido) {
                        if(((EquipoSonido)producto).getBluetooth()) {
                            ((EquipoSonido)productos.get(indice)).setBluetooth(false);
                            System.out.println("\nSe modificó el uso de bluetooth del equipo de verdadero a falso.");
                        } else {
                            ((EquipoSonido)productos.get(indice)).setBluetooth(true);
                            System.out.println("\nSe modificó el uso de bluetooth del equipo de falso a verdadero.");
                        }
                    } else { ((Televisor)productos.get(indice)).setResolucion(modificarResolucion(entrada)); }
                    break;
                case 6:
                    ((Televisor)productos.get(indice)).setTecnologia(modificarTecnologia(entrada));
                    break;
            }
        } while(respuesta<cantidadOpciones);
    }
    public void productoMayorMenorStock() {
        if(productos.size()==0) {
            System.out.println("\nNo hay productos cargados en el sistema.");
            return;
        } else {
            int indiceMayor=0,indiceMenor=0,mayorStock=productos.get(0).getStock(),menorStock=productos.get(0).getStock();
            for(int i=1;i<productos.size();i++) {
                if(productos.get(i).getStock()>mayorStock) {
                    indiceMayor=i;
                    mayorStock=productos.get(i).getStock();
                } else if(productos.get(i).getStock()<menorStock) {
                    indiceMenor=i;
                    menorStock=productos.get(i).getStock();
                }
            }
            System.out.println("\nEl producto con mayor stock es:\n"+productos.get(indiceMayor).getModelo()+"\nStock: "+productos.get(indiceMayor).getStock()+"\n\nEl producto con menor stock es:\n"+productos.get(indiceMenor).getModelo()+"\nStock: "+productos.get(indiceMenor).getStock());
        }
    }
    public static int hallarProducto(ArrayList<Componente> productos,Componente producto) {
        for(int i=0;i<productos.size();i++) {
            if(productos.get(i).equals(producto)) { return i; }
        }
        return -1;
    }
    public static int modificarNumeroCargas(Scanner entrada) {
        int nuevaNumeroCargas;
        System.out.println("\nIngrese la nueva cantidad de cargas:");
        nuevaNumeroCargas=entrada.nextInt();
        while(nuevaNumeroCargas<1) {
            System.out.println("\nValor no válido, intente nuevamente:");
            nuevaNumeroCargas=entrada.nextInt();
        }
        System.out.println("\nSe modificó la cantidad de cargas.");
        return nuevaNumeroCargas;
    }
    public static double modificarPrecio(Scanner entrada) {
        double nuevoPrecio;
        System.out.println("\nIngrese el nuevo precio:");
        nuevoPrecio=entrada.nextDouble();
        while(nuevoPrecio<0.00) {
            System.out.println("\nPrecio no válido, intente nuevamente:");
            nuevoPrecio=entrada.nextDouble();
        }
        System.out.println("\nSe modificó el precio.");
        return nuevoPrecio;
    }
    public static int modificarResolucion(Scanner entrada) {
        int nuevaResolucion;
        System.out.println("\nIngrese la nueva resolución:");
        nuevaResolucion=entrada.nextInt();
        while(nuevaResolucion<1080) {
            System.out.println("\nValor no válido, intente nuevamente:");
            nuevaResolucion=entrada.nextInt();
        }
        System.out.println("\nSe modificó la cantidad de cargas.");
        return nuevaResolucion;
    }
    public static int modificarStock(Scanner entrada) {
        int nuevoStock;
        System.out.println("\nIngrese el nuevo stock:");
        nuevoStock=entrada.nextInt();
        while(nuevoStock<0) {
            System.out.println("\nStock no válido, intente nuevamente:");
            nuevoStock=entrada.nextInt();
        }
        System.out.println("\nSe modificó el stock.");
        return nuevoStock;
    }
    public static String modificarModelo(Scanner entrada) {
        String nuevoModelo;
        System.out.println("\nIngrese el nuevo modelo:");
        entrada.nextLine();
        nuevoModelo=entrada.nextLine();
        System.out.println("\nSe modificó el modelo.");
        return nuevoModelo;
    }
    public static String modificarNombreFabricante(Scanner entrada) {
        String nuevoNombreFabricante;
        System.out.println("\nIngrese el nuevo nombre del fabricante:");
        entrada.nextLine();
        nuevoNombreFabricante=entrada.nextLine();
        System.out.println("\nSe modificó el nombre del fabricante.");
        return nuevoNombreFabricante;
    }
    public static Tecnologia modificarTecnologia(Scanner entrada) {
        int respuesta;
        Tecnologia nuevaTecnologia;
        System.out.println("\nIngrese la nueva tecnología:\n\n1. FullHD\n2. UltraHD\n3. 4K");
        respuesta=entrada.nextInt();
        while(respuesta<1 || respuesta>3) {
            System.out.println("\nDígito no válido, intente nuevamente:");
            respuesta=entrada.nextInt();
        }
        switch(respuesta) {
            case 1:
                nuevaTecnologia=Tecnologia.FULL;
                break;
            case 2:
                nuevaTecnologia=Tecnologia.ULTRA;
                break;
            default:
                nuevaTecnologia=Tecnologia.CUATROK;
                break;
        }
        System.out.println("\nSe modificó la tecnología.");
        return nuevaTecnologia;
    }
}