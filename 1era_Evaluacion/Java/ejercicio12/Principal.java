package hilos.ejercicio12;

/*
 * @author 7J
 */
public class Principal {

    public static void main(String[] args) {
        Hilo h1 = new Hilo("1");
        Hilo h2 = new Hilo("2");
        Hilo h3 = new Hilo("3");
        
        h1.start();
        h2.start();
        h3.start();

    }
}
