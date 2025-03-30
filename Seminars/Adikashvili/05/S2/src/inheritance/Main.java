package inheritance;

public class Main {

    public static void invoke(Parent parent) {
        parent.go();
    }

    public static void invoke(Child child) {
        child.go();
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        invoke(parent);

        Parent p = new Child();
        invoke(p);

        Child child = new Child();
        invoke(child);

//        Child parent = (Child) new Parent();
//        invoke(parent);
    }
}
