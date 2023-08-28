package SistemaElecciones;
import SeresHumanos.Candidato;
public enum Partido {
    POLIAVANZA("El Poli Avanza"),JUNTOSXPOLI("Juntos por el Poli"),UNIONXDOCENCIA("Unión por la Docencia"),FRENTECONST("Frente de los Constituyentes");
    Candidato representante;
    String nombre;
    Partido(String nombre) {
        representante=new Candidato();
        this.nombre=nombre;
    }
    public Candidato getRepresentante() { return representante; }
    public String getNombre() { return nombre; }
    public void setRepresentante(Candidato representante) { this.representante=representante; }
    public void setNombre(String nombre) { this.nombre=nombre; }
}