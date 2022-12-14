package titanic;

/*
 * @author sergio
 */
import java.util.*;

public class Hilo extends Thread {

    private ArrayList<Pasajero> lista = new ArrayList<Pasajero>();

    public Hilo(String nombre, ArrayList<Pasajero> lista) {
        super(nombre);
        this.lista = lista;
    }

    public void run() {
        int cont1 = 0, cont2 = 0, cont3 = 0;
        int supersi1 = 0, superno1 = 0;
        int supersi2 = 0, superno2 = 0;
        int supersi3 = 0, superno3 = 0;

        Iterator it = lista.iterator();

        while (it.hasNext()) {
            Pasajero aux = (Pasajero) it.next();
            //PRIMERA CLASE
            if (aux.getClase() == 1) {
                cont1++;
                if (currentThread().getName().equals("Primera clase")) {
                    if (aux.getSobrevive() == 'N') {
                        superno1++;
                    } else {
                        supersi1++;
                    }
                }
            }

            //SEGUNDA CLASE
            if (aux.getClase() == 2) {
                cont2++;
                if (currentThread().getName().equals("Segunda clase")) {
                    if (aux.getSobrevive() == 'N') {
                        superno2++;
                    } else {
                        supersi2++;
                    }
                }
            }

            //TERCERA CLASE
            if (aux.getClase() == 3) {
                cont3++;
                if (currentThread().getName().equals("Tercera clase")) {
                    if (aux.getSobrevive() == 'N') {
                        superno3++;
                    } else {
                        supersi3++;
                    }
                }
            }
        }

        //CLASE 1
        if (currentThread().getName().equals("Primera clase")) {
            System.out.println("+En primera clase viajaban " + cont1 + " pasajeros. "
                    + "Sobrevivieron " + supersi1 + "(" + ((float) supersi1 / cont1) * 100 + "%) "
                    + "y murieron " + superno1 + "(" + ((float) superno1 / cont1) * 100
                    + "%) pasajeros.");
        }

        //CLASE 2
        if (currentThread().getName().equals("Segunda clase")) {
            System.out.println("+En segunda clase viajaban " + cont2 + " pasajeros. "
                    + "Sobrevivieron " + supersi2 + "(" + ((float) supersi2 / cont2) * 100 + "%) "
                    + "y murieron " + superno2 + "(" + ((float) superno2 / cont2) * 100
                    + "%) pasajeros.");
        }

        //CLASE 3
        if (currentThread().getName().equals("Tercera clase")) {
            System.out.println("+En tercera clase viajaban " + cont3 + " pasajeros. "
                    + "Sobrevivieron " + supersi3 + "(" + ((float) supersi3 / cont3) * 100 + "%) "
                    + "y murieron " + superno3 + "(" + ((float) superno3 / cont3) * 100
                    + "%) pasajeros.");
        }
    }
}
