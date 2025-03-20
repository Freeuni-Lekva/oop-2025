import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilterTest {

    private Filter filter;

    @BeforeEach
    public void setUp() {
        filter = new BooleanFilter();
    }

    @Test
    public void testEmpty() {
        assertEquals(0, filter.size());
    }

    @Test
    public void testAddSize() {
        filter.add(0);
        filter.add(1);
        filter.add(5);
        filter.add(1000);
        filter.add(1);
        assertEquals(4, filter.size());
    }

    @Test
    public void testAddMany() {
        for (int i = 0; i < 31; i++) {
            filter.add((int) Math.pow(2, i));
        }
    }

    @Test
    public void testIsPresent() {
        filter.add(0);
        filter.add(1);
        filter.add(5);
        assertTrue(filter.isPresent(1));
        assertFalse(filter.isPresent(2));
    }

    @Test
    public void testRemove() {
        filter.add(1);
        filter.add(7);
        assertTrue(filter.isPresent(7));
        filter.add(3);
        filter.remove(7);
        filter.remove(7);
        assertTrue(filter.isPresent(1));
        assertFalse(filter.isPresent(7));
        assertEquals(2, filter.size());
    }

}
