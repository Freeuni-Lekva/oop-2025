package interfaces;

public abstract class Phone extends Electronic {

    public abstract void makeCall(String number);

    public void testCall(String number) {
        System.out.println(number);
    }
}
