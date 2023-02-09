
import java.net.*;

/*
 * @author Sergio Castillo Llorens
 */

public class Servidor {

    public static final int PORT = 60000;
    public static ServerSocket servidor;
    public static Socket sCliente;
    
    public static void main(String[] args) {
        try {
            servidor = new ServerSocket(PORT);
            System.out.println("Servidor iniciado en " + PORT);
            
            while (true) {
                sCliente = new Socket();
                sCliente = servidor.accept();
                
                //Creo un hilo y lo inicio
                HiloServidor hilo = new HiloServidor(sCliente, PORT);
                hilo.start();
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
