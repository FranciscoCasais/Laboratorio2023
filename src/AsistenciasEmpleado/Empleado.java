package AsistenciasEmpleado;
import Cosas.Fecha;
import Humanos.Persona;
import Cosas.Dia;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalDate;


import java.util.HashSet;

public class Empleado extends Persona{
    private String telefono;
    private HashSet<Dia> diasLaborales;
    private HashSet<LocalDateTime> fechaHoraIngreso;

    public Empleado(String nombre, String Apellido, Fecha fechaNacimiento, String telefono, HashSet<Dia> diasLaborales, HashSet<LocalDateTime> fechaHoraIngreso) {
        super(nombre, Apellido, fechaNacimiento);
        this.telefono = telefono;
        this.diasLaborales = diasLaborales;
        this.fechaHoraIngreso = fechaHoraIngreso;
    }
    public Empleado() {
        super();
        this.telefono = "";
        this.diasLaborales = new HashSet<>();
        this.fechaHoraIngreso = new HashSet<>();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public HashSet<Dia> getDiasLaborales() {
        return diasLaborales;
    }

    public void setDiasLaborales(HashSet<Dia> diasLaborales) {
        this.diasLaborales = diasLaborales;
    }

    public HashSet<LocalDateTime> getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(HashSet<LocalDateTime> fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }
    public float porcentajeAsistencias (LocalDate mes){
        float contador = 0.0f;
        for (LocalDateTime fecha : fechaHoraIngreso){
            if (fecha.getMonthValue() == mes.getMonthValue() && fecha.getYear() == mes.getYear()){
                contador++;
            }
        }
        float cantDiasLaborales = 0.0f;
        while (mes.getDayOfMonth() > 1) mes.minusDays(1);
        do{
            if (mes.getDayOfWeek() == DayOfWeek.MONDAY && diasLaborales.contains(Dia.LUNES) || mes.getDayOfWeek() == DayOfWeek.TUESDAY && diasLaborales.contains(Dia.MARTES) || mes.getDayOfWeek() == DayOfWeek.WEDNESDAY && diasLaborales.contains(Dia.MIERCOLES) || mes.getDayOfWeek() == DayOfWeek.THURSDAY && diasLaborales.contains(Dia.JUEVES) || mes.getDayOfWeek() == DayOfWeek.FRIDAY && diasLaborales.contains(Dia.VIERNES)) cantDiasLaborales++;
            mes.plusDays(1);
        } while (mes.getDayOfMonth() != 1);
        return (cantDiasLaborales / contador) * 100.0f;
    }
}
