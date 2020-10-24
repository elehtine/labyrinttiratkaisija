package labyrinttiratkaisija.util;

public class StringRakentaja {

    private final int alkuKapasiteetti = 20;

    private char[] merkit;
    private int koko;
    private int kapasiteetti;


    public StringRakentaja() {
        kapasiteetti = alkuKapasiteetti;
        koko = 0;
        merkit = new char[kapasiteetti];
    }

    public void lisaa(String uusi) {
        char[] uusiMerkit = uusi.toCharArray();
        int uusiKoko = koko + uusiMerkit.length;
        tarkista(uusiKoko);
        for (int i = 0; i < uusiMerkit.length; ++i) {
            merkit[koko + i] = uusiMerkit[i];
        }
        koko = uusiKoko;
    }

    private void tarkista(int uusiKoko) {
        if (uusiKoko < kapasiteetti) {
            return;
        }
        kapasiteetti *= 2;

        char[] temp = merkit;
        merkit = new char[kapasiteetti];
        for (int i = 0; i < koko; ++i) {
            merkit[i] = temp[i];
        }
        tarkista(uusiKoko);
    }

    @Override
    public String toString() {
        char[] palautusMerkit = new char[koko];
        for (int i = 0; i < koko; ++i) {
            palautusMerkit[i] = merkit[i];
        }
        return String.valueOf(palautusMerkit);
    }
}

