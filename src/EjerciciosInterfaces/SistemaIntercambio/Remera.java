package EjerciciosInterfaces.SistemaIntercambio;
public class Remera extends PrendaDeRopa {
    private double contorno,largoTorso,medidaEspalda;
    public Remera() {
        contorno=0;
        largoTorso=0;
        medidaEspalda=0;
    }
    public Remera(double contorno,double largoTorso,double medidaEspalda,Estado estado,Material material,String color,String marca) {
        super(estado,material,color,marca);
        this.contorno=contorno;
        this.largoTorso=largoTorso;
        this.medidaEspalda=medidaEspalda;
    }
    public double getContorno() { return contorno; }
    public void setContorno(double contorno) { this.contorno=contorno; }
    public double getLargoTorso() { return largoTorso; }
    public void setLargoTorso(double largoTorso) { this.largoTorso=largoTorso; }
    public double getMedidaEspalda() { return medidaEspalda; }
    public void setMedidaEspalda(double medidaEspalda) { this.medidaEspalda=medidaEspalda; }
    @Override
    public String toString() { return "Estado:\n"+getEstado().toString()+"\nMaterial: "+getMaterial().toString()+"\nColor: "+getColor()+"\nMarca: "+getMarca()+"\nContorno (cm): "+contorno+"\nLargo del torso (cm): "+largoTorso+"\nEspalda (cm): "+medidaEspalda; }
}