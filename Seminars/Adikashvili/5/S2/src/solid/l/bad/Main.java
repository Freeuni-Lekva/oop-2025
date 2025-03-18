package solid.l.bad;

public class Main {

    public static void method(Rectangle rectangle) {
        rectangle.setWidth(10);
        rectangle.setWidth(12);
        // rectangle cant be square
    }

    public static void main(String[] args) {
        Rectangle square = new Square(10, 12);
        System.out.println(square.getArea());
    }
}
