package hilos.ejercicio12;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author 7J
 */
public class Hilo extends Thread {

    public Hilo(String nom) {
        super(nom);
    }

    public void run() {
        File f = new File("menu.txt");
        FileReader fr;
        BufferedReader br;
        String line;
        String[] id;
        File nomFich = null;
        BufferedWriter bw;
        FileWriter fw;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                id = line.split("-");

                switch (id[0]) {
                    case "1":
                        if (currentThread().getName().equals("1")) {
                            nomFich = new File("primeros.txt");
                            fw = new FileWriter(nomFich, true);
                            bw = new BufferedWriter(fw);
                            bw.write(id[1] + "\n");
                            bw.close();
                        }
                        break;
                    case "2":
                        if (currentThread().getName().equals("2")) {
                            nomFich = new File("segundos.txt");
                            fw = new FileWriter(nomFich, true);
                            bw = new BufferedWriter(fw);
                            bw.write(id[1] + "\n");
                            bw.close();
                        }
                        break;
                    case "3":
                        if (currentThread().getName().equals("3")) {
                            nomFich = new File("terceros.txt");
                            fw = new FileWriter(nomFich, true);
                            bw = new BufferedWriter(fw);
                            bw.write(id[1] + "\n");
                            bw.close();
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
