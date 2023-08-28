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
    public void alimentarMain() {
        Scanner entrada=new Scanner(System.in);
        System.out.print("Seleccione el tipo:\n\n1. Perro\n2. Gato\n3. Pájaro cantor\n4. Pájaro no cantor\n5. Pez\n\nIngrese el dígito correspondiente: ");
        int respuesta=entrada.nextInt();
        entrada.nextLine();
        while(respuesta<1 || respuesta>5) {
            System.out.print("Dígito no válido, intente nuevamente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
        }
        System.out.print("Ingrese el nombre de la mascota: ");
        String nombreMascota=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento (en dígitos):\nAño: ");
        int anioMascota=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mesMascota=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int diaMascota=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimientoMascota=new Fecha(anioMascota,diaMascota,mesMascota);
        fechaNacimientoMascota.valida();
        System.out.print("Ingrese el dueño:\nApellido: ");
        String apellidoDuenio=entrada.nextLine();
        System.out.print("Nombre: ");
        String nombreDuenio=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del dueño (en dígitos):\nAño: ");
        int anioDuenio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mesDuenio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int diaDuenio=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimientoDuenio=new Fecha(anioDuenio,diaDuenio,mesDuenio);
        fechaNacimientoMascota.valida();
        Persona duenio=new Persona(nombreDuenio,apellidoDuenio,fechaNacimientoDuenio);
        String canto;
        if(respuesta==3) {
            System.out.print("Ingrese el canto del pájaro:" );
            canto=entrada.nextLine();
        } else { canto=null; }
        switch(respuesta) {
            case 1:
                Perro perro=new Perro(fechaNacimientoMascota,1,duenio,nombreMascota);
                perro.alimentar();
                break;
            case 2:
                Gato gato=new Gato(fechaNacimientoMascota,1,duenio,nombreMascota);
                gato.alimentar();
                break;
            case 3:
                Cantor cantor=new Cantor(fechaNacimientoMascota,1,duenio,canto,nombreMascota);
                cantor.alimentar();
                break;
            case 4:
                NoCantor noCantor=new NoCantor(fechaNacimientoMascota,1,duenio,nombreMascota);
                noCantor.alimentar();
                break;
            case 5:
                Pez pez=new Pez(fechaNacimientoMascota,duenio,nombreMascota);
                pez.alimentar();
                break;
        }
    }
    public void altaMascota(Fecha fechaNacimiento,Persona duenio,String canto,String nombre,Tipo tipo) throws ClassNotFoundException,IllegalAccessException,InstantiationException {
        Class clase=Class.forName(tipo.getNombreClase());
        Mascota nuevaMascota=(Mascota)clase.newInstance();
        if(nuevaMascota instanceof Cantor) nuevaMascota=new Cantor(fechaNacimiento,1,duenio,canto,nombre);
        else if(nuevaMascota instanceof Gato) nuevaMascota=new Gato(fechaNacimiento,1,duenio,nombre);
        else if(nuevaMascota instanceof NoCantor) nuevaMascota=new NoCantor(fechaNacimiento,1,duenio,nombre);
        else nuevaMascota=new Perro(fechaNacimiento,1,duenio,nombre);
        mascotas.add(nuevaMascota);
    }
    public void altaMascotaMain() throws ClassNotFoundException,IllegalAccessException,InstantiationException {
        Scanner entrada=new Scanner(System.in);
        System.out.print("Seleccione el tipo:\n\n1. Perro\n2. Gato\n3. Pájaro cantor\n4. Pájaro no cantor\n5. Pez\n\nIngrese el dígito correspondiente: ");
        int respuesta=entrada.nextInt();
        entrada.nextLine();
        while(respuesta<1 || respuesta>5) {
            System.out.print("Dígito no válido, intente nuevamente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
        }
        System.out.print("Ingrese el nombre de la mascota: ");
        String nombreMascota=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento (en dígitos):\nAño: ");
        int anioMascota=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mesMascota=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int diaMascota=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimientoMascota=new Fecha(anioMascota,diaMascota,mesMascota);
        fechaNacimientoMascota.valida();
        System.out.print("Ingrese el dueño:\nApellido: ");
        String apellidoDuenio=entrada.nextLine();
        System.out.print("Nombre: ");
        String nombreDuenio=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del dueño (en dígitos):\nAño: ");
        int anioDuenio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mesDuenio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int diaDuenio=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimientoDuenio=new Fecha(anioDuenio,diaDuenio,mesDuenio);
        fechaNacimientoMascota.valida();
        Persona duenio=new Persona(nombreDuenio,apellidoDuenio,fechaNacimientoDuenio);
        String canto;
        if(respuesta==3) {
            System.out.print("Ingrese el canto del pájaro:" );
            canto=entrada.nextLine();
        } else { canto=null; }
        Tipo tipo=null;
        switch(respuesta) {
            case 1:
                tipo=Tipo.PERRO;
                break;
            case 2:
                tipo=Tipo.GATO;
                break;
            case 3:
                tipo=Tipo.PAJAROCANTOR;
                break;
            case 4:
                tipo=Tipo.PAJARONOCANTOR;
                break;
            case 5:
                tipo=Tipo.PEZ;
                break;
        }
        this.altaMascota(fechaNacimientoMascota,duenio,canto,nombreMascota,tipo);
    }
    public void eliminarMascota(Mascota mascota) {
        for(Mascota m:mascotas) {
            if(m.equals(mascota)) mascotas.remove(m);
        }
    }
    public void eliminarMascotaMain() {
        Scanner entrada=new Scanner(System.in);
        System.out.print("Seleccione el tipo:\n\n1. Perro\n2. Gato\n3. Pájaro cantor\n4. Pájaro no cantor\n5. Pez\n\nIngrese el dígito correspondiente: ");
        int respuesta=entrada.nextInt();
        entrada.nextLine();
        while(respuesta<1 || respuesta>5) {
            System.out.print("Dígito no válido, intente nuevamente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
        }
        System.out.print("Ingrese el nombre de la mascota: ");
        String nombreMascota=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento (en dígitos):\nAño: ");
        int anioMascota=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mesMascota=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int diaMascota=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimientoMascota=new Fecha(anioMascota,diaMascota,mesMascota);
        fechaNacimientoMascota.valida();
        System.out.print("Ingrese el dueño:\nApellido: ");
        String apellidoDuenio=entrada.nextLine();
        System.out.print("Nombre: ");
        String nombreDuenio=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del dueño (en dígitos):\nAño: ");
        int anioDuenio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mesDuenio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int diaDuenio=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimientoDuenio=new Fecha(anioDuenio,diaDuenio,mesDuenio);
        fechaNacimientoMascota.valida();
        Persona duenio=new Persona(nombreDuenio,apellidoDuenio,fechaNacimientoDuenio);
        String canto;
        if(respuesta==3) {
            System.out.print("Ingrese el canto del pájaro:" );
            canto=entrada.nextLine();
        } else { canto=null; }
        switch(respuesta) {
            case 1:
                Perro perro=new Perro(fechaNacimientoMascota,1,duenio,nombreMascota);
                this.eliminarMascota(perro);
                break;
            case 2:
                Gato gato=new Gato(fechaNacimientoMascota,1,duenio,nombreMascota);
                this.eliminarMascota(gato);
                break;
            case 3:
                Cantor cantor=new Cantor(fechaNacimientoMascota,1,duenio,canto,nombreMascota);
                this.eliminarMascota(cantor);
                break;
            case 4:
                NoCantor noCantor=new NoCantor(fechaNacimientoMascota,1,duenio,nombreMascota);
                this.eliminarMascota(noCantor);
                break;
            case 5:
                Pez pez=new Pez(fechaNacimientoMascota,duenio,nombreMascota);
                this.eliminarMascota(pez);
                break;
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
    public void modificarMascotaMain() {
        Scanner entrada=new Scanner(System.in);
        System.out.print("Seleccione el tipo:\n\n1. Perro\n2. Gato\n3. Pájaro cantor\n4. Pájaro no cantor\n5. Pez\n\nIngrese el dígito correspondiente: ");
        int respuesta=entrada.nextInt();
        entrada.nextLine();
        while(respuesta<1 || respuesta>5) {
            System.out.print("Dígito no válido, intente nuevamente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
        }
        System.out.print("Ingrese el nombre de la mascota: ");
        String nombreMascota=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento (en dígitos):\nAño: ");
        int anioMascota=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mesMascota=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int diaMascota=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimientoMascota=new Fecha(anioMascota,diaMascota,mesMascota);
        fechaNacimientoMascota.valida();
        System.out.print("Ingrese el dueño:\nApellido: ");
        String apellidoDuenio=entrada.nextLine();
        System.out.print("Nombre: ");
        String nombreDuenio=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del dueño (en dígitos):\nAño: ");
        int anioDuenio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mesDuenio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int diaDuenio=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimientoDuenio=new Fecha(anioDuenio,diaDuenio,mesDuenio);
        fechaNacimientoMascota.valida();
        Persona duenio=new Persona(nombreDuenio,apellidoDuenio,fechaNacimientoDuenio);
        String canto;
        if(respuesta==3) {
            System.out.print("Ingrese el canto del pájaro:" );
            canto=entrada.nextLine();
        } else { canto=null; }
        switch(respuesta) {
            case 1:
                Perro perro=new Perro(fechaNacimientoMascota,1,duenio,nombreMascota);
                Perro nuevoPerro= (Perro) modificarAtributos(perro);
                break;
            case 2:
                Gato gato=new Gato(fechaNacimientoMascota,1,duenio,nombreMascota);
                Gato nuevoGato= (Gato) modificarAtributos(gato);
                break;
            case 3:
                Cantor cantor=new Cantor(fechaNacimientoMascota,1,duenio,canto,nombreMascota);
                Cantor nuevoCantor= (Cantor) modificarAtributos(cantor);
                break;
            case 4:
                NoCantor noCantor=new NoCantor(fechaNacimientoMascota,1,duenio,nombreMascota);
                NoCantor nuevoNoCantor= (NoCantor) modificarAtributos(noCantor);
                break;
            case 5:
                Pez pez=new Pez(fechaNacimientoMascota,duenio,nombreMascota);
                Pez nuevoPez= (Pez) modificarAtributos(pez);
                break;
        }
    }
    public void saludarMain() {
        Scanner entrada=new Scanner(System.in);
        System.out.print("Seleccione el tipo:\n\n1. Perro\n2. Gato\n3. Pájaro cantor\n4. Pájaro no cantor\n\nIngrese el dígito correspondiente: ");
        int respuesta=entrada.nextInt();
        entrada.nextLine();
        while(respuesta<1 || respuesta>4) {
            System.out.print("Dígito no válido, intente nuevamente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
        }
        System.out.print("Ingrese el nombre de la mascota: ");
        String nombreMascota=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento (en dígitos):\nAño: ");
        int anioMascota=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mesMascota=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int diaMascota=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimientoMascota=new Fecha(anioMascota,diaMascota,mesMascota);
        fechaNacimientoMascota.valida();
        System.out.print("Ingrese el dueño:\nApellido: ");
        String apellidoDuenio=entrada.nextLine();
        System.out.print("Nombre: ");
        String nombreDuenio=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del dueño (en dígitos):\nAño: ");
        int anioDuenio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Mes: ");
        int mesDuenio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Día: ");
        int diaDuenio=entrada.nextInt();
        entrada.nextLine();
        Fecha fechaNacimientoDuenio=new Fecha(anioDuenio,diaDuenio,mesDuenio);
        fechaNacimientoMascota.valida();
        Persona duenio=new Persona(nombreDuenio,apellidoDuenio,fechaNacimientoDuenio);
        String canto;
        if(respuesta==3) {
            System.out.print("Ingrese el canto del pájaro:" );
            canto=entrada.nextLine();
        } else { canto=null; }
        switch(respuesta) {
            case 1:
                Perro perro=new Perro(fechaNacimientoMascota,1,duenio,nombreMascota);
                if(mascotas.contains(perro)) { System.out.println(perro.saludo()); }
                else { System.out.println("No se encontró a la mascota"); }
                break;
            case 2:
                Gato gato=new Gato(fechaNacimientoMascota,1,duenio,nombreMascota);
                if(mascotas.contains(gato)) { System.out.println(gato.saludo()); }
                else { System.out.println("No se encontró a la mascota"); }
                break;
            case 3:
                Cantor cantor=new Cantor(fechaNacimientoMascota,1,duenio,canto,nombreMascota);
                if(mascotas.contains(cantor)) { System.out.println(cantor.saludo()); }
                else { System.out.println("No se encontró a la mascota"); }
                break;
            case 4:
                NoCantor noCantor=new NoCantor(fechaNacimientoMascota,1,duenio,nombreMascota);
                if(mascotas.contains(noCantor)) { System.out.println(noCantor.saludo()); }
                else { System.out.println("No se encontró a la mascota"); }
                break;
        }
    }
    public static Persona iniciarSesion() {
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
        return usuario;
    }
    public static Mascota modificarAtributos(Mascota mascota) {
        int i=4,respuesta=0;
        Scanner entrada=new Scanner(System.in);
        Fecha nuevaFechaNacimiento=mascota.getFechaNacimiento();
        Persona nuevoDuenio=mascota.getDuenio();
        String nuevoCanto=null,nuevoNombre=mascota.getNombre();
        if(mascota instanceof Cantor) nuevoCanto=((Cantor) mascota).getCanto();
        do {
            System.out.println("Seleccione el atributo a modificar:\n\n1. Nombre\n2. Fecha de nacimiento\n3. Dueño");
            if(mascota instanceof Cantor) {
                i=5;
                System.out.print("4. Canto\n5. Terminar\n\nIngrese el dígito correspondiente: ");
            } else { System.out.print("4. Terminar\n\nIngrese el dígito correspondiente: "); }
            respuesta=entrada.nextInt();
            entrada.nextLine();
            switch(respuesta) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    nuevoNombre=entrada.nextLine();
                    break;
                case 2:
                    System.out.print("Ingrese la nueva fecha de nacimiento (en dígitos):\nAño: ");
                    int anioMascota=entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Mes: ");
                    int mesMascota=entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Día: ");
                    int diaMascota=entrada.nextInt();
                    entrada.nextLine();
                    nuevaFechaNacimiento=new Fecha(anioMascota,diaMascota,mesMascota);
                    nuevaFechaNacimiento.valida();
                    break;
                case 3:
                    System.out.print("Ingrese el apellido del nuevo dueño: ");
                    String apellido=entrada.nextLine();
                    System.out.print("Ingrese su nombre: ");
                    String nombre=entrada.nextLine();
                    System.out.print("Ingrese su fecha de nacimiento (en dígitos):\nAño: ");
                    int anioDuenio=entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Mes: ");
                    int mesDuenio=entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Día: ");
                    int diaDuenio=entrada.nextInt();
                    entrada.nextLine();
                    Fecha fechaNacimientoDuenio=new Fecha(anioDuenio,diaDuenio,mesDuenio);
                    fechaNacimientoDuenio.valida();
                    nuevoDuenio=new Persona(nombre,apellido,fechaNacimientoDuenio);
                    break;
                case 4:
                    if(i!=4) {
                        System.out.print("Ingrese el nuevo canto: ");
                        nuevoCanto=entrada.nextLine();
                    }
                    break;
            }
        } while(respuesta!=i);
        if(mascota instanceof Perro) {
            Perro nuevoPerro=new Perro(nuevaFechaNacimiento,((Perro) mascota).getAlegria(),nuevoDuenio,nuevoNombre);
            return nuevoPerro;
        } else if(mascota instanceof Gato) {
            Gato nuevoGato=new Gato(nuevaFechaNacimiento,((Gato) mascota).getAlegria(),nuevoDuenio,nuevoNombre);
            return nuevoGato;
        } else if(mascota instanceof Cantor) {
            Cantor nuevoCantor=new Cantor(nuevaFechaNacimiento,((Cantor) mascota).getAlegria(),nuevoDuenio,nuevoCanto,nuevoNombre);
            return nuevoCantor;
        } else if(mascota instanceof NoCantor) {
            NoCantor nuevoNoCantor=new NoCantor(nuevaFechaNacimiento,((NoCantor) mascota).getAlegria(),nuevoDuenio,nuevoNombre);
            return nuevoNoCantor;
        } else {
            Pez nuevoPez=new Pez(nuevaFechaNacimiento,nuevoDuenio,nuevoNombre);
            nuevoPez.setVidas(((Pez) mascota).getVidas());
            return nuevoPez;
        }
    }
    public static void main(String[] args) throws ClassNotFoundException,IllegalAccessException,InstantiationException {
        Sistema sistema=new Sistema();
        int respuesta1=0;
        Scanner entrada=new Scanner(System.in);
        Persona usuario=iniciarSesion();
        do {
            System.out.print("1. Dar de alta una mascota\n2. Eliminar mascota\n3. Modificar mascota\n4. Saludar\n5. Alimentar\n6. Salir\n\nIngrese el dígito correspondiente: ");
            respuesta1=entrada.nextInt();
            entrada.nextLine();
            switch(respuesta1) {
                case 1:
                    sistema.altaMascotaMain();
                    break;
                case 2:
                    sistema.eliminarMascotaMain();
                    break;
                case 3:
                    sistema.modificarMascotaMain();
                    break;
                case 4:
                    sistema.saludarMain();
                    break;
                case 5:
                    sistema.alimentarMain();
                    break;
            }
        } while(respuesta1!=6);
    }
}