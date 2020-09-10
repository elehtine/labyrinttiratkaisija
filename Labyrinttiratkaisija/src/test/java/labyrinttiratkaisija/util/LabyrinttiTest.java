package labyrinttiratkaisija.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.util.Scanner;
import java.nio.file.Paths;

import labyrinttiratkaisija.util.Ratkaisija;
import labyrinttiratkaisija.util.Labyrintti;

public class LabyrinttiTest {
    /**
     * Lue onnistuneesti labyrintti tiedostosta
     */
    @Test
    public void lueLabyrinttiTiedostosta() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertTrue(labyrintti != null);
    }

    /**
     * Lue epaonnistuneesti vaarassa formaatissa oleva labyrintti
     */
    @Test
    public void lueLabyrinttiVaarassaFormaatissa() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiVaaraFormaatti.txt");
        assertFalse(labyrintti != null);
    }

    /**
     * Lue epaonnistuneesti labyrintti tiedostosta jota ei ole
     */
    @Test
    public void lueLabyrinttiOlemattomastaTiedostosta() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiEiOlemassa.txt");
        assertFalse(labyrintti != null);
    }
}

