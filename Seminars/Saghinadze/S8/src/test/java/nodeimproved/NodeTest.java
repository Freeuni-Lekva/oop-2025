package nodeimproved;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NodeTest {

    private Node node;

    @BeforeEach
    void setUp() {
        Node n1 = new NumberNode(1);
        Node n2 = new NumberNode(2);
        Node n3 = new NumberNode(3);
        Node op1 = new MultiplicationOperationNode(n2, n3);
        Node op2 = new AddOperationNode(n1, op1);
        node = op2;
    }

    @Test
    void testEvaluate() {
        int result = node.evaluate();
        assert result == 7;
    }

}
