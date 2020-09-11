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
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiTestiVasen.txt");
        assertTrue(labyrintti != null);
    }

    /**
     * Epaonnistuneesti lue vaarassa formaatissa oleva labyrintti
     */
    @Test
    public void lueLabyrinttiVaarassaFormaatissa() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiVaaraFormaatti.txt");
        assertFalse(labyrintti != null);
    }

    /**
     * Epaonnistuneesti lue labyrintti tiedostosta jota ei ole
     */
    @Test
    public void lueLabyrinttiOlemattomastaTiedostosta() {
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrinttiEiOlemassa.txt");
        assertFalse(labyrintti != null);
    }
}

