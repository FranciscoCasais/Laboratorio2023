package Objetos;
public class Coche {
    private double velocidad;
    private String color, marca, modelo;

    public Coche(String color, String marca, String modelo) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double acelerar(double tiempo, double velocidad) {
        return this.velocidad += velocidad / tiempo;
    }

    public double frenar(double tiempo, double velocidad) {
        return this.velocidad -= velocidad / tiempo;
    }
}