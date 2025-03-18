package interfaces;

public abstract class Phone extends Electronic {

    private int number;

    public abstract void makeCall(String number);

    public static void testCall(String number) {

    }
}
