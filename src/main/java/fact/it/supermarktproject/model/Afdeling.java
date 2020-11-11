//Vermeld hier je naam en studentennummer
// Van Eynde Michiel r0794174
package fact.it.supermarktproject.model;

public class Afdeling {
    private String naam, foto;
    private boolean gekoeld;
    private Personeelslid verantwoordelijke;

    public Afdeling() {
    }

    public Afdeling(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Personeelslid getVerantwoordelijke() {
        return verantwoordelijke;
    }

    public void setVerantwoordelijke(Personeelslid verantwoordelijke) {
        this.verantwoordelijke = verantwoordelijke;
    }

    public boolean isGekoeld() {
        return gekoeld;
    }

    public void setGekoeld(boolean gekoeld) {
        this.gekoeld = gekoeld;
    }
}
