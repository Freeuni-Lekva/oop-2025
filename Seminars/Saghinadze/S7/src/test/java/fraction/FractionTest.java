package fraction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FractionTest {

    @Test
    void testZeroDenominator() {
        assertThrows(IllegalArgumentException.class, () -> new Fraction(1, 0));
    }

    @Test
    void testConstructor() {
        Fraction f = new Fraction(1, 2);
        assertEquals(1, f.getNumerator());
        assertEquals(2, f.getDenominator());

        f = new Fraction(-2 , -4);
        assertEquals(1, f.getNumerator());
        assertEquals(2, f.getDenominator());

        f = new Fraction(2 , -4);
        assertEquals(-1, f.getNumerator());
        assertEquals(2, f.getDenominator());


        f = new Fraction(10);
        assertEquals(10, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }

    @Test
    void testReduce() {
        Fraction f = new Fraction(2, 4);
        assertEquals(1, f.getNumerator());
        assertEquals(2, f.getDenominator());

        f = new Fraction(0, 2);
        assertEquals(0, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction f3 = f1.add(f2);
        assertEquals(5, f3.getNumerator());
        assertEquals(6, f3.getDenominator());
    }

    @Test
    void testSub() {
        Fraction f1 = new Fraction(1);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = f1.subtract(f2);
        assertEquals(1, f3.getNumerator());
        assertEquals(2, f3.getDenominator());
    }

    @Test
    void testMul() {
        Fraction f1 = new Fraction(2, 8);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = f1.multiply(f2);
        assertEquals(1, f3.getNumerator());
        assertEquals(8, f3.getDenominator());
    }

    @Test
    void testDiv() {
        Fraction f1 = new Fraction(2, 8);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = f1.divide(f2);
        assertEquals(1, f3.getNumerator());
        assertEquals(2, f3.getDenominator());
    }

    @Test
    void testDivideByZero() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(0 , 10);
        assertThrows(IllegalArgumentException.class, () -> f1.divide(f2));
    }

}
