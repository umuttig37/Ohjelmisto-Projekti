import java.util.PriorityQueue;

public enum TapahtumanTyyppi {
    SAAPUMINEN,
    POISTUMINEN
}

class Tapahtuma implements Comparable<Tapahtuma> {
    private String tapahtumanNimi;
    private long tapahtumaAika;
    private TapahtumanTyyppi tapahtumanTyyppi;

    public Tapahtuma(String nimi, long aika, TapahtumanTyyppi tyyppi) {
        this.tapahtumanNimi = nimi;
        this.tapahtumaAika = aika;
        this.tapahtumanTyyppi = tyyppi;
    }

    public String getTapahtumanNimi() {
        return tapahtumanNimi;
    }

    public long getTapahtumaAika() {
        return tapahtumaAika;
    }

    public TapahtumanTyyppi getTapahtumanTyyppi() {
        return tapahtumanTyyppi;
    }

    @Override
    public int compareTo(Tapahtuma toinen) {
        return Long.compare(this.tapahtumaAika, toinen.tapahtumaAika);
    }

    @Override
    public String toString() {
        return tapahtumanNimi + " " + tapahtumaAika + " Tyyppi: " + tapahtumanTyyppi;
    }
}


public class PaaOhjelma {
    public static void main(String[] args) {
        Tapahtumalista tapahtumalista = new Tapahtumalista();

        tapahtumalista.lisaaTapahtuma(new Tapahtuma("Saapuminen 1", System.currentTimeMillis() + 5000, TapahtumanTyyppi.SAAPUMINEN));
        tapahtumalista.lisaaTapahtuma(new Tapahtuma("Poistuminen 1", System.currentTimeMillis() + 3000, TapahtumanTyyppi.POISTUMINEN));
        tapahtumalista.lisaaTapahtuma(new Tapahtuma("Saapuminen 2", System.currentTimeMillis() + 7000, TapahtumanTyyppi.SAAPUMINEN));

        System.out.println("Tapahtumalistam sisältö ajan ja tyypin järjestyksessä:");
        tapahtumalista.tulostaTapahtumat();
    }
}
