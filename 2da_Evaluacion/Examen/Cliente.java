
import java.io.*;
import java.net.Socket;
import java.util.*;

/*
 * @author Sergio Castillo Llorens
 */

public class Cliente {

    public static int PORT = 60000;
    public static String HOST = "localhost";
    public static Socket sCliente;
    public static Scanner tcl = new Scanner(System.in);
    public static Scanner txt = new Scanner(System.in);
    
    public static void main(String[] args) {
        int cantidad;
        String cadena;
        DataInputStream in;
        DataOutputStream out;
        
        try {
            sCliente = new Socket(HOST, PORT);
            //Al conectar cliente con servidor creo los flujos de entrada y salida
            out = new DataOutputStream(sCliente.getOutputStream());
            in = new DataInputStream(sCliente.getInputStream());
            System.out.println("Conectado con el servidor!");
            
            //Envio la cantidad de palabras al servidor
            System.out.println("Introduce el numero de cadenas que quieres enviar:");
            cantidad = tcl.nextInt();
            out.writeInt(cantidad);
            
            //Escribo tantas palabras como cantidad y lsa envio al servidor
            for (int i = 0; i < cantidad; i++) {
                System.out.println("Cadena nº " + (i+1));
                cadena = txt.nextLine();
                
                out.writeUTF(cadena);
            }
            
            //Recibe los valores ascii de cada cadena desde el servidor
            for (int i = 0; i < cantidad; i++) {
                System.out.println("Suma de Verificacion de la cadena " + (i+1) +": " + in.readInt());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }    
}
