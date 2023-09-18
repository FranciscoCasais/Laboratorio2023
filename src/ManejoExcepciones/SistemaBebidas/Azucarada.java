package ManejoExcepciones.SistemaBebidas;
public class Azucarada extends Bebida {
    private float cantidadAzucar,coeficienteNegatividad;
    private static float coeficientePositividad=1;
    public Azucarada() {
        cantidadAzucar=0;
        coeficienteNegatividad=0;
    }
    public Azucarada(float cantidadAzucar) {
        this.cantidadAzucar=cantidadAzucar;
        this.coeficienteNegatividad=cantidadAzucar*10;
    }
    public float getCantidadAzucar() { return cantidadAzucar; }
    public void setCantidadAzucar(float cantidadAzucar) { this.cantidadAzucar=cantidadAzucar; }
    public float getCoeficienteNegatividad() { return coeficienteNegatividad; }
    public void setCoeficienteNegatividad(float coeficienteNegatividad) { this.coeficienteNegatividad=coeficienteNegatividad; }
    public static float getCoeficientePositividad() { return coeficientePositividad; }
    public static void setCoeficientePositividad(float coeficientePositividad) { Azucarada.coeficientePositividad=coeficientePositividad; }
}