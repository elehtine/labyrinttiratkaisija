package labyrinttiratkaisija.util;

import java.util.Scanner;
import java.nio.file.Paths;

public class Labyrintti {

    public static char[][] lueLabyrintti(String polku) {
        char[][] labyrintti = null;
        try (Scanner lukija = new Scanner(Paths.get(polku))) {
            int x = Integer.valueOf(lukija.nextLine());
            int y = Integer.valueOf(lukija.nextLine());

            labyrintti = new char[x][y];
            for (int j = 0; j < y; ++j) {
                String line = lukija.nextLine();
                for (int i = 0; i < x; ++i) {
                    labyrintti[i][j] = line.charAt(i);
                }
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
            return null;
        }

        return labyrintti;
    }

}
