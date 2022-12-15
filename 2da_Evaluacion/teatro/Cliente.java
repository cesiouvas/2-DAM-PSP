package teatro;

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
            System.out.println("Conectado!");

            //Flujo de salida para el cliente
            InputStream isAux = sCliente.getInputStream();
            DataInputStream dis = new DataInputStream(isAux);

            //Flujo de entrada del cliente
            OutputStream osAux = sCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(osAux);

            //Comienzo cliente
            System.out.println("hola");
            dos.writeUTF("hola");
            System.out.println("Servidor: " + dis.readUTF());

            while (cont) {
                //Selección butaca
                System.out.println("Introduce el código de la butaca que quieras reservar:");
                msg = sc.nextLine();
                
                if (msg.equals("fin")) {
                    dos.writeUTF(msg);
                    System.out.println("Servidor: " + dis.readUTF());
                    cont = false;
                } else {
                    dos.writeUTF(msg);
                    System.out.println("Servidor: " + dis.readUTF());
                }
            }
            
            //Cerrar conexión
            sCliente.close();
            System.out.println("Cerrando conexión...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cliente();
    }
}