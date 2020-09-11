package labyrinttiratkaisija.domain;

import java.util.Scanner;
import java.nio.file.Paths;

/**
 * Luokka joka lukee labyrintteja tiedostoista
 */
public class Labyrintti {

    private int lahtoX;
    private int lahtoY;
    private int maaliX;
    private int maaliY;

    private int leveys;
    private int korkeus;

    boolean[][] labyrintti;

    /**
     * Labyrintin konstruktori johon annetaan labyrintin merkkijonomuotoinen kartta parametrina
     *
     * @param  kartta Kaksiulotteinen lista merkeista jotka kertovat milta labyrintti nayttaa
     */
    public Labyrintti(char[][] kartta) {
        leveys = kartta.length;
        korkeus = kartta[0].length;
        labyrintti = new boolean[leveys][korkeus];
        for (int i = 0; i < leveys; ++i) {
            for (int j = 0; j < korkeus; ++j) {
                if (kartta[i][j] == '#') {
                    labyrintti[i][j] = false;
                } else if (kartta[i][j] == 'l') {
                    labyrintti[i][j] = true;
                    lahtoX = i;
                    lahtoY = j;
                } else if (kartta[i][j] == 'm') {
                    labyrintti[i][j] = true;
                    maaliX = i;
                    maaliY = j;
                } else if (kartta[i][j] == '.') {
                    labyrintti[i][j] = true;
                }
            }
        }
    }

    /**
     * Palauttaa labyrintin lahdon x-koordinaatin
     *
     * @return  Labyrintin lahdon x-koordinaatti
     */
    public int getLahtoX() {
        return lahtoX;
    }

    /**
     * Palauttaa labyrintin lahdon y-koordinaatin
     *
     * @return  Labyrintin lahdon y-koordinaatti
     */
    public int getLahtoY() {
        return lahtoY;
    }

    /**
     * Palauttaa labyrintin maalin x-koordinaatin
     *
     * @return  Labyrintin maalin x-koordinaatti
     */
    public int getMaaliX() {
        return maaliX;
    }

    /**
     * Palauttaa labyrintin maalin y-koordinaatin
     *
     * @return  Labyrintin maalin y-koordinaatti
     */
    public int getMaaliY() {
        return maaliY;
    }

    /**
     * Palauttaa labyrintin leveyden
     *
     * @return  Labyrintin leveys
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     * Palauttaa labyrintin korkeuden
     *
     * @return  Labyrintin korkeus
     */
    public int getKorkeus() {
        return korkeus;
    }


    /**
     * Kertoo onko labyrintissa kyseisessa ruudussa kaytavaa vai seinamaa
     *
     * @param   x   Labyrintin ruudun x-koordinaatti
     * @param   y   Labyrintin ruudun y-koordinaatti
     *
     * @return  Totuusarvo joka on true kun ruutu on kaytavaa, false kun seinamaa
     */
    public boolean onkoKaytava(int x, int y) {
        return labyrintti[x][y];
    }


    /**
     * toString metodi labyrintille koodin korjaukseen kaytettavan tulostuksen helpottamiseen
     *
     * @return  Palauttaa labyrintin merkkijonona
     */
    @Override
    public String toString() {
        String vastaus = "";
        for (int i = 0; i < korkeus; ++i) {
            for (int j = 0; j < leveys; ++j) {
                if (i == lahtoY && j == lahtoX) {
                    vastaus += "l";
                } else if (i == maaliY && j == maaliX) {
                    vastaus += "m";
                } else if (labyrintti[j][i]) {
                    vastaus += ".";
                } else {
                    vastaus += "#";
                }
            }
            vastaus += "\n";
        }
        return vastaus;
    }

    /**
     * Metodille annetaan polku ja se palauttaa tiedostossa olevan labyrintin
     *
     * @param   polku   Labyrinttitiedoston polku
     *
     * @return  Palauttaa labyrintin jos tiedosto on oikea, muuten palauttaa null
     */
    public static char[][] lueLabyrintti(String polku) {
        char[][] labyrintti = null;
        try (Scanner lukija = new Scanner(Paths.get(polku))) {
            int x = Integer.valueOf(lukija.nextLine());
            int y = Integer.valueOf(lukija.nextLine());
            boolean lahtoLoytynyt = false;
            boolean maaliLoytynyt = false;

            labyrintti = new char[x][y];
            for (int j = 0; j < y; ++j) {
                String line = lukija.nextLine();
                for (int i = 0; i < x; ++i) {
                    labyrintti[i][j] = line.charAt(i);
                    if (labyrintti[i][j] == 'l') {
                        if (lahtoLoytynyt) {
                            return null;
                        }
                        lahtoLoytynyt = true;
                    }
                    if (labyrintti[i][j] == 'm') {
                        if (maaliLoytynyt) {
                            return null;
                        }
                        maaliLoytynyt = true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
            return null;
        }

        return labyrintti;
    }

}
