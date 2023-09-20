package ManejoExcepciones.SistemaBebidas;
import Tiempo.Fecha;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Sistema {
    private HashMap<Bebida,Integer> stockBebidas;
    private HashSet<Consumidor> consumidores;
    public Sistema() {
        stockBebidas=new HashMap<>();
        consumidores=new HashSet<>();
    }
    public Sistema(HashMap<Bebida,Integer> stockBebidas,HashSet<Consumidor> consumidores) {
        this.stockBebidas=stockBebidas;
        this.consumidores=consumidores;
    }
    public HashMap<Bebida,Integer> getStockBebidas() { return stockBebidas; }
    public void setStockBebidas(HashMap<Bebida, Integer> stockBebidas) { this.stockBebidas=stockBebidas; }
    public HashSet<Consumidor> getConsumidores() { return consumidores; }
    public void setConsumidores(HashSet<Consumidor> consumidores) { this.consumidores=consumidores; }
    public Bebida encontrarBebida(String nombre) {
        for(Bebida bebida:stockBebidas.keySet()) {
            if(bebida.getNombre().equals(nombre)) return bebida;
        }
        return null;
    }
    public Consumidor encontrarConsumidor(int dni) {
        for(Consumidor consumidor:consumidores) {
            if(consumidor.getDni()==dni) return consumidor;
        }
        return null;
    }
    public Consumidor mejorCoeficiente() {
        Consumidor mejorConsumidor=null;
        for(Consumidor consumidor:consumidores) {
            if(mejorConsumidor==null) mejorConsumidor=consumidor;
            else if(consumidor.coeficienteHidratacion()>mejorConsumidor.coeficienteHidratacion()) mejorConsumidor=consumidor;
        }
        return mejorConsumidor;
    }
    public Consumidor peorCoeficiente() {
        Consumidor peorConsumidor=null;
        for(Consumidor consumidor:consumidores) {
            if(peorConsumidor==null) peorConsumidor=consumidor;
            else if(consumidor.coeficienteHidratacion()<peorConsumidor.coeficienteHidratacion()) peorConsumidor=consumidor;
        }
        return peorConsumidor;
    }
    public void consumirBebida(int cantidad,int dni,String nombreBebida) {
        Bebida bebida=encontrarBebida(nombreBebida);
        Consumidor consumidor=encontrarConsumidor(dni);
        if(bebida==null) {  }
        else if(consumidor==null) {  }
        else if(stockBebidas.get(bebida)-cantidad<0) {  }
        else if(consumidor.getBebidasConsumidas().containsKey(bebida)) consumidor.getBebidasConsumidas().put(bebida,consumidor.getBebidasConsumidas().get(bebida)+cantidad);
        else consumidor.getBebidasConsumidas().put(bebida,cantidad);
        stockBebidas.put(bebida,stockBebidas.get(bebida)-cantidad);
        System.out.println("\nBebida consumida exitosamente.\n");
    }
    public void mostrarCoeficientesHidratacion() {
        System.out.print("\n");
        for(Consumidor consumidor:consumidores) System.out.println(consumidor.getNombre()+" "+consumidor.getApellido()+": "+consumidor.coeficienteHidratacion());
        System.out.print("\n");
    }
    public static void main(String[] args) {
        int respuesta;
        Scanner entrada=new Scanner(System.in);

        Alcoholica alcoholica1=new Alcoholica(2,"Heineken");
        Alcoholica alcoholica2=new Alcoholica(10,"Jack Daniels");
        Alcoholica alcoholica3=new Alcoholica(5,"Dadá");
        Azucarada azucarada1=new Azucarada(8,"CocaCola");
        Azucarada azucarada2=new Azucarada(10,"Monster");
        Azucarada azucarada3=new Azucarada(3,"Levité");
        Neutra neutra1=new Neutra(0,10,"Agua");
        HashMap<Bebida,Integer> bebidasConsumidas=new HashMap<>(),stockBebidas=new HashMap<>();
        stockBebidas.put(alcoholica1,10);
        stockBebidas.put(alcoholica2,10);
        stockBebidas.put(alcoholica3,10);
        stockBebidas.put(azucarada1,10);
        stockBebidas.put(azucarada2,10);
        stockBebidas.put(azucarada3,10);
        stockBebidas.put(neutra1,10);

        bebidasConsumidas.put(alcoholica2,1);
        bebidasConsumidas.put(alcoholica3,2);
        bebidasConsumidas.put(neutra1,1);
        Consumidor c1=new Consumidor(new Fecha(),bebidasConsumidas,1,"Santi","Daniel");
        bebidasConsumidas=new HashMap<>();
        bebidasConsumidas.put(azucarada1,5);
        bebidasConsumidas.put(azucarada2,2);
        bebidasConsumidas.put(azucarada3,3);
        Consumidor c2=new Consumidor(new Fecha(),bebidasConsumidas,2,"Holm","Pela");
        bebidasConsumidas=new HashMap<>();
        bebidasConsumidas.put(alcoholica1,1);
        bebidasConsumidas.put(neutra1,3);
        Consumidor c3=new Consumidor(new Fecha(),bebidasConsumidas,3,"Mochi","Broco");

        HashSet<Consumidor> consumidores=new HashSet<>();
        consumidores.add(c1);
        consumidores.add(c2);
        consumidores.add(c3);

        Sistema sistema=new Sistema(stockBebidas,consumidores);
        do {
            System.out.print("1. Ver todos los coeficientes de hidratación\n2. Ver mejor y peor\n3. Consumir bebida\n4. Salir\n\nIngrese el dígito correspondiente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
            while(respuesta<1 || respuesta>4) {
                System.out.print("Entrada no válida, intente nuevamente: ");
                respuesta=entrada.nextInt();
                entrada.nextLine();
            }
            switch(respuesta) {
                case 1:
                    sistema.mostrarCoeficientesHidratacion();
                    break;
                case 2:
                    Consumidor mejorConsumidor=sistema.mejorCoeficiente(),peorConsumidor=sistema.peorCoeficiente();
                    System.out.println("\nConsumidor con mejor coeficiente de hidratación:\n"+mejorConsumidor.getNombre()+" "+mejorConsumidor.getApellido()+": "+mejorConsumidor.coeficienteHidratacion()+"\n\nConsumidor con peor coeficiente de hidratación:\n"+peorConsumidor.getNombre()+" "+peorConsumidor.getApellido()+": "+peorConsumidor.coeficienteHidratacion()+"\n");
                    break;
                case 3:
                    System.out.print("\nIngrese su DNI: ");
                    int dni=entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Ingrese el nombre de la bebida a consumir: ");
                    String nombreBebida=entrada.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad=entrada.nextInt();
                    entrada.nextLine();
                    sistema.consumirBebida(cantidad,dni,nombreBebida);
                    break;
            }
        } while(respuesta!=4);
    }
}