package labyrinttiratkaisija.domain;

/**
 * Luokka joka generoi labyrintin Kruskalin algoritmin avulla
 */
public class LuontiKruskalilla {

    /**
     * Palauttaa syklittoman labyrintin joka on luotu Kruskalin algoritmilla
     * Labyrintin lahto sijaitsee koordinaateissa (1,1) ja maali (x-2,y-2)
     * Labyrinttia reunustaa seinama
     * <p>
     * Kruskalin algoritmissa on aluksi verkkoon tulevat solmut ja etsitaan aina
     * kaari pienimmalla painokertoimella joka sitten otetaan mukaan verkkoon.
     * Verkkoon ei kuitenkaan tule sykleja. Nyt ei kuitenkaan anneta painokertoimia
     * kaarille vaan laitetaan ne suoraa "suuruusjarjestykseen" sekoittamalla ne
     * satunnaiseen jarjestykseen.
     * <p>
     * Tosiaan labyrinteissa on aina kaytavaa ruudut, joissa x ja y kordinaatit ovat
     * parittomia. Naiden valissa olevia ruutuja lisataan mukaan tassa algoritmissa.
     *
     * @param   leveys   Labyrintin leveys
     * @param   korkeus   Labyrintin korkeus
     *
     * @return  Labyrintti, jos syvyys ja leveys on sopivat
     */
    public static char[][] luo(int leveys, int korkeus) {
        if ((leveys % 2 == 0) || (korkeus % 2 == 0) || (leveys < 5) || (korkeus < 5)) {
            return null;
        }
        char[][] labyrintti = new char[leveys][korkeus];
        for (int i = 0; i < leveys; ++i) {
            for (int j = 0; j < korkeus; ++j) {
                if ((i % 2 == 1) && (j % 2 == 1)) {
                    labyrintti[i][j] = '.';
                } else {
                    labyrintti[i][j] = '#';
                }
            }
        }

        int[][] yhteys = new int[leveys][korkeus]; // Yhdistaa kordinaatit vanhempien numeroihin
        int numero = 1;
        for (int i = 0; i < leveys; ++i) {
            for (int j = 0; j < korkeus; ++j) {
                yhteys[i][j] = numero;
                ++numero;
            }
        }

        int[] vanhempi = new int[numero]; // Taulukko union-find rakenteelle
        int[] koko = new int[numero];
        for (int i = 1; i < numero; ++i) {
            vanhempi[i] = i;
            koko[i] = 1;
        }

        int[] ruudutX = new int[leveys * korkeus / 2];
        int[] ruudutY = new int[leveys * korkeus / 2];
        int indeksi = 0;
        for (int i = 1; i < leveys - 1; ++i) {
            for (int j = 1; j < korkeus - 1; ++j) {
                if ((i % 2) == (j % 2)) {
                    continue;
                }
                ruudutX[indeksi] = i;
                ruudutY[indeksi] = j;
                ++indeksi;
            }
        }

        for (int i = 0; i < indeksi; ++i) { // Sekoitus
            int x = satunnainenNumero(indeksi);
            int temp = ruudutX[i];
            ruudutX[i] = ruudutX[x];
            ruudutX[x] = temp;
            temp = ruudutY[i];
            ruudutY[i] = ruudutY[x];
            ruudutY[x] = temp;
        }

        for (int i = 0; i < indeksi; ++i) {
            int x = ruudutX[i];
            int y = ruudutY[i];
            int a, b;
            if (x % 2 == 0) {
                a = yhteys[x - 1][y];
                b = yhteys[x + 1][y];
            } else {
                a = yhteys[x][y - 1];
                b = yhteys[x][y + 1];
            }

            if (sama(a, b, vanhempi)) {
                continue;
            }
            labyrintti[x][y] = '.';

            yhdista(a, b, vanhempi, koko);
            yhdista(a, yhteys[x][y], vanhempi, koko);
        }

        labyrintti[1][1] = 'l';
        labyrintti[leveys - 2][korkeus - 2] = 'm';
        return labyrintti;
    }

    private static int edustaja(int x, int[] vanhempi) {
        while (x != vanhempi[x]) {
            x = vanhempi[x];
        }
        return x;
    }

    private static boolean sama(int x, int y, int[] vanhempi) {
        return edustaja(x, vanhempi) == edustaja(y, vanhempi);
    }

    private static void yhdista(int a, int b, int[] vanhempi, int[] koko) {
        a = edustaja(a, vanhempi);
        b = edustaja(b, vanhempi);
        if (koko[a] < koko[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        vanhempi[b] = a;
        koko[a] += koko[b];
    }

    private static int satunnainenNumero(int maksimi) {
        return (int) (System.nanoTime() % maksimi);
    }

}
