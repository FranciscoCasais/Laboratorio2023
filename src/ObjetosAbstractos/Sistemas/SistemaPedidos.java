package ObjetosAbstractos.Sistemas;
import java.util.ArrayList;
import java.util.Scanner;
import ObjetosAbstractos.Procesos.Pedido;
import ObjetosFisicos.Otros.Plato;
import SeresHumanos.Alumno;
import SeresHumanos.Persona;
import SeresHumanos.Profesor;
import Tiempo.Fecha;
import Tiempo.Hora;
public class SistemaPedidos {
    private ArrayList<Pedido> pedidos;
    private static ArrayList<Plato> platos;
    private static ArrayList<Alumno> alumnos;
    private static ArrayList<Profesor> profesores;
    public SistemaPedidos() {
        alumnos=new ArrayList<>();
        pedidos=new ArrayList<>();
        platos=new ArrayList<>();
        profesores=new ArrayList<>();
    }
    public ArrayList<Alumno> getAlumnos() { return alumnos; }
    public ArrayList<Pedido> getPedidos() { return pedidos; }
    public ArrayList<Plato> getPlatos() { return platos; }
    public ArrayList<Profesor> getProfesores() { return profesores; }
    public void agregarPedido(int respuesta,Scanner entrada) {
        Fecha fecha=new Fecha();
        Hora hora=new Hora();
        Pedido pedido=new Pedido();
        pedido.setEntregado(false);
        System.out.println("\nIngrese la fecha actual:\nDía:");
        fecha.setDia(entrada.nextInt());
        System.out.println("\nMes:");
        fecha.setMes(entrada.nextInt());
        System.out.println("\nAño:");
        fecha.setAnio(entrada.nextInt());
        pedido.setFechaCreacion(fecha);
        System.out.println("\nIngrese la hora de entrega:\nHoras:");
        hora.setHoras(entrada.nextInt());
        System.out.println("Minutos:");
        hora.setMinutos(entrada.nextInt());
        pedido.setHoraEntrega(hora);
        System.out.println("Ingrese el cliente:\n\n1. Alumno\2. Profesor");
        validarRespuesta(2,respuesta,entrada);
        if(respuesta==1) {
            System.out.println("\nIngrese el ID del alumno:");
            respuesta=entrada.nextInt();
            while(respuesta<0 || respuesta>alumnos.size()-1) {
                System.out.println("\nNo se encontró al alumno, intente nuevamente:");
                respuesta=entrada.nextInt();
            }
            pedido.setCliente(alumnos.get(respuesta));
        } else {
            System.out.println("\nIngrese el ID del profesor:");
            respuesta=entrada.nextInt();
            while(respuesta<0 || respuesta>profesores.size()-1) {
                System.out.println("\nNo se encontró al profesor, intente nuevamente:");
                respuesta=entrada.nextInt();
            }
            pedido.setCliente(profesores.get(respuesta));
        }
        System.out.println("\nIngrese el ID del plato:");
        respuesta=entrada.nextInt();
        while(respuesta<0 || respuesta>platos.size()-1) {
            System.out.println("No se encontró el plato, intente nuevamente:");
            respuesta=entrada.nextInt();
        }
        pedido.setPlato(platos.get(respuesta));
        System.out.println("Pedido agregado.");
    }
    public void agregarPersona(int respuesta,Scanner entrada) {
        Persona persona=new Persona();
        System.out.println("\nIngrese el apellido:");
        entrada.nextLine();
        persona.setApellido(entrada.nextLine());
        System.out.println("\nIngrese el nombre:");
        persona.setNombre(entrada.nextLine());
        if(respuesta==1) {
            System.out.println("\nIngrese la división:");
            ((Alumno)persona).setDivision(entrada.nextLine());
            alumnos.add((Alumno)persona);
            System.out.println("\nAlumno agregado.");
        } else {
            System.out.println("Ingrese el porcentaje de descuento:");
            ((Profesor)persona).setPorcentajeDescuento(entrada.nextInt());
            profesores.add((Profesor)persona);
            System.out.println("\nProfesor agregado.");
        }
    }
    public void agregarPlato(Scanner entrada) {
        Plato plato=new Plato();
        System.out.println("\nIngrese el nombre:");
        entrada.nextLine();
        plato.setNombre(entrada.nextLine());
        System.out.println("\nIngrese el precio (pesos.centavos):");
        plato.setPrecio(entrada.nextDouble());
        platos.add(plato);
        System.out.println("\nPlato agregado.");
    }
    public static void calcularPrecio(ArrayList<Profesor> profesores,Pedido pedido) {
        for(Profesor profesor:profesores) {
            if(pedido.getCliente().getApellido()==profesor.getApellido() && pedido.getCliente().getNombre()==profesor.getNombre()) {
                System.out.println("\nPrecio: $"+(pedido.getPlato().getPrecio()-(pedido.getPlato().getPrecio()*profesor.getPorcentajeDescuento()/100)));
            }
        }
    }
    public void armarResumen(Scanner entrada) {
        Fecha fecha=new Fecha();
        System.out.println("\nIngrese la fecha actual:\n\nDía:");
        fecha.setDia(entrada.nextInt());
        System.out.println("\nMes:");
        fecha.setMes(entrada.nextInt());
        System.out.println("\nAño:");
        fecha.setAnio(entrada.nextInt());
        for(int i=0;i<pedidos.size();i++) {
            if(!(pedidos.get(i).getEntregado()) && pedidos.get(i).getFechaCreacion()==fecha) {
                System.out.println("\nPedido #"+i+"\n\nHora de entrega: "+pedidos.get(i).getHoraEntrega().getHoras()+":"+pedidos.get(i).getHoraEntrega().getMinutos());
                if(pedidos.get(i).getCliente() instanceof Alumno) {
                    System.out.println("Cliente: Alumno"+pedidos.get(i).getCliente().getNombre()+" "+pedidos.get(i).getCliente().getApellido());
                } else {
                    System.out.println("Cliente: Profesor"+pedidos.get(i).getCliente().getNombre()+" "+pedidos.get(i).getCliente().getApellido());
                }
                System.out.println("Plato: "+pedidos.get(i).getPlato().getNombre());
                if(pedidos.get(i).getCliente() instanceof Alumno) {
                    System.out.println("Precio: $"+pedidos.get(i).getPlato().getPrecio());
                } else {
                    calcularPrecio(profesores,pedidos.get(i));
                }
            }
        }
    }
    public void eliminarPedido(int respuesta,Scanner entrada) {
        System.out.println("\nIngrese el ID del pedido a eliminar:");
        respuesta=entrada.nextInt();
        while(respuesta<0 || respuesta>pedidos.size()-1) {
            System.out.println("\nNo se encontró el pedido, intente nuevamente:");
            respuesta=entrada.nextInt();
        }
        pedidos.remove(respuesta);
        System.out.println("\nPedido eliminado.");
    }
    public void eliminarPersona(int respuesta,Scanner entrada) {
        int respuesta2;
        if(respuesta==1) {
            System.out.println("\nIngrese el ID del alumno a eliminar:");
        } else {
            System.out.println("\nIngrese el ID del profesor a eliminar:");
        }
        respuesta2=entrada.nextInt();
        while(respuesta2<0 || respuesta2>alumnos.size()-1) {
            if(respuesta==1) {
                System.out.println("\nNo se encontró el alumno, intente nuevamente.");
            } else {
                System.out.println("\nNo se encontró el profesor, intente nuevamente.");
            }
            respuesta2=entrada.nextInt();
        }
        if(respuesta==1) {
            alumnos.remove(respuesta2);
            System.out.println("\nAlumno eliminado.");
        } else {
            profesores.remove(respuesta2);
            System.out.println("\nProfesor eliminado.");
        }
    }
    public void eliminarPlato(int respuesta,Scanner entrada) {
        System.out.println("\nIngrese el ID del plato a eliminar:");
        respuesta=entrada.nextInt();
        while(respuesta<0 || respuesta>platos.size()-1) {
            System.out.println("\nNo se encontró el plato, intente nuevamente:");
            respuesta=entrada.nextInt();
        }
        platos.remove(respuesta);
        System.out.println("\nPlato eliminado.");
    }
    public void modificarPedido(int respuesta,Scanner entrada) {
        int respuesta2,respuesta3=0;
        System.out.println("\nIngrese el ID del pedido a modificar:");
        respuesta2=entrada.nextInt();
        while(respuesta2<0 || respuesta2>pedidos.size()-1) {
            System.out.println("\nNo se encontró el pedido, intente nuevamente:");
            respuesta2=entrada.nextInt();
        }
        do {
            System.out.println("\n1. Modificar estado\n2. Modificar fecha de creación\n3. Modificar hora de entrega\n4. Modificar cliente\n5. Modificar plato\n6. Terminar");
            validarRespuesta(6,respuesta,entrada);
            switch(respuesta) {
                case 1:
                    if(pedidos.get(respuesta2).getEntregado()) {
                        pedidos.get(respuesta2).setEntregado(false);
                        System.out.println("\nSe cambió el estado del pedido de entregado a pendiente.");
                    } else {
                        pedidos.get(respuesta2).setEntregado(true);
                        System.out.println("\nSe cambió el estado del pedido de pendiente a entregado.");
                    }
                    break;
                case 2:
                    Fecha fecha=new Fecha();
                    System.out.println("\nIngrese la nueva fecha:\nDia:");
                    fecha.setDia(entrada.nextInt());
                    System.out.println("\nMes:");
                    fecha.setMes(entrada.nextInt());
                    System.out.println("\nAño:");
                    fecha.setAnio(entrada.nextInt());
                    pedidos.get(respuesta2).setFechaCreacion(fecha);
                    System.out.println("\nFecha de creación modificada.");
                    break;
                case 3:
                    Hora hora=new Hora();
                    System.out.println("\nIngrese la nueva hora:\nHoras:");
                    hora.setHoras(entrada.nextInt());
                    System.out.println("\nMinutos:");
                    hora.setHoras(entrada.nextInt());
                    pedidos.get(respuesta2).setHoraEntrega(hora);
                    System.out.println("\nHora de entrega modificada.");
                    break;
                case 4:
                    System.out.println("\nIngrese el nuevo cliente:\n\n1. Alumno\n2. Profesor");
                    validarRespuesta(2,respuesta3,entrada);
                    if(respuesta3==1) {
                        System.out.println("\nIngrese el ID del alumno:");
                        respuesta3=entrada.nextInt();
                        while(respuesta3<0 || respuesta3>alumnos.size()-1) {
                            System.out.println("No se encontró el alumno, intente nuevamente:");
                            respuesta3=entrada.nextInt();
                        }
                        pedidos.get(respuesta2).setCliente(alumnos.get(respuesta3));
                    } else {
                        System.out.println("\nIngrese el ID del profesor:");
                        respuesta3=entrada.nextInt();
                        while(respuesta3<0 || respuesta3>profesores.size()-1) {
                            System.out.println("No se encontró el profesor, intente nuevamente:");
                            respuesta3=entrada.nextInt();
                        }
                        pedidos.get(respuesta2).setCliente(profesores.get(respuesta3));
                    }
                    System.out.println("\nCliente modificado.");
                    break;
                case 5:
                    System.out.println("\nIngrese el ID del nuevo plato:");
                    respuesta3=entrada.nextInt();
                    while(respuesta3<0 || respuesta3>platos.size()-1) {
                        System.out.println("\nNo se encontró el plato, intente nuevamente:");
                        respuesta3=entrada.nextInt();
                    }
                    pedidos.get(respuesta2).setPlato(platos.get(respuesta3));
                    System.out.println("\nPlato modificado.");
                    break;
            }
        } while(respuesta<6);
    }
    public void modificarPersona(int respuesta,Scanner entrada) {
        int respuesta2=0,respuesta3=0;
        if(respuesta==1) {
            System.out.println("\nIngrese el ID del alumno a modificar:");
        } else {
            System.out.println("\nIngrese el ID del profesor a modificar:");
        }
        respuesta2=entrada.nextInt();
        while(respuesta2<0 || ((respuesta==1 && respuesta2>alumnos.size()-1) || (respuesta==2 && respuesta2>profesores.size()-1))) {
            System.out.println("\nNo se encontró el alumno, intente nuevamente:");
            respuesta2=entrada.nextInt();
        }
        do {
            System.out.println("\n1. Modificar apellido\n2. Modificar nombre");
            if(respuesta==1) {
                System.out.println("3. Modificar división");
            } else {
                System.out.println("3. Modificar porcentaje de descuento");
            }
            System.out.println("4. Terminar");
            validarRespuesta(4,respuesta3,entrada);
            entrada.nextLine();
            switch(respuesta3) {
                case 1:
                    System.out.println("\nIngrese el nuevo apellido:");
                    if(respuesta==1) {
                        alumnos.get(respuesta2).setApellido(entrada.nextLine());
                    } else {
                        profesores.get(respuesta2).setApellido(entrada.nextLine());
                    }
                    System.out.println("\nApellido modificado.");
                    break;
                case 2:
                    System.out.println("\nIngrese el nuevo nombre:");
                    if(respuesta==1) {
                        alumnos.get(respuesta2).setApellido(entrada.nextLine());
                    } else {
                        profesores.get(respuesta2).setApellido(entrada.nextLine());
                    }
                    alumnos.get(respuesta2).setNombre(entrada.nextLine());
                    System.out.println("\nNombre modificado.");
                    break;
                case 3:
                    if(respuesta==1) {
                        System.out.println("\nIngrese la nueva división:");
                        alumnos.get(respuesta2).setDivision(entrada.nextLine());
                        System.out.println("\nDivisión modificada.");
                    } else {
                        System.out.println("\nIngrese el nuevo porcentaje de descuento:");
                        profesores.get(respuesta2).setPorcentajeDescuento(entrada.nextInt());
                        System.out.println("\nPorcentaje de descuento modificado.");
                    }
                    break;
            }
        } while(respuesta3<4);
    }
    public void modificarPlato(int respuesta,Scanner entrada) {
        int respuesta2;
        System.out.println("\nIngrese el ID del plato a modificar:");
        respuesta2=entrada.nextInt();
        while(respuesta2<0 || respuesta2>platos.size()-1) {
            System.out.println("\nNo se encontró el plato, intente nuevamente:");
            respuesta2=entrada.nextInt();
        }
        do {
            System.out.println("\n1. Modificar precio\n2. Modificar nombre\n3. Terminar");
            validarRespuesta(3,respuesta,entrada);
            if(respuesta==1) {
                System.out.println("\nIngrese el nuevo precio (pesos.centavos):");
                platos.get(respuesta2).setPrecio(entrada.nextDouble());
                System.out.println("\nPrecio modificado.");
            } else if(respuesta==2) {
                System.out.println("\nIngrese el nuevo nombre:");
                entrada.nextLine();
                platos.get(respuesta2).setNombre(entrada.nextLine());
                System.out.println("Nombre modificado.");
            }
        } while(respuesta<3);
    }
    public void setAlumnos(ArrayList<Alumno> alumnos) { this.alumnos=alumnos; }
    public void setPedidos(ArrayList<Pedido> pedidos) { this.pedidos=pedidos; }
    public void setPlatos(ArrayList<Plato> platos) { this.platos=platos; }
    public void setProfesores(ArrayList<Profesor> profesores) { this.profesores=profesores; }
    public static void validarRespuesta(int numeroOpciones,int respuesta,Scanner entrada) {
        System.out.println("\nIngrese el dígito correspondiente:");
        respuesta=entrada.nextInt();
        while(respuesta<1 || respuesta>numeroOpciones) {
            System.out.println("\nDígito no válido, intente nuevamente:");
            respuesta=entrada.nextInt();
        }
    }
    public static void main(String[] args) {
        int respuesta=0;
        Scanner entrada=new Scanner(System.in);
        SistemaPedidos sistema=new SistemaPedidos();
        do {
            System.out.println("1. Acceder a listado de alumnos\n2. Acceder a listado de profesores\n3. Acceder a listado de platos\n4. Acceder a listado de pedidos\n5. Obtener pedidos pendientes del día\n6. Salir\n");
            validarRespuesta(6,respuesta,entrada);
            switch(respuesta) {
                case 1:
                    System.out.println("\n1. Agregar alumno\n2. Modificar alumno\n3. Eliminar alumno\n");
                    validarRespuesta(3,respuesta,entrada);
                    switch(respuesta) {
                        case 1:
                            sistema.agregarPersona(respuesta,entrada);
                            break;
                        case 2:
                            sistema.modificarPersona(respuesta,entrada);
                            break;
                        default:
                            sistema.eliminarPersona(respuesta,entrada);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\n1. Agregar profesor\n2. Modificar profesor\n3. Eliminar profesor\n");
                    validarRespuesta(3,respuesta,entrada);
                    switch(respuesta) {
                        case 1:
                            sistema.agregarPersona(respuesta,entrada);
                            break;
                        case 2:
                            sistema.modificarPersona(respuesta,entrada);
                            break;
                        default:
                            sistema.eliminarPersona(respuesta,entrada);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("\n1. Agregar plato\n2. Modificar plato\n3. Eliminar plato\n");
                    validarRespuesta(3,respuesta,entrada);
                    switch(respuesta) {
                        case 1:
                            sistema.agregarPlato(entrada);
                            break;
                        case 2:
                            sistema.modificarPlato(respuesta,entrada);
                            break;
                        default:
                            sistema.eliminarPlato(respuesta,entrada);
                            break;
                    }
                    break;
                case 4:
                    System.out.println("\n1. Agregar pedido\n2. Modificar pedido\n3. Eliminar pedido\n");
                    validarRespuesta(3,respuesta,entrada);
                    switch(respuesta) {
                        case 1:
                            sistema.agregarPedido(respuesta,entrada);
                            break;
                        case 2:
                            sistema.modificarPedido(respuesta,entrada);
                            break;
                        default:
                            sistema.eliminarPedido(respuesta,entrada);
                            break;
                    }
                    break;
                case 5:
                    sistema.armarResumen(entrada);
                    break;
            }
        } while(respuesta<6);
    }
}