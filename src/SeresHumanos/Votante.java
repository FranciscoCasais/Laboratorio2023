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
        provincia=Provincia.BUENOSAIRES;
    }
    public Votante(boolean voto,int dni,Provincia provincia) {
        this.voto=voto;
        this.dni=dni;
        this.provincia=provincia;
    }
    public boolean getVoto() { return voto; }
    public int getDni() { return dni; }
    public String getNacionalidad() { return nacionalidad; }
    public void setVoto(boolean voto) { this.voto=voto; }
    public void setDni(int dni) { this.dni=dni; }
    public static void setNacionalidad(String nacionalidad) { Votante.nacionalidad=nacionalidad; }
    public void emitirVoto(HashSet<Partido> partidos) {
        boolean deseleccionar,entrar=true,terminar=false;
        int i,respuesta;
        HashMap<Integer,Partido> idPartidos=new HashMap<>();
        Scanner entrada=new Scanner(System.in);
        if(!this.getVoto()) {
            do {
                i=1;
                System.out.println("Seleccione al candidato:\n");
                for(Partido partido:partidos) {
                    if(entrar) idPartidos.put(i,partido);
                    System.out.println(i+" "+partido.getRepresentante().getNombre()+" "+partido.getRepresentante().getApellido()+", "+partido.getNombre());
                    i++;
                }
                entrar=false;
                System.out.print(i+". Cancelar\n\nIngrese el dígito correspondiente: ");
                respuesta=entrada.nextInt();
                entrada.nextLine();
                while(respuesta<1 || respuesta>i) {
                    System.out.print("Dígito no válido, intente nuevamente: ");
                    respuesta=entrada.nextInt();
                    entrada.nextLine();
                }
                if(respuesta!=i) {
                    do {
                        Partido partidoSeleccionado=idPartidos.get(respuesta);
                        deseleccionar=false;
                        System.out.print("Seleccionó a "+partidoSeleccionado.getRepresentante().getNombre()+partidoSeleccionado.getRepresentante().getApellido()+", del partido "+partidoSeleccionado.getNombre()+"\n\n1. Ver propuestas\n2. Votar\n3. Atrás\n\nIngrese el dígito correspondiente: ");
                        respuesta=entrada.nextInt();
                        entrada.nextLine();
                        while(respuesta<1 || respuesta>3) {
                            System.out.print("Dígito no válido, intente nuevamente: ");
                            respuesta=entrada.nextInt();
                            entrada.nextLine();
                        }
                        switch(respuesta) {
                            case 1:
                                partidoSeleccionado.getRepresentante().mostrarPropuestas();
                                System.out.print("\nIngrese cualquier dígito para volver atrás: ");
                                respuesta=entrada.nextInt();
                                entrada.nextLine();
                                break;
                            case 2:
                                partidoSeleccionado.getRepresentante().getVotosPorProvincia().put(provincia,partidoSeleccionado.getRepresentante().getVotosPorProvincia().get(provincia)+1);
                                voto=!voto;
                                deseleccionar=true;
                                terminar=true;
                                System.out.println("Se emitió el voto exitosamente.");
                                break;
                            default:
                                deseleccionar=true;
                                break;
                        }
                    } while(!deseleccionar);
                } else terminar=true;
            } while(!terminar);
        } else System.out.println("Usted ya emitió su voto.");
    }
}