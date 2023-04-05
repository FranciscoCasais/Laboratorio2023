import java.util.ArrayList;
import java.util.Scanner;
import Unidad1.Fecha;
import Unidad2.Equipo;
import Unidad2.Jugador;
import Unidad2.Partido;
public class Main {
    public static boolean ningunNumeroCamisetaRepetido(ArrayList<Jugador> jugadores,int numeroCamiseta) {
        for(int i=0;i<jugadores.size();i++) {
            for(int j=0;j<jugadores.size();j++) {
                if(jugadores.get(i).getNumeroCamiseta()==numeroCamiseta) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean yaHayCapitan(ArrayList<Jugador> jugadores) {
        for(Jugador jugador:jugadores) {
            if(jugador.getCapitan()) {
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Jugador> crearJugadores(Scanner entrada) {
        ArrayList<Jugador> jugadores=new ArrayList<>();
        char respuesta;
        int anio,dia,mes,numeroCamiseta;
        System.out.println("\nIngrese los datos de los jugadores:");
        for(int i=0;i<10;i++) {
            Jugador jugador=new Jugador();
            System.out.println("\nIngrese los datos del jugador n° "+(i+1)+":\n\nNombre completo:");
            entrada.nextLine();
            jugador.setNombreCompleto(entrada.nextLine());
            System.out.println("\nFecha de nacimiento:\nDía:");
            dia=entrada.nextInt();
            System.out.println("Mes:");
            mes=entrada.nextInt();
            System.out.println("Año:");
            anio=entrada.nextInt();
            jugador.setFechaNacimiento(new Fecha(anio,dia,mes));
            System.out.println("\nNúmero de camiseta:");
            numeroCamiseta=entrada.nextInt();
            while(!(ningunNumeroCamisetaRepetido(jugadores,numeroCamiseta))) {
                System.out.println("\nEl número de camiseta ingresado ya está en uso en este equipo, por favor ingrese otro:");
                numeroCamiseta=entrada.nextInt();
            }
            jugador.setNumeroCamiseta(numeroCamiseta);
            if(!(yaHayCapitan(jugadores))) {
                System.out.println("\n¿El jugador será el capitán del equipo? (S/N)");
                respuesta=entrada.next().charAt(0);
                while(respuesta!='s' && respuesta!='S' && respuesta!='n' && respuesta!='N') {
                    System.out.println("\nPor favor ingrese s,S ó n,N:");
                    respuesta=entrada.next().charAt(0);
                }
                if(respuesta=='s' || respuesta=='S') {
                    jugador.setCapitan(true);
                } else {
                    jugador.setCapitan(false);
                }
            }
            jugadores.add(jugador);
        }
        System.out.println("\n");
        return jugadores;
    }
    public static boolean sinNombresRepetidos(ArrayList<Equipo> equipos,String nombre) {
        for(Equipo equipo:equipos) {
            if(equipo.getNombre().equals(nombre)) {
                return false;
            }
        }
        return true;
    }
    public static void crearEquipo(ArrayList<Equipo> equipos,Scanner entrada) {
        ArrayList<Boolean> disponibilidadHoraria=new ArrayList<>();
        Equipo equipo=new Equipo();
        int respuesta;
        String nombre;
        System.out.println("\nIngrese el nombre del equipo:");
        entrada.nextLine();
        nombre=entrada.nextLine();
        while(!(sinNombresRepetidos(equipos,nombre))) {
            System.out.println("\nEl nombre ingresado ya está en uso, por favor ingrese otro:");
            nombre=entrada.nextLine();
        }
        equipo.setNombre(nombre);
        System.out.println("\nIngrese el barrio de procedencia:");
        equipo.setBarrioProcedencia(entrada.nextLine());
        System.out.println("\nIngrese la disponibilidad horaria del equipo de Lunes a Viernes:\n\n1. Mañana\n2. Tarde\n3. Noche\n");
        respuesta=entrada.nextInt();
        while(respuesta<1 || respuesta>3) {
            System.out.println("\nDígito no válido, intente nuevamente.");
            respuesta=entrada.nextInt();
        }
        switch (respuesta) {
            case 1:
                disponibilidadHoraria.add(true);
                disponibilidadHoraria.add(false);
                disponibilidadHoraria.add(false);
                break;
            case 2:
                disponibilidadHoraria.add(false);
                disponibilidadHoraria.add(true);
                disponibilidadHoraria.add(false);
                break;
            default:
                disponibilidadHoraria.add(false);
                disponibilidadHoraria.add(false);
                disponibilidadHoraria.add(true);
                break;
        }
        equipo.setDisponibilidadHoraria(disponibilidadHoraria);
        equipo.setJugadores(crearJugadores(entrada));
        equipos.add(equipo);
    }
    public static ArrayList<Equipo> anotarEquipos() {
        ArrayList<Equipo> equipos=new ArrayList<>();
        char respuesta;
        Scanner entrada=new Scanner(System.in);
        do {
            System.out.println("¿Crear nuevo equipo? (S/N)");
            respuesta=entrada.next().charAt(0);
            while(respuesta!='s' && respuesta!='S' && respuesta!='n' && respuesta!='N') {
                System.out.println("\nPor favor ingrese s,S ó n,N:");
                respuesta=entrada.next().charAt(0);
            }
            if(respuesta=='s' || respuesta=='S') {
                crearEquipo(equipos,entrada);
            }
        } while(respuesta=='s' || respuesta=='S');
        return equipos;
    }
    public static boolean equiposLibres(ArrayList<Partido> partidosDelDia,int i,int j) {
        for(Partido partido:partidosDelDia) {
            if(partido.getEquipo1()==i || partido.getEquipo1()==j || partido.getEquipo2()==i || partido.getEquipo2()==j) {
                return false;
            }
        }
        return true;
    }
    public static boolean oponentePendiente(ArrayList<ArrayList<Partido>> fixture,int i,int j) {
        for(ArrayList<Partido> partidosDelDia:fixture) {
            for(Partido partido:partidosDelDia) {
                if ((partido.getEquipo1() == i || partido.getEquipo2() == i) && (partido.getEquipo1() == j || partido.getEquipo2() == j)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean partidosPendientes(ArrayList<ArrayList<Partido>> fixture,ArrayList<Equipo> equiposDelTurno) {
        for(int i=0;i<equiposDelTurno.size();i++) {
            ArrayList<Partido> partidosJugadosPorEquipo=new ArrayList<>();
            for(ArrayList<Partido> partidosDelDia:fixture) {
                for(Partido partido:partidosDelDia) {
                    if(partido.getEquipo1()==i || partido.getEquipo2()==i) {
                        partidosJugadosPorEquipo.add(partido);
                    }
                }
            }
            if(partidosJugadosPorEquipo.size()!=equiposDelTurno.size()-1) {
                return true;
            }
        }
        return false;
    }
    public static ArrayList<ArrayList<Partido>> armarFixture(ArrayList<Equipo> equipos,int turno) {
        ArrayList<ArrayList<Partido>> fixture=new ArrayList<>();
        ArrayList<Equipo> equiposDelTurno=new ArrayList<>();
        for(Equipo equipo:equipos) {
            if(equipo.getDisponibilidadHoraria().get(turno)) {
                equiposDelTurno.add(equipo);
            }
        }
        do {
            ArrayList<Partido> partidosDelDia=new ArrayList<>();
            for(int i=0;i<equiposDelTurno.size();i++) {
                for(int j=0;j<equiposDelTurno.size();j++) {
                    if(i!=j) {
                        if(equiposLibres(partidosDelDia,i,j) && oponentePendiente(fixture,i,j)) {
                            Partido partido=new Partido(i,j,equiposDelTurno.get(i).getNombre(),equiposDelTurno.get(i).getNombre());
                            partidosDelDia.add(partido);
                        }
                    }
                }
            }
            fixture.add(partidosDelDia);
        } while(partidosPendientes(fixture,equiposDelTurno));
        return fixture;
    }
    public static void identificarDiaSemana(int i) {
        while(i>5) {
            i-=6;
        }
        switch(i) {
            case 0:
                System.out.println("\nLunes:");
                break;
            case 1:
                System.out.println("Martes:");
                break;
            case 2:
                System.out.println("Miércoles:");
                break;
            case 3:
                System.out.println("Jueves:");
                break;
            case 4:
                System.out.println("Viernes:");
                break;
            case 5:
                System.out.println("Sábado:");
                break;
        }
    }
    public static void mostrarFixture(ArrayList<ArrayList<Partido>> fixture) {
        for(int i=0;i<fixture.size();i++) {
            identificarDiaSemana(i);
            for(Partido partido:fixture.get(i)) {
                System.out.println("\n"+partido.getEquipo1Nombre()+" vs. "+partido.getEquipo2Nombre());
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Equipo> equipos=anotarEquipos();
        ArrayList<ArrayList<Partido>> fixtureManiana=armarFixture(equipos,0);
        ArrayList<ArrayList<Partido>> fixtureTarde=armarFixture(equipos,1);
        ArrayList<ArrayList<Partido>> fixtureNoche=armarFixture(equipos,2);
        System.out.println("\nA continuación se muestran los fixtures diseñados para cada turno:");
        mostrarFixture(fixtureManiana);
        mostrarFixture(fixtureTarde);
        mostrarFixture(fixtureNoche);
    }
}