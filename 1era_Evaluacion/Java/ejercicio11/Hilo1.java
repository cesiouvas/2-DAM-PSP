package hilos.ejercicio11;

/*
 * @author 7J
 */

public class Hilo1 extends Thread {
    
    public Hilo1(String nom) {
        super(nom);
    }

    public void run() {
        for (int i = 0; i <= 4; i++) {
            System.out.println(getName()+" amb valor = "+ i);
        }
    }
}
