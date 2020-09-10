package labyrinttiratkaisija.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.Scanner;
import java.nio.file.Paths;

import labyrinttiratkaisija.util.Ratkaisija;
import labyrinttiratkaisija.util.Labyrintti;

public class RatkaisijaTest {
    /**
     * Yhden ruudun liikkumista vasemmalle lahdosta maaliin
     */
    @Test
    public void yksiVasemmalle() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertFalse(labyrintti == null);
        assertTrue(Ratkaisija.ratkaise("VASEN", labyrintti));
    }

    /**
     * Yhden ruudun liikkumista oikealle lahdosta kun maali olisikin vasemmalla
     */
    @Test
    public void yksiVasemmalleEpaonnistuu() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertFalse(labyrintti == null);
        assertFalse(Ratkaisija.ratkaise("OIKEA", labyrintti));
    }

    /**
     * Lyhyen labyrintin ratkaisu oikein
     */
    @Test
    public void lyhytLabyrintti() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiLyhyt.txt");
        assertFalse(labyrintti == null);
        assertTrue(Ratkaisija.ratkaise("OIKEA OIKEA ALAS ALAS VASEN VASEN", labyrintti));
    }

    /**
     * Lyhyessa labyrintissa liikkumista mutta ei maaliin asti
     */
    @Test
    public void lyhytLabyrinttiEiMaaliin() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiLyhyt.txt");
        assertFalse(labyrintti == null);
        assertFalse(Ratkaisija.ratkaise("OIKEA OIKEA ALAS", labyrintti));
    }

    /**
     * Lyhyessa labyrintissa liikkuminen seinan lapi
     */
    @Test
    public void lyhytLabyrinttiSeinanLapi() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiLyhyt.txt");
        assertFalse(labyrintti == null);
        assertFalse(Ratkaisija.ratkaise("ALAS ALAS", labyrintti));
    }

    /**
     * Spiraalilabyrintin ratkaisu
     */
    @Test
    public void spiraaliLabyrintti() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiSpiraali.txt");
        assertFalse(labyrintti == null);
        assertTrue(Ratkaisija.ratkaise(
                    "OIKEA OIKEA OIKEA OIKEA ALAS ALAS ALAS ALAS VASEN VASEN VASEN VASEN YLOS YLOS OIKEA OIKEA",
                    labyrintti));
    }

    /**
     * Olemattoman labyrintin ratkaisu palauttaa false
     */
    @Test
    public void olematonLabyrinttiEpaonnistuu() {
        assertFalse(Ratkaisija.ratkaise("OIKEA ALAS OIKEA YLOS", null));
    }
}

