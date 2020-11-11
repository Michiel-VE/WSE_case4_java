package fact.it.supermarktproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.supermarktproject.model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersoneelslidTests {

    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorEnGetters() {
        Personeelslid personeel = new Personeelslid("Juul", "Kabas");
        assertEquals("Juul", personeel.getVoornaam());
        assertEquals("Kabas", personeel.getFamilienaam());
        assertEquals(LocalDate.now(), personeel.getInDienstSinds());
    }


    /**
     * Test of toString method, of class Personeelslid.
     */
    @Test
    public void testToString() {
        Personeelslid donald = new Personeelslid("Donald", "Duck");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
        assertEquals("Personeelslid DUCK Donald is in dienst sinds " + LocalDate.now().format(dtf) , donald.toString());
    }

    /**
     * Test of toString method, of class Personeelslid.
     */
    @Test
    public void testToString2() {
        Personeelslid donald = new Personeelslid("Donald", "Duck");
        donald.setInDienstSinds(LocalDate.of(1999,2,25));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
        assertEquals("Personeelslid DUCK Donald is in dienst sinds " + donald.getInDienstSinds().format(dtf) , donald.toString());
    }

}
