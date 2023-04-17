package Unidad3.Ejercicio3;
public class Componente {
    protected double precio;
    protected int stock;
    protected String modelo,nombreFabricante;
    public Componente() {
        precio=0.00;
        stock=0;
        modelo="";
        nombreFabricante="";
    }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public String getModelo() { return modelo; }
    public String getNombreFabricante(){ return nombreFabricante; }
    public void setPrecio(double precio) { this.precio=precio; }
    public void setStock(int stock) { this.stock=stock; }
    public void setModelo(String modelo) { this.modelo=modelo; }
    public void setNombreFabricante(String nombreFabricante) { this.nombreFabricante=nombreFabricante; }
}