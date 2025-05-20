public class SampleTest {

    private int x;

    @BeforeEach
    public void setUp1() {
        x = 2;
    }

    @BeforeEach
    public void setUp2() {
        x = 2;
    }

    @TestCase
    public void test1() {
        Assertions.assertEquals(2, x);
    }

    @TestCase
    public void test2() {
        Assertions.assertEquals(2, x);
    }

}
