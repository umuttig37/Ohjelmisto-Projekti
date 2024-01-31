package Ohjelmointiprojekti1;

public class Testohjelma {
    public static void main(String[] args) {
        //osa1
        Asiakas asiakas1 = new Asiakas();
        System.out.println("Asiakas 1 ID: " + asiakas1.getId());
        System.out.println("Asiakas 1 Aloitusaika: " + asiakas1.getAloitusaika());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        asiakas1.setLopetusaika(System.currentTimeMillis());

        System.out.println("Asiakas 1 Lopetusaika: " + asiakas1.getLopetusaika());
        System.out.println("Asiakas 1 Kulutettu aika: " + asiakas1.kulutettuAika() + " ms");

        //osa5
        Palvelupiste palvelupiste = new Palvelupiste();

        for (int i = 1; i <= 5; i++) {
            Asiakas asiakas = new Asiakas();
            palvelupiste.lisaaJonoon(asiakas);
        }

        palvelupiste.palvele();
    }
}