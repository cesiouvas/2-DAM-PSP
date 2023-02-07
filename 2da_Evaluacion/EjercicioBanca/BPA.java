
/*
 * @author sergio
 */

public class BPA {
    public static void main(String[] args) {
        
        //CREAR CUENTA
        Compte c = new Compte(40, 500);
        
        //CREAR PERSONAS
        Persona p1 = new Persona("Sergio", c);
        Persona p2 = new Persona("Juan", c);
        
        //INICIAR LOS HILOS
        p1.start();
        p2.start();
        
    }
}
