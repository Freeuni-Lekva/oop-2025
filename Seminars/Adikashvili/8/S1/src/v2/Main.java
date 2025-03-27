package v2;

public class Main {

    public static void main(String[] args) {
        Node v1 = new ValueNode(1);
        Node v2 = new ValueNode(2);
        Node plus = new PlusNode(v1, v2);

        System.out.println(plus.evaluate());
        System.out.println(plus.toString());
    }
}
