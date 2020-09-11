package labyrinttiratkaisija.util;

import labyrinttiratkaisija.domain.Labyrintti;

/**
 * Luokka joka tarkistaa onko ratkaisu oikein
 * Sisaltaa vakiomuuttujat jokaiselle neljalle suunnalle
 */
public class Tarkistaja {

    public static final String OIKEA = "OIKEA";
    public static final String ALAS = "ALAS";
    public static final String VASEN = "VASEN";
    public static final String YLOS = "YLOS";

    /**
     * Kertoo onko labyrintti ratkaistu oikein
     *
     * @param   reitti  Labyrintissa kuljettu reitti, esim. "ALAS ALAS OIKEA OIKEA YLOS YLOS"
     * @param   labyrintti  Kuvaa labyrintin, '.' on kaytavaa, '#' on seinaa, l-kirjain on lahto ja m-kirjain on maali
     *
     * @return  Palauttaa paattyyko reitti maaliin
     */
    public static boolean tarkista(String reitti, Labyrintti labyrintti) {
        if (labyrintti == null) {
            return false;
        }

        int sijaintiX = labyrintti.getLahtoX();
        int sijaintiY = labyrintti.getLahtoY();
        for (String komento: reitti.split(" ")) {
            if (!labyrintti.onkoKaytava(sijaintiX, sijaintiY)) {
                return false;
            }
            if (komento.equals(OIKEA)) {
                ++sijaintiX;
            }
            if (komento.equals(ALAS)) {
                ++sijaintiY;
            }
            if (komento.equals(VASEN)) {
                --sijaintiX;
            }
            if (komento.equals(YLOS)) {
                --sijaintiY;
            }
        }
        if (sijaintiX == labyrintti.getMaaliX() && sijaintiY == labyrintti.getMaaliY()) {
            return true;
        }
        return false;
    }

}

