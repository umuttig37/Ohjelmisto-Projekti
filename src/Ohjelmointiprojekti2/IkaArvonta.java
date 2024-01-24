package Ohjelmointiprojekti2;

import java.util.Random;

public class IkaArvonta {
    public static void main(String[] args) {
        int opiskelijoidenMaara = 1000;

        int[] ikaJakaumaProsentit = {30, 40, 20, 10};
        int[] ikaJakaumaRajat = new int[ikaJakaumaProsentit.length + 1];
        ikaJakaumaRajat[0] = 0;

        for (int i = 0; i < ikaJakaumaProsentit.length; i++) {
            ikaJakaumaRajat[i + 1] = ikaJakaumaRajat[i] + ikaJakaumaProsentit[i];
        }

        Random random = new Random();

        int[] iat = new int[opiskelijoidenMaara];
        for (int i = 0; i < opiskelijoidenMaara; i++) {
            int satunnainenLuku = random.nextInt(100);

            for (int j = 0; j < ikaJakaumaRajat.length - 1; j++) {
                if (satunnainenLuku >= ikaJakaumaRajat[j] && satunnainenLuku < ikaJakaumaRajat[j + 1]) {
                    int alaRaja = 18 + j * 5;
                    int ylaRaja = alaRaja + 4;
                    iat[i] = random.nextInt(ylaRaja - alaRaja + 1) + alaRaja;
                    break;
                }
            }
        }

        for (int i = 0; i < opiskelijoidenMaara; i++) {
            System.out.println("Opiskelija " + (i + 1) + ": " + iat[i] + " vuotta");
        }
    }
}
