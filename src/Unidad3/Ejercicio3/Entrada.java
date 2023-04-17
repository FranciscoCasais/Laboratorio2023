package Unidad3.Ejercicio3;
public class Entrada extends Componente {
    private boolean teclado,mouse;
    private String puertosValidos,tipoConector;
    public Entrada() {
        super();
        teclado=false;
        mouse=false;
        puertosValidos="";
        tipoConector="";
    }
    public boolean getTeclado() { return teclado; }
    public boolean getMouse() { return mouse; }
    public String getPuertosValidos() { return puertosValidos; }
    public String getTipoConector() { return tipoConector; }
    public void setTeclado(boolean teclado) { this.teclado=teclado; }
    public void setMouse(boolean mouse) { this.mouse=mouse; }
    public void setPuertosValidos(String puertosValidos) { this.puertosValidos=puertosValidos; }
    public void setTipoConector(String tipoConector) { this.tipoConector=tipoConector; }
}