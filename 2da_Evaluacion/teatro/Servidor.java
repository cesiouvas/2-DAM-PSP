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
            boolean cont = true;
            String msg, butacas;
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
            while (cont) {
                msg = dis.readUTF();

                switch (msg) {
                    case "hola":
                        System.out.println("Cliente: " + msg);
                        dos.writeUTF("Hola soy el servidor");
                        break;
                        
                    //GAL
                    case "GAL":
                        System.out.println("Cliente: " + msg);
                        if (contGAL == 0) {
                            dos.writeUTF("Butacas agotadas para GAL");
                        } else {
                            contGAL--;
                            dos.writeUTF("Reserva GAL " + contGAL);
                        }
                        break;
                        
                    //CEN
                    case "CEN":
                        System.out.println("Cliente: " + msg);
                        if (contCEN == 0) {
                            dos.writeUTF("Butacas agotadas para CEN");
                        } else {
                            contCEN--;
                            dos.writeUTF("Reserva CEN " + contCEN);
                        }
                        break;
                        
                    //LAT1
                    case "LAT1":
                        System.out.println("Cliente: " + msg);
                        if (contLAT1 == 0) {
                            dos.writeUTF("Butacas agotadas para LAT1");
                        } else {
                            contLAT1--;
                            dos.writeUTF("Reserva LAT1 " + contLAT1);
                        }
                        break;
                        
                    //LAT2
                    case "LAT2":
                        System.out.println("Cliente: " + msg);
                        if (contLAT2 == 0) {
                            dos.writeUTF("Butacas agotadas para LAT2");
                        } else {
                            contLAT2--;
                        dos.writeUTF("Reserva LAT2 " + contLAT2);
                        }
                        break;
                        
                    //VIP1
                    case "VIP1":
                        System.out.println("Cliente: " + msg);
                        if (contVIP1 == 0) {
                            dos.writeUTF("Butacas agotadas para VIP1");
                        } else {
                            contVIP1--;
                            dos.writeUTF("Reserva VIP1 " + contVIP1);
                        }
                        break;
                        
                    //VIP2
                    case "VIP2":
                        System.out.println("Cliente: " + msg);
                        if (contVIP2 == 0) {
                            dos.writeUTF("Butacas agotadas para VIP2");
                        } else {
                            contVIP2--;
                            dos.writeUTF("Reserva VIP2 " + contVIP2);
                        }
                        break;
                    //VER BUTACAS
                    case "Ver butacas":
                        System.out.println("Cliente: " + msg);
                        butacas = "Tipo de butaca: VIP 1. Precio 250€. Disponibles: " + contVIP1
                                + "\n";
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }
}
