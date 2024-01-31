package Ohjelmointiprojekti2;
import java.util.PriorityQueue;

class Tapahtumalista {
    private PriorityQueue<Tapahtuma> tapahtumat = new PriorityQueue<>();

    public void lisaaTapahtuma(Tapahtuma tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    public Tapahtuma haeSeuraavaTapahtuma() {
        return tapahtumat.poll();
    }

    public void tulostaTapahtumat() {
        while (!tapahtumat.isEmpty()) {
            System.out.println(haeSeuraavaTapahtuma());
        }
    }
}
