package ObjetosFisicos.Componentes;
public class Televisor extends Multimedia {
    private int resolucion;
    private String tecnologia;
    public Televisor() {
        super();
        resolucion=1080;
        tecnologia="FullHD";
    }
    public int getResolucion() { return resolucion; }
    public String getTecnologia() { return tecnologia; }
    public void setResolucion(int resolucion) { this.resolucion=resolucion; }
    public void setTecnologia(String tecnologia) { this.tecnologia=tecnologia; }
}