package EjerciciosInterfaces.Restaurante;
import java.time.LocalDate;
import java.util.*;
public class Sistema implements GestionRestaurante {
    private HashSet<Chef> chefs;
    private HashSet<Plato> menu;
    private String nombreRestaurante;
    public Sistema() {
        chefs=new HashSet<>();
        menu=new HashSet<>();
        nombreRestaurante="";
    }
    public Sistema(HashSet<Chef> chefs, HashSet<Plato> menu,String nombreRestaurante) {
        this.chefs = chefs;
        this.menu = menu;
        this.nombreRestaurante = nombreRestaurante;
    }
    public HashSet<Chef> getChefs() { return chefs; }
    public void setChefs(HashSet<Chef> chefs) { this.chefs = chefs; }
    public HashSet<Plato> getMenu() { return menu; }
    public void setMenu(HashSet<Plato> menu) { this.menu = menu; }
    public String getNombreRestaurante() { return nombreRestaurante; }
    public void setNombreRestaurante(String nombreRestaurante) { this.nombreRestaurante = nombreRestaurante; }
    public Chef seleccionarChefACargo(Scanner entrada) {
        HashMap<Integer,Chef> idChefs=new HashMap<>();
        int i=1;
        System.out.println("\nSeleccione el chef que estará a cargo de la preparación del plato:\n");
        for(Chef chef:chefs) {
            System.out.println(i+". "+chef.getNombre()+" "+chef.getApellido());
            idChefs.put(i,chef);
            i++;
        }
        System.out.print("\nIngrese el dígito correspondiente: ");
        int chefSeleccionado=entrada.nextInt();
        entrada.nextLine();
        while(chefSeleccionado<1 || chefSeleccionado>=i) {
            System.out.print("Dígito no válido, intente nuevamente: ");
            chefSeleccionado=entrada.nextInt();
            entrada.nextLine();
        }
        return idChefs.get(chefSeleccionado);
    }
    public void agregarPlato(Scanner entrada) {
        System.out.print("\nIngrese el nombre del plato: ");
        String nombre=entrada.nextLine();
        System.out.print("Ingrese la descripción del plato: ");
        String descripcion=entrada.nextLine();
        Tipo tipo=seleccionarTipo(entrada);
        System.out.print("\nIngrese el precio: ");
        double precio=entrada.nextDouble();
        Chef chefACargo=seleccionarChefACargo(entrada);
        agregarPlato(new Plato(chefACargo,precio,descripcion,nombre,tipo));
    }
    public void contratarChef(Scanner entrada) {
        System.out.print("\nIngrese el nombre del chef: ");
        String nombre=entrada.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido=entrada.nextLine();
        System.out.print("Ingrese el año de nacimiento: ");
        int anio=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Ingrese el mes: ");
        int mes=entrada.nextInt();
        entrada.nextLine();
        System.out.print("Ingrese el día del mes: ");
        int dia=entrada.nextInt();
        entrada.nextLine();
        LocalDate fechaNacimiento=LocalDate.of(anio,mes,dia);
        System.out.print("Ingrese el DNI: ");
        int dni=entrada.nextInt();
        entrada.nextLine();
        System.out.print("¿El chef tiene experiencia previa? (S/N): ");
        String respuesta;
        do {
            respuesta=entrada.nextLine();
            while(respuesta.length()!=1) {
                System.out.print("Por favor ingrese solo \"S\" ó \"N\": ");
                respuesta=entrada.nextLine();
            }
        } while(!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
        char letra=respuesta.toUpperCase().charAt(0);
        boolean experienciaCulinariaPrevia;
        if(letra=='S') experienciaCulinariaPrevia=true;
        else experienciaCulinariaPrevia=false;
        contratarChef(new Chef(nombre,apellido,fechaNacimiento,experienciaCulinariaPrevia,dni));
    }
    public void mostrarMenu() {
        for(Plato plato:menu) System.out.println("\n"+plato.toString());
    }
    public static Tipo seleccionarTipo(Scanner entrada) {
        HashMap<Integer,Tipo> idTipos=new HashMap<>();
        int i=1;
        System.out.println("\nSeleccione el tipo:\n");
        for(Tipo tipo:Tipo.values()) {
            System.out.println(i+". "+tipo.toString().toUpperCase().charAt(0)+tipo.toString().substring(1));
            idTipos.put(i,tipo);
            i++;
        }
        System.out.print("\nIngrese el dígito correspondiente: ");
        int tipoSeleccionado=entrada.nextInt();
        entrada.nextLine();
        while(tipoSeleccionado<1 || tipoSeleccionado>=i) {
            System.out.print("Dígito no válido, intente nuevamente: ");
            tipoSeleccionado=entrada.nextInt();
            entrada.nextLine();
        }
        return idTipos.get(tipoSeleccionado);
    }
    @Override
    public void agregarPlato(Plato plato) {
        try{
            if(!chefs.contains(plato.getChefACargo())) throw new ChefNoContratadoException("\nEl plato no pudo ser agregado porque el chef a cargo no se encuentra en el sistema.");
            else if(menu.contains(plato)) throw new PlatoRepetidoException("\nEl plato no pudo ser agregado porque ya está incluido en el menú.");
            else {
                menu.add(plato);
                System.out.println("\nEl plato \""+plato.getNombre()+"\" se agregó al menú de "+nombreRestaurante+".");
            }
        } catch(ChefNoContratadoException | PlatoRepetidoException e) { System.out.println(e.getMessage()); }
    }
    @Override
    public void contratarChef(Chef chef) {
        try {
            if(!chef.hasExperienciaCulinariaPrevia()) throw new ChefSinExperienciaPreviaException("\nEl chef no pudo ser agregado porque no cumple con el criterio de contratación de experiencia culinaria previa.");
            else if(!chef.mayorDeEdad()) throw new ChefMenorDeEdadException("\nEl chef no pudo ser agregado porque no cumple con el criterio de contratación de ser mayor de edad.");
            else {
                chefs.add(chef);
                System.out.println("\nEl chef "+chef.getNombre()+" "+chef.getApellido()+" se unió al equipo de "+nombreRestaurante+".");
            }
        } catch(ChefSinExperienciaPreviaException | ChefMenorDeEdadException e) { System.out.println(e.getMessage()); }
    }
    public static void main(String[] args) {
        int respuesta;
        HashSet<Chef> chefs=new HashSet<>();
        HashSet<Plato> menu=new HashSet<>();
        Scanner entrada=new Scanner(System.in);

        Chef c1=new Chef("Daniel","Santi",LocalDate.of(2004,11,10),true,1);
        Chef c2=new Chef("El","Paja",LocalDate.of(2004,11,10),true,2);
        Chef c3=new Chef("Barbosa","Ingeniero",LocalDate.of(2004,11,10),true,3);
        chefs.add(c1);
        chefs.add(c2);
        chefs.add(c3);

        Plato p1=new Plato(c1,1250,"En honor a los valientes caballeros del reino de Avalon","Papas del draǵon",Tipo.ENTRADA);
        Plato p3=new Plato(c2,3500,"La especialidad de la casa","Cazuela de quesos",Tipo.PLATOPRINCIPAL);
        Plato p2=new Plato(c3,2000,"No apto para intolerantes a la lactosa","Torta cremosa",Tipo.POSTRE);
        menu.add(p1);
        menu.add(p2);
        menu.add(p3);

        Sistema sistema=new Sistema(chefs,menu,"Lo de Daniel");
        do {
            System.out.print("\nBienvenido a "+sistema.getNombreRestaurante()+"\n\n1. Contratar chef\n2. Agregar plato\n3. Ver menú\n4. Salir\n\nIngrese el dígito correspondiente: ");
            respuesta=entrada.nextInt();
            entrada.nextLine();
            while(respuesta<1 || respuesta>4) {
                System.out.print("Dígito no válido, intente nuevamente: ");
                respuesta=entrada.nextInt();
                entrada.nextLine();
            }
            switch(respuesta) {
                case 1:
                    sistema.contratarChef(entrada);
                    break;
                case 2:
                    sistema.agregarPlato(entrada);
                    break;
                case 3:
                    sistema.mostrarMenu();
                    break;
            }
        } while(respuesta!=4);
    }
}