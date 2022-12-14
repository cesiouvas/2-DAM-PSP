
import java.util.*;

/*
 * @author sergio
 */
public class Coche extends Thread {

    private String marca;
    private int id;
    private boolean frenar;
    private int distancia;

    public Coche(String marca, int id) {
        super(marca);
        this.id = id;
        frenar = false;
        distancia = 0;

        System.out.println("Coche creado: " + marca + "(" + id + ")");
    }

    public void run() {
        Random r = new Random();
        int num;

        while (frenar == false) {
            num = (int) (r.nextDouble() * 100);
            distancia += num;

            if (distancia > 500) {
                frenar = true;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "(" + id + ") ha recorrido " + distancia + " km!");

            }
        }
        System.out.println("-----------------------------------");
        System.out.println("El " + getName() + "(" + id + ") ha acabado al recorrer " + distancia + " km.");
    }

}
