package nodeimproved;

public class MultiplicationOperationNode extends OperationNode {
    public MultiplicationOperationNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }
}
