package hilos.ejercicio11;

/*
 * @author 7J
 */

public class Principal {
    
    public static void main(String[] args) {
        Hilo1 h1 = new Hilo1("Hilo 1");
        h1.start();
        
        Hilo1 h2 = new Hilo1("Hilo 2");
        h2.start();
        
        Hilo1 h3 = new Hilo1("Hilo 3");
        h3.start();
        
        System.out.println("3 hilos iniciados...");
    }
}
