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
     * Testaa yhden ruudun liikkumista vasemmalle lahdosta maaliin
     */
    @Test
    public void yksiVasemmalle() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertFalse(labyrintti == null);
        assertTrue(Ratkaisija.ratkaise("VASEN", labyrintti));
    }

    /**
     * Testaa yhden ruudun liikkumista oikealle lahdosta kun maali olisikin vasemmalla
     */
    @Test
    public void yksiVasemmalleEpaonnistuu() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertFalse(labyrintti == null);
        assertFalse(Ratkaisija.ratkaise("OIKEA", labyrintti));
    }
}

