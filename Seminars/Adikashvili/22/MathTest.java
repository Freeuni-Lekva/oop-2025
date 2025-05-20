public class MathTest {

    private Math math;

    @BeforeEach
    public void setUp() {
        math = new Math();
    }

    @TestCase
    public void testAddition() {
        Assertions.assertEquals(1, math.add(1, 1));
    }

    @TestCase
    public void testSubtraction() {
        Assertions.assertEquals(0, math.substract(1, 1));
    }
}
