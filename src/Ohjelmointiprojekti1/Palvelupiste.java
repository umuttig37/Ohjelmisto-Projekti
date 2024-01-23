package Ohjelmointiprojekti1;

import java.util.LinkedList;

class Palvelupiste {
    private LinkedList<Asiakas> jono = new LinkedList<>();
    private long kokonaisAika = 0;

    public void lisaaJonoon(Asiakas asiakas) {
        jono.add(asiakas);
    }

    public Asiakas poistaJonosta() {
        if (!jono.isEmpty()) {
            return jono.remove();
        } else {
            return null;
        }
    }

    public void palvele() {
        while (!jono.isEmpty()) {
            Asiakas asiakas = poistaJonosta();
            if (asiakas != null) {
                long aloitusaika = System.currentTimeMillis();
                System.out.println("Palvelua henkilölle ID " + asiakas.getId() + " alkoi klo " + aloitusaika);
                int palveluaika = (int) (Math.random() * 5000);
                try {
                    Thread.sleep(palveluaika);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long lopetusaika = System.currentTimeMillis();
                System.out.println("Palvelua henkilölle ID " + asiakas.getId() + " päättyi klo " + lopetusaika);
                asiakas.setLopetusaika(lopetusaika);
                kokonaisAika += asiakas.kulutettuAika();
            }
        }
    }

   
}
