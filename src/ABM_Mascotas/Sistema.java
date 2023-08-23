package ABM_Mascotas;
import java.util.*;
import SeresHumanos.Persona;
import Tiempo.Fecha;
public class Sistema {
    private HashSet<Mascota> mascotas;
    public Sistema() { mascotas=new HashSet<>(); }
    public HashSet<Mascota> getMascotas() { return mascotas; }
    public void setMascotas(HashSet<Mascota> mascotas) { this.mascotas=mascotas; }
    public String saludar(Mascota mascota,Persona persona) {
        for(Mascota m:mascotas) {
            if(m.equals(mascota) && m.getDuenio().equals(persona) && m instanceof Terrestre) return ((Terrestre) m).saludo();
            else if(m.equals(mascota) && m.getDuenio().equals(persona) && m instanceof Pez) {
                ((Pez) m).setVidas(((Pez) m).getVidas()-1);
                if(((Pez) m).getVidas()==0) mascotas.remove(m);
            }
            else if(m.equals(mascota) && m instanceof Terrestre && !(m instanceof Cantor) && !(m instanceof NoCantor)) return ((Terrestre) m).saludo().toUpperCase()+'!';
            else if(m.equals(mascota) && !(m instanceof Pez)) return null;
            else mascotas.remove(m);
        }
        return null;
    }
    public void altaMascota(Persona duenio,String canto,String nombre,Tipo tipo) throws ClassNotFoundException,IllegalAccessException,InstantiationException {
        Class clase=Class.forName(tipo.getNombreClase());
        Mascota nuevaMascota=(Mascota)clase.newInstance();
        if(nuevaMascota instanceof Cantor) nuevaMascota=new Cantor(1,duenio,canto,nombre);
        else if(nuevaMascota instanceof Gato) nuevaMascota=new Gato(1,duenio,nombre);
        else if(nuevaMascota instanceof NoCantor) nuevaMascota=new NoCantor(1,duenio,nombre);
        else nuevaMascota=new Perro(1,duenio,nombre);
        mascotas.add(nuevaMascota);
    }
    public void eliminarMascota(Mascota mascota) {
        for(Mascota m:mascotas) {
            if(m.equals(mascota)) mascotas.remove(m);
        }
    }
    public void modificarMascota(Mascota nuevaMascota,Mascota mascotaAnterior) {
        for(Mascota m:mascotas) {
            if(m.equals(mascotaAnterior)) {
                mascotas.remove(m);
                mascotas.add(nuevaMascota);
            }
        }
    }
    public static void main(String[] args) {
        int respuesta=0;
        Scanner entrada=new Scanner(System.in);
        System.out.print("Ingrese su apellido: ");
        String apellido=entrada.nextLine();
        System.out.print("Ingrese su nombre: ");
        String nombre=entrada.nextLine();
        System.out.print("Ingrese su fecha de nacimiento (en dígitos):\nAño: ");
        int anio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mes=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int dia=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimiento=new Fecha(anio,dia,mes);
        fechaNacimiento.valida();
        Persona usuario=new Persona(nombre,apellido,fechaNacimiento);
        do {
            System.out.print("1. Dar de alta una mascota\n2. Eliminar mascota\n3. Modificar mascota\n4. Saludar\n5. Alimentar\n6. Salir\n\nIngrese el dígito correspondiente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
            switch(respuesta) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
            }
        } while(respuesta!=6);
    }
}