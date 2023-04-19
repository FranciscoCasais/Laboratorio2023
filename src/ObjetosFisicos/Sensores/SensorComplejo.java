package ObjetosFisicos.Sensores;
import java.util.ArrayList;
import java.util.Scanner;
public class SensorComplejo {
    private ArrayList<Sensor> sensores;
    private double valorActual;
    public SensorComplejo() { sensores=new ArrayList<>(); }
    public ArrayList<Sensor> getSensores() { return sensores; }
    public double getValorActual() { return valorActual; }
    public void setSensores(ArrayList<Sensor> sensores) { this.sensores=sensores; }
    public void setValorActual(double valorActual) { this.valorActual=valorActual; }
    public double calcularValorUmbral() {
        double valorUmbral=0;
        for(Sensor sensor:sensores) { valorUmbral+=sensor.getValorUmbral(); }
        return valorUmbral/sensores.size();
    }
    public void agregarSensor(Scanner entrada) {
        int respuesta=0;
        Sensor sensor;
        System.out.println("\nIngrese el tipo de sensor:\n\n1. Detector de humo\n2. Sensor de temperatura\n3. Sensor de presión");
        validarRespuesta(3,respuesta,entrada);
        switch(respuesta) {
            case 1:
                sensor=new DetectorHumo();
                break;
            case 2:
                sensor=new SensorTemperatura();
                break;
            default:
                sensor=new SensorPresion();
                break;
        }
        System.out.println("\nIngrese el valor umbral del sensor:");
        sensor.setValorUmbral(entrada.nextDouble());
        System.out.println("\nIngrese el año de compra:");
        sensor.setAnioCompra(entrada.nextInt());
        sensores.add(sensor);
    }
    public void dispararAlarma() { System.out.println("Alarma del sensor complejo activada"); }
    public void eliminarSensor(Scanner entrada) {
        int respuesta=0;
        System.out.println("\nSeleccione el sensor a eliminar del sensor complejo:\n");
        for(int i=0;i<sensores.size();i++) {
            if(sensores.get(i) instanceof DetectorHumo) { System.out.println((i+1)+". Detector de humo con valor umbral = "+sensores.get(i).getValorUmbral()); }
            else if(sensores.get(i) instanceof SensorTemperatura) { System.out.println((i+1)+". Sensor de temperatura con valor umbral = "+sensores.get(i).getValorUmbral()); }
            else { System.out.println((i+1)+". Sensor de presión con valor umbral = "+sensores.get(i).getValorUmbral()); }
        }
        validarRespuesta(sensores.size(),respuesta,entrada);
        System.out.println("\nSe eliminó el sensor.\n");
    }
    public static void validarRespuesta(int numeroOpciones,int respuesta,Scanner entrada) {
        System.out.println("\nIngrese el dígito correspondiente:");
        respuesta=entrada.nextInt();
        while(respuesta<1 || respuesta>4) {
            System.out.println("\nDígito no válido, intente nuevamente:");
            respuesta=entrada.nextInt();
        }
    }
    public static void main(String[] args) {
        int respuesta=0;
        Scanner entrada=new Scanner(System.in);
        SensorComplejo sensorComplejo=new SensorComplejo();
        do {
            System.out.println("1. Ingresar valor\n2. Agregar sensor\n3. Eliminar sensor\n4. Finalizar programa");
            validarRespuesta(4,respuesta,entrada);
            switch(respuesta) {
                case 1:
                    System.out.println("\nIngrese un valor decimal:");
                    sensorComplejo.setValorActual(entrada.nextDouble());
                    if(sensorComplejo.getValorActual()>sensorComplejo.calcularValorUmbral()) { sensorComplejo.dispararAlarma(); }
                    break;
                case 2:
                    sensorComplejo.agregarSensor(entrada);
                    break;
                case 3:
                    sensorComplejo.eliminarSensor(entrada);
                    break;
            }
        } while(respuesta<4);
    }
}