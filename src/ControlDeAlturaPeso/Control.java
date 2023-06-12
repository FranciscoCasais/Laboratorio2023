package ControlDeAlturaPeso;
import java.time.LocalDate;
public class Control {
    private float altura;
    private float peso;

    public Control(float altura, float peso) {
        this.altura = altura;
        this.peso = peso;
    }

    public Control() {
        this.altura = 0.0f;
        this.peso = 0.0f;
    }
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void agregarPeso(float aumento){
        peso+=aumento;
    }
    public void agregarAltura(float aumento){
        altura+=aumento;
    }
}
