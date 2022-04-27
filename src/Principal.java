import java.util.Scanner;
import java.util.ArrayList;
public class Principal {
    public static void main(String[] args){
        Principal.mostrarMenu();
    }

    public static void mostrarMenu(){
        ArrayList<Zombies> zombies = new ArrayList<Zombies>();
        ArrayList<Ubicaciones> ubicaciones = new ArrayList<Ubicaciones>();
        Scanner sc = new Scanner(System.in);
        System.out.println("*-*-*-*-*-* Q'hubo pá, Bienvenido a los muertos caminantes :P *-*-*-*-*-*");
        System.out.println(" ");
        System.out.println("* Ingrese 0 para mostrar el menu");
        System.out.println("* ¿Tienes miedo? Ingresa cualquier número para salir...");
        int num = sc.nextInt();
        if(num==0) {
            do {
                System.out.println(" ");
                System.out.println("*-*-*-*-*-* Menu Principal *-*-*-*-*-*");
                System.out.println(" ");
                System.out.println("* Ingrese 0 para finalizar el programa");
                System.out.println("* Ingrese 1 para agregar un nuevo zombie");
                System.out.println("* Ingrese 2 para ver la información de todos los zombies");
                System.out.println("* Ingrese 3 para ver la cantidad total de zombies ");
                System.out.println("* Ingrese 4 para ver la información de los zombies con tipo de sangre “O+” o “AB+” ");
                System.out.println("* Ingrese 5 para ver la información de los zombies que nacieron después del año 2000");
                System.out.println("* Ingrese 6 para lanzar una bomba a los zombies");
                System.out.println("* Ingrese 7 para agregar una nueva ubicación");
                System.out.println("* Ingrese 8 para ver información de todas las ubicaciones");
                System.out.println("* Ingrese 9 para ver la ubicación más segura de la ciudad");
                System.out.println("* Ingrese 10 para ver todas las ubicaciones ordenadas por su distancia a Alexandria");
                System.out.println("* Ingrese 11 para ver una frase aleatoria sobre los zombies");
                System.out.println("* Ingrese 12 para eliminar a los zombies con ms de 70 de salud");
                System.out.println("");
                num = sc.nextInt();
                if(num==0){
                    System.out.println(" ");
                    System.out.println("*-*-* Gracias, hasta pronto :D *-*-*");
                    break;
                }
                switch (num){
                    case 1:
                        System.out.println("Ingrese el nombre del Zombie"); String n = sc.next();
                        System.out.println("Ingrese la salud del Zombie (0-100)"); int s = sc.nextInt();
                        while(!Zombies.verificarSalud(s)){
                            System.out.println("Valor incorrecto, por favor intente nuevamente");
                            s = sc.nextInt();
                        }
                        System.out.println("Ingrese la fecha de nacimiento del Zombie (DD/MM/AAAA)"); String date = sc.next();
                        while(!Zombies.verificarFecha(date)) {
                            System.out.println("Valor incorrecto, por favor intente nuevamente");
                            date = sc.next();
                        }
                        System.out.println("Ingrese el tipo de sangre del Zombie"); String blood = sc.next();
                        while(!Zombies.verificarSangre(blood)) {
                            System.out.println("Valor incorrecto, por favor intente nuevamente");
                            blood = sc.next();
                        }
                        blood = Zombies.convertirMayuscula(blood);
                        zombies.add(Zombies.crearZombie(n,s,date,blood));
                        System.out.println(" ");
                        System.out.println("*-*-* Zombie añadido *-*-*");
                        zombies.get(zombies.size()-1).imprimirZombie();
                        break;

                    case 2:
                        Zombies.imprimirTodosZombies(zombies);
                        break;

                    case 3:
                        Zombies.cantidadZombies(zombies);
                        break;

                    case 4:
                        Zombies.imprimirZombiesSangre(zombies);
                        break;

                    case 5:
                        Zombies.imprimirZombies2000(zombies);
                        break;

                    case 6:
                        Zombies.lanzarBomba(zombies);
                        break;

                    case 7:
                        System.out.println("Ingrese el nombre de la ubicación"); String name = sc.next();
                        System.out.println("Ingrese la distancia a Alexandria (Metros)"); float dist = sc.nextFloat();
                        System.out.println("Ingrese la cantidad de Zombies de la ubicación"); int cant = sc.nextInt();
                        ubicaciones.add(Ubicaciones.crearUbicacion(name,dist,cant));
                        System.out.println(" ");
                        System.out.println("*-*-* Ubicación añadida *-*-*");
                        ubicaciones.get(ubicaciones.size()-1).imprimirUbicacion();
                        break;

                    case 8:
                        Ubicaciones.imprimirTodasUbicaciones(ubicaciones);
                        break;

                    case 9:
                        Ubicaciones.ubicacionMasSegura(ubicaciones);
                        break;

                    case 10:
                        Ubicaciones.imprimirUbicacionesAlexandria(ubicaciones);

                        break;

                    case 11:
                        Zombies.frasesZombies();
                        break;

                    case 12:
                        Zombies.eliminarZombiesSalud(zombies);
                        break;

                }
            }while(1<2);


        }else{
            System.out.println(" ");
            System.out.println("*-*-* Gracias por nada :D *-*-*");
        }
    }
}

