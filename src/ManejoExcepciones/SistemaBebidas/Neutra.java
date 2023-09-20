package ManejoExcepciones.SistemaBebidas;
public class Neutra extends Bebida {
    private float coeficienteNegatividad,coeficientePositividad;
    public Neutra() {
        coeficienteNegatividad=0;
        coeficientePositividad=0;
    }
    public Neutra(float coeficienteNegatividad,float coeficientePositividad,String nombre) {
        super(nombre);
        this.coeficienteNegatividad=coeficienteNegatividad;
        this.coeficientePositividad=coeficientePositividad;
    }
    public float getCoeficienteNegatividad() { return coeficienteNegatividad; }
    public void setCoeficienteNegatividad(float coeficienteNegatividad) { this.coeficienteNegatividad=coeficienteNegatividad; }
    public float getCoeficientePositividad() { return coeficientePositividad; }
    public void setCoeficientePositividad(float coeficientePositividad) { this.coeficientePositividad=coeficientePositividad; }
    public float coeficienteHidratacion(int cantidad) { return cantidad*(coeficientePositividad-coeficienteNegatividad); }
}