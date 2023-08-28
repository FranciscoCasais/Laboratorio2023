package SeresHumanos;
import SistemaElecciones.*;
import java.util.*;
public class Votante extends Persona {
    private boolean voto;
    private int dni;
    private Provincia provincia;
    private static String nacionalidad="argentino/a";
    public Votante() {
        voto=false;
        dni=0;
    }
    public Votante(boolean voto,int dni) {
        this.voto=voto;
        this.dni=dni;
    }
    public boolean getVoto() { return voto; }
    public int getDni() { return dni; }
    public String getNacionalidad() { return nacionalidad; }
    public void setVoto(boolean voto) { this.voto=voto; }
    public void setDni(int dni) { this.dni=dni; }
    public static void setNacionalidad(String nacionalidad) { Votante.nacionalidad=nacionalidad; }
    public void emitirVoto(HashSet<Partido> partidos) {
        int i=1,respuesta;
        Scanner entrada=new Scanner(System.in);
        if(!this.getVoto()) {
            System.out.println("Seleccione al candidato:\n");
            for(Partido partido:partidos) {
                System.out.println(i+" "+partido.getRepresentante().getNombre()+" "+partido.getRepresentante().getApellido()+", "+partido.getNombre());
                i++;
            }
            System.out.print("\nIngrese el dígito correspondiente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
            while(respuesta<1 || respuesta>i) {
                System.out.print("Dígito no válido, intente nuevamente: ");
                respuesta=entrada.nextInt();
                entrada.nextLine();
            }

        } else { System.out.println("Usted ya emitió su voto."); }
    }
}