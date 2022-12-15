package P2;

/*
 * @author Sergio Castillo Llorens
 */

import java.io.*;
import java.net.*;

public class cliente {
    static final String host = "localhost";
    static final int port = 5000;
    
    public cliente() {
        try {
            //Crear socket
            Socket sCliente = new Socket(host, port);
            System.out.println("Conectando al servidor...");
            System.out.println("Conectado");
            
            //Flujo de salida para el cliente
            InputStream isAux = sCliente.getInputStream();
            DataInputStream dis = new DataInputStream(isAux);
            
            //Flujo de entrada del cliente
            OutputStream osAux = sCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(osAux);
            
            System.out.println("Hola");
            dos.writeUTF("Hola");
            System.out.println("Servidor: " + dis.readUTF());
            System.out.println("¿Cómo estás?");
            dos.writeUTF("¿Cómo estás?");
            System.out.println("Servidor: " + dis.readUTF());
            System.out.println("Adios");
            dos.writeUTF("Adios");
            System.out.println("Servidor: " + dis.readUTF());
            
            //Cerrar conexión
            System.out.println("Cerrando conexión...");
            sCliente.close();
            
        } catch (Exception e) {
            System.out.println("No se ha podido conectar a " + host + ": " + port);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new cliente();
        return;
    }
}
