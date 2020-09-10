package labyrinttiratkaisija.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import labyrinttiratkaisija.util.Ratkaisija;
import labyrinttiratkaisija.util.Labyrintti;

/**
 * Yksikkotesteja labyrintin ratkaisuntarkastaja luokalle
 */
public class RatkaisijaTest {
    /**
     * Yhden ruudun liikkuminenvasemmalle lahdosta maaliin
     */
    @Test
    public void yksiVasemmalle() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertFalse(labyrintti == null);
        assertTrue(Ratkaisija.ratkaise("VASEN", labyrintti));
    }

    /**
     * Yhden ruudun liikkuminen oikealle lahdosta kun maali olisikin vasemmalla
     */
    @Test
    public void yksiVasemmalleEpaonnistuu() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertFalse(labyrintti == null);
        assertFalse(Ratkaisija.ratkaise("OIKEA", labyrintti));
    }

    /**
     * Lyhyen labyrintin ratkaiseminen oikein
     */
    @Test
    public void lyhytLabyrintti() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiLyhyt.txt");
        assertFalse(labyrintti == null);
        assertTrue(Ratkaisija.ratkaise("OIKEA OIKEA ALAS ALAS VASEN VASEN", labyrintti));
    }

    /**
     * Lyhyessa labyrintissa liikkuminen mutta ei maaliin asti
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
     * Spiraalilabyrintin ratkaiseminen
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
     * Olemattoman labyrintin ratkaiseminen palauttaa false
     */
    @Test
    public void olematonLabyrinttiEpaonnistuu() {
        assertFalse(Ratkaisija.ratkaise("OIKEA ALAS OIKEA YLOS", null));
    }

    /**
     * Liikkuminen labyrintissa jossa ei ole maalia
     */
    @Test
    public void labyrinttiEiMaalia() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiEiMaalia.txt");
        assertFalse(labyrintti == null);
        assertFalse(Ratkaisija.ratkaise("VASEN", labyrintti));
    }

    /**
     * Labyrintti jossa on 2 lahtoa
     */
    @Test
    public void labyrinttiKaksiLahtoa() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiKaksiLahtoa.txt");
        assertFalse(labyrintti == null);
        assertFalse(Ratkaisija.ratkaise("OIKEA", labyrintti));
    }

    /**
     * Labyrintti jossa no 2 maalia
     */
    @Test
    public void labyrinttiKaksiMaalia() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiKaksiMaalia.txt");
        assertFalse(labyrintti == null);
        assertFalse(Ratkaisija.ratkaise("OIKEA", labyrintti));
    }

}

