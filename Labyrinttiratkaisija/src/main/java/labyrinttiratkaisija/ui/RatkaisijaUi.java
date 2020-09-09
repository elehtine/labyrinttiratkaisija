package labyrinttiratkaisija.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import labyrinttiratkaisija.util.Labyrintti;

public class RatkaisijaUi extends Application {

    @Override
    public void start(Stage ikkuna) {
        GridPane ruudukko = new GridPane();
        
        char[][] labyrintti = Labyrintti.lueLabyrintti("src/main/resources/labyrintti1.txt");
        if (labyrintti != null) {
            for (int i = 0; i < labyrintti.length; ++i) {
                for (int j = 0; j < labyrintti[0].length; ++j) {
                    Rectangle ruutu = new Rectangle(30, 30);
                    if (labyrintti[i][j] == '.') {
                        ruutu.setFill(Color.GRAY);
                    } else if (labyrintti[i][j] == '#') {
                        ruutu.setFill(Color.BLACK);
                    } else if (labyrintti[i][j] == 'l') {
                        ruutu.setFill(Color.RED);
                    } else if (labyrintti[i][j] == 'm') {
                        ruutu.setFill(Color.GREEN);
                    }
                    ruudukko.add(ruutu, i, j);
                }
            }
        }

        Scene nakyma = new Scene(ruudukko);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
