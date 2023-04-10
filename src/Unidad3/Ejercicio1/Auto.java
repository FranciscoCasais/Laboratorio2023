package Unidad3.Ejercicio1;
public class Auto extends Motorizado {
    private boolean descapotable;
    public Auto() {
        super();
        descapotable=false;
    }
    public boolean getDescapotable() { return descapotable; }
    public void setDescapotable(boolean descapotable) { this.descapotable=descapotable; }
}