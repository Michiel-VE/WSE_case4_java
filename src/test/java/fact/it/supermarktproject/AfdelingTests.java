package fact.it.supermarktproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.supermarktproject.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AfdelingTests {

    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorEnGetters() {
        Afdeling afdeling = new Afdeling("fruit");
        assertEquals("fruit", afdeling.getNaam());
    }

    /**
     * Test of setNaam method, of class Afdeling.
     */
    @Test
    public void testSetNaam() {
        Afdeling groenten = new Afdeling();
        groenten.setNaam("groenten");
        assertEquals("groenten", groenten.getNaam());
    }

    /**
     * Test of setgekoeld, of class Afdeling.
     */
    @Test
    public void testSetGekoeld() {
        Afdeling groenten = new Afdeling("groenten");
        groenten.setGekoeld(true);
        assertEquals(true, groenten.isGekoeld());
        groenten.setGekoeld(false);
        assertEquals(false, groenten.isGekoeld());
    }


    /**
     * Test of setFoto method, of class Afdeling.
     */
    @Test
    public void testSetFoto() {
        Afdeling groenten = new Afdeling("groenten");
        groenten.setFoto("testfoto.jpg");
        assertEquals("testfoto.jpg", groenten.getFoto());
    }

    /**
     * Test of setVerantwoordelijke method, of class Afdeling.
     */
    @Test
    public void testVerantwoordelijke() {
        Afdeling groenten = new Afdeling("groenten");
        Personeelslid Mickey = new Personeelslid("Mickey", "Mouse");
        groenten.setVerantwoordelijke(Mickey);
        assertEquals(Mickey, groenten.getVerantwoordelijke());
    }
}
