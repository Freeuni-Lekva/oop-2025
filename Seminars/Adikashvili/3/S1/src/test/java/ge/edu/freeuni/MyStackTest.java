package ge.edu.freeuni;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStackTest {

    private MyStack<String> stack;

    @BeforeEach
    public void setUp() {
        stack = new MyStack<>();
    }

    @Test
    public void testAddSizeSmall() {
        assertEquals(0, stack.size());
        stack.add("element");
        assertEquals(1, stack.size());
    }

    @Test
    public void testAddSizeBig() {
        for (int i = 0; i < 10000; i++) {
            stack.add(String.valueOf(1));
        }
        assertEquals(10000, stack.size());
    }

    @Test
    public void testAddAll() {
        stack.addAll(Arrays.asList("1", "2", "3"));
        assertEquals(3, stack.size());
        assertEquals("3", stack.pop());
    }

    @Test
    public void testPop() {
        stack.add("1");
        stack.add("2");
        assertEquals("2", stack.pop());
        assertEquals("1", stack.pop());
    }

    @Test
    public void testPopEmpty() {
        assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                stack.pop();
            }
        });
    }
}
