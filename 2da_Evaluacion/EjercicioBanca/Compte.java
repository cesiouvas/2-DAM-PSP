/*
 * @author sergio
 */

public class Compte {

    private int saldo, max;

    public Compte(int saldo, int max) {
        this.max = max;
        this.saldo = saldo;
    }

    // SALDO ACTUAL
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getMax() {
        return max;
    }

    //INGRESO
    public synchronized void ingreso(int saldo, String nom) {
        try {
            //NO SE PUEDE INGRESAR MÁS DINERO
            if ((saldo + getSaldo()) > getMax()) {
                do {
                    System.out.println(
                            "(!) " + nom + " quiere ingresar " + saldo + " dinero. Demasiado saldo. Saldo actual: "
                                    + getSaldo());
                    wait();
                    System.out.println("*** " + nom + " vuelve a comprobar INGRESO de " + saldo);
                } while (getSaldo() + saldo > getMax());
            }
            //INGRESAR
            setSaldo(getSaldo() + saldo);
            System.out.println(nom + " ingresa => : " + saldo + ". Saldo actual es: " + getSaldo());
            notify();
        } catch (Exception e) {
            e.getMessage();
            System.out.println("(!) Error al hacer el ingreso...");
        }
    }

    //REINTEGRO
    public synchronized void reintegro(int saldo, String nom) {
        try {
            //NO SE PUEDE RETIRAR MÁS DINERO
            if ((getSaldo() - saldo) < 0) {
                do {
                    System.out.println(nom + " quiere retirar " + saldo
                            + " dinero pero no hay suficiente saldo. Saldo actual: " + getSaldo());
                    wait();
                    System.out.println("*** " + nom + " vuelve a comprobar REINTEGRO de " + saldo);
                } while (getSaldo() - saldo < 0);
            }
            //RETIRAR
            setSaldo(getSaldo() - saldo);
            System.out.println(nom + " retira => : " + saldo + ". Saldo actual es: " + getSaldo());
            notify();
        } catch (InterruptedException e) {
            e.getMessage();
            System.out.println("(!) Error al hacer el reintegro...");
        }
    }
}
