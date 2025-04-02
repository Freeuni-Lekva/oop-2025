package node;

public class Node {
    private char op;
    private int value;

    private Node left;
    private Node right;

    public int evaluate() {
        if (op == '_') {
            return value;
        }

        int leftValue = left.evaluate();
        int rightValue = right.evaluate();

        if (op == '+') {
            return leftValue + rightValue;
        }

        return leftValue * rightValue;


        // Other supported ops ...
    }

    @Override
    public String toString() {
        if (op == '_') {
            return String.valueOf(value);
        }

        String leftStr = left.toString();
        String rightStr = right.toString();

        if (op == '+') {
            return "(" + leftStr + " + " + rightStr + ")";
        }

        return "(" + leftStr + " * " + rightStr + ")";

        // Other supported ops
    }

}
