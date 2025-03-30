package solid.l.good;

public class Rectangle implements Shape {

    private int width, height;

    @Override
    public int getArea() {
        return width * height;
    }
}
