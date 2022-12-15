package teatro;

/*
 * @author Sergio Castillo Llorens
 */
import java.io.*;
import java.net.*;

public class Servidor {

    static final int port = 5000;

    public Servidor() {
        try {
            int contGAL = 8, contCEN = 54, contLAT1 = 4, contLAT2 = 4, contVIP1 = 3, contVIP2 = 3;
            
            //Crear socket y esperar
            ServerSocket ssServidor = new ServerSocket(port);
            System.out.println("Escucho por el puerto " + port);

            Socket sCliente = ssServidor.accept();
            System.out.println("Sirvo al cliente");

            //Flujo de salida para el cliente
            InputStream isAux = sCliente.getInputStream();
            DataInputStream dis = new DataInputStream(isAux);

            //Flujo de entrada del cliente
            OutputStream osAux = sCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(osAux);

            //Comienzo servidor
            System.out.println("Cliente: " + dis.readUTF());
            dos.writeUTF("Hola soy el servidor");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }
}
