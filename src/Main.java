import java.util.ArrayList;
import java.util.Scanner;
import Unidad1.*;
public class Main {
    public static void main(String[] args) {
        // Clase Libro:
        Libro libro1=new Libro();
        libro1.mostrarInfoLibro();
        Fecha fecha1=new Fecha();
        Libro libro2=new Libro(100,573865298,fecha1,"Ciudad Nueva","Historia de la Antigua Grecia");
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
        // Unidad 2:
        // Ejercicio 1:
        ArrayList<Integer> numerosEnteros=new ArrayList<Integer>();
        Integer numero1=1,numero2=2,numero3=3,numero4=4,numero5=5,suma=0;
        numerosEnteros.add(numero1);
        numerosEnteros.add(numero2);
        numerosEnteros.add(numero3);
        numerosEnteros.add(numero4);
        numerosEnteros.add(numero5);
        for(Integer numero:numerosEnteros) {
            suma+=numero;
        }
        System.out.println(suma);
        // Ejercicio 2:
        ArrayList<String> cadenas=new ArrayList<String>();
        char letra;
        int cantidadCoincidencias=0;
        Scanner entrada=new Scanner(System.in);
        String cadena1="barco",cadena2="bebé",cadena3="palo",cadena4="gallo",cadena5="burocracia";
        cadenas.add(cadena1);
        cadenas.add(cadena2);
        cadenas.add(cadena3);
        cadenas.add(cadena4);
        cadenas.add(cadena5);
        System.out.println("Ingresar letra:");
        letra=entrada.next().charAt(0);
        for(String cadena:cadenas) {
            if(cadena.charAt(0)==letra) {
                cantidadCoincidencias++;
                System.out.println(cadena);
            }
        }
        if(cantidadCoincidencias==0) {
            System.out.println("No se encontraron palabras que comenzaran con la letra ingresada.");
        }
        // Ejercicio 3:
        ArrayList<Persona> personas=new ArrayList<Persona>();
        Persona persona1=new Persona(),persona2=new Persona(),persona3=new Persona(),persona4=new Persona(),persona5=new Persona();
        persona1.setEdad(46);
        persona2.setEdad(21);
        persona3.setEdad(29);
        persona4.setEdad(37);
        persona5.setEdad(83);
        persona1.setDireccion("Los Incas 3795");
        persona2.setDireccion("Corrientes 9834");
        persona3.setDireccion("Triunvirato 8023");
        persona4.setDireccion("Lavalle 754");
        persona5.setDireccion("9 de Julio 9221");
        persona1.setNombre("Carlos Fernández");
        persona2.setNombre("Julio Domínguez");
        persona3.setNombre("Rodolfo Mondongo");
        persona4.setNombre("Cristina de Pazzi");
        persona5.setNombre("Alberto Perverto");
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        personas.add(persona5);
        for(Persona persona:personas) {
            if (persona.getEdad() > 30) {
                System.out.println("\n");
                persona.getDatos();
            }
        }
    }
}