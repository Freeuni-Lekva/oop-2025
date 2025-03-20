import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        for (int i = 0; i < 100; i++) {
            filter.add(i);
            assertEquals(i + 1, filter.size());
        }
    }

    @Test
    public void testAddTwice() {
        filter.add(1);
        filter.add(1);
        assertEquals(1, filter.size());
    }

    @Test
    public void testIsPresent() {
        filter.add(0);
        assertTrue(filter.isPresent(0));
        assertFalse(filter.isPresent(1));
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 100; i++) {
            filter.add(i);
            assertTrue(filter.isPresent(i));
        }

        for (int i = 0; i < 100; i++) {
            filter.remove(i);
            assertFalse(filter.isPresent(i));
        }
    }

    @Test
    public void testRemoveTwice() {
        filter.add(0);
        filter.remove(0);
        filter.remove(0);
        assertEquals(0, filter.size());
    }
}
