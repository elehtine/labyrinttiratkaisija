package labyrinttiratkaisija.domain;

import labyrinttiratkaisija.domain.Labyrintti;
import labyrinttiratkaisija.util.StringRakentaja;

/**
 * Ratkaisee labyrintin seuraamalla oikean puoleista seinamaa
 */
public class RatkaisuSeinanSeuraus {

    private static final int OIKEA = 0;
    private static final int ALAS = 1;
    private static final int VASEN = 2;
    private static final int YLOS = 3;
    private static final String[] NOTAATIO = new String[] { "OIKEA", "ALAS", "VASEN", "YLOS" };

    private Labyrintti labyrintti;
    private int leveys;
    private int korkeus;
    private String[] suunnat;

    
    /**
     * Alustaa oliolle labyrintin ja tarvittavat muuttujat
     *
     * @param   labyrintti  Ratkaistava labyrintti
     */
    public RatkaisuSeinanSeuraus(Labyrintti labyrintti) {
        this.labyrintti = labyrintti;
        this.leveys = labyrintti.getLeveys();
        this.korkeus = labyrintti.getKorkeus();
        this.suunnat = new String[leveys * korkeus];
    }

    /**
     * Palauttaa ratkaisun olion labyrinttiin
     *
     * @return  Merkkijonomuodossa reitti joka seuraa koko ajan oikean puoleista seinamaa
     */
    public String ratkaisu() {
        int leveys = labyrintti.getLeveys();
        int korkeus = labyrintti.getKorkeus();

        StringRakentaja ratkaisu = new StringRakentaja();
        int xSijainti = labyrintti.getLahtoX();
        int ySijainti = labyrintti.getLahtoY();
        int suunta = OIKEA;
        while (true) {
            suunta++;
            for (int d = 0; d < 4; d++) {
                if (!voikoMenna(xSijainti, ySijainti, suunta - d)) {
                    continue;
                }
                suunta = suunta - d;
                if (suunta < 0) {
                    suunta += 4;
                } else if (suunta >= 4) {
                    suunta -= 4;
                }
                ratkaisu.lisaa(NOTAATIO[suunta] + " ");
                ratkaisu.lisaa(NOTAATIO[suunta] + " ");
                if (suunta == OIKEA) {
                    xSijainti += 2;
                } else if (suunta == ALAS) {
                    ySijainti += 2;
                } else if (suunta == VASEN) {
                    xSijainti -= 2;
                } else if (suunta == YLOS) {
                    ySijainti -= 2;
                }
                break;
            }

            if (xSijainti == labyrintti.getMaaliX() && ySijainti == labyrintti.getMaaliY()) {
                return ratkaisu.toString().trim();
            }
        }
    }

    private boolean voikoMenna(int x, int y, int suunta) {
        if (suunta < 0) {
            suunta += 4;
        } else if (suunta >= 4) {
            suunta -= 4;
        }
        if (suunta == OIKEA) {
            return labyrintti.onkoKaytava(x + 1, y);
        } else if (suunta == ALAS) {
            return labyrintti.onkoKaytava(x, y + 1);
        } else if (suunta == VASEN) {
            return labyrintti.onkoKaytava(x - 1, y);
        } else if (suunta == YLOS) {
            return labyrintti.onkoKaytava(x, y - 1);
        }
        return false;
    }

}

