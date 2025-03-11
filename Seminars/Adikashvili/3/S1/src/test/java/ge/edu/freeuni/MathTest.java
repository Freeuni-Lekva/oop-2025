package ge.edu.freeuni;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTest {

    @Test
    public void testAddSmall() {
        assertEquals(3, Math.add(1, 2));
    }

    @Test
    public void testAddBig() {
        assertEquals(100000, Math.add(99999, 1));
        assertEquals(-1, Math.add(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void testAddNegatives() {
        assertEquals(-10, Math.add(-5, -5));
        assertEquals(-100, Math.add(-101, 1));
        assertEquals(-1, Math.add(101, -102));
    }

    @Test
    public void testAddZero() {
        assertEquals(0, Math.add(0, 0));
        assertEquals(9, Math.add(0, 9));
        assertEquals(9, Math.add(9, 0));
    }


    @Test
    public void testAbsSmall() {
        assertEquals(0, Math.abs(0));
        assertEquals(1, Math.abs(-1));
    }

    @Test
    public void testAbsPositives() {
        assertEquals(100, Math.abs(100));
        assertEquals(Integer.MAX_VALUE, Math.abs(Integer.MAX_VALUE));
    }

    @Test
    public void testAbsNegatives() {
        assertEquals(2, Math.abs(-2));
        assertEquals(2000000000, Math.abs(-2000000000));
    }
}
