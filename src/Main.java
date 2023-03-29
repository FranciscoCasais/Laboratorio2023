import java.util.ArrayList;
import java.util.Scanner;
import Unidad1.*;
public class Main {
    public static void main(String[] args) {
        // Unidad 1:
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
        autorCancion.setNombreCompleto("Diego Mancini");
        Cancion cancion2=new Cancion(autorCancion,"La Gaviota");
        System.out.println(cancion2.getAutor().getNombreCompleto()+" - "+cancion2.getTitulo());
        // Unidad 2:
        // Ejercicio 1:
        ArrayList<Integer> numerosEnteros=new ArrayList<Integer>();
        char respuesta;
        int suma=0;
        Scanner entrada1=new Scanner(System.in),entrada2=new Scanner(System.in),entrada3=new Scanner(System.in);
        do {
            System.out.println("¿Ingresar nuevo dato? (S/N)");
            respuesta=entrada1.next().charAt(0);
            if(respuesta=='S' || respuesta=='s') {
                System.out.println("Ingresar valor entero:");
                numerosEnteros.add(entrada2.nextInt());
            }
        } while(respuesta=='S' || respuesta=='s');
        for(int numero:numerosEnteros) {
            suma+=numero;
        }
        System.out.println("Suma de todos los valores ingresados: "+suma);
        // Ejercicio 2:
        ArrayList<String> cadenas=new ArrayList<String>();
        char letra;
        int cantidadCoincidencias=0;
        do {
            System.out.println("¿Ingresar nueva palabra? (S/N)");
            respuesta=entrada1.next().charAt(0);
            if(respuesta=='S' || respuesta=='s') {
                System.out.println("Ingresar palabra:");
                cadenas.add(entrada3.nextLine());
            }
        } while(respuesta=='S' || respuesta=='s');
        System.out.println("Ingresar letra:");
        letra=entrada1.next().charAt(0);
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
        do {
            System.out.println("¿Crear nueva persona? (S/N)");
            respuesta=entrada1.next().charAt(0);
            if(respuesta=='S' || respuesta=='s') {
                Persona p=new Persona();
                System.out.println("Ingresar nombre completo:");
                p.setNombreCompleto(entrada3.nextLine());
                System.out.println("Ingresar edad:");
                p.setEdad(entrada2.nextInt());
                System.out.println("Ingresar dirección:");
                p.setDireccion(entrada3.nextLine());
                personas.add(p);
            }
        } while(respuesta=='S' || respuesta=='s');
        for(Persona persona:personas) {
            if (persona.getEdad() > 30) {
                System.out.println("\n");
                persona.getDatos();
            }
        }
    }
}