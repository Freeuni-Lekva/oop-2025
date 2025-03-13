import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PairTest {

    @Test
    public void testEquals() {
        Pair<String, Integer> p1 = new Pair<>("1", 1);
        Pair<String, Integer> p2 = new Pair<>();
        p2.setFirst("1");
        p2.setSecond(1);

        assertEquals(p1, p2);
    }

    @Test
    public void testNotEquals() {
        Pair<String, Integer> p = new Pair<>();
        assertNotEquals(p, 1);

        Pair<String, Integer> p1 = new Pair<>("1", 1);
        Pair<String, Double> p2 = new Pair<>("1", 1.0);

        assertNotEquals(p1, p2);
    }

    @Test
    public void testGetters() {
        Pair<String, Integer> p = new Pair<>();
        p.setFirst("1");
        p.setSecond(2);
        assertEquals("1", p.getFirst());
        assertEquals(2, p.getSecond());
    }
}
