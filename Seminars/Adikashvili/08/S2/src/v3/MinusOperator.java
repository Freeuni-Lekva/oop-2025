package v3;

public class MinusOperator extends Operator {

    public MinusOperator(Node left, Node right) {
        super(left, right);
    }

    @Override
    public char getOperator() {
        return '-';
    }

    @Override
    public double simpleEvaluate(double left, double right) {
        return left - right;
    }
}
