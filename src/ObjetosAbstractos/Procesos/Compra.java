package ObjetosAbstractos.Procesos;
import ObjetosFisicos.Componentes.CPU;
import ObjetosFisicos.Componentes.Componente;
import ObjetosFisicos.Componentes.Entrada;
import ObjetosFisicos.Componentes.Salida;
import ObjetosFisicos.MetodosPago.Efectivo;
import ObjetosFisicos.MetodosPago.Tarjeta;
import SeresHumanos.Cliente;
import java.util.ArrayList;
import java.util.Scanner;
public class Compra {
    private Cliente cliente;
    private ArrayList<Componente> carrito,componentes;
    public Compra() {
        cliente=new Cliente();
        carrito=new ArrayList<>();
        componentes=new ArrayList<>();
    }
    public Cliente getCliente() { return cliente; }
    public ArrayList<Componente> getCarrito() { return carrito; }
    public ArrayList<Componente> getComponentes() { return componentes; }
    public void setCliente(Cliente cliente) { this.cliente=cliente; }
    public void setCarrito(ArrayList<Componente> carrito) { this.carrito=carrito; }
    public void setComponentes(ArrayList<Componente> componentes) { this.componentes=componentes; }
    public boolean componentesMinimos() {
        boolean cpu=false,entrada=false,salida=false;
        for(Componente componente:carrito) {
            if(componente instanceof CPU) { cpu=true; }
            else if(componente instanceof Entrada) { entrada=true; }
            else if(componente instanceof Salida) { salida=true; }
        }
        if(cpu && entrada && salida) { return true; }
        else { return false; }
    }
    public boolean cpuIncluido(ArrayList<Componente> componentesCompra) {
        for(Componente componente:componentesCompra) { if(componente instanceof CPU) { return true; } }
        return false;
    }
    public static void agregarCPU(ArrayList<Componente> carrito,ArrayList<Componente> componentes,int respuesta,Scanner entrada) {
        ArrayList<Componente> cpus=new ArrayList<>();
        System.out.println("\nElija su CPU:\n");
        for(int i=0;i<componentes.size();i++) {
            if(componentes.get(i) instanceof CPU && componentes.get(i).getStock()>0) { cpus.add(componentes.get(i)); }
            System.out.println((i+1)+". "+cpus.get(i).getModelo()+" "+cpus.get(i).getNombreFabricante()+": $"+cpus.get(i).getPrecio());
        }
        validarRespuesta(cpus.size(),respuesta,entrada);
        carrito.add(cpus.get(respuesta));
        cpus.get(respuesta).setStock(cpus.get(respuesta).getStock()-1);
        System.out.println("\nEl CPU se añadió al carrito de compra.\n");
    }
    public static void agregarPeriferico(ArrayList<Componente> carrito,ArrayList<Componente> componentes,int respuesta,Scanner entrada) {
        ArrayList<Componente> perifericos=new ArrayList<>();
        System.out.println("\nElija su periférico:\n");
        for(int i=0;i<componentes.size();i++) {
            if((componentes.get(i) instanceof Entrada || componentes.get(i) instanceof Salida) && componentes.get(i).getStock()>0) { perifericos.add(componentes.get(i)); }
            System.out.println((i+1)+". "+perifericos.get(i).getModelo()+" "+perifericos.get(i).getNombreFabricante()+": $"+perifericos.get(i).getPrecio());
        }
        validarRespuesta(perifericos.size(),respuesta,entrada);
        carrito.add(perifericos.get(respuesta));
        perifericos.get(respuesta).setStock(perifericos.get(respuesta).getStock()-1);
        System.out.println("\nEl periférico se añadío al carrito de compra.\n");
    }
    public static void agregarOtroComponente(ArrayList<Componente> carrito,ArrayList<Componente> componentes,int respuesta,Scanner entrada) {
        ArrayList<Componente> otrosComponentes=new ArrayList<>();
        System.out.println("\nElija su componente:\n");
        for(int i=0;i<componentes.size();i++) {
            if(!(componentes.get(i) instanceof CPU || componentes.get(i) instanceof Entrada || componentes.get(i) instanceof Salida) && componentes.get(i).getStock()>0) { otrosComponentes.add(componentes.get(i)); }
            System.out.println((i+1)+". "+otrosComponentes.get(i).getModelo()+" "+otrosComponentes.get(i).getNombreFabricante()+": $"+otrosComponentes.get(i).getPrecio());
        }
        validarRespuesta(otrosComponentes.size(),respuesta,entrada);
        carrito.add(otrosComponentes.get(respuesta));
        otrosComponentes.get(respuesta).setStock(otrosComponentes.get(respuesta).getStock()-1);
        System.out.println("\nEl componente se añadío al carrito de compra.\n");
    }
    public void agregarComponente(boolean cpu,boolean periferico,Scanner entrada) {
        int respuesta=0;
        if(cpu) { agregarCPU(componentes,carrito,respuesta,entrada); }
        else if(periferico) { agregarPeriferico(componentes,carrito,respuesta,entrada); }
        else { agregarOtroComponente(componentes,carrito,respuesta,entrada); }
    }
    public static double calcularMontoTotal(ArrayList<Componente> carrito) {
        double montoTotal=0.00;
        for(Componente componente:carrito) { montoTotal+=componente.getPrecio(); }
        return montoTotal;
    }
    public void mostrarCarrito() {
        System.out.println("\nEstado actual del carrito:\n");
        for(Componente componente:carrito) {
            System.out.println(componente.getModelo()+" "+componente.getNombreFabricante()+": $"+componente.getPrecio());
        }
        System.out.println("\nTotal actual: $"+calcularMontoTotal(carrito));
    }
    public void quitarComponente(Scanner entrada) {
        int respuesta=0;
        System.out.println("\nElija el componente para quitar del carrito de compra:\n");
        for(int i=0;i<carrito.size();i++) { System.out.println((i+1)+". "+carrito.get(i).getModelo()+" "+carrito.get(i).getNombreFabricante()+": $"+carrito.get(i).getPrecio()); }
        validarRespuesta(carrito.size(),respuesta,entrada);
        carrito.get(respuesta).setStock(carrito.get(respuesta).getStock()+1);
        carrito.remove(respuesta);
        System.out.println("\nSe quitó el componente del carrito del compra.\n");
    }
    public static void validarRespuesta(int numeroOpciones,int respuesta,Scanner entrada) {
        System.out.println("\nIngrese el dígito correspondiente:");
        respuesta=entrada.nextInt();
        while(respuesta<1 || respuesta>numeroOpciones) {
            System.out.println("\nDígito no válido, intente nuevamente:");
            respuesta=entrada.nextInt();
        }
    }
    public static void main(String[] args) {
        boolean finalizar=false;
        Cliente cliente=new Cliente();
        Compra compra=new Compra();
        int respuesta=0;
        Scanner entrada=new Scanner(System.in);
        do {
            System.out.println("Por favor elija sus componentes:\n\n1. Agregar CPU\n2. Agregar periférico\n3. Agregar otros componente\n4. Quitar componente\n5. Finalizar\n");
            if(compra.getCarrito().size()>0) {
                compra.mostrarCarrito();
            }
            validarRespuesta(5,respuesta,entrada);
            switch(respuesta) {
                case 1:
                    if(compra.cpuIncluido(compra.getCarrito())) { System.out.println("\nYa se encuentra un CPU en el carrito de compra; para elegir otro, elimine el CPU actual."); }
                    else { compra.agregarComponente(true,false,entrada); }
                    break;
                case 2:
                    compra.agregarComponente(false,true,entrada);
                    break;
                case 3:
                    compra.agregarComponente(false,false,entrada);
                    break;
                case 4:
                    compra.quitarComponente(entrada);
                    break;
                default:
                    if(compra.componentesMinimos()) { finalizar=true; }
                    else { System.out.println("\nLos componentes mínimos requeridos para realizar la compra son 1 CPU, 1 dispositivo de entrada y 1 dispositivo de salida.\n"); }
                    break;
            }
        } while(!finalizar);
        System.out.println("\nUsted está a punto de realizar la compra de:");
        compra.mostrarCarrito();
        System.out.println("\nPor favor rellene el formulario con sus datos:\n\nApellido:");
        entrada.nextLine();
        cliente.setApellido(entrada.nextLine());
        System.out.println("\nNombre:");
        cliente.setNombre(entrada.nextLine());
        System.out.println("\nTeléfono:");
        cliente.setTelefono(entrada.nextLine());
        System.out.println("\nSeleccione su método de pago:\n\n1. Efectivo\n2. Tarjeta (recargo del 5%)\n");
        validarRespuesta(2,respuesta,entrada);
        if(respuesta==1) {
            Efectivo efectivo=new Efectivo();
            efectivo.setMonto(calcularMontoTotal(compra.getCarrito()));
        } else {
            Tarjeta tarjeta=new Tarjeta();
            System.out.println("\nPor favor ingrese los datos de su tarjeta:\n\n1. Crédito\n2. Débito\n");
            validarRespuesta(2,respuesta,entrada);
            if(respuesta==1) {
                tarjeta.setCredito(true);
                tarjeta.setDebito(false);
            } else {
                tarjeta.setCredito(false);
                tarjeta.setDebito(true);
            }
            System.out.println("\nNúmero:");
            tarjeta.setNumero(entrada.nextInt());
            System.out.println("\nBanco:");
            entrada.nextLine();
            tarjeta.setBanco(entrada.nextLine());
            tarjeta.setMonto(calcularMontoTotal(compra.getCarrito())*1.05);
        }
        System.out.println("\nOperación realiada con éxito:");
        compra.mostrarCarrito();
        System.out.println("\n¡Muchas gracias por su compra!");
    }
}