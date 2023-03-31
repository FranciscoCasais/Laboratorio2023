package Unidad1;
public class Rectangulo {
    private double altura, base;

    public Rectangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public double getBase() {
        return base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double calcularArea(double altura, double base) {
        return altura * base;
    }

    public double calcularPerimetro(double altura, double base) {
        return altura * 2 + base * 2;
    }
}