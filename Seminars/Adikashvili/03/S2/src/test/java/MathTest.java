
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTest {

    @Test
    public void testSumSmall() {
        assertEquals(5, Math.sum(1, 4));
    }

    @Test
    public void testSumBig() {
        assertEquals(-1, Math.sum(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void testSumZero() {
        assertEquals(0, Math.sum(0, 0));
        assertEquals(10, Math.sum(10, 0));
        assertEquals(10, Math.sum(0, 10));
        assertEquals(-10, Math.sum(-10, 0));
    }

    @Test
    public void testSumNegatives() {
        assertEquals(0, Math.sum(-10, 10));
        assertEquals(-20, Math.sum(-10, -10));
        assertEquals(0, Math.sum(10, -10));
    }

    @Test
    public void testAbsZero() {
        assertEquals(0, Math.abs(0));
    }

    @Test
    public void testAbsSmall() {
        assertEquals(1, Math.abs(-1));
        assertEquals(1, Math.abs(1));
    }

    @Test
    public void testAbsBig() {
        assertEquals(100000, Math.abs(-100000));
        assertEquals(100000, Math.abs(100000));
    }
}
