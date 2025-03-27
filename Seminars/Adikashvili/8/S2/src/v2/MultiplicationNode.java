package v2;

public class MultiplicationNode implements Node {

    private Node left, right;

    public MultiplicationNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }

    public String toString() {
        return "(" + left.toString() + "*" + right.toString() + ")";
    }
}
