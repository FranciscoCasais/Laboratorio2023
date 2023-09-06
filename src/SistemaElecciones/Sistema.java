package SistemaElecciones;
import java.util.*;
import SeresHumanos.Candidato;
import SeresHumanos.Votante;
import Tiempo.Fecha;
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

        // agregar datos al sistema:
        HashSet<String> propuestas=new HashSet<>();
        propuestas.add("chamuyo 1");
        propuestas.add("chamuyo 2");
        propuestas.add("chamuyo 3");
        propuestas.add("chamuyo 4");
        propuestas.add("chamuyo 5");
        HashMap<Tema,HashSet<String>> propuestasPorTema=new HashMap<>();
        propuestasPorTema.put(Tema.AMBIENTE,propuestas);
        propuestasPorTema.put(Tema.ECONOMIA,propuestas);
        propuestasPorTema.put(Tema.EDUCACION,propuestas);
        propuestasPorTema.put(Tema.SALUD,propuestas);
        propuestasPorTema.put(Tema.SEGURIDAD,propuestas);

        Partido p1=Partido.FRENTECONST;
        Candidato c1=new Candidato(new Fecha(),100,propuestasPorTema,Partido.FRENTECONST,"Schiaretti","JUAAAAAN");
        p1.setRepresentante(c1);
        Partido p2=Partido.JUNTOSXPOLI;
        Candidato c2=new Candidato(new Fecha(),200,propuestasPorTema,Partido.JUNTOSXPOLI,"Bullrich","Codicia");
        p2.setRepresentante(c2);
        Partido p3=Partido.POLIAVANZA;
        Candidato c3=new Candidato(new Fecha(),300,propuestasPorTema,Partido.POLIAVANZA,"Milanga","Javier");
        p3.setRepresentante(c3);
        Partido p4=Partido.UNIONXDOCENCIA;
        Candidato c4=new Candidato(new Fecha(),400,propuestasPorTema,Partido.UNIONXDOCENCIA,"Sarassa","Sergio");
        p4.setRepresentante(c4);
        HashSet<Partido> partidos=new HashSet<>();
        partidos.add(p1);
        partidos.add(p2);
        partidos.add(p3);
        partidos.add(p4);

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
        Votante v17=new Votante(false,17,Provincia.SALTA);
        Votante v18=new Votante(false,18,Provincia.CATAMARCA);
        Votante v19=new Votante(false,19,Provincia.CHACO);
        Votante v20=new Votante(false,20,Provincia.CHUBUT);
        Votante v21=new Votante(false,21,Provincia.CORRIENTES);
        Votante v22=new Votante(false,22,Provincia.FORMOSA);
        Votante v23=new Votante(false,23,Provincia.JUJUY);
        Votante v24=new Votante(false,24,Provincia.LAPAMPA);
        Votante v25=new Votante(false,25,Provincia.LARIOJA);
        Votante v26=new Votante(false,26,Provincia.MISIONES);
        Votante v27=new Votante(false,27,Provincia.NEUQUEN);
        Votante v28=new Votante(false,28,Provincia.RIONEGRO);
        Votante v29=new Votante(false,29,Provincia.SANJUAN);
        Votante v30=new Votante(false,30,Provincia.SANLUIS);
        Votante v31=new Votante(false,31,Provincia.SANTACRUZ);
        Votante v32=new Votante(false,32,Provincia.SANTIAGOESTERO);
        Votante v33=new Votante(false,33,Provincia.TIERRAFUEGO);
        Votante v34=new Votante(false,34,Provincia.TUCUMAN);
        HashSet<Votante> padron=new HashSet<>();
        padron.add(v1);
        padron.add(v2);
        padron.add(v3);
        padron.add(v4);
        padron.add(v5);
        padron.add(v6);
        padron.add(v7);
        padron.add(v8);
        padron.add(v9);
        padron.add(v10);
        padron.add(v11);
        padron.add(v12);
        padron.add(v13);
        padron.add(v14);
        padron.add(v15);
        padron.add(v16);
        padron.add(v17);
        padron.add(v18);
        padron.add(v19);
        padron.add(v20);
        padron.add(v21);
        padron.add(v22);
        padron.add(v23);
        padron.add(v24);
        padron.add(v25);
        padron.add(v26);
        padron.add(v27);
        padron.add(v28);
        padron.add(v29);
        padron.add(v30);
        padron.add(v31);
        padron.add(v32);
        padron.add(v33);
        padron.add(v34);

        Sistema sistema=new Sistema(partidos,padron);

        // codigo:
        boolean cambiar,terminar;
        int respuesta=0;
        Scanner entrada=new Scanner(System.in);
        do {
            cambiar=false;
            terminar=false;
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
            do {
                System.out.print("1. Votar a un partido\n2. Mostrar votos por candidato\n3. Mostrar candidato ganador actual\n4. Mostrar porcentaje de personas que no votaron\n5. Cambiar de usuario\n6. Salir\n\nIngrese el dígito correspondiente: ");
                respuesta=entrada.nextInt();
                entrada.nextLine();
                while(respuesta<1 || respuesta>6) {
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
                        System.out.println("El candidato con más votos actualmente es "+candidatoGanador.getNombre()+" "+candidatoGanador.getApellido()+", del partido "+candidatoGanador.getPartidoPolitico().getNombre()+", con "+candidatoGanador.votosTotales()+" votos.");
                        break;
                    case 4:
                        System.out.println("El "+sistema.porcentajeNoVotantes()+"% del padrón no votó.");
                        break;
                    case 5:
                        cambiar=true;
                        break;
                    default:
                        cambiar=true;
                        terminar=true;
                        break;
                }
            } while(!cambiar);
        } while(!terminar);
    }
}