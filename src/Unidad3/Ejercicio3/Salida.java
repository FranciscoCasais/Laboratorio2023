package Unidad3.Ejercicio3;
public class Salida extends Componente {
    protected String puertosValidos;
    public Salida() {
        super();
        puertosValidos="";
    }
    public String getPuertosValidos() { return puertosValidos; }
    public void setPuertosValidos(String puertosValidos) { this.puertosValidos=puertosValidos; }
}