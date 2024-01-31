package Ohjelmointiprojekti3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Saapumisprosessi {
    private String tapahtumanTyyppi;
    private Random satunnaislukugeneraattori;

    public Saapumisprosessi(String tapahtumanTyyppi) {
        this.tapahtumanTyyppi = tapahtumanTyyppi;
        this.satunnaislukugeneraattori = new Random();
    }

    public void lisaaTapahtuma(List<String> tapahtumalista, Kello kello) {
        double saapumisvali = generoiSaapumisvali();
        kello.asetaAika(saapumisvali);
        tapahtumalista.add(tapahtumanTyyppi + " saapui kello " + kello.haeAika());
    }

    private double generoiSaapumisvali() {
        return -Math.log(1 - satunnaislukugeneraattori.nextDouble());
    }

    public static void main(String[] args) {
        Saapumisprosessi saapumisprosessi = new Saapumisprosessi("Saapuminen");
        Kello kello = Kello.getInstance();
        List<String> tapahtumalista = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            saapumisprosessi.lisaaTapahtuma(tapahtumalista, kello);
        }

        for (String tapahtuma : tapahtumalista) {
            System.out.println(tapahtuma);
        }
    }
}
