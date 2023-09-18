package ManejoExcepciones.SistemaBebidas;
public class Alcoholica extends Bebida {
    private float cantidadAlcohol,coeficienteNegatividad;
    private static float coeficientePositividad=0;
    public Alcoholica() {
        cantidadAlcohol=0;
        coeficienteNegatividad=0;
    }
    public Alcoholica(float cantidadAlcohol) {
        this.cantidadAlcohol=cantidadAlcohol;
        coeficienteNegatividad=cantidadAlcohol*20;
    }
    public float getCantidadAlcohol() { return cantidadAlcohol; }
    public void setCantidadAlcohol(float cantidadAlcohol) { this.cantidadAlcohol=cantidadAlcohol; }
    public float getCoeficienteNegatividad() { return coeficienteNegatividad; }
    public void setCoeficienteNegatividad(float coeficienteNegatividad) { this.coeficienteNegatividad=coeficienteNegatividad; }
    public static float getCoeficientePositividad() { return coeficientePositividad; }
    public static void setCoeficientePositividad(float coeficientePositividad) { Alcoholica.coeficientePositividad=coeficientePositividad; }
}