package SistemaCine;
import java.time.*;
import java.util.HashSet;
import java.util.Scanner;
public class Sistema {
    private HashSet<Funcion> funciones;
    private HashSet<Pelicula> peliculas;
    private HashSet<Sala> salas;
    private HashSet<Usuario> usuarios;
    public Sistema() {
        funciones=new HashSet<>();
        peliculas=new HashSet<>();
        salas=new HashSet<>();
        usuarios=new HashSet<>();
    }
    public Sistema(HashSet<Funcion> funciones,HashSet<Pelicula> peliculas,HashSet<Sala> salas,HashSet<Usuario> usuarios) {
        this.funciones=funciones;
        this.peliculas=peliculas;
        this.salas=salas;
        this.usuarios=usuarios;
    }
    public HashSet<Funcion> getFunciones() { return funciones; }
    public void setFunciones(HashSet<Funcion> funciones) { this.funciones=funciones; }
    public HashSet<Pelicula> getPeliculas() { return peliculas; }
    public void setPeliculas(HashSet<Pelicula> peliculas) { this.peliculas=peliculas; }
    public HashSet<Sala> getSalas() { return salas; }
    public void setSalas(HashSet<Sala> salas) { this.salas=salas; }
    public HashSet<Usuario> getUsuarios() { return usuarios; }
    public void setUsuarios(HashSet<Usuario> usuarios) { this.usuarios=usuarios; }
    public Pelicula encontrarPeliculaPorId(int id) {
        for(Pelicula pelicula:peliculas) {
            if(pelicula.getId()==id) return pelicula;
        }
        return null;
    }
    public Pelicula peliculaMasVista() {
        int mayoresVistasPelicula=0;
        Pelicula peliculaMasVista=new Pelicula();
        for(Pelicula pelicula:peliculas) {
            int vistasPelicula=0;
            for(Usuario usuario:usuarios) {
                for(Funcion funcion:usuario.getEntradasCompradas()) {
                    if(funcion.getPelicula().equals(pelicula)) vistasPelicula++;
                }
            }
            if(vistasPelicula>mayoresVistasPelicula) {
                mayoresVistasPelicula=vistasPelicula;
                peliculaMasVista=pelicula;
            }
        }
        return peliculaMasVista;
    }
    public Sala encontrarSalaPorNumero(int numeroSala) {
        for(Sala sala:salas) {
            if(sala.getNumeroSala()==numeroSala) return sala;
        }
        return null;
    }
    public Usuario usuarioConMenosEntradasCompradas() {
        boolean entrar=true;
        int menoresEntradasCompradas=0;
        Usuario usuarioConMenosEntradasCompradas=new Usuario();
        for(Usuario usuario:usuarios) {
            if(entrar || usuario.cantidadEntradasCompradas()<menoresEntradasCompradas) {
                entrar=false;
                menoresEntradasCompradas=usuario.cantidadEntradasCompradas();
                usuarioConMenosEntradasCompradas=usuario;
            }
        }
        return usuarioConMenosEntradasCompradas;
    }
    public void agregarFuncion() {
        Scanner entrada=new Scanner(System.in);
        System.out.print("Ingrese cuándo se dará la función:\nAño: ");
        int anio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes (número 1-12): ");
        int mes=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día (número 1-31): ");
        int dia=entrada.nextInt();
        LocalDate fecha=LocalDate.of(anio,mes,dia);
        System.out.print("Hora (0-23): ");
        int hora=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Minutos (0-59): ");
        int minutos=entrada.nextInt();
        entrada.nextLine();
        LocalTime horario=LocalTime.of(hora,minutos);
        LocalDateTime fechaHora=LocalDateTime.of(fecha,horario);
        System.out.println("Seleccione la película que se va a transmitir:\n");
        mostrarPeliculasPorOrdenId();
        System.out.print("\nIngrese el dígito correspondiente: ");
        int idPelicula=entrada.nextInt();
        Pelicula pelicula=encontrarPeliculaPorId(idPelicula);
        while(pelicula==null) {
            System.out.print("Entrada no válida, intente nuevamente: ");
            idPelicula=entrada.nextInt();
            entrada.nextLine();
            pelicula=encontrarPeliculaPorId(idPelicula);
        }
        System.out.println("Seleccione la sala en la que tendrá lugar la función:\n");
        mostrarSalasPorOrdenNumero();
        System.out.print("\nIngrese el dígito correspondiente: ");
        int numeroSala=entrada.nextInt();
        entrada.nextLine();
        Sala sala=encontrarSalaPorNumero(numeroSala);
        while(sala==null) {
            System.out.print("Entrada no válida, intente nuevamente: ");
            numeroSala=entrada.nextInt();
            entrada.nextLine();
            sala=encontrarSalaPorNumero(numeroSala);
        }
        Funcion nuevaFuncion=new Funcion(0,fechaHora,pelicula,sala);
        funciones.add(nuevaFuncion);
        System.out.println("Se agregó la función exitosamente.");
    }
    public void mostrarFuncionesDisponibles() {
        for(Funcion funcion:funciones) {
            if(funcion.getFechaHora().isBefore(LocalDateTime.now())) System.out.println(funcion.getPelicula().toString()+", "+funcion.getFechaHora().getDayOfMonth()+"/"+funcion.getFechaHora().getMonth()+"/"+funcion.getFechaHora().getYear()+" "+funcion.getFechaHora().getHour()+":"+funcion.getFechaHora().getMinute());
        }
    }
    public void mostrarPeliculasPorOrdenId() {
        int i=1;
        Pelicula pelicula;
        do {
            pelicula=encontrarPeliculaPorId(i);
            if(pelicula!=null) {
                System.out.println(i+". "+pelicula.toString());
                i++;
            }
        } while(pelicula!=null);
    }
    public void mostrarSalasPorOrdenNumero() {
        int i=1;
        Sala sala;
        do {
            sala=encontrarSalaPorNumero(i);
            if(sala!=null) {
                System.out.println(i+". Sala "+sala.getNumeroSala());
                i++;
            }
        } while(sala!=null);
    }
    public static void main(String[] args) {
        int respuesta;
        Scanner entrada=new Scanner(System.in);

        Pelicula p1=new Pelicula();

        Sistema sistema=new Sistema();
        do {
            System.out.print("1. Cantidad de usuarios en el sistema\n2. Cantidad de películas en el sistema\n3. Agregar función\n4. Funciones disponibles\n5. Película más vista\n6. Usuario con menos entradas compradas\n7. Salir\n\nIngrese el dígito correspondiente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
            while(respuesta<1 || respuesta>7) {
                System.out.print("Entrada no válida, intente nuevamente: ");
                respuesta=entrada.nextInt();
                entrada.nextLine();
            }
            switch(respuesta) {
                case 1:
                    System.out.println("La cantidad de usuarios cargados en el sistema es de "+Usuario.getCantidadUsuarios()+".");
                    break;
                case 2:
                    System.out.println("La cantidad de películas cargadas en el sistema es de"+Pelicula.getCantidadPeliculas()+".");
                    break;
                case 3:
                    sistema.agregarFuncion();
                    break;
                case 4:
                    sistema.mostrarFuncionesDisponibles();
                    break;
                case 5:
                    Pelicula peliculaMasVista=sistema.peliculaMasVista();
                    System.out.println("La película más vista actualmente es "+peliculaMasVista.toString());
                    break;
                case 6:
                    Usuario usuarioConMenosEntradasCompradas=sistema.usuarioConMenosEntradasCompradas();
                    System.out.println("El usuario con menos entradas compradas es "+usuarioConMenosEntradasCompradas.getNombre()+" "+usuarioConMenosEntradasCompradas.getApellido()+", con "+ usuarioConMenosEntradasCompradas.cantidadEntradasCompradas()+".");
                    break;
            }
        } while(respuesta!=7);
    }
}