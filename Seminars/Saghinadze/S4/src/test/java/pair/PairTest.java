package pair;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PairTest {

    @Test
    void testNullValues(){
        Pair<String, Integer> p1 = null;
        Pair<String, Integer> p2 = null;
        Pair<Double, Boolean> p3 = null;

        assertEquals(p1,p2);
        assertEquals(p1,p3);
    }

    @Test
    void testEquals(){
        Pair<String, Integer> p1 = new Pair<>("Hello" , 0);
        Pair<String, Integer> p2 = new Pair<>("Hello" , 0);
        assertEquals(p1,p2);

        Pair<String, Integer> p3 = new Pair<>("Hello" , null);
        Pair<String, Integer> p4 = new Pair<>("Hello" , 0);
        assertNotEquals(p3,p4);
    }

    @Test
    void testIncorrectImplementation() {
        PairIncorrectEquals<String, Integer> p1 = new PairIncorrectEquals<>("Hello" , 0);
        PairIncorrectEquals<String, Integer> p2 = new PairIncorrectEquals<>("Hello" , null);

        //java.lang.NullPointerException: Cannot invoke "Object.equals(Object)" because "p.second" is null
        assertThrows(NullPointerException.class, () -> p1.equals(p2));
    }
}
