
import java.io.*;
import java.util.*;

/*
 * @author 7J
 */
public class ej1 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);

        Runtime r = Runtime.getRuntime();
        String com, linea;
        int exitVal;
        Process p = null;

        com = "java prueba.java \"juan carlos!!\" ";

        if (args.length < 1) {
            System.out.println("Se necesita un nombre de fichero");
            System.exit(1);
        }

        try {
            FileOutputStream fos = new FileOutputStream(args[0]);
            PrintWriter pw = new PrintWriter(fos);
            p = r.exec(com);

            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String lin;

            while ((lin = br.readLine()) != null) {
                System.out.println("Inserisc en " + args[0] + " > " + lin);
                pw.println(lin);
            }
            br.close();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //COMPROBACION DE ERRORES
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
