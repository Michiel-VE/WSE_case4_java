package fact.it.supermarktproject.controller;
//Vermeld hier je naam en studentennummer
//        Van Eynde Michiel r0794174

import fact.it.supermarktproject.model.Afdeling;
import fact.it.supermarktproject.model.Klant;
import fact.it.supermarktproject.model.Personeelslid;
import fact.it.supermarktproject.model.Supermarkt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class MainController {

    private ArrayList<Personeelslid> personeelsleden;
    private ArrayList<Klant> klanten;
    private ArrayList<Supermarkt> supermarkten;

    @PostConstruct
    public void lijstenVullen() {
        vulPersoneelsledenLijst();
        vulKlantenLijst();
        vulSupermarktenLijst();
    }

    /* Codeer hieronder al je verschillende mappings */

    @RequestMapping("/0_examen")
    public String wedde(Model model){
        model.addAttribute("wedde", personeelsleden);
        return "0_examen";
    }

    @RequestMapping("/1_klantRegristratie")
    public String klantRegristratie(Model model) {
        model.addAttribute("supermarkten", supermarkten);
        return ("1_klantRegristratie");
    }

    @RequestMapping("/2_klantFormulier")
    public String nieuwKlant(Model model, HttpServletRequest request) {
        String voornaam = request.getParameter("voornaam");
        String familienaam = request.getParameter("familienaam");
        String geboortejaarstr = request.getParameter("geboortejaar");
        int geboortejaar = Integer.parseInt(geboortejaarstr);
        String keuzestr = request.getParameter("supermarktIndex");
        int keuze = Integer.parseInt(keuzestr);

        if (keuze > supermarkten.size()){
            model.addAttribute("foutmelding", "Geen geldige supermarkt");
            return "99_fout";
        }

        Klant k = new Klant(voornaam, familienaam);
        Supermarkt s = supermarkten.get(keuze);
        k.setGeboortejaar(geboortejaar);
        s.registreerKlant(k);
        model.addAttribute("klant", k);
        klanten.add(k);


        return ("2_klantFormulier");

    }

    @RequestMapping("/3_personeelRegristratie")
    public String personeelRegristratie() {

        return ("3_personeelRegristratie");
    }

    @RequestMapping("/4_personeelFormulier")
    public String nieuwPersoneel(Model model, HttpServletRequest request) {
        String voornaam = request.getParameter("voornaam");
        String familienaam = request.getParameter("familienaam");
        String dienststr = request.getParameter("dienst");
        LocalDate dienst = LocalDate.parse(dienststr);
        String weddestr = request.getParameter("wedde");
        double wedde = Double.parseDouble(weddestr);
        Personeelslid p = new Personeelslid(voornaam, familienaam);
        p.setInDienstSinds(dienst);
        p.setWedde(wedde);
        personeelsleden.add(p);
        model.addAttribute("personeelslid", p);
        return ("4_personeelFormulier");
    }

    @RequestMapping("/5_personeelsleden")
    public String toonPersoneel(Model model) {
        model.addAttribute("personeelsleden", personeelsleden);
        return ("5_personeelsleden");
    }

    @RequestMapping("/6_klanten")
    public String toonKlant(Model model) {
        model.addAttribute("klanten", klanten);
        return ("6_klanten");
    }

    @RequestMapping("/7_supermarktRegistratie")
    public String nieuwSupermarkt() {
        return ("7_supermarktRegistratie");
    }

    @RequestMapping("/8_supermarktenFormulier")
    public String toonSupermarkt(Model model, HttpServletRequest request) {
        String supermarktnaam = request.getParameter("supermarkt");
        Supermarkt s = new Supermarkt(supermarktnaam);
        if (supermarktnaam != null) {
            boolean supermarktBestaat = false;
            for (Supermarkt supermarkt1 : supermarkten) {
                if (supermarkt1.getNaam().equals(supermarktnaam)) {
                    supermarktBestaat = true;
                    break;
                }
            }
            if (!supermarktBestaat) {
                supermarkten.add(s);
            }
        }

        model.addAttribute("supermarkten", supermarkten);
        return ("8_supermarktenFormulier");
    }

    @RequestMapping("/9_afdelingRegistratie")
    public String toonAfdeling(Model model) {
        model.addAttribute("personeelsleden", personeelsleden);
        model.addAttribute("supermarkten", supermarkten);
        return ("9_afdelingRegistratie");
    }

    @RequestMapping("/10_afdelingFormulier")
    public String nieuwAfdeling(Model model, HttpServletRequest request) {
        String naam = request.getParameter("naam");
        int supermarktIndex = Integer.parseInt(request.getParameter("supermarkt"));

        if (naam != null) {
            String foto = request.getParameter("foto");
            int personeelIndex = Integer.parseInt(request.getParameter("v_afdeling"));
            String gekoeldstr = request.getParameter("gekoeld");
            boolean gekoeld = Boolean.parseBoolean(gekoeldstr);


            if ((supermarktIndex < 0) && (personeelIndex < 0)) {
                model.addAttribute("foutmelding", "Er is niets aangeduid");
                return ("99_fout");
            } else if (personeelIndex < 0) {
                model.addAttribute("foutmelding", "Geen verantwoordelijke gekozen");
                return ("99_fout");
            } else if (supermarktIndex < 0) {
                model.addAttribute("foutmelding", "Geen supermarkt gekozen");
                return ("99_fout");
            }

            Afdeling a = new Afdeling(naam);
            Personeelslid p = personeelsleden.get(personeelIndex);
            Supermarkt s = supermarkten.get(supermarktIndex);

            a.setVerantwoordelijke(p);
            a.setGekoeld(gekoeld);
            a.setFoto(foto);
            s.voegAfdelingToe(a);
        }
        Supermarkt s = supermarkten.get(supermarktIndex);
        model.addAttribute("supermarkt", s);
        return ("10_afdelingFormulier");
    }

    @RequestMapping("/11_zoek")
    public String zoekAfdeling(Model model, HttpServletRequest request) {
        String gezocht = request.getParameter("zoeken");
        boolean afdelingBestaat = false;
        for (Supermarkt supermarkt1 : supermarkten) {
            if (supermarkt1.zoekAfdelingOpNaam(gezocht) != null) {
                afdelingBestaat = true;
                Afdeling a = supermarkt1.zoekAfdelingOpNaam(gezocht);
                model.addAttribute("afdeling", a);
            }
        }
        if (!afdelingBestaat) {
            model.addAttribute("foutmelding", "Geen afdeling met naam " + gezocht + " gevonden");
            return "99_fout";
        }

        return "11_zoek";
    }

    private ArrayList<Personeelslid> vulPersoneelsledenLijst() {
        personeelsleden = new ArrayList<>();
        Personeelslid jitse = new Personeelslid("Jitse", "Verhaegen");
        Personeelslid bert = new Personeelslid("Bert", "De Meulenaere");
        Personeelslid sanne = new Personeelslid("Sanne", "Beckers");
        jitse.setWedde(5000.0);
        bert.setWedde(2500.0);
        sanne.setWedde(1500.0);
        personeelsleden.add(jitse);
        personeelsleden.add(bert);
        personeelsleden.add(sanne);
        return personeelsleden;
    }

    private ArrayList<Klant> vulKlantenLijst() {
        klanten = new ArrayList<>();
        Klant daan = new Klant("Daan", "Mertens");
        daan.setGeboortejaar(2001);
        Klant wim = new Klant("Wim", "Wijns");
        wim.setGeboortejaar(1956);
        Klant gert = new Klant("Gert", "Pauwels");
        gert.setGeboortejaar(1978);
        Klant michiel = new Klant("Michiel", "Van Eynde");
        michiel.setGeboortejaar(1999);
        klanten.add(daan);
        klanten.add(wim);
        klanten.add(gert);
        klanten.add(michiel);
        klanten.get(0).voegToeAanBoodschappenlijst("melk");
        klanten.get(0).voegToeAanBoodschappenlijst("kaas");
        klanten.get(1).voegToeAanBoodschappenlijst("eieren");
        klanten.get(1).voegToeAanBoodschappenlijst("water");
        klanten.get(1).voegToeAanBoodschappenlijst("bloemkool");
        klanten.get(1).voegToeAanBoodschappenlijst("sla");
        klanten.get(2).voegToeAanBoodschappenlijst("tomaten");
        klanten.get(3).voegToeAanBoodschappenlijst("WC-papier");
        klanten.get(3).voegToeAanBoodschappenlijst("Spek");
        klanten.get(3).voegToeAanBoodschappenlijst("Paaseieren");
        return klanten;
    }

    private ArrayList<Supermarkt> vulSupermarktenLijst() {
        supermarkten = new ArrayList<>();
        Supermarkt supermarkt1 = new Supermarkt("Colruyt Geel");
        Supermarkt supermarkt2 = new Supermarkt("Okay Meerhout");
        Supermarkt supermarkt3 = new Supermarkt("Colruyt Herentals");
        Afdeling afdeling1 = new Afdeling("Brood");
        Afdeling afdeling2 = new Afdeling("Groenten");
        afdeling2.setGekoeld(true);
        Afdeling afdeling3 = new Afdeling("Fruit");
        afdeling3.setGekoeld(true);
        Afdeling afdeling4 = new Afdeling("Vlees");
        afdeling4.setGekoeld(true);
        Afdeling afdeling5 = new Afdeling("Dranken");
        Afdeling afdeling6 = new Afdeling("Diepvries");
        afdeling1.setFoto("/img/brood.jpg");
        afdeling2.setFoto("/img/groenten.jpg");
        afdeling3.setFoto("/img/fruit.jpg");
        afdeling1.setVerantwoordelijke(personeelsleden.get(0));
        afdeling2.setVerantwoordelijke(personeelsleden.get(1));
        afdeling3.setVerantwoordelijke(personeelsleden.get(2));
        afdeling4.setVerantwoordelijke(personeelsleden.get(0));
        afdeling5.setVerantwoordelijke(personeelsleden.get(1));
        afdeling6.setVerantwoordelijke(personeelsleden.get(2));

        supermarkt1.voegAfdelingToe(afdeling1);
        supermarkt1.voegAfdelingToe(afdeling2);
        supermarkt2.voegAfdelingToe(afdeling3);
        supermarkt2.voegAfdelingToe(afdeling4);
        supermarkt3.voegAfdelingToe(afdeling5);
        supermarkt3.voegAfdelingToe(afdeling6);
        supermarkten.add(supermarkt1);
        supermarkten.add(supermarkt2);
        supermarkten.add(supermarkt3);
        return supermarkten;
    }
}
