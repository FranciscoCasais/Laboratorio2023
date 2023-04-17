package Unidad3.Ejercicio4;
public class Sensor {
    protected boolean estado;
    protected double valorActual,valorUmbral;
    protected int anioCompra;
    public Sensor() {
        estado=false;
        valorActual=0.00;
        valorUmbral=0.00;
        anioCompra=2023;
    }
    public boolean getEstado() { return estado; }
    public double getValorActual() { return valorActual; }
    public double getValorUmbral() { return valorUmbral; }
    public int getAnioCompra() { return anioCompra; }
    public void setEstado(boolean estado) { this.estado=estado; }
    public void setValorActual(double valorActual) { this.valorActual=valorActual; }
    public void setValorUmbral(double valorUmbral) { this.valorUmbral=valorUmbral; }
    public void setAnioCompra(int anioCompra) { this.anioCompra=anioCompra; }
}