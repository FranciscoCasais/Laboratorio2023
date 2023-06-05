package ObjetosAbstractos.Grupos;
import ObjetosFisicos.Vehiculos.Auto;
import ObjetosFisicos.Vehiculos.Bicicleta;
import ObjetosFisicos.Vehiculos.Camioneta;
import ObjetosFisicos.Vehiculos.Vehiculo;
import java.util.ArrayList;
public class EmpresaVehiculos {
    protected ArrayList<Vehiculo> flota;
    public EmpresaVehiculos() { flota=new ArrayList<>(); }
    public ArrayList<Vehiculo> getFlota() { return flota; }
    public void setFlota(ArrayList<Vehiculo> flota) { this.flota=flota; }
    public void agregarCarga(Camioneta camioneta,double cargaKG) {
        if(camioneta.getCargaActualKG()+cargaKG<=camioneta.getCapacidadCargaKG()) {
            camioneta.setCargaActualKG(camioneta.getCargaActualKG()+cargaKG);
            System.out.println("La carga se agregó a la camioneta con éxito.");
        } else { System.out.println("La carga no se puede agregar a la camioneta ya que excede su capacidad máxima."); }
    }
    public void porcentajeDescapotables() {
        int cantidadAutos=0,cantidadDescapotables=0;
        for(Vehiculo vehiculo:flota) {
            if(vehiculo instanceof Auto) {
                cantidadAutos++;
                if(((Auto)vehiculo).getDescapotable()) { cantidadDescapotables++; }
            }
        }
        System.out.println("El "+cantidadDescapotables*100/cantidadDescapotables+"% de los autos de la empresa son descapotables.");
    }
    public void tipoMayorCantidad() {
        int cantidadAutos=0,cantidadBicicletas=0,cantidadCamionetas=0;
        for(Vehiculo vehiculo:flota) {
            if(vehiculo instanceof Auto) { cantidadAutos++; }
            else if(vehiculo instanceof Bicicleta) { cantidadBicicletas++; }
            else if(vehiculo instanceof Camioneta) { cantidadCamionetas++; }
        }
        System.out.println("El tipo de vehículo del cual la empresa posee una mayor cantidad es: ");
        if(cantidadAutos>cantidadBicicletas && cantidadAutos>cantidadCamionetas) { System.out.println("auto (cantidad: " + cantidadAutos + " unidades)"); }
        else if(cantidadBicicletas>cantidadAutos && cantidadBicicletas>cantidadCamionetas) { System.out.println("bicicleta (cantidad: " + cantidadBicicletas + " unidades)"); }
        else { System.out.println("camioneta (cantidad: " + cantidadCamionetas + " unidades)"); }
    }
}