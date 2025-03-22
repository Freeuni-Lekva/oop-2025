package seminar;

interface Device {
    void on();
    void off();
}

abstract class Electronic implements Device {
    public void on() {
        System.out.println("Device is on");
    }

    public void off() {
        System.out.println("Device is off");
    }
    abstract void plugin();
}

abstract class Phone extends Electronic {
    public void plugin() {
        System.out.println("Phone is plugged in");
    }

    public abstract void makeCall();

    public void testCall() {
        System.out.println("Beeeeep");
    }
}

class Mobile extends Phone {
    public void makeCall() {
        System.out.println("Making a call");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Phone phone = new Mobile();
        phone.makeCall();
    }
}