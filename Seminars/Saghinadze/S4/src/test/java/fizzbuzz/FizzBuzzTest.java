package fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pair.Pair;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {


    @Test
    void test0() {
        assertEquals("FizzBuzz", FizzBuzz.Evaluate(0));
    }

    @Test
    void testDiv15(){
        assertEquals("FizzBuzz", FizzBuzz.Evaluate(30)); // Contains 3
        assertEquals("FizzBuzz", FizzBuzz.Evaluate(15)); // Contains 5
        assertEquals("FizzBuzz", FizzBuzz.Evaluate(315)); // Contains both
        assertEquals("FizzBuzz", FizzBuzz.Evaluate(60)); // Contains neither
    }

    @Test
    void testDiv3() {
        assertEquals("Fizz", FizzBuzz.Evaluate(36)); // Contains 3
        assertEquals("Fizz", FizzBuzz.Evaluate(51)); // Contains 5
        assertEquals("FizzBuzz", FizzBuzz.Evaluate(351)); // Contains both
        assertEquals("Fizz", FizzBuzz.Evaluate(9)); // Contains neither
    }

    @Test
    void testDiv5() {
        assertEquals("Fizz", FizzBuzz.Evaluate(130)); // Contains 3
        assertEquals("Buzz", FizzBuzz.Evaluate(5)); // Contains 5
        assertEquals("FizzBuzz", FizzBuzz.Evaluate(35)); // Contains both
        assertEquals("Buzz", FizzBuzz.Evaluate(10)); // Contains neither
    }

    @Test
    void testOther() {
        assertEquals("Fizz", FizzBuzz.Evaluate(13)); // Contains 3
        assertEquals("Buzz", FizzBuzz.Evaluate(59)); // Contains 5
        assertEquals("FizzBuzz", FizzBuzz.Evaluate(53)); // Contains both
        assertEquals("1222", FizzBuzz.Evaluate(1222)); // Contains neither
        assertEquals("1", FizzBuzz.Evaluate(1));
        assertEquals("7", FizzBuzz.Evaluate(7));
        assertEquals("11", FizzBuzz.Evaluate(11));
    }

    @ParameterizedTest(name = "{index} => expected={0}, input={1}") // For more verbose test outputs
    @CsvSource({
            "FizzBuzz, 30",
            "Fizz, 13",
            "Buzz, 52",
            "1121, 1121"
    })
    void pTestFizzBuzzCsvSource(String expected, int input) {
        assertEquals(expected, FizzBuzz.Evaluate(input));
    }


    static Stream<Arguments> fizzBuzzParams() {
        return Stream.of(
                Arguments.of("FizzBuzz", 30),
                Arguments.of("Fizz", 13),
                Arguments.of("Buzz", 52),
                Arguments.of("1121", 1121)
        );
    }

    @ParameterizedTest
    @MethodSource("fizzBuzzParams")
    void pTestFizzBuzzMethodSource(String expected, int input) {
        assertEquals(expected, FizzBuzz.Evaluate(input));
    }


    static Stream<Arguments> fizzBuzzPairParams() {
        return Stream.of(
                Arguments.of(new Pair<>("FizzBuzz", 30)),
                Arguments.of(new Pair<>("Fizz", 13))
        );
    }

    @ParameterizedTest
    @MethodSource("fizzBuzzPairParams")
    void pTestFizzBuzzPair(final Pair<String, Integer> pair) {
        assertEquals(pair.getFirst(), FizzBuzz.Evaluate(pair.getSecond()));
    }


}
