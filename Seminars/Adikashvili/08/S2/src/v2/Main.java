package v2;

public class Main {

    public static void main(String[] args) {
        Node v1 = new ValueNode(10);
        Node v2 = new ValueNode(20);

        Node plusNode = new PlusNode(v1, v2);
        System.out.println(plusNode.evaluate());
        System.out.println(plusNode);
    }
}
