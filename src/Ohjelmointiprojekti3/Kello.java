package Ohjelmointiprojekti3;

import java.util.Date;

public class Kello {
    private static Kello instance;
    private Date aika;

    private Kello() {
        this.aika = new Date();
    }

    public static synchronized Kello getInstance() {
        if (instance == null) {
            instance = new Kello();
        }
        return instance;
    }

    public synchronized void asetaAika(Date uusiAika) {
        this.aika = uusiAika;
    }

    public synchronized Date haeAika() {
        return this.aika;
    }

    public static void main(String[] args) {
        Kello kello = Kello.getInstance();

        System.out.println("Nykyinen aika: " + kello.haeAika());

        Date uusiAika = new Date();
        kello.asetaAika(uusiAika);
        System.out.println("Uusi aika: " + kello.haeAika());
    }
}
