import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Ubicaciones {
    private String nombre;
    private float distanciaAlexandria;
    private int cantidadDeZombies;



    public Ubicaciones(String n, float dist, int cant) {
        this.nombre = n;
        this.distanciaAlexandria = dist;
        this.cantidadDeZombies = cant;
    }

    public Ubicaciones(Ubicaciones u) {
        this.nombre = u.getNombre();
        this.distanciaAlexandria = u.getDistanciaAlexandria();
        this.cantidadDeZombies = u.cantidadDeZombies;
    }

    public Ubicaciones() {

    }

    public String getNombre() {
        return this.nombre;
    }

    public float getDistanciaAlexandria() {
        return this.distanciaAlexandria;
    }

    public int getCantidadDeZombies() {
        return this.cantidadDeZombies;
    }



    public static Ubicaciones crearUbicacion(String n, float dist, int cant) {
        Ubicaciones u = new Ubicaciones(n, dist, cant);
        return u;
    }

    public void imprimirUbicacion() {

        System.out.println("Nombre: " + this.nombre);
        System.out.println("Distancia a Alexandria: " + this.distanciaAlexandria);
        System.out.println("Cantidad de Zombies: " + this.cantidadDeZombies);
    }

    public static void imprimirTodasUbicaciones(ArrayList<Ubicaciones> u) {
        int j = 0;
        for (int i = 0; i < u.size(); i++) {
            System.out.println(" ");
            System.out.println("*-*-* Informacion ubicación #" + (i + 1) + " *-*-*");
            u.get(i).imprimirUbicacion();
            j++;
        }
        if (j == 0)
            System.out.println("*-*-* No hay ubicaciones, no sé que quieres que haga ._. *-*-*");

    }

    public static void ubicacionMasSegura(ArrayList<Ubicaciones> u) {
        Ubicaciones s = new Ubicaciones();
        if (u.size() != 0) {
            s = new Ubicaciones(u.get(0));
            for (int i = 1; i < u.size(); i++) {
                if (u.get(i).getCantidadDeZombies() < u.get(0).getCantidadDeZombies()) {
                    s = new Ubicaciones(u.get(i));
                }


            }
            System.out.println("*-*-* La ubicación o ubicaciones más seguras son: *-*-*");
            System.out.println(" ");
            s.ubicacionesMasSeguraRepetida(u);

        } else
            System.out.println("*-*-* No hay ubicaciones que mostrar *-*-*");

    }

    public void ubicacionesMasSeguraRepetida(ArrayList<Ubicaciones> u) {
        this.imprimirUbicacion();
        for (int i = 0; i < u.size(); i++) {
            if (u.get(i).getCantidadDeZombies() == this.cantidadDeZombies)
                if (u.get(i).getDistanciaAlexandria() != this.distanciaAlexandria && !(u.get(i).getNombre().equals(this.nombre)))
                    u.get(i).imprimirUbicacion();
            System.out.println(" ");
        }

    }

    public static void imprimirUbicacionesAlexandria(ArrayList<Ubicaciones> u) {
        ArrayList<Ubicaciones> array = new ArrayList<Ubicaciones>(u);
        Ubicaciones temp = new Ubicaciones();
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = array.size() - 1; j > i; j--) {
                if (array.get(j - 1).getDistanciaAlexandria() > array.get(j).getDistanciaAlexandria()) {
                    temp = array.get(j - 1);
                    array.set(j - 1, array.get(j));
                    array.set(j, temp);
                }
            }
        }
        Ubicaciones.imprimirTodasUbicaciones(array);

    }




}
