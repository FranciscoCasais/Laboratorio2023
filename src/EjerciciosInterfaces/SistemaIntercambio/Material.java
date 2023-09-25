package EjerciciosInterfaces.SistemaIntercambio;
public enum Material {
    ALGODON,POLIESTER,SEDA;
    public String toString() {
        if(this.equals(ALGODON)) return name().toLowerCase().substring(0,5)+"ó"+name().toLowerCase().charAt(6);
        else if(this.equals(POLIESTER)) return name().toLowerCase().substring(0,4)+"é"+name().toLowerCase().substring(5,9);
        else return name().toLowerCase();
    }
}