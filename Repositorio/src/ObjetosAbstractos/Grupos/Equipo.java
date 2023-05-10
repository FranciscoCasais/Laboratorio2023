package ObjetosAbstractos.Grupos;
import ObjetosAbstractos.Otros.Turno;
import SeresHumanos.Jugador;
import java.util.ArrayList;
public class Equipo {
    Turno turno;
    ArrayList<Jugador> jugadores;
    private String barrioProcedencia,nombre;
    public Equipo() {
        turno=null;
        jugadores=new ArrayList<>();
        barrioProcedencia="";
        nombre="";
    }
    public Turno getTurno() { return turno; }
    public ArrayList<Jugador> getJugadores() { return jugadores; }
    public String getBarrioProcedencia() { return barrioProcedencia; }
    public String getNombre() { return nombre; }
    public void setJugadores(ArrayList<Jugador> jugadores) { this.jugadores=jugadores; }
    public void setTurno(Turno turno) { this.turno=turno; }
    public void setBarrioProcedencia(String barrioProcedencia) { this.barrioProcedencia=barrioProcedencia; }
    public void setNombre(String nombre) { this.nombre=nombre; }
}