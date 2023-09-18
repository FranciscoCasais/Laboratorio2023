package SistemaCine;
import Tiempo.Fecha;
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
        Pelicula.setCantidadPeliculas(Pelicula.getCantidadPeliculas()-1);
        for(Pelicula pelicula:peliculas) {
            int vistasPelicula=0;
            for(Usuario usuario:usuarios) {
                for(Funcion funcion:usuario.getEntradasCompradas()) {
                    if(funcion.getPelicula().equals(pelicula) && funcion.getFechaHora().isBefore(LocalDateTime.now())) vistasPelicula++;
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
        Usuario.setCantidadUsuarios(Usuario.getCantidadUsuarios()-1);
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
        System.out.print("\nIngrese cuándo se dará la función:\nAño: ");
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
        System.out.println("\nSeleccione la película que se va a transmitir:\n");
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
        System.out.println("\nSeleccione la sala en la que tendrá lugar la función:\n");
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
        System.out.println("\nSe agregó la función exitosamente.\n");
    }
    public void mostrarFuncionesDisponibles() {
        System.out.println("\nLas funciones disponibles actualmente son:\n");
        for(Funcion funcion:funciones) {
            if(funcion.getFechaHora().isAfter(LocalDateTime.now()) && funcion.getButacasOcupadas()<45) System.out.println(funcion.toString());
        }
        System.out.print("\n");
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

        Pelicula p1=new Pelicula(Genero.ACCION,120,"John Timb");
        Pelicula p2=new Pelicula(Genero.ACCION,90,"La Patrix");
        Pelicula p3=new Pelicula(Genero.AVENTURA,100,"Las crónicas del Paja");
        Pelicula p4=new Pelicula(Genero.AVENTURA,90,"El señor de los olín");
        Pelicula p5=new Pelicula(Genero.COMEDIA,110,"Los tres timbeados");
        Pelicula p6=new Pelicula(Genero.COMEDIA,80,"Pajamigos");
        Pelicula p7=new Pelicula(Genero.ROMANCE,120,"El Paja y la Bestia");
        Pelicula p8=new Pelicula(Genero.ROMANCE,110,"El Paja y Julieta");
        Pelicula p9=new Pelicula(Genero.DRAMA,130,"Pajanieves y los siete olincitos");
        Pelicula p10=new Pelicula(Genero.DRAMA,80,"Pajunzel");
        HashSet<Pelicula> peliculas=new HashSet<>();
        peliculas.add(p1);
        peliculas.add(p2);
        peliculas.add(p3);
        peliculas.add(p4);
        peliculas.add(p5);
        peliculas.add(p6);
        peliculas.add(p7);
        peliculas.add(p8);
        peliculas.add(p9);
        peliculas.add(p10);

        Sala s1=new Sala(1);
        Sala s2=new Sala(2);
        Sala s3=new Sala(3);
        Sala s4=new Sala(4);
        Sala s5=new Sala(5);
        Sala s6=new Sala(6);
        Sala s7=new Sala(7);
        Sala s8=new Sala(8);
        Sala s9=new Sala(9);
        Sala s10=new Sala(10);
        HashSet<Sala> salas=new HashSet<>();
        salas.add(s1);
        salas.add(s2);
        salas.add(s3);
        salas.add(s4);
        salas.add(s5);
        salas.add(s6);
        salas.add(s7);
        salas.add(s8);
        salas.add(s9);
        salas.add(s10);

        Funcion f1=new Funcion(13,LocalDateTime.of(2023,9,15,17,30),p1,s1);
        Funcion f2=new Funcion(28,LocalDateTime.of(2023,9,3,16,0),p2,s2);
        Funcion f3=new Funcion(45,LocalDateTime.of(2023,9,8,22,0),p3,s3);
        Funcion f4=new Funcion(9,LocalDateTime.of(2023,8,11,13,45),p4,s4);
        Funcion f5=new Funcion(31,LocalDateTime.of(2023,9,17,17,30),p5,s5);
        Funcion f6=new Funcion(16,LocalDateTime.of(2023,10,23,11,0),p6,s6);
        Funcion f7=new Funcion(14,LocalDateTime.of(2023,10,31,8,15),p7,s7);
        Funcion f8=new Funcion(20,LocalDateTime.of(2023,11,2,0,0),p8,s8);
        Funcion f9=new Funcion(5,LocalDateTime.of(2023,10,10,16,30),p9,s9);
        Funcion f10=new Funcion(42,LocalDateTime.of(2023,12,28,17,30),p10,s10);
        HashSet<Funcion> funciones=new HashSet<>();
        funciones.add(f1);
        funciones.add(f2);
        funciones.add(f3);
        funciones.add(f4);
        funciones.add(f5);
        funciones.add(f6);
        funciones.add(f7);
        funciones.add(f8);
        funciones.add(f9);
        funciones.add(f10);

        HashSet<Funcion> entradasCompradas=new HashSet<>();
        entradasCompradas.add(f1);
        entradasCompradas.add(f3);
        entradasCompradas.add(f7);
        entradasCompradas.add(f9);
        Usuario u1=new Usuario(entradasCompradas,new Fecha(),"Fernández","usuario1@gmail.com","Carlos");
        entradasCompradas=new HashSet<>();
        entradasCompradas.add(f5);
        entradasCompradas.add(f8);
        Usuario u2=new Usuario(entradasCompradas,new Fecha(),"Carone","usuario2@gmail.com","Fernando");
        entradasCompradas=new HashSet<>();
        entradasCompradas.add(f6);
        entradasCompradas.add(f7);
        entradasCompradas.add(f8);
        entradasCompradas.add(f10);
        Usuario u3=new Usuario(entradasCompradas,new Fecha(),"Illuminati","usuario3@gmail.com","Santino");
        entradasCompradas=new HashSet<>();
        entradasCompradas.add(f2);
        entradasCompradas.add(f3);
        entradasCompradas.add(f6);
        entradasCompradas.add(f8);
        entradasCompradas.add(f10);
        Usuario u4=new Usuario(entradasCompradas,new Fecha(),"Eberle","usuario4@gmail.com","Paja");
        entradasCompradas=new HashSet<>();
        entradasCompradas.add(f3);
        entradasCompradas.add(f4);
        entradasCompradas.add(f7);
        Usuario u5=new Usuario(entradasCompradas,new Fecha(),"Broco","usuario5@gmail.com","Santi");
        entradasCompradas=new HashSet<>();
        entradasCompradas.add(f8);
        Usuario u6=new Usuario(entradasCompradas,new Fecha(),"Yañez","usuario6@gmail.com","Boli");
        entradasCompradas=new HashSet<>();
        entradasCompradas.add(f2);
        entradasCompradas.add(f3);
        entradasCompradas.add(f4);
        entradasCompradas.add(f6);
        entradasCompradas.add(f7);
        entradasCompradas.add(f8);
        entradasCompradas.add(f9);
        entradasCompradas.add(f10);
        Usuario u7=new Usuario(entradasCompradas,new Fecha(),"Chivo","usuario7@gmail.com","Lauti");
        entradasCompradas=new HashSet<>();
        entradasCompradas.add(f2);
        entradasCompradas.add(f9);
        Usuario u8=new Usuario(entradasCompradas,new Fecha(),"Holm","usuario8@gmail.com","Pela");
        entradasCompradas=new HashSet<>();
        entradasCompradas.add(f1);
        entradasCompradas.add(f5);
        entradasCompradas.add(f10);
        Usuario u9=new Usuario(entradasCompradas,new Fecha(),"Papas","usuario9@gmail.com","Maxi");
        entradasCompradas=new HashSet<>();
        entradasCompradas.add(f2);
        entradasCompradas.add(f3);
        entradasCompradas.add(f5);
        entradasCompradas.add(f7);
        Usuario u10=new Usuario(entradasCompradas,new Fecha(),"Mondongo","usuario10@gmail.com","Rodolfo");
        HashSet<Usuario> usuarios=new HashSet<>();
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);
        usuarios.add(u5);
        usuarios.add(u6);
        usuarios.add(u7);
        usuarios.add(u8);
        usuarios.add(u9);
        usuarios.add(u10);

        Sistema sistema=new Sistema(funciones,peliculas,salas,usuarios);
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
                    System.out.println("\nLa cantidad de usuarios cargados en el sistema es de "+Usuario.getCantidadUsuarios()+".\n");
                    break;
                case 2:
                    System.out.println("\nLa cantidad de películas cargadas en el sistema es de "+Pelicula.getCantidadPeliculas()+".\n");
                    break;
                case 3:
                    sistema.agregarFuncion();
                    break;
                case 4:
                    sistema.mostrarFuncionesDisponibles();
                    break;
                case 5:
                    Pelicula peliculaMasVista=sistema.peliculaMasVista();
                    System.out.println("\nLa película más vista actualmente es "+peliculaMasVista.toString()+".\n");
                    break;
                case 6:
                    Usuario usuarioConMenosEntradasCompradas=sistema.usuarioConMenosEntradasCompradas();
                    System.out.println("\nEl usuario con menos entradas compradas es "+usuarioConMenosEntradasCompradas.getNombre()+" "+usuarioConMenosEntradasCompradas.getApellido()+", con "+ usuarioConMenosEntradasCompradas.cantidadEntradasCompradas()+".\n");
                    break;
            }
        } while(respuesta!=7);
    }
}