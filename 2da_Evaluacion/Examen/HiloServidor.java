
import java.io.*;
import java.net.*;
import java.util.*;

/*
 * @author Sergio Castillo Llorens
 */
public class HiloServidor extends Thread {

    private DataInputStream in;
    private DataOutputStream out;
    private int PORT;
    private Socket sCliente;
    private ArrayList<Integer> listaAscii = new ArrayList<Integer>();

    public HiloServidor(Socket sCliente, int PORT) {
        this.sCliente = sCliente;
        this.PORT = PORT;
        System.out.println("Creo hilo servidor: Socket[addr=" +sCliente.getInetAddress() + ", port=" + sCliente.getPort() + ", localport=" + PORT +"]");
    }

    public void run() {
        int cantidad, valor = 0;
        String cadena;

        try {
            System.out.println("Inicio HiloServidor...");
            //Creo los flujos de entrada y salida
            out = new DataOutputStream(sCliente.getOutputStream());
            in = new DataInputStream(sCliente.getInputStream());
            
            //Recibo la cantidad de palabras desde el cliente
            cantidad = in.readInt();
            System.out.println("Numero de cadenas que va a enviar el cliente: " + cantidad);
            
            //Recibo tantas cadenas como cantidad
            for (int i = 0; i < cantidad; i++) {
                cadena = in.readUTF();
                
                //Recorro cada palabra y convierto los caracteres en valores ascii
                for (int j = 0; j < cadena.length(); j++) {
                    char c = cadena.charAt(j);
                    valor += (int) c;
                }
                listaAscii.add(valor);
                valor = 0;
            }
            
            //Envío los valores ascii al cliente
            for (int i = 0; i < listaAscii.size(); i++) {
                out.writeInt(listaAscii.get(i));
            }
            
            //Finaliza la conexion
            System.out.println("FIN CON Socket[addr=" +sCliente.getInetAddress() + ", port=" + sCliente.getPort() + ", localport=" + PORT +"]");
            sCliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
