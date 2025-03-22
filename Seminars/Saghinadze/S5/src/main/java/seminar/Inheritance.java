package seminar;

class Parent{
    public void go(){
        System.out.println("go method from Parent class");
    }
}

class Child extends Parent{

    @Override
    public void go(){
        System.out.println("go method from Child class");
    }
}

public class Inheritance {

    public static void invoke(Parent p) {
        p.go();
    }

    public static void invoke(Child c) {
        c.go();
    }


    public static void main(String []args) {
        Parent p = new Parent();
        Child c = new Child();
        Parent pc = new Child();

        System.out.println("ParentParent");
        invoke(p);

        System.out.println("ChildChild");
        invoke(c);


        System.out.println("ParentChild");
        invoke(pc);



    }
}
