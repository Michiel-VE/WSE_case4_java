package fact.it.supermarktproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.supermarktproject.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class KlantTests {

    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorEnGetters() {

        Klant klant = new Klant("Donald", "Duck");
        assertEquals("Donald", klant.getVoornaam());
        assertEquals("Duck", klant.getFamilienaam());
        assertEquals(-1, klant.getKlantenkaartnr());
    }

    /**
     * Test of setVoornaam method, of class Klant.
     */
    @Test
    public void testSetVoornaam() {
        Klant klant = new Klant("Donald", "Duck");
        klant.setVoornaam("Mickey");
        assertEquals("Mickey", klant.getVoornaam());
    }

    /**
     * Test of setVoornaam method, of class Klant.
     */
    @Test
    public void testSetFamilienaam() {
        Klant klant = new Klant("Donald", "Duck");
        klant.setFamilienaam("Mouse");
        assertEquals("Mouse", klant.getFamilienaam());
    }

    /**
     * Test of setVoornaam method, of class Klant.
     */
    @Test
    public void testSetPretparkcode() {
        Klant klant = new Klant("Donald", "Duck");
        klant.setKlantenkaartnr(11);
        assertEquals(11, klant.getKlantenkaartnr());
    }

    /**
     * check basic functionality of Klant: constructor, setters/getters and
     * adding product to wishlist
     */
    @Test
    public void testBoodschappenlijstBasics() {
        Klant v1 = new Klant("Donald", "Duck");
        assertEquals(0, v1.getAantalOpBoodschappenlijst());
        assertTrue(v1.voegToeAanBoodschappenlijst("suiker"));
        assertEquals(1, v1.getAantalOpBoodschappenlijst());
    }

    /**
     * Klant can add maximum 15 product names to wishlist
     */
    @Test
    public void testBoodschappenlijstMax15() {
        Klant v1 = new Klant("Donald", "Duck");
        assertEquals(0, v1.getAantalOpBoodschappenlijst());
        assertTrue(v1.voegToeAanBoodschappenlijst("melk"));
        assertEquals(1, v1.getAantalOpBoodschappenlijst());
        assertTrue(v1.voegToeAanBoodschappenlijst("suiker"));
        assertEquals(2, v1.getAantalOpBoodschappenlijst());
        assertTrue(v1.voegToeAanBoodschappenlijst("eieren"));
        assertEquals(3, v1.getAantalOpBoodschappenlijst());
        assertTrue(v1.voegToeAanBoodschappenlijst("brood"));
        assertEquals(4, v1.getAantalOpBoodschappenlijst());
        assertTrue(v1.voegToeAanBoodschappenlijst("water"));
        assertEquals(5, v1.getAantalOpBoodschappenlijst());
        assertFalse(v1.voegToeAanBoodschappenlijst("keukenrol"));
        assertEquals(5, v1.getAantalOpBoodschappenlijst());
    }

    /**
     * Test of toString method, of class Klant.
     */
    @Test
    public void testToString() {
        Klant donald = new Klant("Donald", "Duck");
        donald.setKlantenkaartnr(9);
        assertEquals("Klant DUCK Donald met klantenkaartnr 9", donald.toString());
    }

}
