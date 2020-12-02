package fact.it.supermarktproject.model;
//Vermeld hier je naam en studentennummer
// Van Eynde Michiel r0794174

import java.util.ArrayList;

public class Klant extends Persoon {
    private ArrayList<String> boodschappenlijst = new ArrayList<>();
    private int klantenkaartnr;

    public Klant(String voornaam, String familienaam) {
        super(voornaam, familienaam);
        this.klantenkaartnr = -1;
    }


    public int getKlantenkaartnr() {
        return klantenkaartnr;
    }

    public void setKlantenkaartnr(int klantenkaartnr) {
        this.klantenkaartnr = klantenkaartnr;
    }

    public ArrayList<String> getBoodschappenlijst() {
        return boodschappenlijst;
    }

    public boolean voegToeAanBoodschappenlijst(String product) {
        if (getAantalOpBoodschappenlijst() < 5) {
            boodschappenlijst.add(product);
            return true;
        } else {
            return false;
        }
    }

    public int getAantalOpBoodschappenlijst() {
        return boodschappenlijst.size();
    }

    public String toString() {
        return "Klant " + super.toString() + " met klantenkaartnr " + '5';

    }
}
