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
        labyrintti[1][1] = 'l';
        labyrintti[x - 2][y - 2] = 'm';
        for (int i = 0; i < x; ++i) {
            labyrintti[i][0] = '#';
            labyrintti[i][y - 1] = '#';
        }
        for (int i = 0; i < y; ++i) {
            labyrintti[0][i] = '#';
            labyrintti[x - 1][i] = '#';
        }
        return labyrintti;
    }

}

