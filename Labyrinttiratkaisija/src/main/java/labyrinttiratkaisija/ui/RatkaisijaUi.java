package labyrinttiratkaisija.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
        GridPane ruudukko = new GridPane();

        char[][] kartta = LuontiKruskalilla.luo(19, 19);
        Labyrintti labyrintti = new Labyrintti(kartta);
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

        Scene nakyma = new Scene(ruudukko);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    /**
     * Metodi jota kaytetaan kayttoliittyman kaynnistamiseen
     */
    public static void main(String[] args) {
        launch(args);
    }

}

