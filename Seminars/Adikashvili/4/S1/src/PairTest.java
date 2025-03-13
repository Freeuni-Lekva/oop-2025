import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PairTest {

    @Test
    public void testEquals() {
        Pair<String, Integer> p1 = new Pair<>("1", 1);
        Pair<String, Integer> p2 = new Pair<>("1", 1);
        assertEquals(p1, p2);
        assertTrue(p1.equals(p2));
    }

    @Test
    public void testNotEquals() {
        Pair<String, Integer> p1 = new Pair<>(null, 1);
        Pair<Integer, Object> p2 = new Pair<>(1, 1);

        assertNotEquals(p1, p2);
    }


}
