import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStackTest {

    private MyStack<Integer> myStack;

    @BeforeEach
    public void init() {
        myStack = new MyStack<>();
    }

    @Test
    public void testAddSizeSmall() {
        assertEquals(0, myStack.size());
        myStack.add(1);
        assertEquals(1, myStack.size());
    }

    @Test
    public void testAddSizeBig() {
        for (int i = 0; i < 100000; i++) {
            myStack.add(i);
            assertEquals(i + 1, myStack.size());
        }
    }

    @Test
    public void testAddAll() {
        myStack.addAll(Arrays.asList(1, 2, 3, 4));
        assertEquals(4, myStack.size());
        for (int i = 4; i >= 1; i--) {
            assertEquals(i, myStack.pop());
        }
    }

    @Test
    public void testPop() {
        for (int i = 0; i <= 1000; i++) {
            myStack.add(i);
        }

        for (int i = 1000; i >= 0; i--) {
            assertEquals(i, myStack.pop());
        }
    }

    @Test
    public void testPopEmpty() {
        assertThrows(RuntimeException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                myStack.pop();
            }
        });
    }
}
