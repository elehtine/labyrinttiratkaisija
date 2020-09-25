package labyrinttiratkaisija.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import labyrinttiratkaisija.util.Tarkistaja;
import labyrinttiratkaisija.domain.Labyrintti;
import labyrinttiratkaisija.domain.RatkaisuSeinanSeuraus;

/**
 * Yksikkotesteja labyrintin ratkaisemiselle oikeanpuoleista seinaa seuraamalla
 */
public class RatkaisuSeinanSeurausTest {

    /**
     * Lyhyen labyrintin ratkaisu
     */
    @Test
    public void lyhytLabyrintti() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiLyhyt.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        RatkaisuSeinanSeuraus ratkaisuSyvyyshaulla = new RatkaisuSeinanSeuraus(labyrintti);
        String ratkaisu = ratkaisuSyvyyshaulla.ratkaisu();
        assertEquals("OIKEA OIKEA ALAS ALAS VASEN VASEN", ratkaisu);
    }

    /**
     * Spiraalilabyrintin ratkaisu
     */
    @Test
    public void spiraaliLabyrintti() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiSpiraali.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        RatkaisuSeinanSeuraus ratkaisuSyvyyshaulla = new RatkaisuSeinanSeuraus(labyrintti);
        String ratkaisu = ratkaisuSyvyyshaulla.ratkaisu();
        assertEquals("OIKEA OIKEA OIKEA OIKEA ALAS ALAS ALAS ALAS VASEN VASEN VASEN VASEN YLOS YLOS OIKEA OIKEA", ratkaisu);
    }

    /**
     * Testilabyrintin ratkaisu
     */
    @Test
    public void testiLabyrintti() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrintti1.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        RatkaisuSeinanSeuraus ratkaisuSyvyyshaulla = new RatkaisuSeinanSeuraus(labyrintti);
        String ratkaisu = ratkaisuSyvyyshaulla.ratkaisu();
        assertEquals(
                "ALAS ALAS ALAS ALAS YLOS YLOS OIKEA OIKEA ALAS ALAS ALAS ALAS VASEN VASEN OIKEA OIKEA OIKEA OIKEA OIKEA OIKEA",
                ratkaisu);
    }

}

