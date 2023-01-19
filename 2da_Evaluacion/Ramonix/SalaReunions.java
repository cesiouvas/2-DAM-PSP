
import java.util.ArrayList;

/*
 * @author Sergio Castillo Llorens
 */
public class SalaReunions {

    private static boolean neo;
    private static ArrayList<String> lista;

    public SalaReunions() {
        this.neo = false;
        this.lista = new ArrayList<String>();
    }

    public SalaReunions(boolean neo) {
        this.neo = neo;
        this.lista = new ArrayList<String>();
    }

    //Añade hackers a la lista de hackers
    public static void addHacker(String nom) {
        lista.add(nom);
    }

    public ArrayList<String> getHacker() {
        return this.lista;
    }

    //Comprueba el estado de Neo
    public boolean estaNeo() {
        return neo;
    }

    //Si Neo llega lo setea a true
    public static void setNeo() {
        neo = true;
    }
}
