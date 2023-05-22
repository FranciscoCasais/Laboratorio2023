package ObjetosAbstractos.Otros;
public enum Color {
    ROJO("#FF0000","rojo"),ROJO_NARANJA("#FF4000","rojo naranja"),NARANJA("#FF8000","naranja"),AMBAR("#FFBF00\t","ámbar"),AMARILLO("#FFFF00","amarillo"),LIMA("#00FF00","lima"),VERDE("#008000","verde"),CIAN("#00FFFF","cian"),CERULEO("#98B4D4","cerúleo"),AZUL("#0000FF","azul"),VIOLETA("#EE82EE","violeta"),MAGENTA("#9E4F88","magenta"),FUCSIA("#CE4676","fucsia");
    private String codigoHexadecimal,nombre;
    private Color(String codigoHexadecimal,String nombre) {
        this.codigoHexadecimal=codigoHexadecimal;
        this.nombre=nombre;
    }
    public String getCodigoHexadecimal() { return codigoHexadecimal; }
    public String getNombre() { return nombre; }
}