package inheritance;


public class Test {

    public static void invoke(Parent parent) {
        parent.go();
    }

    public static void invoke(Child child) {
        child.go();
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        invoke(parent);

        Child child = new Child();
        invoke(child);

        Parent parentChild = new Child();
        invoke(parentChild);

//        Child childParent = (Child)new Parent(); ILLEGAL!
    }
}
