package EjerciciosInterfaces.SistemaIntercambio;
public class Pantalon extends PrendaDeRopa implements Prestable {
    private double largo,medidaCadera,medidaCintura;
    public Pantalon() {
        super();
        largo=0;
        medidaCadera=0;
        medidaCintura=0;
    }
    public Pantalon(double largo,double medidaCadera,double medidaCintura,Estado estado,Material material,String color,String marca) {
        super(estado,material,color,marca);
        this.largo=largo;
        this.medidaCadera=medidaCadera;
        this.medidaCintura=medidaCintura;
    }
    public double getLargo() { return largo; }
    public void setLargo(double largo) { this.largo=largo; }
    public double getMedidaCadera() { return medidaCadera; }
    public void setMedidaCadera(double medidaCadera) { this.medidaCadera=medidaCadera; }
    public double getMedidaCintura() { return medidaCintura; }
    public void setMedidaCintura(double medidaCintura) { this.medidaCintura=medidaCintura; }
    @Override
    public String toString() { return "Estado:\n"+getEstado().toString()+"\nMaterial: "+getMaterial().toString()+"\nColor: "+getColor()+"\nMarca: "+getMarca()+"\nLargo (cm): "+largo+"\nCadera (cm): "+medidaCadera+"\nCintura (cm): "+medidaCintura; }
    @Override
    public void prestar() {
        // if() System.out.println("El libro se dará prestado.");
        // else System.out.println("El libro no se prestará.");
    }
}