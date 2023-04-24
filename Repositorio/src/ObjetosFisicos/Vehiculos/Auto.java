package ObjetosFisicos.Vehiculos;

public class Auto extends Motorizado {
    private boolean descapotable;
    private double velocidad;
    private String color, marca, modelo;
    public Auto() {
        super();
        descapotable=false;
        velocidad=0.00;
        color="";
        marca="";
        modelo="";
    }
    public boolean getDescapotable() { return descapotable; }
    public double getVelocidad() { return velocidad; }
    public String getColor() { return color; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public void setDescapotable(boolean descapotable) { this.descapotable=descapotable; }
    public void setVelocidad(double velocidad) { this.velocidad=velocidad; }
    public void setColor(String color) { this.color=color; }
    public void setMarca(String marca) { this.marca=marca; }
    public void setModelo(String modelo) { this.modelo=modelo; }
    public double acelerar(double tiempo, double velocidad) { return this.velocidad+=velocidad/tiempo; }
    public double frenar(double tiempo, double velocidad) { return this.velocidad-=velocidad/tiempo; }
}