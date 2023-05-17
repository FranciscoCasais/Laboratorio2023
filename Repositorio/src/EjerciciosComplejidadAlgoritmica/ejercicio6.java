package EjerciciosComplejidadAlgoritmica;
import java.util.ArrayList;
public class ejercicio6 {
    public static int maximosImparesSeguidos(ArrayList<Integer> vector) {
        int maximosImparesSeguidos=0,imparesSeguidos=0;
        for(int i=0;i<vector.size();i++) {
            if(vector.get(i)%2==1) { imparesSeguidos++; }
            else {
                if(imparesSeguidos>maximosImparesSeguidos) { maximosImparesSeguidos=imparesSeguidos; }
                imparesSeguidos=1;
            }
        }
        if(imparesSeguidos>maximosImparesSeguidos) { maximosImparesSeguidos=imparesSeguidos; }
        return maximosImparesSeguidos;
    }
}