package labyrinttiratkaisija.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import labyrinttiratkaisija.domain.LuontiSyvyyshaulla;

/**
 * Yksikkotesteja labyrintin syvyyshaulla luomisen toteuttavalle luokalle
 */
public class LuontiSyvyyshaullaTest {

    /**
     * Ei muodosta parillisen levyista labyrinttia
     */
    @Test
    public void eiParillisenLevea() {
        int x = 11;
        int y = 8;
        char[][] labyrintti = LuontiSyvyyshaulla.luo(x, y);
        assertTrue(labyrintti == null);
    }
    
    /**
     * Ei muodosta parillisen korkuista labyrinttia
     */
    @Test
    public void eiParillisenKorkea() {
        int x = 10;
        int y = 9;
        char[][] labyrintti = LuontiSyvyyshaulla.luo(x, y);
        assertTrue(labyrintti == null);
    }

    /**
     * Palauttaa oikean kokoisen labyrintin kun leveys on suurempi kuin korkeus
     */
    @Test
    public void oikeaKokoLevea() {
        int x = 11;
        int y = 9;
        char[][] labyrintti = LuontiSyvyyshaulla.luo(x, y);
        assertFalse(labyrintti == null);
        assertTrue(labyrintti.length == x);
        assertTrue(labyrintti[0].length == y);
    }

    /**
     * Palauttaa oikean kokoisen labyrintin kun leveys on pienempi kuin korkeus
     */
    @Test
    public void oikeaKokoKapea() {
        int x = 9;
        int y = 11;
        char[][] labyrintti = LuontiSyvyyshaulla.luo(x, y);
        assertFalse(labyrintti == null);
        assertTrue(labyrintti.length == x);
        assertTrue(labyrintti[0].length == y);
    }

    /**
     * Ei muodosta liian kapeata labyrinttia
     */
    @Test
    public void eiLuoLiianKapeaa() {
        int x = 3;
        int y = 9;
        char[][] labyrintti = LuontiSyvyyshaulla.luo(x, y);
        assertTrue(labyrintti == null);
    }

    /**
     * Ei muodosta liian matalaa labyrinttia
     */
    @Test
    public void eiLuoLiianMatalaa() {
        int x = 11;
        int y = 3;
        char[][] labyrintti = LuontiSyvyyshaulla.luo(x, y);
        assertTrue(labyrintti == null);
    }

    /**
     * Labyrintin reuna on seinamaa
     */
    @Test
    public void reunaOnSeinamaa() {
        int x = 11;
        int y = 9;
        char[][] labyrintti = LuontiSyvyyshaulla.luo(x, y);
        assertFalse(labyrintti == null);
        assertTrue(labyrintti.length == x);
        assertTrue(labyrintti[0].length == y);
        for (int i = 0; i < x; ++i) {
            assertTrue(labyrintti[i][0] == '#');
            assertTrue(labyrintti[i][y-1] == '#');
        }
        for (int i = 0; i < y; ++i) {
            assertTrue(labyrintti[0][i] == '#');
            assertTrue(labyrintti[x-1][i] == '#');
        }
    }

    /**
     * Labyrintin lahto on oikeassa alakulmassa
     */
    @Test
    public void lahtoOletuskohdassa() {
        int x = 11;
        int y = 9;
        char[][] labyrintti = LuontiSyvyyshaulla.luo(x, y);
        assertFalse(labyrintti == null);
        assertTrue(labyrintti[1][1] == 'l');
    }

    /**
     * Labyrintin maali on oikeassa alakulmassa
     */
    @Test
    public void maaliOletuskohdassa() {
        int x = 11;
        int y = 9;
        char[][] labyrintti = LuontiSyvyyshaulla.luo(x, y);
        assertFalse(labyrintti == null);
        assertTrue(labyrintti[x-2][y-2] == 'm');
    }

}

