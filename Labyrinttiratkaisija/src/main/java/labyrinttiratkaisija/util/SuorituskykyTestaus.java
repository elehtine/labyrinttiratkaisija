package labyrinttiratkaisija.util;

import labyrinttiratkaisija.domain.Labyrintti;
import labyrinttiratkaisija.domain.LuontiSyvyyshaulla;
import labyrinttiratkaisija.domain.LuontiKruskalilla;
import labyrinttiratkaisija.domain.LuontiPrimilla;
import labyrinttiratkaisija.domain.RatkaisuLeveyshaulla;
import labyrinttiratkaisija.domain.RatkaisuSeinanSeuraus;

/**
 * Testaa toimiiko kaikki algoritmit tehokkaasti toivotun kokoisella syotteella
 */
public class SuorituskykyTestaus {

    private final int korkeus = 199;
    private final int leveys = 199;
    private final String[] luontiNimet = new String[] { "Kruskal", "Prim", "Syvyyshaku" };
    private final String[] ratkaisuNimet = new String[] { "Leveyshaku", "Seinan seuraaminen" };

    private boolean testattu;
    private long[] ajatLuonti;
    private long[][] ajatRatkaisu;

    public SuorituskykyTestaus() {
        testattu = false;
        ajatLuonti = new long[3];
        ajatRatkaisu = new long[3][2];
    }

    public void testaa() {
        testattu = true;

        long alku, loppu;

        Labyrintti[] labyrintit = new Labyrintti[3];

        for (int i = 0; i < 3; ++i) {
            alku = System.nanoTime();

            if (i == 0) {
                labyrintit[i] =  new Labyrintti(LuontiKruskalilla.luo(leveys, korkeus));
            } else if (i == 1) {
                labyrintit[i] = new Labyrintti(LuontiPrimilla.luo(leveys, korkeus));
            } else if (i == 2) {
                labyrintit[i] = new Labyrintti(LuontiSyvyyshaulla.luo(leveys, korkeus));
            }

            loppu = System.nanoTime();
            ajatLuonti[i] = loppu - alku;
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 2; ++j) {
                alku = System.nanoTime();

                if (j == 0) {
                    RatkaisuLeveyshaulla leveyshaku = new RatkaisuLeveyshaulla(labyrintit[i]);
                    leveyshaku.ratkaisu();
                } else if (j == 1) {
                    RatkaisuSeinanSeuraus seinanSeuraus = new RatkaisuSeinanSeuraus(labyrintit[i]);
                    seinanSeuraus.ratkaisu();
                }


                loppu = System.nanoTime();
                ajatRatkaisu[i][j] = loppu - alku;
            }
        }
    }

    @Override
    public String toString() {
        if (!testattu) {
            return "Testausta ei ole tehty";
        }

        String vastaus = "";
        vastaus += "Labyrinttien korkeus: \t " + korkeus + "\nLabyrinttien leveys: \t " + leveys + "\n\n";

        vastaus += "Luomiseen kulunut aika: \n";
        for (int i = 0; i < 3; ++i) {
            vastaus += luontiNimet[i] + "\t" + ajatLuonti[i] / 1e9 + "\n";
        }
        vastaus += "\n\n";

        vastaus += "Ratkaisemiseen kulunut aika: \n";
        for (int i = 0; i < 3; ++i) {
            vastaus += "\t" + luontiNimet[i];
        }
        vastaus += "\n"

        for (int i = 0; i < 2; ++i) {
            vastaus += ratkaisuNimet[i];
            for (int j = 0; j < 3; ++j) {
                vastaus += "\t" + ajatRatkaisu[j][i] / 1e9 + "\n";
            }
        }

        vastaus += "\n";
        return vastaus;
    }

    public static void main(String[] args) {
        SuorituskykyTestaus testaus = new SuorituskykyTestaus();
        testaus.testaa();
        System.out.println(testaus);
        testaus.testaa();
        System.out.println(testaus);
    }

}

