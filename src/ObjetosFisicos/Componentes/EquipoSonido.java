package ObjetosFisicos.Componentes;
public class EquipoSonido extends Multimedia {
    private boolean bluetooth;
    public EquipoSonido() {
        super();
        bluetooth=false;
    }
    public boolean getBluetooth() { return bluetooth; }
    public void setBluetooth(boolean bluetooth) { this.bluetooth=bluetooth; }
}