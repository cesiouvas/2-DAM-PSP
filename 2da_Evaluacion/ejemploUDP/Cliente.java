package ejemploUDP;

import java.io.*;
import java.net.*;
import java.util.*;

/*
 * @author Sergio Castillo Llorens
 */

public class Cliente {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DatagramSocket dSocket = null;

        /*
        if (args.length < 3) {
            System.out.println("Utilización: java cliente <mensaje> <nombre host> <numero puerto>");
            System.exit(1);
        }
         */
        
        try {
            //ENVIAR DATAGRAMA
            dSocket = new DatagramSocket();
            
            System.out.println("Mensaje para enviar:");
            String msg;
            msg = sc.nextLine();
            
            byte[] mensEnviado = msg.getBytes();
            InetAddress ahost = InetAddress.getByName("localhost"); //HOST
            int serverPort = 5000; //PUERTO
            DatagramPacket dpEnvio = new DatagramPacket(mensEnviado, mensEnviado.length, ahost, serverPort);
            dSocket.send(dpEnvio);

            //RECIBO DE DATAGRAMA
            byte[] mensRecibido = new byte[1000];
            DatagramPacket dpRespuesta = new DatagramPacket(mensRecibido, mensRecibido.length);
            dSocket.receive(dpRespuesta);
            System.out.println("Respuesta: " + new String(dpRespuesta.getData()));

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("IO: " + ex.getMessage());
        } finally {
            if (dSocket != null) {
                dSocket.close();
            }
        }
    }
}
