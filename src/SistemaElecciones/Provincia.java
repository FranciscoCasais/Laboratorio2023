package SistemaElecciones;
public enum Provincia {
    BUENOSAIRES("Buenos Aires"),CABA("Ciudad Autónoma de Buenos Aires"),CATAMARCA("Catamarca"),CHACO("Chaco"),CHUBUT("Chubut"),CORDOBA("Córdoba"),CORRIENTES("Corrientes"),ENTRERIOS("Entre Ríos"),FORMOSA("Formosa"),JUJUY("Jujuy"),LAPAMPA("La Pampa"),LARIOJA("La Rioja"),MENDOZA("Mendoza"),MISIONES("Misiones"),NEUQUEN("Neuquén"),RIONEGRO("Río Negro"),SALTA("Salta"),SANJUAN("San Juan"),SANLUIS("San Luis"),SANTACRUZ("Santa Cruz"),SANTAFE("Santa Fe"),SANTIAGOESTERO("Santiago del Estero"),TIERRAFUEGO("Tierra del Fuego, Antártida e Islas del Atlántico Sur"),TUCUMAN("Tucumán");
    private String nombre;
    Provincia(String nombre) { this.nombre=nombre; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre=nombre; }
}