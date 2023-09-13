package SistemaCine;
public class Sala {
    private int numeroSala;
    private static int capacidad=45;
    public Sala() { numeroSala=0; }
    public Sala(int numeroSala) { this.numeroSala=numeroSala; }
    public int getNumeroSala() { return numeroSala; }
    public void setNumeroSala(int numeroSala) { this.numeroSala=numeroSala; }
    public static int getCapacidad() { return capacidad; }
    public static void setCapacidad(int capacidad) { Sala.capacidad=capacidad; }
}