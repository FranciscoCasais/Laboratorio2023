package ObjetosFisicos.Componentes;
import ObjetosAbstractos.Sistemas.Tecnologia;
public class Televisor extends Multimedia {
    private int resolucion;
    private Tecnologia tecnologia;
    public Televisor() {
        super();
        resolucion=1080;
        tecnologia=null;
    }
    public int getResolucion() { return resolucion; }
    public Tecnologia getTecnologia() { return tecnologia; }
    public void setResolucion(int resolucion) { this.resolucion=resolucion; }
    public void setTecnologia(Tecnologia tecnologia) { this.tecnologia=tecnologia; }
}