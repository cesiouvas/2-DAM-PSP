package teatro;

/*
 * @author Sergio Castillo Llorens
 */
import java.io.*;
import java.net.*;

public class Cliente {

    static final String host = "localhost";
    static final int port = 5000;

    public Cliente() {
        try {
            //Crear socket
            Socket sCliente = new Socket(host, port);
            System.out.println("Conectando al servidor...");
            System.out.println("Conectado!");

            //Flujo de salida para el cliente
            InputStream isAux = sCliente.getInputStream();
            DataInputStream dis = new DataInputStream(isAux);

            //Flujo de entrada del cliente
            OutputStream osAux = sCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(osAux);
            
            //Comienzo cliente
            System.out.println("Hola");
            dos.writeUTF("Hola");
            System.out.println("Servidor: " + dis.readUTF());
            
            //Selección butaca

        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    public static void main(String[] args) {
        new Cliente();
    }
}
