package labyrinttiratkaisija.domain;

import labyrinttiratkaisija.domain.Labyrintti;

/**
 * Ratkaisee labyrintin leveyshaulla
 */
public class RatkaisuLeveyshaulla {

    private Labyrintti labyrintti;
    private int leveys;
    private int korkeus;
    private int[] xLista;
    private int[] yLista;
    private int[] matka;
    private boolean[][] kaydyt;
    private String[][] suunnat;

    
    /**
     * Alustaa oliolle labyrintin ja tarvittavat muuttujat
     *
     * @param   labyrintti  Ratkaistava labyrintti
     */
    public RatkaisuLeveyshaulla(Labyrintti labyrintti) {
        this.labyrintti = labyrintti;
        this.leveys = labyrintti.getLeveys();
        this.korkeus = labyrintti.getKorkeus();
        this.xLista = new int[leveys * korkeus];
        this.yLista = new int[leveys * korkeus];
        this.matka = new int[leveys * korkeus];
        this.kaydyt = new boolean[leveys][korkeus];
        this.suunnat = new String[leveys][korkeus];
    }

    /**
     * Palauttaa ratkaisun olion labyrinttiin
     *
     * @return  Merkkijonomuodossa nopein reitti, esim. "ALAS ALAS OIKEA OIKEA YLOS YLOS"
     */
    public String ratkaisu() {
        int leveys = labyrintti.getLeveys();
        int korkeus = labyrintti.getKorkeus();

        xLista[0] = labyrintti.getLahtoX();
        yLista[0] = labyrintti.getLahtoY();
        matka[0] = 0;
        int seuraava = 0;
        int viimeinen = 1;
        while (true) {
            int x = xLista[seuraava];
            int y = yLista[seuraava];
            int d = matka[seuraava];
            seuraava++;
            if (x == 0 || y == 0) {
                return "";
            }
            if (kaydyt[x][y]) {
                continue;
            }
            kaydyt[x][y] = true;

            if (x == labyrintti.getMaaliX() && y == labyrintti.getMaaliY()) {
                return reitti(x, y);
            }

            if (labyrintti.onkoKaytava(x + 1, y) && !kaydyt[x + 1][y]) {
                suunnat[x + 1][y] = "OIKEA";
                xLista[viimeinen] = x + 1;
                yLista[viimeinen] = y;
                matka[viimeinen] = d + 1;
                viimeinen++;
            }
            if (labyrintti.onkoKaytava(x - 1, y) && !kaydyt[x - 1][y]) {
                suunnat[x - 1][y] = "VASEN";
                xLista[viimeinen] = x - 1;
                yLista[viimeinen] = y;
                matka[viimeinen] = d + 1;
                viimeinen++;
            }
            if (labyrintti.onkoKaytava(x, y + 1) && !kaydyt[x][y + 1]) {
                suunnat[x][y + 1] = "ALAS";
                xLista[viimeinen] = x;
                yLista[viimeinen] = y + 1;
                matka[viimeinen] = d + 1;
                viimeinen++;
            }
            if (labyrintti.onkoKaytava(x, y - 1) && !kaydyt[x][y - 1]) {
                suunnat[x][y - 1] = "YLOS";
                xLista[viimeinen] = x;
                yLista[viimeinen] = y - 1;
                matka[viimeinen] = d + 1;
                viimeinen++;
            }
        }
    }

    private String reitti(int x, int y) {
        String vastaus = "";
        while (true) {
            if (x == labyrintti.getLahtoX() && y == labyrintti.getLahtoY()) {
                return vastaus.trim();
            }
            vastaus = suunnat[x][y] + " " + vastaus;
            if (suunnat[x][y].equals("OIKEA")) {
                x--;
            } else if (suunnat[x][y].equals("ALAS")) {
                y--;
            } else if (suunnat[x][y].equals("VASEN")) {
                x++;
            } else if (suunnat[x][y].equals("YLOS")) {
                y++;
            }
        }
    }
}

