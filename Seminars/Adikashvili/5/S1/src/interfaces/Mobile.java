package interfaces;

public class Mobile extends Phone {

    @Override
    public void makeCall(String number) {
        System.out.println(number);
    }

    @Override
    public void testCall(String number) {
        System.out.println("....");
    }

    @Override
    public void plugin() {

    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }
}
