package titanic;

import java.io.*;
import java.util.*;

/*
 * @author sergio
 */

public class Principal {
    
    public static void main(String[] args) {
        File f = new File("Titanic.csv");
        ArrayList<Pasajero> lista = new ArrayList<Pasajero>();
        
        String linea = "";
        
        System.out.println("BIENVENIDO AL TITANIC");
        
        try {
            Scanner tcl = new Scanner(f);
            tcl.nextLine();
            while  (tcl.hasNext()) {
                linea = tcl.nextLine();
                String palabra[] = linea.split(",");
                Pasajero p = new Pasajero(Integer.parseInt(palabra[0]), palabra[1], palabra[2], Integer.parseInt(palabra[3]), palabra[4], palabra[5].charAt(0));
                lista.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        //LANZAR HILOS
        Hilo h1 = new Hilo("Primera clase", lista);
        Hilo h2 = new Hilo("Segunda clase", lista);
        Hilo h3 = new Hilo("Tercera clase", lista);
        h1.setPriority(Thread.MAX_PRIORITY);
        h2.setPriority(Thread.MIN_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);
        h1.start();
        h2.start();
        h3.start();
        
        System.out.println("FIN DE LA TRAVESÍA");
    }
}
