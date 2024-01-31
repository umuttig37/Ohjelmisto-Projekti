import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Testohjelma {
    public static void main(String[] args) {
        Saapumisprosessi saapumisprosessi = new Saapumisprosessi("Saapuminen");
        Kello kello = Kello.getInstance();
        Tapahtumalists tapahtumalista = new Tapahtumalists();

        for (int i = 0; i < 10; i++) {
            saapumisprosessi.lisaaTapahtuma(tapahtumalista, kello);
        }

        System.out.println("Viimeisin tapahtuma-aika: " + kello.haeAika());

        while (!tapahtumalista.onTyhja()) {
            Tapahtumat tapahtuma = tapahtumalista.poistaTapahtuma();
            Palvelupiste.kasitteleAsiakas(tapahtuma, kello);
        }

        for (int i = 0; i < 5; i++) {
            kello.asetaAika(kello.haeAika() + 1);
        }

        while (!Palvelupiste.onTyhja()) {
            Asiakas asiakas = Palvelupiste.palveleAsiakas();
            long palveluaika = kello.haeAika() - asiakas.saapumisAika();
            System.out.println("Asiakas vietti järjestelmässä " + palveluaika + " aikayksikköä.");
        }
    }
}

class Tapahtumalists {
    private List<Tapahtumat> tapahtumat;

    public Tapahtumalists() {
        tapahtumat = new ArrayList<>();
    }

    public void lisaaTapahtuma(Tapahtumat tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    public boolean onTyhja() {
        return tapahtumat.isEmpty();
    }

    public Tapahtumat poistaTapahtuma() {
        if (!tapahtumat.isEmpty()) {
            return tapahtumat.remove(0);
        }
        return null;
    }
}

class Palvelupiste {
    private static List<Asiakas> jonotettavatAsiakkaat = new ArrayList<>();

    public static void kasitteleAsiakas(Tapahtumat tapahtuma, Kello kello) {
        Asiakas asiakas = new Asiakas(tapahtuma, kello.haeAika());
        jonotettavatAsiakkaat.add(asiakas);
    }

    public static boolean onTyhja() {
        return jonotettavatAsiakkaat.isEmpty();
    }

    public static Asiakas palveleAsiakas() {
        if (!jonotettavatAsiakkaat.isEmpty()) {
            return jonotettavatAsiakkaat.remove(0);
        }
        return null;
    }
}

class Asiakas {
    private Tapahtumat tapahtuma;
    private long saapumisAika;

    public Asiakas(Tapahtumat tapahtuma, long saapumisAika) {
        this.tapahtuma = tapahtuma;
        this.saapumisAika = saapumisAika;
    }

    public long saapumisAika() {
        return saapumisAika;
    }
}

class Tapahtumat {

}

class Saapumisprosessi {
    private String tapahtumanTyyppi;
    private Random satunnaislukugeneraattori;

    public Saapumisprosessi(String tapahtumanTyyppi) {
        this.tapahtumanTyyppi = tapahtumanTyyppi;
        this.satunnaislukugeneraattori = new Random();
    }

    public void lisaaTapahtuma(Tapahtumalists tapahtumalista, Kello kello) {
        double saapumisvali = generoiSaapumisvali();
        kello.asetaAika((long) saapumisvali);
        tapahtumalista.lisaaTapahtuma(new Tapahtumat());
    }

    private double generoiSaapumisvali() {
        return -Math.log(1 - satunnaislukugeneraattori.nextDouble());
    }
}

class Kello {
    private static Kello instance;
    private long aika;

    private Kello() {
        this.aika = 0;
    }

    public static synchronized Kello getInstance() {
        if (instance == null) {
            instance = new Kello();
        }
        return instance;
    }

    public synchronized void asetaAika(long uusiAika) {
        this.aika = uusiAika;
    }

    public synchronized long haeAika() {
        return this.aika;
    }
}
