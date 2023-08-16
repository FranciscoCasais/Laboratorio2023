package ControlDeAlturaPeso;

import Tiempo.Fecha;
import SeresHumanos.Persona;

import java.util.HashSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Paciente extends Persona {
    private HashMap<LocalDate, Control> controles;

    public Paciente(String nombre, String apellido, Fecha fechaNacimiento, HashMap<LocalDate, Control> controles) {
        super(nombre, apellido, fechaNacimiento);
        this.controles = controles;
    }
    public Paciente() {
        super();
        this.controles = new HashMap<LocalDate, Control>();
    }

    public HashMap<LocalDate, Control> getControles() {
        return controles;
    }

    public void setControles(HashMap<LocalDate, Control> controles) {
        this.controles = controles;
    }
    public void agregarControl(LocalDate fecha, Control control){
        controles.put(fecha, control);
    }
    public Control promedioPesoAltura(int anio){
        Control promedioControl = new Control(0.0f, 0.0f);
        int cantControles = 0;
        for (Map.Entry<LocalDate, Control> entry : controles.entrySet()){
            if (entry.getKey().getYear() == anio){
                promedioControl.agregarAltura(entry.getValue().getAltura());
                promedioControl.agregarPeso(entry.getValue().getPeso());
                cantControles++;
            }
        }
        promedioControl.setPeso(promedioControl.getPeso()/cantControles);
        promedioControl.setAltura(promedioControl.getAltura()/cantControles);
        return promedioControl;
    }

    public float porcentajeCrecimiento(int anioInicial, int anioFinal){
        float alturaInicial=0.0f;
        LocalDate fechaInicial = LocalDate.now();
        LocalDate fechaFinal = LocalDate.now();
        float alturaFinal=0.0f;
        for (Map.Entry<LocalDate, Control> entry : controles.entrySet()){
            if (entry.getKey().getYear() == anioInicial && alturaInicial == 0.0f || entry.getKey().getYear() == anioInicial && entry.getKey().isAfter(fechaInicial)){
                fechaInicial = entry.getKey();
                alturaInicial = entry.getValue().getAltura();
            }
            else if (entry.getKey().getYear() == anioFinal && alturaFinal == 0.0f || entry.getKey().getYear() == anioFinal && entry.getKey().isAfter(fechaFinal)){
                fechaFinal = entry.getKey();
                alturaFinal = entry.getValue().getAltura();
            }
        }
        return ((100.0f / alturaInicial) * alturaFinal) - 100.0f;
    }
    public Control getControl(LocalDate fecha){
        return controles.get(fecha);
    }
}
