package EjerciciosHash.Ejercicio1;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Scanner;
public class Empresa {
    private HashMap<Integer,Empleado> empleados;
    public Empresa() { empleados=new HashMap<>(); }
    public HashMap<Integer,Empleado> getEmpleados() { return empleados; }
    public void setEmpleados(HashMap<Integer,Empleado> empleados) { this.empleados=empleados; }
    public static void main(String[] args) {

        Empresa empresa=new Empresa();
        Scanner entrada=new Scanner(System.in);
        System.out.println("Bienvenido, por favor ingrese su ID de empleado:");
        int idEmpleado=entrada.nextInt();
        while(!(empresa.getEmpleados().containsKey(idEmpleado))) {
            System.out.println("\nNo se econtró el ID, por favor intente nuevamente:");
            entrada.nextLine();
            idEmpleado=entrada.nextInt();
        }
        if(empresa.getEmpleados().get(idEmpleado).getDiasAsistencia().contains(LocalDateTime.now().getDayOfWeek())) {
            empresa.getEmpleados().get(idEmpleado).getRegistroAsistencia().add(LocalDateTime.now());
            System.out.println("\nAsistencia registrada con éxito.");
        } else { System.out.println("\nEl empleado seleccionado no debe asistir hoy al trabajo."); }
        int respuesta,numeroMes;
        do {
            System.out.println("\n1. Porcentaje de asistencia por mes\n2. Empleados con mayor asistencia\n3. Salir\n\nIngrese el dígito correspondiente:");
            entrada.nextLine();
            respuesta=entrada.nextInt();
            while(respuesta<1 && respuesta>3) {
                System.out.println("\nDígito no válido, por favor intente nuevamente:");
                entrada.nextLine();
                respuesta=entrada.nextInt();
            }
            if(respuesta<3) {
                System.out.println("\nIngrese el número del mes por el que se filtrarán las fechas (1-12):");
                entrada.nextLine();
                numeroMes=entrada.nextInt();
                while(numeroMes<1 || numeroMes>12) {
                    System.out.println("\nNúmero no válido, por favor intente nuevamente:");
                    entrada.nextLine();
                    numeroMes=entrada.nextInt();
                }
                Month mes;
                switch(numeroMes) {
                    case 1:
                        mes=Month.JANUARY;
                        break;
                    case 2:
                        mes=Month.FEBRUARY;
                        break;
                    case 3:
                        mes=Month.MARCH;
                        break;
                    case 4:
                        mes=Month.APRIL;
                        break;
                    case 5:
                        mes=Month.MAY;
                        break;
                    case 6:
                        mes=Month.JUNE;
                        break;
                    case 7:
                        mes=Month.JULY;
                        break;
                    case 8:
                        mes=Month.AUGUST;
                        break;
                    case 9:
                        mes=Month.SEPTEMBER;
                        break;
                    case 10:
                        mes=Month.OCTOBER;
                        break;
                    case 11:
                        mes=Month.NOVEMBER;
                        break;
                    default:
                        mes=Month.DECEMBER;
                        break;
                }
                if(respuesta==1) { System.out.println("\nEl porcentaje de asistencia para el mes seleccionado es del "+empresa.getEmpleados().get(idEmpleado).porcentajeDeAsistencia(mes)+"%."); }
                else {
                    System.out.println("\nLos empleados con una tasa de asistencia mayor al 80% son los siguientes:");
                    for(Empleado empleado:empresa.getEmpleados().values()) {
                        if (empleado.porcentajeDeAsistencia(mes)>80) { System.out.println("\n"+empleado.getNombre()+" "+empleado.getApellido()); }
                    }
                }
            }
        } while(respuesta<3);
    }
}