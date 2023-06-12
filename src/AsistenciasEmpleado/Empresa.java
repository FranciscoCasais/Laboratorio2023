package AsistenciasEmpleado;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class Empresa {
    private HashSet<Empleado> empleados;

    public Empresa(HashSet<Empleado> empleados) {
        this.empleados = empleados;
    }
    public Empresa() {
        this.empleados = new HashSet<>();
    }

    public HashSet<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(HashSet<Empleado> empleados) {
        this.empleados = empleados;
    }

    public HashSet<Empleado> empleadosConMayorAsistencia(LocalDate mes){
        HashSet<Empleado> empleadosAsistencias = new HashSet<Empleado>();
        for (Empleado empleado : empleados) if (empleado.porcentajeAsistencias(mes) >= 80.0f) empleadosAsistencias.add(empleado);
        return empleadosAsistencias;
    }
}
