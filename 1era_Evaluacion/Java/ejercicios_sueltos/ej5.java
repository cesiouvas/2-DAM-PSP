
import java.io.*;


/*
 * @author 7J
 */
public class ej5 {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String com = "cmd /c date";
        Process p = null;

        try {
            p = r.exec(com);
            OutputStream os = p.getOutputStream();
            os.write("20-10-22\n".getBytes());
            os.flush();

            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Error en " + com);
            e.printStackTrace();
        }
    }
}
