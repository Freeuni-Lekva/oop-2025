package v2;

public class MinusNode implements Node {

    private Node left, right;

    public MinusNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + "-" + right.toString() + ")";
    }
}
