package ObjetosFisicos.Otros;
public enum Editorial {
    KAPELUSZ("Kapelusz"),SUDAMERICANA("Sudamericana"),ATLANTIDA("Atlántida"),EL_ATENEO("El Ateneo"),INTERZONA("Interzona"),SUR("Sur"),ALIANZA("Alianza");
    private String nombre;
    private Editorial(String nombre) { this.nombre=nombre; }
    public String getNombre() { return nombre; }
}