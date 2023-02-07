
import java.util.*;

/*
 * @author sergio
 */
public class Persona extends Thread {

    private String nombre;
    private Compte c;
    Random rnd = new Random();

    //CONSTRUCTOR
    public Persona(String nombre, Compte c) {
        this.nombre = nombre;
        this.c = c;
    }

    public String getNombre() {
        return nombre;
    }

    //SALARIO RANDOM
    public int random() {
        return (int) (Math.random() * 501.0);
    }

    public void hacerIngreso() {
        int suma = random();
        c.ingreso(suma, getNombre());
    }

    public void hacerReintegro() {
        int resta = random();
        c.reintegro(resta, getNombre());
    }

    @Override
    public void run() {
        hacerIngreso();
        hacerReintegro();
        hacerIngreso();
        hacerReintegro();
    }
}
