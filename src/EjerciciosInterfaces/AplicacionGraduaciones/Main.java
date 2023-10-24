package EjerciciosInterfaces.AplicacionGraduaciones;
import java.time.LocalDate;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) {
        ExamenEscrito ee1=new ExamenEscrito(90,7,LocalDate.now());
        ExamenEscrito ee2=new ExamenEscrito(80,9,LocalDate.now());
        ExamenEscrito ee3=new ExamenEscrito(100,5,LocalDate.now());
        ExamenOral eo1=new ExamenOral(LocalDate.now(),NivelSatisfaccion.SUFICIENTE);
        ExamenOral eo2=new ExamenOral(LocalDate.now(),NivelSatisfaccion.INSUFICIENTE);
        ExamenOral eo3=new ExamenOral(LocalDate.now(),NivelSatisfaccion.EXCELENTE);

        // este examen tira una excepcion por no tener una nota entre 0 y 10
        ExamenEscrito ee4=new ExamenEscrito(70,11,LocalDate.now());

        HashSet<Examen> examanesRealizados=new HashSet<>();

        examanesRealizados.add(ee1);
        examanesRealizados.add(eo1);
        examanesRealizados.add(eo3);
        Alumno a1=new Alumno(examanesRealizados,1,LocalDate.now(),"Cúter","Mate");

        examanesRealizados=new HashSet<>();
        examanesRealizados.add(ee3);
        examanesRealizados.add(eo1);
        examanesRealizados.add(eo2);
        Alumno a2=new Alumno(examanesRealizados,1,LocalDate.now(),"Drogón","Paja");

        examanesRealizados=new HashSet<>();
        examanesRealizados.add(ee1);
        examanesRealizados.add(ee2);
        examanesRealizados.add(eo3);
        Alumno a3=new Alumno(examanesRealizados,1,LocalDate.now(),"Negra","Selva");

        examanesRealizados=new HashSet<>();
        examanesRealizados.add(ee3);
        examanesRealizados.add(eo1);
        examanesRealizados.add(eo2);
        Alumno a4=new Alumno(examanesRealizados,1,LocalDate.now(),"Santi","Daniel");

        examanesRealizados=new HashSet<>();
        examanesRealizados.add(ee2);
        examanesRealizados.add(eo1);
        examanesRealizados.add(eo3);
        Alumno a5=new Alumno(examanesRealizados,1,LocalDate.now(),"Sampi","Juanfran");

        HashSet<Alumno> alumnos=new HashSet<>();
        alumnos.add(a1);
        alumnos.add(a2);
        alumnos.add(a3);
        alumnos.add(a4);
        alumnos.add(a5);
        Sistema sistema=new Sistema(alumnos);

        System.out.println("La cantidad de alumnos aprobados en el colegio es "+sistema.cantidadAprobados()+" de "+sistema.getAlumnos().size()+".");
    }
}