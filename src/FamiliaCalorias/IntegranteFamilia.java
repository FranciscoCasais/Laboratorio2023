package FamiliaCalorias;
import Cosas.Fecha;
import Humanos.Persona;

import java.util.ArrayList;

public class IntegranteFamilia extends Persona {
    private ArrayList<Plato> platos;

    public IntegranteFamilia(String nombre, Fecha fechaNacimiento, ArrayList<Plato> platos) {
        super(nombre, fechaNacimiento);
        this.platos = platos;
    }
    public IntegranteFamilia() {
        super();
        this.platos = new ArrayList<Plato>();
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public int caloriasTotales(){
        int caloriasTotales = 0;
        for (Plato plato : platos){
            caloriasTotales += plato.getCalorias();
        }
        return caloriasTotales;
    }
}
