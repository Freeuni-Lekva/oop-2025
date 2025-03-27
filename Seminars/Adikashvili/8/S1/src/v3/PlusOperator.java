package v3;

public class PlusOperator extends Operator {

    public PlusOperator(Node left, Node right) {
        super(left, right);
    }

    @Override
    public char getOperator() {
        return '+';
    }

    @Override
    public double doEvaluate(double left, double right) {
        return left + right;
    }
}
