package EjerciciosInterfaces.Restaurante;
public enum Tipo {
    ENTRADA,PLATOPRINCIPAL,POSTRE;
    @Override
    public String toString() {
        if(!equals(Tipo.PLATOPRINCIPAL)) return name().toLowerCase();
        else return name().toLowerCase().substring(0,5)+" "+name().toLowerCase().substring(5);
    }
}