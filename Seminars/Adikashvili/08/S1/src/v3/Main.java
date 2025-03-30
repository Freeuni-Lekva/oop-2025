package v3;

public class Main {

    public static void main(String[] args) {

        Node v1 = new ValueNode(1);
        Node v2 = new ValueNode(4);

        Operator plusOperator = new PlusOperator(v1, v2);

        System.out.println(plusOperator.evaluate());
        System.out.println(plusOperator);
    }
}
