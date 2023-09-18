package SistemaCine;
import java.time.LocalDateTime;
public class Funcion {
    private int butacasOcupadas;
    private LocalDateTime fechaHora;
    private Pelicula pelicula;
    private Sala sala;
    public Funcion() {
        butacasOcupadas=0;
        fechaHora=null;
        pelicula=new Pelicula();
        sala=new Sala();
    }
    public Funcion(int butacasOcupadas,LocalDateTime fechaHora,Pelicula pelicula,Sala sala) {
        this.butacasOcupadas=butacasOcupadas;
        this.fechaHora=fechaHora;
        this.pelicula=pelicula;
        this.sala=sala;
    }
    public int getButacasOcupadas() { return butacasOcupadas; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public void setButacasOcupadas(int butacasOcupadas) { this.butacasOcupadas=butacasOcupadas; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora=fechaHora; }
    public void setPelicula(Pelicula pelicula) { this.pelicula=pelicula; }
    public void setSala(Sala sala) { this.sala=sala; }
    public String toString() {
        if(getFechaHora().getMinute()<10) {
            String minutos="0"+getFechaHora().getMinute();
            return getPelicula().toString()+", "+getFechaHora().getDayOfMonth()+"/"+getFechaHora().getMonth()+"/"+getFechaHora().getYear()+" "+getFechaHora().getHour()+":"+minutos;
        } else return getPelicula().toString()+", "+getFechaHora().getDayOfMonth()+"/"+getFechaHora().getMonth()+"/"+getFechaHora().getYear()+" "+getFechaHora().getHour()+":"+getFechaHora().getMinute();
    }
}