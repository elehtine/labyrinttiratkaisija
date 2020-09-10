package labyrinttiratkaisija.util;

public class Ratkaisija {

    public static final String OIKEA = "OIKEA";
    public static final String ALAS = "ALAS";
    public static final String VASEN = "VASEN";
    public static final String YLOS = "YLOS";

    public static boolean ratkaise(String reitti, char[][] labyrintti) {
        if (labyrintti == null) {
            return false;
        }
        int lahtoX = -1;
        int lahtoY = -1;
        int maaliX = -1;
        int maaliY = -1;
        for (int i = 0; i < labyrintti.length; ++i) {
            for (int j = 0; j < labyrintti[0].length; ++j) {
                if (labyrintti[i][j] == 'l') {
                    if (lahtoX != -1 || lahtoY != -1) {
                        return false;
                    }
                    lahtoX = i;
                    lahtoY = j;
                }
                if (labyrintti[i][j] == 'm') {
                    if (maaliX != -1 || maaliY != -1) {
                        return false;
                    }
                    maaliX = i;
                    maaliY = j;
                }
            }
        }
        if (lahtoX == -1 || lahtoY == -1 || maaliX == -1 || maaliY == -1) return false;

        int sijaintiX = lahtoX;
        int sijaintiY = lahtoY;
        for (String komento: reitti.split(" ")) {
            if (labyrintti[sijaintiX][sijaintiY] == '#') {
                return false;
            }
            if (komento.equals(OIKEA)) {
                ++sijaintiX;
            }
            if (komento.equals(ALAS)) {
                ++sijaintiY;
            }
            if (komento.equals(VASEN)) {
                --sijaintiX;
            }
            if (komento.equals(YLOS)) {
                --sijaintiY;
            }
        }
        if (sijaintiX == maaliX && sijaintiY == maaliY) return true;
        return false;
    }

}

