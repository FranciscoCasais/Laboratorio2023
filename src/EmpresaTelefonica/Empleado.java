package EmpresaTelefonica;

import Humanos.Persona;

public class Empleado extends Persona {
    private String numTelefono;
    private String pais;

    public Empleado(String nombre, String apellido, int dni, String numTelefono, String pais) {
        super(nombre, apellido, dni);
        this.numTelefono = numTelefono;
        this.pais = pais;
    }
    public Empleado() {
        super();
        this.numTelefono = "";
        this.pais = "";
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
