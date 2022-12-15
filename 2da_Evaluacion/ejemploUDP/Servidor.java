package ejemploUDP;

/*
 * @author Sergio Castillo Llorens
 */

import java.io.*;
import java.net.*;

public class Servidor {
    
        public static void main(String[] args) {
        DatagramSocket dSocket = null;
        
        /*
        if (args.length < 1) {
            System.out.println("Uso: java UDPServer <numero de puerto>");
            System.exit(1);
        }
        */
        
        try {
            //NUMERO DE PUERTO
            int numSocket = 5000;
            dSocket = new DatagramSocket(numSocket);
            byte[] mesRecibido = new byte[1000];
            
            while (true) {
                DatagramPacket dpRecibido = new DatagramPacket(mesRecibido, mesRecibido.length);
                dSocket.receive(dpRecibido);
                System.out.println("Recibo del cliente: " + new String(dpRecibido.getData()));
            
                //ENVIA DATAGRAMA
                DatagramPacket dpRespuesta = new DatagramPacket(dpRecibido.getData(), dpRecibido.getLength(), dpRecibido.getAddress(), dpRecibido.getPort());
                dSocket.send(dpRespuesta);
            }
            
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
