public class Assertions {

    public static void assertEquals(Object expected, Object actual) {
        if (expected == null && actual == null) {
            return;
        }

        if (expected == null || !expected.equals(actual)) {
            throw new AssertionError("Expected: " + expected + ", got: " + actual);
        }
    }
}
