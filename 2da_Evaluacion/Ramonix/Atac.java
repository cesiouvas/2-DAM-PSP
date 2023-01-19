
import java.io.*;
import java.net.Socket;

/*
 * @author Sergio Castillo Llorens
 */
public class Atac implements Comu {

    //NEO ATACA 20 cada 2 seg
    //PAUET Y PAQUITO ATACAN 10 cada 1 seg
    //ABASTOS CURA 10 cada 1 seg
    
    static int energia;
    static Socket sClient = null;

    public static void enviarAtac(String nom) {
        Thread hacker = Thread.currentThread();
        InputStream isAux;
        DataInputStream dis;
        OutputStream osAux;
        DataOutputStream dos;
        Socket sClient;
        
        try {
            //Crea el socket y se conecta al servidor
            sClient = new Socket(HOST, PORT);
            
            //Flujo de salida para el cliente
            isAux = sClient.getInputStream();
            dis = new DataInputStream(isAux);

            //Flujo de entrada del cliente
            osAux = sClient.getOutputStream();
            dos = new DataOutputStream(osAux);            

            //Ataque a RAMONIX dependiendo del nombre del hacker
            switch (nom) {
                case "Neo":
                    hacker.sleep(2000);
                    System.out.println(ANSI_RED + "Neo atacando");
                    dos.writeUTF(nom);
                    break;
                case "P4q1T0":
                    hacker.sleep(1000);
                    System.out.println(ANSI_YELLOW + "P4q1T0 atacando");
                    dos.writeUTF(nom);
                    break;
                case "PaU3T":
                    hacker.sleep(1000);
                    System.out.println(ANSI_YELLOW + "PaU3T atacando");
                    dos.writeUTF(nom);
                    break;
                case "Ab4$t0$":
                    hacker.sleep(1000);
                    System.out.println(ANSI_GREEN + "Ab4$t0$ atacando");
                    dos.writeUTF(nom);
                    break;
            }
            //Recibe la vida de Ramonix
            energia = dis.readInt();

        } catch (Exception e) {
        }
    }

    public static int getEnergia() {
        return energia;
    }
}
