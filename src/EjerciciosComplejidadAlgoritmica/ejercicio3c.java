package EjerciciosComplejidadAlgoritmica;
import java.util.ArrayList;
public class ejercicio3c {
    public static int maximasMesetasIguales(ArrayList<Integer> vector) {
        int maximasMesetasIguales=0,meseta=vector.get(0),mesetasIguales=0;
        for(int i=0;i<vector.size();i++) {
            if(meseta==vector.get(i)) { mesetasIguales++; }
            else {
                meseta=vector.get(i);
                if(mesetasIguales>maximasMesetasIguales) { maximasMesetasIguales=mesetasIguales; }
                mesetasIguales=1;
            }
        }
        if(mesetasIguales>maximasMesetasIguales) { maximasMesetasIguales=mesetasIguales; }
        return maximasMesetasIguales;
    }
    public static void main(String[] args) {
        ArrayList<Integer> vector=new ArrayList<>();
        vector.add(0);
        vector.add(0);
        vector.add(0);
        vector.add(1);
        vector.add(0);
        System.out.println("Máxima cantidad de valores iguales seguidos en el vector: "+maximasMesetasIguales(vector));
    }
}