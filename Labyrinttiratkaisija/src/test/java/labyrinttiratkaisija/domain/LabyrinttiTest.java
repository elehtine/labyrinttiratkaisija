package labyrinttiratkaisija.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.util.Scanner;
import java.nio.file.Paths;

import labyrinttiratkaisija.util.Tarkistaja;
import labyrinttiratkaisija.domain.Labyrintti;

/**
 * Yksikkotesteja labyrinttien tiedostosta lukevalle luokalle
 */
public class LabyrinttiTest {
    /**
     * Onnistuneesti lue labyrintti tiedostosta
     */
    @Test
    public void lueLabyrinttiTiedostosta() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertTrue(kartta != null);
    }

    /**
     * Epaonnistuneesti lue vaarassa formaatissa oleva labyrintti
     */
    @Test
    public void lueLabyrinttiVaarassaFormaatissa() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiVaaraFormaatti.txt");
        assertFalse(kartta != null);
    }

    /**
     * Epaonnistuneesti lue labyrintti tiedostosta jota ei ole
     */
    @Test
    public void lueLabyrinttiOlemattomastaTiedostosta() {
        char[][] kartta = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiEiOlemassa.txt");
        assertFalse(kartta != null);
    }
}

