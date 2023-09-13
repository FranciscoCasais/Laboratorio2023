package SistemaCine;
public enum Genero {
    ACCION,AVENTURA,ROMANCE,DRAMA,COMEDIA;
    public String toString() {
        if(this.equals(ACCION)) return name().charAt(0)+name().toLowerCase().substring(1,4)+"ó"+name().toLowerCase().charAt(5);
        else return name().charAt(0)+name().toLowerCase().substring(1,name().length());
    }
}