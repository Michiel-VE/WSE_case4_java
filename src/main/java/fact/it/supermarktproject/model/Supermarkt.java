//Vermeld hier je naam en studentennummer
// Van Eynde Michiel r0794174

package fact.it.supermarktproject.model;

import java.util.ArrayList;

public class Supermarkt {
    private String naam;
    private int aantalKlanten;
    private ArrayList<Afdeling> afdelingen = new ArrayList<>();
    private Klant klant;

    public Supermarkt(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public ArrayList<Afdeling> getAfdelingen() {
        return afdelingen;
    }

    public int getAantalAfdelingen() {
        return getAfdelingen().size();
    }

    public void voegAfdelingToe(Afdeling afdeling) {
        getAfdelingen().add(afdeling);
    }

    public Afdeling zoekAfdelingOpNaam(String naam) {
        for (Afdeling afdeling : afdelingen)
            if (afdeling.getNaam().toLowerCase().equals(naam.toLowerCase())) {
                return afdeling;
            }

        return null;
    }

    public void registreerKlant(Klant klant) {
        aantalKlanten += 1;
        klant.setKlantenkaartnr(aantalKlanten);

    }

}
