package EjerciciosInterfaces.CampaniaElecciones;
public class Celular implements Mensajero {
    private CompaniaTelefonica companiaTelefonica;
    private int numeroSerie;
    private long numero;
    private String fabricante,modelo;
    public Celular() {
        companiaTelefonica=CompaniaTelefonica.CLARO;
        numeroSerie=0;
        numero=0;
        fabricante="";
        modelo="";
    }
    public Celular(CompaniaTelefonica companiaTelefonica, int numeroSerie, long numero, String fabricante, String modelo) {
        this.companiaTelefonica = companiaTelefonica;
        this.numeroSerie = numeroSerie;
        this.numero = numero;
        this.fabricante = fabricante;
        this.modelo = modelo;
    }
    public CompaniaTelefonica getCompaniaTelefonica() { return companiaTelefonica; }
    public void setCompaniaTelefonica(CompaniaTelefonica companiaTelefonica) { this.companiaTelefonica = companiaTelefonica; }
    public int getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(int numeroSerie) { this.numeroSerie = numeroSerie; }
    public long getNumero() { return numero; }
    public void setNumero(long numero) { this.numero = numero; }
    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
}
