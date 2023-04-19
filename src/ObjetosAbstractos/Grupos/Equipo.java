package ObjetosAbstractos.Grupos;
import SeresHumanos.Jugador;

import java.util.ArrayList;
public class Equipo {
    ArrayList<Boolean> disponibilidadHoraria;
    ArrayList<Jugador> jugadores;
    private String barrioProcedencia,nombre;
    public Equipo() {
        disponibilidadHoraria=new ArrayList<>();
        jugadores=new ArrayList<>();
        barrioProcedencia="";
        nombre="";
    }
    public ArrayList<Boolean> getDisponibilidadHoraria() { return disponibilidadHoraria; }
    public ArrayList<Jugador> getJugadores() { return jugadores; }
    public String getBarrioProcedencia() { return barrioProcedencia; }
    public String getNombre() { return nombre; }
    public void setJugadores(ArrayList<Jugador> jugadores) { this.jugadores=jugadores; }
    public void setDisponibilidadHoraria(ArrayList<Boolean> disponibilidadHoraria) { this.disponibilidadHoraria=disponibilidadHoraria; }
    public void setBarrioProcedencia(String barrioProcedencia) { this.barrioProcedencia=barrioProcedencia; }
    public void setNombre(String nombre) { this.nombre=nombre; }
}