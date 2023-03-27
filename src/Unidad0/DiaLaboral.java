package Unidad0;
import java.util.Scanner;
public class DiaLaboral{
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        String diaSemanal;
        System.out.println("Introduzca un día de la semana:");
        diaSemanal=entrada.nextLine();
        while(!(diaSemanal.equals("lunes")||diaSemanal.equals("martes")||diaSemanal.equals("miércoles")||diaSemanal.equals("jueves")||diaSemanal.equals("viernes")||diaSemanal.equals("sábado")||diaSemanal.equals("domingo"))) {
            System.out.println("Error: no se ingresó un día de la semana, intente nuevamente:");
            diaSemanal=entrada.nextLine();
        }
        if(diaSemanal.equals("sábado")||diaSemanal.equals("domingo")) {
            System.out.println("No es un día laboral");
        } else {
            System.out.println("Es un día laboral");
        }
    }
}
