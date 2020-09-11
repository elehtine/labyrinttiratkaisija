package labyrinttiratkaisija.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import labyrinttiratkaisija.util.Tarkistaja;
import labyrinttiratkaisija.domain.Labyrintti;

/**
 * Yksikkotesteja labyrintin ratkaisuntarkastaja luokalle
 */
public class TarkistajaTest {
    /**
     * Yhden ruudun liikkuminenvasemmalle lahdosta maaliin
     */
    @Test
    public void yksiVasemmalle() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        assertTrue(Tarkistaja.tarkista("VASEN", labyrintti));
    }

    /**
     * Yhden ruudun liikkuminen oikealle lahdosta kun maali olisikin vasemmalla
     */
    @Test
    public void yksiVasemmalleEpaonnistuu() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        assertFalse(Tarkistaja.tarkista("OIKEA", labyrintti));
    }

    /**
     * Lyhyen labyrintin ratkaiseminen oikein
     */
    @Test
    public void lyhytLabyrintti() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiLyhyt.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        assertTrue(Tarkistaja.tarkista("OIKEA OIKEA ALAS ALAS VASEN VASEN", labyrintti));
    }

    /**
     * Lyhyessa labyrintissa liikkuminen mutta ei maaliin asti
     */
    @Test
    public void lyhytLabyrinttiEiMaaliin() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiLyhyt.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        assertFalse(Tarkistaja.tarkista("OIKEA OIKEA ALAS", labyrintti));
    }

    /**
     * Lyhyessa labyrintissa liikkuminen seinan lapi
     */
    @Test
    public void lyhytLabyrinttiSeinanLapi() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiLyhyt.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        assertFalse(Tarkistaja.tarkista("ALAS ALAS", labyrintti));
    }

    /**
     * Spiraalilabyrintin ratkaiseminen
     */
    @Test
    public void spiraaliLabyrintti() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiSpiraali.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        assertTrue(Tarkistaja.tarkista(
                    "OIKEA OIKEA OIKEA OIKEA ALAS ALAS ALAS ALAS VASEN VASEN VASEN VASEN YLOS YLOS OIKEA OIKEA",
                    labyrintti));
    }

    /**
     * Olemattoman labyrintin ratkaiseminen palauttaa false
     */
    @Test
    public void olematonLabyrinttiEpaonnistuu() {
        assertFalse(Tarkistaja.tarkista("OIKEA ALAS OIKEA YLOS", null));
    }

    /**
     * Liikkuminen labyrintissa jossa ei ole maalia
     */
    @Test
    public void labyrinttiEiMaalia() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiEiMaalia.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        assertFalse(Tarkistaja.tarkista("VASEN", labyrintti));
    }

    /**
     * Labyrintti jossa on 2 lahtoa
     */
    @Test
    public void labyrinttiKaksiLahtoa() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiKaksiLahtoa.txt");
        assertTrue(kartta == null);
    }

    /**
     * Labyrintti jossa no 2 maalia
     */
    @Test
    public void labyrinttiKaksiMaalia() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiKaksiMaalia.txt");
        assertTrue(kartta == null);
    }

}

