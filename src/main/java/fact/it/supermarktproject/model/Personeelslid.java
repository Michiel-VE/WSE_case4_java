//Vermeld hier je naam en studentennummer
// Van Eynde Michiel r0794174

package fact.it.supermarktproject.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


public class Personeelslid extends Persoon {
    private LocalDate inDienstSinds;
    private double wedde;

    public Personeelslid(String voornaam, String familienaam) {
        super(voornaam, familienaam);
        this.inDienstSinds = LocalDate.now();
    }

    public LocalDate getInDienstSinds() {
        return inDienstSinds;
    }

    public void setInDienstSinds(LocalDate inDienstSinds) {
        this.inDienstSinds = inDienstSinds;
    }

    public double getWedde() {
        return wedde;
    }

    public void setWedde(double wedde) {
        this.wedde = wedde;
    }

    public String toString() {
        LocalDate neemDatum = getInDienstSinds();
        DateTimeFormatter datumFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String datumGeformateerd = neemDatum.format(datumFormat);

        return "Personeelslid " + super.toString() + " is in dienst sinds " + datumGeformateerd;
    }
}
