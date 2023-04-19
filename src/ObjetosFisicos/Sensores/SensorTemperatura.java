package ObjetosFisicos.Sensores;
public class SensorTemperatura extends Sensor {
    public SensorTemperatura() { super(); }
    public void dispararAlarma() { System.out.println("¡Cuidado! La temperatura sube"); }
}