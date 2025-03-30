package solid.l.good;

public class Square implements Shape {

    int side;

    @Override
    public int getArea() {
        return side * side;
    }
}
