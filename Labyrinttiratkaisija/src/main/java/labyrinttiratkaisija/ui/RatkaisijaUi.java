package labyrinttiratkaisija.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import labyrinttiratkaisija.domain.Labyrintti;
import labyrinttiratkaisija.domain.LuontiSyvyyshaulla;
import labyrinttiratkaisija.domain.LuontiKruskalilla;
import labyrinttiratkaisija.domain.RatkaisuLeveyshaulla;
import labyrinttiratkaisija.ui.Reitti;

/**
 * Kayttoliittyman muodostava luokka joka tulee kaynnistamaan muun tarvittavan koodin
 */
public class RatkaisijaUi extends Application {

    /**
     * Size of squares in the maze
     */
    public static final int SIZE = 30;

    Scene luontiNakyma;
    Scene ratkaisuNakyma;
    Labyrintti labyrintti;
    GridPane ruudukko;
    Stage ikkuna;
    Reitti reitti;

    /**
     * Kayttoliittyman nayttava metodi
     *
     * @param   ikkuna   Ikkuna jonka sisalle kayttoliittyma luodaan
     */
    @Override
    public void start(Stage ikkuna) {
        this.ikkuna = ikkuna;

        Button kruskal = new Button("Kruskalin algoritmi");
        Button syvyyshaku = new Button("Svyyshaku");
        Button takaisinLuomisesta = new Button("Takaisin");
        VBox luontiNapit = new VBox();
        luontiNapit.getChildren().add(new Label("Valitse luontialgoritmi"));
        luontiNapit.getChildren().add(kruskal);
        luontiNapit.getChildren().add(syvyyshaku);
        luontiNapit.getChildren().add(takaisinLuomisesta);

        luontiNakyma = new Scene(luontiNapit);


        Button leveyshaku = new Button("Nopein reitti leveyshaulla");
        Button seinanSeuraaminen = new Button("Reitti oikeaa seinää seuraamalla");
        Button takaisinRatkaisemisesta = new Button("Takaisin");
        VBox ratkaisuNapit = new VBox();
        ratkaisuNapit.getChildren().add(new Label("Valitse ratkaisualgoritmi"));
        ratkaisuNapit.getChildren().add(leveyshaku);
        ratkaisuNapit.getChildren().add(seinanSeuraaminen);
        ratkaisuNapit.getChildren().add(takaisinRatkaisemisesta);

        ratkaisuNakyma = new Scene(ratkaisuNapit);


        kruskal.setOnAction((action) -> {
            Labyrintti labyrintti = new Labyrintti(LuontiKruskalilla.luo(19, 19));
            paivita(labyrintti);
            pysaytaReitti();
        });

        syvyyshaku.setOnAction((action) -> {
            Labyrintti labyrintti = new Labyrintti(LuontiSyvyyshaulla.luo(19, 19));
            paivita(labyrintti);
            pysaytaReitti();
        });

        takaisinLuomisesta.setOnAction((action) -> {
            paivita(labyrintti);
        });


        leveyshaku.setOnAction((action) -> {
            pysaytaReitti();
            paivita(labyrintti);
            RatkaisuLeveyshaulla ratkaisija = new RatkaisuLeveyshaulla(labyrintti);
            String ohjeet = ratkaisija.ratkaisu();
            naytaRatkaisu(ohjeet);
        });

        takaisinRatkaisemisesta.setOnAction((action) -> {
            pysaytaReitti();
            paivita(labyrintti);
        });


        char[][] kartta = LuontiKruskalilla.luo(19, 19);
        labyrintti = new Labyrintti(kartta);
        paivita(labyrintti);


        ikkuna.show();
    }

    private void paivita(Labyrintti labyrintti) {
        this.labyrintti = labyrintti;
        getRuudukko(labyrintti);

        Button luo = new Button("Luo uusi labyrintti");
        Button ratkaise = new Button("Ratkaise labyrintti");
        VBox labyrinttiNapit = new VBox();
        labyrinttiNapit.getChildren().add(luo);
        labyrinttiNapit.getChildren().add(ratkaise);

        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(ruudukko);
        asettelu.setRight(labyrinttiNapit);
        Scene labyrinttiNakyma = new Scene(asettelu);

        luo.setOnAction((action) -> {
            ikkuna.setScene(luontiNakyma);
        });

        ratkaise.setOnAction((action) -> {
            ikkuna.setScene(ratkaisuNakyma);
        });

        ikkuna.setScene(labyrinttiNakyma);
    }

    private void naytaRatkaisu(String ohjeet) {
        reitti = new Reitti(ohjeet);
        ruudukko.add(reitti, 1, 1);
        reitti.liiku();
    }

    private void pysaytaReitti() {
        if (reitti != null) {
            reitti.pysahdy();
        }
    }

    private void getRuudukko(Labyrintti labyrintti) {
        ruudukko = new GridPane();
        if (labyrintti != null) {
            for (int i = 0; i < labyrintti.getLeveys(); ++i) {
                for (int j = 0; j < labyrintti.getKorkeus(); ++j) {
                    Rectangle ruutu = new Rectangle(SIZE, SIZE);
                    if (i == labyrintti.getLahtoX() && j == labyrintti.getLahtoY()) {
                        ruutu.setFill(Color.RED);
                    } else if (i == labyrintti.getMaaliX() && j == labyrintti.getMaaliY()) {
                        ruutu.setFill(Color.GREEN);
                    } else if (labyrintti.onkoKaytava(i, j)) {
                        ruutu.setFill(Color.GRAY);
                    }
                    ruudukko.add(ruutu, i, j);
                }
            }
        }
    }

    /**
     * Metodi jota kaytetaan kayttoliittyman kaynnistamiseen
     */
    public static void main(String[] args) {
        launch(args);
    }

}

