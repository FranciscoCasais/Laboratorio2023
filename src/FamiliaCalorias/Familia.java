package FamiliaCalorias;

import Humanos.Persona;

import java.util.ArrayList;
import java.util.HashSet;

public class Familia {
    private HashSet<IntegranteFamilia>integrantes;

    public Familia(HashSet<IntegranteFamilia> integrantes) {
        this.integrantes = integrantes;
    }
    public Familia() {
        this.integrantes = new HashSet<IntegranteFamilia>();
    }

    public HashSet<IntegranteFamilia> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(HashSet<IntegranteFamilia> integrantes) {
        this.integrantes = integrantes;
    }

    public float promedioCaloriasFamilia(){
        float caloriasTotales = 0.0f;
        for (IntegranteFamilia integranteFamilia : integrantes){
            caloriasTotales += integranteFamilia.caloriasTotales();
        }
        return caloriasTotales/integrantes.size();
    }
    public IntegranteFamilia personaMasCalorica(){
        IntegranteFamilia persona = new IntegranteFamilia();
        for (IntegranteFamilia integranteFamilia : integrantes){
            if (persona.caloriasTotales() <= integranteFamilia.caloriasTotales()){
                persona = integranteFamilia;
            }
        }
        return persona;
    }
    public IntegranteFamilia personaMenosCalorica(){
        IntegranteFamilia persona = new IntegranteFamilia();
        boolean contador = false;
        for (IntegranteFamilia integranteFamilia : integrantes){
            if (!(contador) || persona.caloriasTotales() > integranteFamilia.caloriasTotales()){
                persona = integranteFamilia;
                contador = true;
            }
        }
        return persona;
    }
}
