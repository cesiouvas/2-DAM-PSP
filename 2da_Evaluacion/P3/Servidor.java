package P3;

/*
 * @author Sergio Castillo Llorens
 */
import java.io.*;
import java.net.*;

public class Servidor {

    //Puerto que espera las conexiones
    static final int port = 5000;

    public Servidor() {
        try {
            String msg;
            boolean cont = true;

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

            while (cont) {
                msg = dis.readUTF();

                switch (msg) {
                    case "hola":
                        System.out.println("Cliente: " + msg);
                        dos.writeUTF("Hola soy el servidor");
                        break;
                    case "que tal?":
                        System.out.println("Cliente: " + msg);
                        dos.writeUTF("Muy bien!");
                        break;
                    case "adios":
                        System.out.println("Cliente: " + msg);
                        dos.writeUTF("Hasta luego!");
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
            ssServidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }
}
