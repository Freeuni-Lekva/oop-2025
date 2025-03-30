package v3;

public abstract class Operator implements Node {

    private Node left;

    private Node right;

    public Operator(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return doEvaluate(left.evaluate(), right.evaluate());
    }

    public String toString() {
        return "(" + left.toString() + getOperator() + right.toString() + ")";
    }

    public abstract char getOperator();

    public abstract double doEvaluate(double left, double right);
}
