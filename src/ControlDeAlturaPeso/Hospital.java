package ControlDeAlturaPeso;

import java.util.HashSet;

public class Hospital {
    HashSet<Paciente> pacientes;

    public Hospital(HashSet<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    public Hospital() {
        this.pacientes = new HashSet<Paciente>();
    }

    public HashSet<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(HashSet<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}