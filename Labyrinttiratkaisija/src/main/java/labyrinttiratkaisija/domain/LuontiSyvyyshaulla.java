package labyrinttiratkaisija.domain;

/**
 * Luokka joka generoi labyrintin syvyyshaun avulla
 */
public class LuontiSyvyyshaulla {

    /**
     * Palauttaa syklittoman labyrintin joka on luotu syvyyshaulla
     * Labyrintin lahto sijaitsee koordinaateissa (1,1) ja maali (x-2,y-2)
     * Labyrinttia reunustaa seinama
     *
     * @param   x   Labyrintin leveys
     * @param   y   Labyrintin korkeus
     *
     * @return  Labyrintti, jos syvyys ja leveys on sopivat
     */
    public static char[][] luo(int x, int y) {
        if ((x % 2 == 0) || (y % 2 == 0) || (x < 5) || (y < 5)) {
            return null;
        }
        char[][] labyrintti = new char[x][y];
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                labyrintti[i][j] = '#';
            }
        }
        labyrintti[1][1] = 'l';
        labyrintti[2][1] = '.';
        labyrintti[x - 2][y - 2] = 'm';
        labyrintti[x - 3][y - 2] = '.';
        etene(labyrintti, 3, 1);
        return labyrintti;
    }

    private static void etene(char[][] labyrintti, int x, int y) {
        labyrintti[x][y] = '.';
        for (String suunta: suunnatSatunnaisessaJarjestyksessa()) {
            int i = 2;
            if (suunta.equals("VASEN") || suunta.equals("YLOS")) {
                i = -i;
            }
            if (suunta.equals("OIKEA") || suunta.equals("VASEN")) {
                if (x + i > 0 && x + i < labyrintti.length && labyrintti[x + i][y] == '#') {
                    labyrintti[x + i / 2][y] = '.';
                    etene(labyrintti, x + i, y);
                }
            }
            if (suunta.equals("ALAS") || suunta.equals("YLOS")) {
                if (y + i > 0 && y + i < labyrintti[0].length && labyrintti[x][y + i] == '#') {
                    labyrintti[x][y + i / 2] = '.';
                    etene(labyrintti, x, y + i);
                }
            }
        }
    }

    private static String[] suunnatSatunnaisessaJarjestyksessa() {
        String[] vastaus = "OIKEA ALAS VASEN YLOS".split(" ");
        for (int i = 0; i < 4; ++i) {
            int x = satunnainenNumero();
            String temp = vastaus[i];
            vastaus[i] = vastaus[x];
            vastaus[x] = temp;
        }
        return vastaus;
    }

    private static int satunnainenNumero() {
        return (int) (System.nanoTime() % 4L);
    }

}

