package Tiempo;
public class Hora {
    private int horas,minutos;
    public Hora() {
        horas=0;
        minutos=0;
    }
    public int getHoras() { return horas; }
    public int getMinutos() { return minutos; }
    public void setHoras(int horas) { this.horas=horas; }
    public void setMinutos(int minutos) { this.minutos=minutos; }
    public void sumarHoras(Hora hora1,Hora hora2) {
        if(hora1.getMinutos()+hora2.getMinutos()<=59) { minutos=hora1.getMinutos()+hora2.getMinutos(); }
        else {
            horas=1;
            minutos=(hora1.getMinutos()+hora2.getMinutos())-60;
        }
        horas+=hora1.getHoras()+hora2.getHoras();
    }
}