/*
 * @author Sergio Castillo Llorens
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class Hacker extends Thread {

    private String nom;
    private SalaReunions sala;
    private int energia;

    public Hacker(String name) {
        nom = name;
    }

    public Hacker(String name, SalaReunions nsala) {
        nom = name;
        sala = nsala;
    }

    public void run() {

        try {
            synchronized (sala) {
                //Añade los hackers a la lista
                sala.addHacker(this.nom);

                if (this.nom.equals("Neo")) {
                    //Neo ha llegado y notifica a todos los Hackers
                    System.out.println("****** Neo-: Bon dia. Anem a destruir RAMONIX! ******");
                    sala.setNeo();
                    sala.notifyAll();
                } else {
                    if (!sala.estaNeo()) {
                        //No está Neo, los Hackers se esperan
                        sala.wait();
                    } else {
                        //Está Neo
                        sala.notifyAll();
                        System.out.println(nom + "-: Bon dia Neo...");
                    }
                }
                //Están todos
                System.out.println("JA ESTEM TOTS. " + nom + " COMENÇA L'ATAC!!!");
            }

            do {
                //Comienza el ataque
                Atac.enviarAtac(this.nom);
                
                //Recibe la energia de RAMONIX para ver si sigue atacando
                energia = Atac.getEnergia();
            } while (energia > 0);
        } catch (Exception e) {
        }
    }

    public String getNom() {
        return nom;
    }
}
