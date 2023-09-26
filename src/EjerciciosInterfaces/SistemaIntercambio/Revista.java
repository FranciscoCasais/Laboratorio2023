package EjerciciosInterfaces.SistemaIntercambio;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
public class Revista extends LibroDeTexto implements Prestable {
    private Month mesPublicacion;
    private MonthDay diaPublicacion;
    public Revista() {
        super();
        mesPublicacion=null;
        diaPublicacion=null;
    }
    public Revista(int codigo,Month mesPublicacion,MonthDay diaPublicacion,String titulo,Year anioPublicacion) {
        super(codigo,titulo,anioPublicacion);
        this.mesPublicacion=mesPublicacion;
        this.diaPublicacion=diaPublicacion;
    }
    public Month getMesPublicacion() { return mesPublicacion; }
    public void setMesPublicacion(Month mesPublicacion) { this.mesPublicacion=mesPublicacion; }
    public MonthDay getDiaPublicacion() { return diaPublicacion; }
    public void setDiaPublicacion(MonthDay diaPublicacion) { this.diaPublicacion=diaPublicacion; }
    @Override
    public boolean cumpleCondicionesPrestar() {
        int mesActual=LocalDate.now().getMonthValue(),mesPublicacionRevista=mesPublicacion.getValue();
        while(mesActual%3!=0) mesActual++;
        while(mesPublicacionRevista%3!=0) mesPublicacionRevista++;
        return !getAnioPublicacion().equals(LocalDate.now().getYear()) || mesActual!=mesPublicacionRevista;
    }
    @Override
    public String toString() { return "Código: "+getCodigo()+"\nTítulo: "+getTitulo()+"\nAño de publicación: "+getAnioPublicacion().getValue()+"\nMes de publicación: "+mesPublicacion+"\nDía de publicación: "+diaPublicacion; }
    @Override
    public void prestar() {
        if(cumpleCondicionesPrestar()) System.out.println("La revista se dará prestada.");
        else System.out.println("La revista no se prestará.");
    }
}