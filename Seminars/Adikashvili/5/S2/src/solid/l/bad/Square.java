package solid.l.bad;

public class Square extends Rectangle {

    int side;

    public Square(int side) {
        super(side, side);
    }

    public Square(int width, int height) {
        super(width, height);
    }

    public int getArea() {
        return side * side;
    }
}
