package labyrinttiratkaisija.ui;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;

import labyrinttiratkaisija.ui.RatkaisijaUi;

public class Reitti extends Rectangle {

    private AnimationTimer animationTimer;
    private String[] ohjeet;
    private int indeksi;

    public Reitti(String reitti) {
        String[] ohjeet = reitti.split(" ");
        setVisible(false);
        setWidth(RatkaisijaUi.SIZE);
        setHeight(RatkaisijaUi.SIZE);
        setArcWidth(RatkaisijaUi.SIZE);
        setArcHeight(RatkaisijaUi.SIZE);
        setFill(Color.ORANGE);

        animationTimer = new AnimationTimer() {
            private long edellinen;
            private long tauko;

            @Override
            public void start() {
                edellinen = System.nanoTime();
                tauko = 300000000;
                indeksi = 0;
                super.start();
            }

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < tauko) {
                    return;
                }
                if (indeksi >= ohjeet.length) {
                    indeksi = 0;
                    setTranslateX(0);
                    setTranslateY(0);
                }

                edellinen = nykyhetki;

                if (ohjeet[indeksi].equals("OIKEA")) {
                    setTranslateX(getTranslateX() + RatkaisijaUi.SIZE);
                } else if (ohjeet[indeksi].equals("ALAS")) {
                    setTranslateY(getTranslateY() + RatkaisijaUi.SIZE);
                } else if (ohjeet[indeksi].equals("VASEN")) {
                    setTranslateX(getTranslateX() - RatkaisijaUi.SIZE);
                } else if (ohjeet[indeksi].equals("YLOS")) {
                    setTranslateY(getTranslateY() - RatkaisijaUi.SIZE);
                }
                ++indeksi;
            }
        };
    }

    public void liiku() {
        setVisible(true);
        animationTimer.start();
    }

    public void pysahdy() {
        animationTimer.stop();
        setVisible(false);
    }
}

