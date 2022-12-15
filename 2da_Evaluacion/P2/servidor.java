package P2;

/*
 * @author Sergio Castillo Llorens
 */
import java.io.*;
import java.net.*;

public class servidor {

    //Puerto que espera las conexiones
    static final int port = 5000;

    public servidor() {
        try {
            //Crea el socket y espera
            ServerSocket ssServidor = new ServerSocket(port);
            System.out.println("Escucho por el puerto " + port);

                //accept() crea un socket nuevo para comunicarse con el cliente
                Socket sCliente = ssServidor.accept();
                System.out.println("Sirvo al cliente");

                //Flujo de salida para el cliente
                InputStream isAux = sCliente.getInputStream();
                DataInputStream dis = new DataInputStream(isAux);

                //Flujo de entrada del cliente
                OutputStream osAux = sCliente.getOutputStream();
                DataOutputStream dos = new DataOutputStream(osAux);

                System.out.println("Cliente: " + dis.readUTF());
                dos.writeUTF("Hola soy el servidor");
                System.out.println("Cliente: " + dis.readUTF());
                dos.writeUTF("Muy bien!");
                System.out.println("Cliente: " + dis.readUTF());
                dos.writeUTF("Hasta luego!");

                //Cerrar conexión
                System.out.println("Cerrando conexión...");
                sCliente.close();
                ssServidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new servidor();
    }
}
