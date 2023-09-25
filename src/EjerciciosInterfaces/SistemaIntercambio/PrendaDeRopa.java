package EjerciciosInterfaces.SistemaIntercambio;
public abstract class PrendaDeRopa {
    private Estado estado;
    private Material material;
    private String color,marca;
    public PrendaDeRopa() {
        estado=new Estado();
        material=null;
        color="";
        marca="";
    }
    public PrendaDeRopa(Estado estado,Material material,String color,String marca) {
        this.estado=estado;
        this.material=material;
        this.color=color;
        this.marca=marca;
    }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado=estado; }
    public Material getMaterial() { return material; }
    public void setMaterial(Material material) { this.material=material; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color=color; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca=marca; }
    public abstract String toString();
}