package titanic;

/*
 * @author sergio
 */

public class Pasajero {
    private int clase, edad;
    private String nombre, apellido, lugar;
    private char sobrevive;
    
    public Pasajero (int clase, String apellido, String nombre, int edad, String lugar, char sobrevive) {
        this.clase = clase;
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.lugar = lugar;
        this.sobrevive = sobrevive;
    }
    
    public int getClase() {
        return clase;
    }
    
    public char getSobrevive() {
        return sobrevive;
    }
}
