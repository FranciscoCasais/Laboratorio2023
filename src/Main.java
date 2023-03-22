import Unidad1.*;
public class Main {
    public static void main(String[] args) {
        // Clase Libro:
        Libro libro1=new Libro();
        libro1.mostrarInfoLibro();
        Fecha fecha1=new Fecha();
        Libro libro2=new Libro(100,fecha1,"Ciudad Nueva","653-8-73-928753-1","Historia de la Antigua Grecia");
        Fecha fecha2=new Fecha();
        if(libro1.compararFechaPublicacion(fecha2)) {
            System.out.println("El libro se publicó antes de la fecha ingresada.");
        } else {
            System.out.println("El libro se publicó después de la fecha ingresada.");
        }
        // Clase Cafetera:
        Cafetera cafetera1=new Cafetera();
        Cafetera cafetera2=new Cafetera(250);
        Cafetera cafetera3=new Cafetera(50,100);
        System.out.println(cafetera3.getCantidadActual());
        cafetera3.llenarCafetera();
        System.out.println(cafetera3.getCantidadActual());
        cafetera3.servirTaza(75);
        System.out.println(cafetera3.getCantidadActual());
        cafetera3.agregarCafe(25);
        System.out.println(cafetera3.getCantidadActual());
        cafetera3.vaciarCafetera();
        System.out.println(cafetera3.getCantidadActual());
        // Clase Cancion:
        Cancion cancion1=new Cancion();
        Persona autorCancion=new Persona();
        autorCancion.setEdad(46);
        autorCancion.setDireccion("Lavalle 7845");
        autorCancion.setNombre("Diego Mancini");
        Cancion cancion2=new Cancion(autorCancion,"La Gaviota");
        System.out.println(cancion2.getAutor().getNombre()+" - "+cancion2.getTitulo());
    }
}