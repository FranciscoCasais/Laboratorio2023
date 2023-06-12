package ABM_Lugares;

import java.util.HashSet;

public class Tierra {
    private HashSet<Continente> continentes;

    public Tierra(HashSet<Continente> continentes) {
        this.continentes = continentes;
    }
    public Tierra() {
        this.continentes = new HashSet<Continente>();
    }

    public HashSet<Continente> getContinentes() {
        return continentes;
    }

    public void setContinentes(HashSet<Continente> continentes) {
        this.continentes = continentes;
    }
    public int getPoblacion(int codigo){
        int poblacion = 0;
        for (Continente continente : continentes){
            if (continente.getCodigo() == codigo) {
                poblacion = continente.getPoblacion();
            }
            else{
                for (Pais pais : continente.getPaises()){
                    if (pais.getCodigo() == codigo){
                        poblacion = pais.getPoblacion();
                    }
                    else{
                        for (Estado estado : pais.getEstados()){
                            if (estado.getCodigo() == codigo){
                                poblacion = estado.getPoblacion();
                            }
                            else {
                                for (Ciudad ciudad : estado.getCiudades()) {
                                    if (ciudad.getCodigo() == codigo){
                                        poblacion = ciudad.getPoblacion();
                                    }
                                    else {
                                        for (Barrio barrio : ciudad.getBarrios()){
                                            if (barrio.getCodigo() == codigo){
                                                poblacion = codigo;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return poblacion;
    }
    public void pantallaInformativa (){
        Continente continenteMasPoblado = new Continente();
        Continente continenteMenosPoblado = new Continente();
        Pais paisMasPoblado = new Pais();
        Pais paisMenosPoblado = new Pais();
        boolean contador = false;
        for (Continente continente : continentes){
            if (!contador){
                continenteMasPoblado = continente;
                continenteMenosPoblado = continente;
            }
            else if (continente.getPoblacion() >= continenteMasPoblado.getPoblacion()){
                continenteMasPoblado = continente;
            }
            else if (continente.getPoblacion() <= continenteMenosPoblado.getPoblacion()){
                continenteMenosPoblado = continente;
            }
            for (Pais pais : continente.getPaises()){
                if (!contador){
                    contador = true;
                    paisMasPoblado = pais;
                    paisMenosPoblado = pais;
                }
                else if (pais.getPoblacion() >= paisMasPoblado.getPoblacion()){
                    paisMasPoblado = pais;
                }
                else if (pais.getPoblacion() <= paisMenosPoblado.getPoblacion()){
                    paisMenosPoblado = pais;
                }
            }
        }
        System.out.println("Continente mas poblado: " + continenteMasPoblado.getNombre());
        System.out.println("Continente menos poblado: " + continenteMenosPoblado.getNombre());
        System.out.println("Pais mas poblado: " + paisMasPoblado.getNombre());
        System.out.println("Pais menos poblado: " + paisMenosPoblado.getNombre());
    }
}
