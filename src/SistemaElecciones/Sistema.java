package SistemaElecciones;
import java.util.*;
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
    public Votante encontrarDni(int dni) {
        for(Votante votante:padron) {
            if(votante.getDni()==dni) return votante;
        }
        return null;
    }
    public static void main(String[] args) {
        Sistema sistema=new Sistema();
        Scanner entrada=new Scanner(System.in);
        System.out.print("Ingrese su DNI: ");
        int dni=entrada.nextInt();
        entrada.nextLine();
        Votante usuario=sistema.encontrarDni(dni);
        while(usuario==null) {
            System.out.print("El DNI no se encuentra en el padrón, intente nuevamente: ");
            dni=entrada.nextInt();
            entrada.nextLine();
            usuario=sistema.encontrarDni(dni);
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        } while(respuesta!=5);
    }
}