package labyrinttiratkaisija.ui;

import java.util.Scanner;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RatkaisijaUi extends Application {

    @Override
    public void start(Stage ikkuna) {
        GridPane ruudukko = new GridPane();

        try (Scanner lukija = new Scanner(Paths.get("src/main/resources/labyrintti1.txt"))) {
            int x = Integer.valueOf(lukija.nextLine());
            int y = Integer.valueOf(lukija.nextLine());

            char[][] labyrintti = new char[x][y];
            for (int j = 0; j < y; ++j) {
                String line = lukija.nextLine();
                for (int i = 0; i < x; ++i) {
                    labyrintti[i][j] = line.charAt(i);
                }
            }

            for (int i = 0; i < x; ++i) {
                for (int j = 0; j < y; ++j) {
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
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        Scene nakyma = new Scene(ruudukko);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

