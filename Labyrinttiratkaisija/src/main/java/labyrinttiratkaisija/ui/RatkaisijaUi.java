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

/**
 * Kayttoliittyman muodostava luokka joka tulee kaynnistamaan muun tarvittavan koodin
 */
public class RatkaisijaUi extends Application {

    /**
     * Kayttoliittyman nayttava metodi
     *
     * @param   ikkuna   Ikkuna jonka sisalle kayttoliittyma luodaan
     */
    @Override
    public void start(Stage ikkuna) {
        Button kruskal = new Button("Kruskalin algoritmi");
        Button syvyyshaku = new Button("Svyyshaku");
        Button takaisinLuomisesta = new Button("Takaisin");
        VBox luontiNapit = new VBox();
        luontiNapit.getChildren().add(new Label("Valitse algoritmi"));
        luontiNapit.getChildren().add(kruskal);
        luontiNapit.getChildren().add(syvyyshaku);
        luontiNapit.getChildren().add(takaisinLuomisesta);

        Scene luontiNakyma = new Scene(luontiNapit);

        char[][] kartta = LuontiKruskalilla.luo(19, 19);
        Labyrintti labyrintti = new Labyrintti(kartta);
        Scene labyrinttiNakyma = getLabyrinttiNakyma(labyrintti, luontiNakyma, ikkuna);

        kruskal.setOnAction((action) -> {
            Labyrintti l = new Labyrintti(LuontiKruskalilla.luo(19, 19));
            ikkuna.setScene(getLabyrinttiNakyma(l, luontiNakyma, ikkuna));
        });

        syvyyshaku.setOnAction((action) -> {
            Labyrintti l = new Labyrintti(LuontiSyvyyshaulla.luo(19, 19));
            ikkuna.setScene(getLabyrinttiNakyma(l, luontiNakyma, ikkuna));
        });

        takaisinLuomisesta.setOnAction((action) -> {
            ikkuna.setScene(labyrinttiNakyma);
        });

        ikkuna.setScene(labyrinttiNakyma);
        ikkuna.show();
    }

    private Scene getLabyrinttiNakyma(Labyrintti labyrintti, Scene luonti, Stage ikkuna) {
        GridPane ruudukko = new GridPane();
        if (labyrintti != null) {
            for (int i = 0; i < labyrintti.getLeveys(); ++i) {
                for (int j = 0; j < labyrintti.getKorkeus(); ++j) {
                    Rectangle ruutu = new Rectangle(30, 30);
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
            ikkuna.setScene(luonti);
        });
        return labyrinttiNakyma;
    }

    /**
     * Metodi jota kaytetaan kayttoliittyman kaynnistamiseen
     */
    public static void main(String[] args) {
        launch(args);
    }

}

