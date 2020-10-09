package labyrinttiratkaisija.ui;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Color;
import javafx.animation.AnimationTimer

import labyrinttiratkaisija.RatkaisijaUI.SIZE;

public class Reitti extends Rectangle {

    private AnimationTimer animationTimer;
    private String[] ohjeet;
    private int indeksi;

    public Reitti(String reitt) {
        ohjeet = reitti.split();
        setVisible(false);
        setFill(Color.ORANGE);

        animationTimer = new AnimationTimer() {
            private long edellinen;
            private long tauko;

            @Override
            public void start() {
                lastUpdate = System.nanoTime();
                tauko = 1000000;
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
                }

                if (ohjeet[indeksi].equals("OIKEA")) {
                    setTranslateX(SIZE);
                } else if (ohjeet[indeksi].equals("ALAS")) {
                    setTranslateY(SIZE);
                } else if (ohjeet[indeksi].equals("VASEN")) {
                    setTranslateX(-SIZE);
                } else if (ohjeet[indeksi].equals("YLOS")) {
                    setTranslateY(-SIZE);
                }
            };
    }

    public void liiku() {
        setVisible(true);
        animationTimer.start();
    }

    public pysahdy() {
        animationTimer.stop();
        setVisible(false);
    }
}

