import java.util.ArrayList;

public class Zombies {
    private String nombre;
    private int salud;
    private String fechaDeNacimiento;
    private String tipoDeSangre;


    public void setSalud(int s){
        this.salud = s;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getSalud(){
        return this.salud;
    }

    public String getFechaDeNacimiento(){
        return this.fechaDeNacimiento;
    }

    public String getTipoDeSangre(){
        return this.tipoDeSangre;
    }




    public Zombies(String n, int s, String date, String type) {
        this.nombre = n;
        this.salud = s;
        this.fechaDeNacimiento = date;
        this.tipoDeSangre = type;
    }

    public static Zombies crearZombie(String n, int s, String date, String type){
        Zombies z = new Zombies(n,s,date,type);
        return z;
    }

    public static boolean verificarSalud(int s){
        return s <= 100 && s > 0;
    }

    public static boolean verificarSangre(String s) {
        if(s.equals("A+") || s.equals("A-") || s.equals("B+") || s.equals("B-") || s.equals("AB+") || s.equals("AB-") || s.equals("O+") || s.equals("O-"))
            return true;
        else if(s.equals("a+") || s.equals("a-") || s.equals("b+") || s.equals("b-") || s.equals("ab+") || s.equals("ab-") || s.equals("o+") || s.equals("o-")){
            return true;
        }else
            return false;

    }

    public static boolean verificarFecha(String s){

        return (s.length() == 10);

    }

    public static String convertirMayuscula(String s){
        if(s.length()==2)
            s= s.substring(0,1).toUpperCase() + s.substring(1);
        else if(s.length()==3)
            s = s.substring(0,2).toUpperCase() + s.substring(2);

        return s;
    }

    public void imprimirZombie(){

        System.out.println("Nombre: "+this.nombre);
        System.out.println("Salud: "+this.salud);
        System.out.println("Fecha de Nacimiento: "+this.fechaDeNacimiento);
        System.out.println("Tipo de Sangre: "+this.tipoDeSangre);
    }

    public static void imprimirTodosZombies(ArrayList<Zombies> z){
        int j = 0;
        for(int i = 0; i<z.size(); i++){
            System.out.println(" ");
            System.out.println("*-*-* Informacion Zombie #"+(i+1)+" *-*-*");
            z.get(i).imprimirZombie();
            j++;
        }
        if (j==0)
            System.out.println("*-*-* No hay zombies, no sé que quieres que haga ._. *-*-*");

    }

    public  static void cantidadZombies(ArrayList<Zombies> z){
        System.out.println(" ");
        if(z.size() == 0)
            System.out.println("*-*-* Actualmente no hay Zombies creados, cree uno pues >:c *-*-*");
        else if(z.size() == 1)
            System.out.println("*-*-* Actualmente hay 1 Zombie creado *-*-*");
        else
            System.out.println("*-*-* Actualmente hay "+z.size()+" Zombies creados *-*-*");

    }

    public static void imprimirZombiesSangre(ArrayList<Zombies> z){
        int j = 0;
        for(int i = 0; i<z.size(); i++){
            if(z.get(i).getTipoDeSangre().equals("O+") || z.get(i).getTipoDeSangre().equals("AB+")){
                System.out.println(" ");
                System.out.println("*-*-* Informacion Zombie #"+(i+1)+" *-*-*");
                z.get(i).imprimirZombie();
                j++;
            }
        }
        if(j==0){
            System.out.println(" ");
            System.out.println("*-*-* Actualmente no existen Zombies con tipo de sangre “O+” o “AB+” *-*-*");
        }

    }

    public static void imprimirZombies2000(ArrayList<Zombies> z){
        int j = 0;
        for(int i = 0; i<z.size(); i++){
            int year = Integer.parseInt(z.get(i).getFechaDeNacimiento().substring(6,10));
            if(year>=2000){
                System.out.println(" ");
                System.out.println("*-*-* Informacion Zombie #"+(i+1)+" *-*-*");
                z.get(i).imprimirZombie();
                j++;
            }
        }
        if(j==0){
            System.out.println(" ");
            System.out.println("*-*-* Actualmente no existen Zombies que hayan nacido despues de año 2000 *-*-*");
        }
    }

    public static void lanzarBomba(ArrayList<Zombies> s){
        System.out.println("*-*-* ¡Sufran malditos no muertos! *-*-*");
        s.forEach((z) -> z.setSalud(z.getSalud()/2) );
    }

    public static void frasesZombies(){
        String[] frases = {"*-*-* Para un Zombie, todo el mundo sabe igual de bien *-*-*","*-*-* De los Zombies aprendí que al acercarse a una persona, lo primero que hay que buscar es su cerebro *-*-*"
                , "*-*-* Tengo malas noticias para tí, tienes un Zombie detrás *-*-*", "*-*-* Apocalipsis Zombie en progreso, por favor mantenga la calma o por lo menos su cerebro *-*-*", "*-*-* Zombies are comming... *-*-*"};
        int random = (int) (Math.random()*(0-4)+4);
        System.out.println(frases[random]);
    }

    public static void eliminarZombiesSalud(ArrayList<Zombies> z) {
        if (z.size() != 0) {
            int j = 0;
            for (int i = 1; i < z.size(); i++) {
                if (z.get(i).getSalud() >= 70) {
                    z.remove(i);
                    j++;
                }


            }
            if(j == 0)
                System.out.println("*-*-* No hay ningún Zombie con salud mayor a 70 *-*-*");
            else if(j == 1)
                System.out.println("*-*-* Se ha eliminado "+j+" Zombie *-*-*");
            else
                System.out.println("*-*-* Se han eliminado "+j+" Zombies *-*-*");

        } else
            System.out.println("*-*-* No hay ningún zombie que eliminar *-*-*");

    }


}