import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    public void init() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testDiv15() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(0));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(15));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(150));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(30));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(60));
    }

    @Test
    public void testContains35() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(35));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(53));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(537));
    }

    @Test
    public void testDiv3() {
        assertEquals("Fizz", fizzBuzz.evaluate(3));
        assertEquals("Fizz", fizzBuzz.evaluate(6));
        assertEquals("Fizz", fizzBuzz.evaluate(9));
        assertEquals("Fizz", fizzBuzz.evaluate(333333));
    }

    @Test
    public void testContains3() {
        assertEquals("Fizz", fizzBuzz.evaluate(31));
        assertEquals("Fizz", fizzBuzz.evaluate(1318));
    }

    @Test
    public void testDiv5() {
        assertEquals("Buzz", fizzBuzz.evaluate(5));
        assertEquals("Buzz", fizzBuzz.evaluate(10));
        assertEquals("Buzz", fizzBuzz.evaluate(550));
    }

    @Test
    public void testContains5() {
        assertEquals("Buzz", fizzBuzz.evaluate(58));
        assertEquals("Buzz", fizzBuzz.evaluate(551));
    }

    @Test
    public void testOtherCases() {
        assertEquals("17", fizzBuzz.evaluate(17));
        assertEquals("101", fizzBuzz.evaluate(101));
        assertEquals("172", fizzBuzz.evaluate(172));
    }
}
