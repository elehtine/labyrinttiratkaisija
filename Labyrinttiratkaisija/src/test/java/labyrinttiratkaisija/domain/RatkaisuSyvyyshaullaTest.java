package labyrinttiratkaisija.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import labyrinttiratkaisija.util.Tarkistaja;
import labyrinttiratkaisija.domain.Labyrintti;
import labyrinttiratkaisija.domain.RatkaisuSyvyyshaulla;

/**
 * Yksikkotesteja labyrintin ratkaisuntarkastaja luokalle
 */
public class RatkaisuSyvyyshaullaTest {
    /**
     * Yhden ruudun labyrintin ratkaisu
     */
    @Test
    public void yksiVasemmalle() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        RatkaisuSyvyyshaulla ratkaisuSyvyyshaulla = new RatkaisuSyvyyshaulla(labyrintti);
        String ratkaisu = ratkaisuSyvyyshaulla.ratkaisu();
        assertTrue(Tarkistaja.tarkista(ratkaisu, labyrintti));
    }

    /**
     * Lyhyen labyrintin ratkaisu
     */
    @Test
    public void lyhytLabyrintti() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiLyhyt.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        RatkaisuSyvyyshaulla ratkaisuSyvyyshaulla = new RatkaisuSyvyyshaulla(labyrintti);
        String ratkaisu = ratkaisuSyvyyshaulla.ratkaisu();
        assertTrue(Tarkistaja.tarkista(ratkaisu, labyrintti));
    }

    /**
     * Spiraalilabyrintin ratkaisu
     */
    @Test
    public void spiraaliLabyrintti() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiSpiraali.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        RatkaisuSyvyyshaulla ratkaisuSyvyyshaulla = new RatkaisuSyvyyshaulla(labyrintti);
        String ratkaisu = ratkaisuSyvyyshaulla.ratkaisu();
        assertTrue(Tarkistaja.tarkista(ratkaisu, labyrintti));
    }

    /**
     * Testilabyrintin ratkaisu
     */
    @Test
    public void testiLabyrintti() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrintti1.txt");
        assertFalse(kartta == null);
        Labyrintti labyrintti = new Labyrintti(kartta);
        RatkaisuSyvyyshaulla ratkaisuSyvyyshaulla = new RatkaisuSyvyyshaulla(labyrintti);
        String ratkaisu = ratkaisuSyvyyshaulla.ratkaisu();
        assertTrue(Tarkistaja.tarkista(ratkaisu, labyrintti));
    }

}

