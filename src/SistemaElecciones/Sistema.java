package SistemaElecciones;
import java.util.*;
import SeresHumanos.Candidato;
import SeresHumanos.Votante;
public class Sistema {
    private HashSet<Partido> partidos;
    private HashSet<Votante> padron;
    public Sistema() {
        partidos=new HashSet<>();
        padron=new HashSet<>();
    }
    public Sistema(HashSet<Partido> partidos,HashSet<Votante> padron) {
        this.partidos=partidos;
        this.padron=padron;
    }
    public HashSet<Partido> getPartidos() { return partidos; }
    public HashSet<Votante> getPadron() { return padron; }
    public void setPartidos(HashSet<Partido> partidos) { this.partidos=partidos; }
    public void setPadron(HashSet<Votante> padron) { this.padron=padron; }
    public Candidato candidatoGanador() {
        boolean entrar=true;
        Candidato candidatoGanador=new Candidato();
        for(Partido partido:partidos) {
            if(entrar) {
                candidatoGanador=partido.getRepresentante();
                entrar=false;
            } else if(candidatoGanador.votosTotales()<partido.getRepresentante().votosTotales()) candidatoGanador=partido.getRepresentante();
        }
        return candidatoGanador;
    }
    public double porcentajeNoVotantes() {
        int noVoto=0;
        for(Votante votante:padron) {
            if(!votante.getVoto()) noVoto++;
        }
        return (noVoto*100)/padron.size();
    }
    public Votante encontrarVotante(int dni) {
        for(Votante votante:padron) {
            if(votante.getDni()==dni) return votante;
        }
        return null;
    }
    public static void main(String[] args) {
        Sistema sistema=new Sistema();

        Votante v1=new Votante(false,1,Provincia.CABA);
        Votante v2=new Votante(false,2,Provincia.CABA);
        Votante v3=new Votante(false,3,Provincia.BUENOSAIRES);
        Votante v4=new Votante(false,4,Provincia.BUENOSAIRES);
        Votante v5=new Votante(false,5,Provincia.BUENOSAIRES);
        Votante v6=new Votante(false,6,Provincia.CORDOBA);
        Votante v7=new Votante(false,7,Provincia.CORDOBA);
        Votante v8=new Votante(false,8,Provincia.SANTAFE);
        Votante v9=new Votante(false,9,Provincia.SANTAFE);
        Votante v10=new Votante(false,10,Provincia.MENDOZA);
        Votante v11=new Votante(false,11,Provincia.MENDOZA);
        Votante v12=new Votante(false,12,Provincia.ENTRERIOS);
        Votante v13=new Votante(false,13,Provincia.ENTRERIOS);
        Votante v14=new Votante(false,14,Provincia.TUCUMAN);
        Votante v15=new Votante(false,15,Provincia.TUCUMAN);
        Votante v16=new Votante(false,16,Provincia.SALTA);

        Scanner entrada=new Scanner(System.in);
        System.out.print("Ingrese su DNI: ");
        int dni=entrada.nextInt();
        entrada.nextLine();
        Votante usuario=sistema.encontrarVotante(dni);
        while(usuario==null) {
            System.out.print("El DNI no se encuentra en el padrón, intente nuevamente: ");
            dni=entrada.nextInt();
            entrada.nextLine();
            usuario=sistema.encontrarVotante(dni);
        }
        int respuesta=0;
        do {
            System.out.print("1. Votar a un partido\n2. Mostrar votos por candidato\n3. Mostrar candidato ganador actual\n4. Mostrar porcentaje de personas que no votaron\n5. Salir\n\nIngrese el dígito correspondiente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
            while(respuesta<1 || respuesta>5) {
                System.out.print("Dígito no válido, intente nuevamente: ");
                respuesta=entrada.nextInt();
                entrada.nextLine();
            }
            switch(respuesta) {
                case 1:
                    usuario.emitirVoto(sistema.getPartidos());
                    break;
                case 2:
                    for(Partido partido:sistema.getPartidos()) {
                        System.out.println("\n\n"+partido.getRepresentante().getNombre()+" "+partido.getRepresentante().getApellido()+":\n");
                        partido.getRepresentante().mostrarVotos();
                    }
                    break;
                case 3:
                    Candidato candidatoGanador=sistema.candidatoGanador();
                    System.out.println("El candidato con más votos actualmente es "+candidatoGanador.getNombre()+" "+candidatoGanador.getApellido()+", del partido "+candidatoGanador.getPartidoPolitico().getNombre()+".");
                    break;
                case 4:
                    System.out.println("El "+sistema.porcentajeNoVotantes()+"% del padrón no votó.");
                    break;
            }
        } while(respuesta!=5);
    }
}