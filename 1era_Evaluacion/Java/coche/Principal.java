/*
 * @author sergio
 */

import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        Scanner txt = new Scanner(System.in);
        ArrayList<Coche> lista = new ArrayList<Coche>();

        int coches, cont = 1;
        String marca;

        System.out.println("Cuantos coches quieres?");
        coches = tcl.nextInt();

        while (cont <= coches) {
            System.out.println("Dime la marca del coche " + cont);
            marca = txt.nextLine();
            Coche c = new Coche(marca, cont);
            lista.add(c);
            cont++;
        }
        
        System.out.println("Que comience la carrera");
        Iterator it = lista.iterator();
        while (it.hasNext()) {
            Coche aux = (Coche)it.next();
            aux.start();
        }
    }
}
