import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    public FizzBuzzTest() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testDiv15() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(0));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(15));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(150));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(300));
    }

    @Test
    public void testContains35() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(35));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(53));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(533));
    }

    @Test
    public void testDiv3() {
        assertEquals("Fizz", fizzBuzz.evaluate(3));
        assertEquals("Fizz", fizzBuzz.evaluate(12));
    }

    @Test
    public void testContains3() {
        assertEquals("Fizz", fizzBuzz.evaluate(31));
        assertEquals("Fizz", fizzBuzz.evaluate(13));
    }

    @Test
    public void testDiv5() {
        assertEquals("Buzz", fizzBuzz.evaluate(5));
        assertEquals("Buzz", fizzBuzz.evaluate(55));
    }

    @Test
    public void testContains5() {
        assertEquals("Buzz", fizzBuzz.evaluate(5111));
        assertEquals("Buzz", fizzBuzz.evaluate(511));
    }

    @Test
    public void testOther() {
        assertEquals("17", fizzBuzz.evaluate(17));
        assertEquals("71", fizzBuzz.evaluate(71));
        assertEquals("29", fizzBuzz.evaluate(29));
    }

}
