package nodeimproved;

public abstract class OperationNode implements Node{
    protected final Node left;
    protected final Node right;

    public OperationNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}
