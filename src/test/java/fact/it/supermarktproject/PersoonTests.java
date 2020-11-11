package fact.it.supermarktproject;

import fact.it.supermarktproject.model.Persoon;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.supermarktproject.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class PersoonTests {

    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorEnGetters() {

        Persoon leonie = new Persoon("Leonie", "Pelgroms");
        assertEquals("Leonie", leonie.getVoornaam());
        assertEquals("Pelgroms", leonie.getFamilienaam());
        Persoon persoon = new Persoon();
        assertNull(persoon.getVoornaam());
        assertNull(persoon.getFamilienaam());
    }

    /**
     * Test of setVoornaam method, of class Persoon.
     */
    @Test
    public void testSetVoornaam() {
        Persoon persoon = new Persoon();
        persoon.setVoornaam("Frans");
        assertEquals("Frans", persoon.getVoornaam());
    }

    /**
     * Test of setVoornaam method, of class Persoon.
     */
    @Test
    public void testSetFamilienaam() {
        Persoon persoon = new Persoon();
        persoon.setFamilienaam("Caers");
        assertEquals("Caers", persoon.getFamilienaam());
    }

    /**
     * Test of toString method, of class Persoon.
     */
    @Test
    public void testToString() {
        Persoon leonie = new Persoon("Leonie", "Pelgroms");
        assertEquals("PELGROMS Leonie", leonie.toString());
        Persoon frans = new Persoon("Frans", "Caers");
        assertEquals("CAERS Frans", frans.toString());
    }

}
