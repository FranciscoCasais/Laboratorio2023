package EmpresaTelefonica;

import javax.xml.ws.spi.http.HttpHandler;
import java.util.ArrayList;
import java.util.HashSet;

public class Empresa {
    private HashSet<Empleado>empleados;
    private HashSet<Llamada>llamadas;

    public Empresa(HashSet<Empleado> empleados, HashSet<Llamada> llamadas) {
        this.empleados = empleados;
        this.llamadas = llamadas;
    }
    public Empresa() {
        this.empleados = new HashSet<Empleado>();
        this.llamadas = new HashSet<Llamada>();
    }

    public HashSet<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(HashSet<Empleado> empleados) {
        this.empleados = empleados;
    }

    public HashSet<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(HashSet<Llamada> llamadas) {
        this.llamadas = llamadas;
    }
    public void agregarLlamada(Llamada llamada){
        llamadas.add(llamada);
        if (!empleados.contains(llamada.getEmpleadoOrigen())) empleados.add(llamada.getEmpleadoOrigen());
        if (!empleados.contains(llamada.getEmpleadoDestino())) empleados.add(llamada.getEmpleadoDestino());
    }
    public HashSet<Llamada>listadoLlamadas(Empleado empleado){
        HashSet<Llamada>llamadasRealizadas = new HashSet<Llamada>();
        for (Llamada llamada : llamadas){
            if (llamada.getEmpleadoOrigen().equals(empleado) || llamada.getEmpleadoDestino().equals(empleado)){
                llamadasRealizadas.add(llamada);
            }
        }
        return llamadasRealizadas;
    }
    public ArrayList<Empleado>ranking(){
        ArrayList<Empleado>ranking_ = new ArrayList<Empleado>();
        float _1 = 0.0f, _2 = 0.0f, _3 = 0.0f;
        for(Empleado empleado : empleados){
            float duracion = 0.0f;
            HashSet<Llamada>llamadas1 = listadoLlamadas(empleado);
            for (Llamada llamada : llamadas1){
                if (!(llamada.getEmpleadoOrigen().getPais().equals(llamada.getEmpleadoDestino().getPais()))){
                    duracion += llamada.getDuracion();
                }
            }
            if (duracion >= _1){
                _1 = duracion;
                switch (ranking_.size()){
                    case 0:
                        ranking_.add(empleado);
                        break;
                    case 1:
                        ranking_.add(ranking_.get(0));
                        ranking_.set(0, empleado);
                        break;
                    case 2:
                        ranking_.add(ranking_.get(1));
                        ranking_.set(1, ranking_.get(0));
                        ranking_.set(0, empleado);
                        break;
                    case 3:
                        ranking_.set(2, ranking_.get(1));
                        ranking_.set(1, ranking_.get(0));
                        ranking_.set(0, empleado);
                        break;
                }
            }else if(duracion >= _2){
                _2 = duracion;
                switch (ranking_.size()){
                    case 1:
                        ranking_.add(empleado);
                        break;
                    case 2:
                        ranking_.add(ranking_.get(1));
                        ranking_.set(1, empleado);
                        break;
                    case 3:
                        ranking_.set(2, ranking_.get(1));
                        ranking_.set(1, empleado);
                        break;
                }
            }else if(duracion >=_3){
                _3 = duracion;
                switch (ranking_.size()){
                    case 2:
                        ranking_.add(empleado);
                        break;
                    case 3:
                        ranking_.set(2, empleado);
                        break;
                }
            }
        }
        return ranking_;
    }
}
