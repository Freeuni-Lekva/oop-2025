package filter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FilterTest {

    static Stream<Arguments> filterTypeParams() {
        return Stream.of(
                Arguments.of("BitmaskFilter", new BitmaskFilter()),
                Arguments.of("HashSetFilter", new HashSetFilter())
                // Add more filters here
        );
    }

    @ParameterizedTest(name = "{0} - Empty Filter")
    @MethodSource("filterTypeParams")
    void testEmpty(String filterName, Filter f) {
        assertEquals(0, f.size());
    }

    @ParameterizedTest(name = "{0} - Add Single Element")
    @MethodSource("filterTypeParams")
    void testAdd(String filterName, Filter f) {
        f.add(123);
        assertEquals(1, f.size());
        assertTrue(f.isPresent(123));
    }

    @ParameterizedTest(name = "{0} - Add Multiple Elements")
    @MethodSource("filterTypeParams")
    void testMultipleAdd(String filterName, Filter f) {
        f.add(1);
        f.add(2);
        f.add(3);
        assertEquals(3, f.size());
        assertTrue(f.isPresent(1));
        assertTrue(f.isPresent(2));
        assertTrue(f.isPresent(3));
    }

    @ParameterizedTest(name = "{0} - Add Duplicate Element")
    @MethodSource("filterTypeParams")
    void testAddSameNumberMultipleTimes(String filterName, Filter f) {
        f.add(1);
        f.add(1);
        f.add(1);
        assertEquals(1, f.size());
        assertTrue(f.isPresent(1));
    }

    @ParameterizedTest(name = "{0} - Add Large Indices")
    @MethodSource("filterTypeParams")
    void testAddLargeIndices(String filterName, Filter f) {
        f.add(1);
        f.add(10);
        f.add(100);
        assertEquals(3, f.size());
    }

    @ParameterizedTest(name = "{0} - Remove Element")
    @MethodSource("filterTypeParams")
    void testRemove(String filterName, Filter f) {
        f.add(1);
        f.add(2);
        f.add(3);
        f.remove(2);
        assertEquals(2, f.size());
        assertTrue(f.isPresent(1));
        assertFalse(f.isPresent(2));
        assertTrue(f.isPresent(3));
    }

    @ParameterizedTest(name = "{0} - Remove Non-Existent Element")
    @MethodSource("filterTypeParams")
    void testAlreadyRemoved(String filterName, Filter f) {
        f.add(1);
        f.remove(1);
        f.remove(1);
        f.remove(10);
        f.remove(100);
        assertEquals(0, f.size());
        assertFalse(f.isPresent(1));
    }

    @ParameterizedTest(name = "{0} - Ensure Random Elements Are Not Present")
    @MethodSource("filterTypeParams")
    void testRandomElementsAreNotAdded(String filterName, Filter f) {
        f.add(0);
        f.add(1);
        f.add(2);
        for (int i = 3; i < 100; i++) {
            assertFalse(f.isPresent(i));
        }
    }

    @ParameterizedTest(name = "{0} - Negative Numbers Should Not Be Present")
    @MethodSource("filterTypeParams")
    void testNegatives(String filterName, Filter f) {
        assertFalse(f.isPresent(-12313));
        f.add(-1321231); // Assuming negative numbers are ignored
    }

    @ParameterizedTest(name = "{0} - Performance Load Test")
    @MethodSource("filterTypeParams")
    void loadTest(String filterName, Filter f) {
        Instant start = Instant.now();
        Random r = new Random();

        for (int i = 0; i < 10000000; i++) {
            f.add(r.nextInt());
        }

        for (int i = 0; i < 10000000; i++) {
            f.remove(r.nextInt());
            int x = f.size();
        }

        Instant end = Instant.now();
        long elapsed = end.toEpochMilli() - start.toEpochMilli();
        System.out.println(filterName + " Load Test Time: " + elapsed + "ms");

        assertTrue(elapsed < 5000);
    }

}
