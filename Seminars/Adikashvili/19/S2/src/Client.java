import bean.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread {

    private final String address;

    private final int port;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void run() {
        try (Socket socket = new Socket(address, port)) {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // create new student with id 11
            out.writeObject(Command.CREATE_STUDENT);
            out.writeObject(new Student(11, "a", "b"));

            // create new student with id 12
            out.writeObject(Command.CREATE_STUDENT);
            out.writeObject(new Student(12, "c", "d"));

            out.writeObject(Command.GET_STUDENT);
            out.writeObject(12);
            Student student = (Student) in.readObject();
            System.out.println("got student: " + student);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
