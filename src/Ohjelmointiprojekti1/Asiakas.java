package Ohjelmointiprojekti1;

import java.util.LinkedList;

class Asiakas {
    private static int seuraavaId = 1;
    private int id;
    private long aloitusaika;
    private long lopetusaika;

    public Asiakas() {
        this.id = seuraavaId++;
        this.aloitusaika = System.currentTimeMillis();
        this.lopetusaika = 0;
    }

    public int getId() {
        return id;
    }

    public long getAloitusaika() {
        return aloitusaika;
    }

    public long getLopetusaika() {
        return lopetusaika;
    }

    public void setLopetusaika(long lopetusaika) {
        this.lopetusaika = lopetusaika;
    }

    public long kulutettuAika() {
        if (lopetusaika == 0) {
            return System.currentTimeMillis() - aloitusaika;
        } else {
            return lopetusaika - aloitusaika;
        }
    }
}