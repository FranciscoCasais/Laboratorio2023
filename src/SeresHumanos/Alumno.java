package SeresHumanos;
import java.util.ArrayList;
import Unidad1.Fecha;
import Unidad2.Materia;
public class Alumno extends SerHumano {
    private ArrayList<Materia> materias;
    public Alumno() {
        super();
        materias = new ArrayList<Materia>();
    }
    public ArrayList<Double> getNotas(int posicion) {
        return materias.get(posicion).getNotas();
    }

    public Fecha getFechaNacimiento() {
        return super.getFechaNacimiento();
    }

    public String getNombreCompleto() {
        return super.getNombreCompleto();
    }

    public void setNotas(ArrayList<Double> notas, int posicion) {
        materias.get(posicion).setNotas(notas);
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        super.fechaNacimiento = fechaNacimiento;
    }

    public void setNombreCompleto(String nombreCompleto) {
        super.nombreCompleto = nombreCompleto;
    }

    public void agregarNota(double nota, int posicion) {
        materias.get(posicion).getNotas().add(nota);
    }

    public double menorNota(int posicion) {
        double menorNota = materias.get(posicion).getNotas().get(0);
        for (double nota : materias.get(posicion).getNotas()) {
            if (nota < menorNota) {
                menorNota = nota;
            }
        }
        return menorNota;
    }

    public double mayorNota(int posicion) {
        double mayorNota = materias.get(posicion).getNotas().get(0);
        for (double nota : materias.get(posicion).getNotas()) {
            if (nota > mayorNota) {
                mayorNota = nota;
            }
        }
        return mayorNota;
    }

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public double promedioNotasMateria(int posicion) {
        double promedio = 0;
        for (double nota : materias.get(posicion).getNotas()) {
            promedio += nota;
        }
        promedio /= materias.get(posicion).getNotas().size();
        return promedio;
    }

    public double promedioNotasTotal() {
        double promedioMateria = 0, promedioTotal = 0;
        for (int i = 0; i < materias.size(); i++) {
            for (double nota : materias.get(i).getNotas()) {
                promedioMateria += nota;
            }
            promedioMateria /= materias.get(i).getNotas().size();
            promedioTotal += promedioMateria;
            promedioMateria = 0;
        }
        promedioTotal /= materias.size();
        return promedioTotal;
    }
}