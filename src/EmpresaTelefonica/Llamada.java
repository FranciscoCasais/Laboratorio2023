package EmpresaTelefonica;

import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada {
    private LocalDate fecha;
    private float duracion;//Segundos
    private Empleado empleadoOrigen;
    private Empleado empleadoDestino;

    public Llamada(LocalDate fecha, float duracion, Empleado empleadoOrigen, Empleado empleadoDestino) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.empleadoOrigen = empleadoOrigen;
        this.empleadoDestino = empleadoDestino;
    }
    public Llamada() {
        this.fecha = LocalDate.now();
        this.duracion = 0.0f;
        this.empleadoOrigen = new Empleado();
        this.empleadoDestino = new Empleado();
    }
    public Llamada(LocalDate fecha, Empleado empleadoOrigen, Empleado empleadoDestino) {
        this.fecha = fecha;
        this.duracion = 0.0f;
        this.empleadoOrigen = empleadoOrigen;
        this.empleadoDestino = empleadoDestino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public Empleado getEmpleadoOrigen() {
        return empleadoOrigen;
    }

    public void setEmpleadoOrigen(Empleado empleadoOrigen) {
        this.empleadoOrigen = empleadoOrigen;
    }

    public Empleado getEmpleadoDestino() {
        return empleadoDestino;
    }

    public void setEmpleadoDestino(Empleado empleadoDestino) {
        this.empleadoDestino = empleadoDestino;
    }
}
