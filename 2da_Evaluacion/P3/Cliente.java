package P3;

/*
 * @author Sergio Castillo Llorens
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {

    static final String host = "localhost";
    static final int port = 5000;
    static Scanner sc = new Scanner(System.in);

    public Cliente() {
        try {
            boolean cont = true;
            String msg;

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

            while (cont) {
                msg = sc.nextLine();
                
                switch (msg) {
                    case "hola":
                        dos.writeUTF(msg);
                        System.out.println("Servidor: " + dis.readUTF());
                        break;
                    case "que tal?":
                        dos.writeUTF(msg);
                        System.out.println("Servidor: " + dis.readUTF());
                        break;
                    case "adios":
                        dos.writeUTF(msg);
                        System.out.println("Servidor: " + dis.readUTF());
                        cont = false;
                        break;
                    default:
                        System.out.println("Mensaje no encontrado");
                        break;
                }
            }
            
            //Cerrar conexión
            System.out.println("Cerrando conexión...");
            sCliente.close();

        } catch (Exception e) {
            System.out.println("No se ha podido conectar a " + host + ": " + port);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cliente();
        return;
    }
}
