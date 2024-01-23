package Ohjelmointiprojekti1;

import java.util.LinkedList;
import java.util.Scanner;

public class Asiakashallinta {

    public static void main(String[] args) {
        LinkedList<Asiakas> asiakasJono = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Lisää asiakas");
            System.out.println("2. Poista asiakas");
            System.out.println("3. Lopeta");

            int valinta = scanner.nextInt();

            switch (valinta) {
                case 1:
                    Asiakas uusiAsiakas = new Asiakas();
                    asiakasJono.add(uusiAsiakas);
                    System.out.println("Asiakas lisätty jonoon. ID: " + uusiAsiakas.getId());
                    break;
                case 2:
                    if (!asiakasJono.isEmpty()) {
                        Asiakas poistettuAsiakas = asiakasJono.remove();
                        long kulutettuAika = poistettuAsiakas.kulutettuAika();
                        System.out.println("Asiakas ID " + poistettuAsiakas.getId() +
                                " poistettu jonosta. Kulutettu aika: " + kulutettuAika + " ms");
                    } else {
                        System.out.println("Jonossa ei ole asiakkaita.");
                    }
                    break;
                case 3:
                    System.out.println("Ohjelma lopetetaan.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Virheellinen valinta. Yritä uudelleen.");
            }
        }
    }
}
