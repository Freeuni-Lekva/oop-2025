package v1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NodeTest {

    @Test
    public void testValue() {
        Node valueNode = new Node(1);
        assertEquals(1.0, valueNode.evaluate());
        assertEquals("1.0", valueNode.toString());
    }

    @Test
    public void testPlus() {
        Node v1 = new Node('+', 1, 2);
        Node v2 = new Node(3);
        Node v3 = new Node('-', v1, v2);
        assertEquals(0, v3.evaluate());
        assertEquals("((1.0+2.0)-3.0)", v3.toString());
    }

    @Test
    public void testIllegalOperator() {
        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Node node = new Node('%', 1, 2);
                node.evaluate();
            }
        });
    }
}
