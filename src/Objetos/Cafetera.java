package Objetos;
public class Cafetera {
    private double cantidadActual, cantidadMaxima;

    public Cafetera() {
        cantidadActual = 0;
        cantidadMaxima = 1000;
    }

    public Cafetera(double cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public Cafetera(double cantidadActual, double cantidadMaxima) {
        if (cantidadActual > cantidadMaxima) {
            this.cantidadActual = cantidadMaxima;
        } else {
            this.cantidadActual = cantidadActual;
        }
        this.cantidadMaxima = cantidadMaxima;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public double getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadActual(double cantidadActual) {
        if (cantidadActual > cantidadMaxima) {
            this.cantidadActual = cantidadMaxima;
        } else {
            this.cantidadActual = cantidadActual;
        }
    }

    public void setCantidadMaxima(double cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public void llenarCafetera() {
        cantidadActual = cantidadMaxima;
    }

    public void servirTaza(int capacidad) {
        if (cantidadActual >= capacidad) {
            cantidadActual -= capacidad;
        } else {
            cantidadActual = 0;
        }
    }

    public void vaciarCafetera() {
        cantidadActual = 0;
    }

    public void agregarCafe(int cantidad) {
        if (cantidadActual + cantidad <= cantidadMaxima) {
            cantidadActual += cantidad;
        } else {
            System.out.println("Error: cantidad máxima de la cafetera excedida.");
        }
    }
}