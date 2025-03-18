package interfaces;

public interface Device {

    default void on() {
        System.out.println("device");
    }

    void off();
}
