
import java.io.*;
import java.net.*;

/*
 * @author sergio
 */

public class Ramonix implements Comu {

    public static int energia;
    public static boolean cont;

    public Ramonix(int energia) {
        this.energia = energia;
        this.cont = true;
    }

    public static void servidor() {
        Socket sClient = null;
        ServerSocket ssServidor;
        InputStream isAux;
        DataInputStream dis;
        OutputStream osAux;
        DataOutputStream dos;
        String ataque;

        try {
            //Abro la conexión
            ssServidor = new ServerSocket(PORT);
            System.out.println(ANSI_GREEN + "BENVINGUTS A RAMONIX!!\n");

            while (energia > 0) {
                //Espera a que se conecte el cliente
                sClient = ssServidor.accept();

                //Flujo de salida para el servidor
                isAux = sClient.getInputStream();
                dis = new DataInputStream(isAux);
                //Flujo de entrada del servidor
                osAux = sClient.getOutputStream();
                dos = new DataOutputStream(osAux);

                //Recibe el nombre del hacker que va a atacar
                ataque = dis.readUTF();

                //Ataca dependiendo del nombre del hacker que haya mandado el cliente
                switch (ataque) {
                    //Ataca NEO
                    case "Neo":
                        energia -= 20;
                        System.out.println(ANSI_RED + "Atac des de: " + ataque);
                        System.out.println("*** Energia: " + energia);
                        break;
                    //Ataca P4q1T0
                    case "P4q1T0":
                        System.out.println(ANSI_YELLOW + "Atac des de: " + ataque);
                        energia -= 10;
                        System.out.println("*** Energia: " + energia);
                        break;
                    //Ataca PaU3T
                    case "PaU3T":
                        System.out.println(ANSI_YELLOW + "Atac des de: " + ataque);
                        energia -= 10;
                        System.out.println("*** Energia: " + energia);
                        break;
                    //Ataca Ab4$t0$
                    case "Ab4$t0$":
                        System.out.println(ANSI_GREEN + "Atac des de: " + ataque);
                        energia += 10;
                        System.out.println("*** Energia: " + energia);
                        break;
                }
                //Envía la vida que queda después del ataque al cliente
                dos.writeInt(energia);
            }
            
            //Energia = 0
            //CIERRA LA CONEXIÓN
            System.out.println("COMUNIQUE AL CLIENT QUE TANQUE");
            sClient.close();
            ssServidor.close();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        Ramonix ramonix = new Ramonix(500);
        ramonix.servidor();
    }
}
