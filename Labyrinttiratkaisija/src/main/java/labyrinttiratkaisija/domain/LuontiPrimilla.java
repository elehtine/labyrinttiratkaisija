package labyrinttiratkaisija.domain;

/**
 * Luokka joka generoi labyrintin Primin algoritmin avulla
 */
public class LuontiPrimilla {

    /**
     * Palauttaa syklittoman labyrintin joka on luotu Primin algoritmilla
     * Labyrintin lahto sijaitsee koordinaateissa (1,1) ja maali (x-2,y-2)
     * Labyrinttia reunustaa seinama
     * <p>
     * Primin algoritmissa aluksi labyrintissa on vain yksi ruutu ja siihen lisataan
     * kaytava kerrallaan reitteja aina pienimman painokertoimen mukaan. Tata simuloidaan
     * katsomalla mitka kaytavat reunustavat jo tunnettua labyrinttia ja valitaan niista
     * satunnaisesti yksi
     * <p>
     * Tosiaan labyrinteissa on aina kaytavaa ruudut, joissa x ja y kordinaatit ovat
     * parittomia. Naiden valissa olevia ruutuja lisataan mukaan tassa algoritmissa.
     *
     * @param   leveys   Labyrintin leveys
     * @param   korkeus   Labyrintin korkeus
     *
     * @return  Labyrintti, jos korkeus ja leveys on sopivat
     */
    public static char[][] luo(int leveys, int korkeus) {
        if ((leveys % 2 == 0) || (korkeus % 2 == 0) || (leveys < 5) || (korkeus < 5)) {
            return null;
        }

        char[][] labyrintti = new char[leveys][korkeus];
        for (int i = 0; i < leveys; ++i) {
            for (int j = 0; j < korkeus; ++j) {
                labyrintti[i][j] = '#';
            }
        }
        labyrintti[1][1] = 'l';
        labyrintti[leveys - 2][korkeus - 2] = 'm';
        labyrintti[leveys - 3][korkeus - 2] = '.';

        int[] ruudutX = new int[leveys * korkeus / 2];
        int[] ruudutY = new int[leveys * korkeus / 2];
        int[] kaytavaX = new int[leveys * korkeus / 2];
        int[] kaytavaY = new int[leveys * korkeus / 2];
        ruudutX[0] = 3;
        ruudutY[0] = 1;
        kaytavaX[0] = 2;
        kaytavaY[0] = 1;
        int koko = 1;
        while (koko > 0) {
            int indeksi = satunnainenNumero(koko);
            int x = ruudutX[indeksi];
            int y = ruudutY[indeksi];
            int kx = kaytavaX[indeksi];
            int ky = kaytavaY[indeksi];

            --koko;
            ruudutX[indeksi] = ruudutX[koko];
            ruudutY[indeksi] = ruudutY[koko];
            kaytavaX[indeksi] = kaytavaX[koko];
            kaytavaY[indeksi] = kaytavaY[koko];

            if (labyrintti[x][y] != '#') {
                continue;
            }

            labyrintti[x][y] = '.';
            labyrintti[kx][ky] = '.';
            if (x + 2 < leveys && labyrintti[x + 2][y] == '#') {
                ruudutX[koko] = x + 2;
                ruudutY[koko] = y;
                kaytavaX[koko] = x + 1;
                kaytavaY[koko] = y;
                ++koko;
            }
            if (y + 2 < korkeus && labyrintti[x][y + 2] == '#') {
                ruudutX[koko] = x;
                ruudutY[koko] = y + 2;
                kaytavaX[koko] = x;
                kaytavaY[koko] = y + 1;
                ++koko;
            }
            if (x - 2 > 0 && labyrintti[x - 2][y] == '#') {
                ruudutX[koko] = x - 2;
                ruudutY[koko] = y;
                kaytavaX[koko] = x - 1;
                kaytavaY[koko] = y;
                ++koko;
            }
            if (y - 2 > 0 && labyrintti[x][y - 2] == '#') {
                ruudutX[koko] = x;
                ruudutY[koko] = y - 2;
                kaytavaX[koko] = x;
                kaytavaY[koko] = y - 1;
                ++koko;
            }
        }
        return labyrintti;
    }

    private static int satunnainenNumero(int maksimi) {
        return (int) (System.nanoTime() % maksimi);
    }

}

