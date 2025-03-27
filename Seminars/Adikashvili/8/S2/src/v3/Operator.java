package v3;

public abstract class Operator {

    private Node left, right;

    public Operator(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public double evaluate() {
        return simpleEvaluate(left.evaluate(), right.evaluate());
    }

    @Override
    public String toString() {
        return "(" + left.toString() + "?" + right.toString() + ")";
    }

    abstract char getOperator();

    abstract double simpleEvaluate(double left, double right);
}
