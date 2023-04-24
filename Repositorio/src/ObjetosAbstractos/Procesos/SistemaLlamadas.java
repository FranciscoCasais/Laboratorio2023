package ObjetosAbstractos.Procesos;
import SeresHumanos.Empleado;
import Tiempo.Hora;
import java.util.ArrayList;
import java.util.Scanner;
public class SistemaLlamadas {
    ArrayList<Empleado> registroEmpleados=new ArrayList<>();
    ArrayList<Llamada> registroLlamadas=new ArrayList<>();
    public ArrayList<Empleado> getRegistroEmpleados() { return registroEmpleados; }
    public ArrayList<Llamada> getRegistroLlamadas() { return registroLlamadas; }
    public void setRegistroEmpleados(ArrayList<Empleado> registroEmpleados) { this.registroEmpleados=registroEmpleados; }
    public void setRegistroLlamadas(ArrayList<Llamada> registroLlamadas) { this.registroLlamadas=registroLlamadas; }
    public int buscarEmpleado(long dni) {
        for(int i=0;i<registroEmpleados.size();i++) {
            if(registroEmpleados.get(i).getDNI()==dni) { return i; }
        }
        return -1;
    }
    public void realizarListadoLlamadas() {
        System.out.println("\nListado de llamadas por empleado:");
        for(Empleado empleado:registroEmpleados) {
            int cantidadLlamadas=0;
            for(Llamada llamada:registroLlamadas) {
                if(llamada.getOrigen()==empleado) {
                    cantidadLlamadas++;
                }
            }
            System.out.println("\n"+empleado.getApellido()+", "+empleado.getNombre()+" ("+empleado.getDNI()+"):\n"+cantidadLlamadas+" llamadas realizadas");
        }
    }
    public void realizarRankingDuracion() {
        System.out.println("\nRanking de empleados por duración total de llamada:");
        Hora duracionTotal=new Hora();
        for(Empleado empleado:registroEmpleados) {
            for(Llamada llamada:registroLlamadas) {
                if(llamada.getOrigen()==empleado) { duracionTotal.sumarHoras(duracionTotal,llamada.getDuracion()); }
            }
            System.out.println("\n"+empleado.getApellido()+", "+empleado.getNombre()+" ("+empleado.getDNI()+"):\n"+duracionTotal.getHoras()+" horas y "+duracionTotal.getMinutos()+" minutos de tiempo en llamadas");
        }
    }
    public static void main(String[] args) {
        int respuesta;
        long dni;
        Scanner entrada=new Scanner(System.in);
        SistemaLlamadas sistemaLlamadas=new SistemaLlamadas();
        System.out.println("\nIngrese su DNI:");
        dni=entrada.nextLong();
        while(sistemaLlamadas.buscarEmpleado(dni)==-1) {
            System.out.println("\nNo se encontró al empleado, intente nuevamente:");
            dni=entrada.nextLong();
        }
        int i=sistemaLlamadas.buscarEmpleado(dni);
        do {
            System.out.println("1. Realizar llamada\n2. Listado de llamadas por empleado\n3. Ranking de duración total de llamadas\n4. Finalizar programa\n\nIngrese el dígito correspondiente:");
            respuesta=entrada.nextInt();
            while(respuesta<1 || respuesta>4) {
                System.out.println("\nDígito no válido, intente nuevamente:");
                respuesta=entrada.nextInt();
            }
            switch(respuesta) {
                case 1:
                    String telefono;
                    System.out.println("\nIngrese el número de teléfono:");
                    entrada.nextLine();
                    telefono=entrada.nextLine();
                    sistemaLlamadas.getRegistroEmpleados().get(i).realizarLlamada(sistemaLlamadas.getRegistroEmpleados(),sistemaLlamadas.getRegistroLlamadas(),entrada,telefono);
                    break;
                case 2:
                    sistemaLlamadas.realizarListadoLlamadas();
                    break;
                case 3:
                    sistemaLlamadas.realizarRankingDuracion();
                    break;
            }
        } while(respuesta<4);
    }
}