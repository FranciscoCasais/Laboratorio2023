package FamiliaCalorias;

public class Plato {
    private int calorias;
    private String nombrePlato;

    public Plato(int calorias, String nombrePlato) {
        this.calorias = calorias;
        this.nombrePlato = nombrePlato;
    }
    public Plato() {
        this.calorias = 0;
        this.nombrePlato = "";
    }
    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

}
