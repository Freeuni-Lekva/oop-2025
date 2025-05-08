import bean.Student;

import java.io.*;
import java.net.Socket;

public class Client {

    public String address;

    private final int port;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void start() {
        new Thread(() -> {
            try (Socket socket = new Socket(address, port)) {
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                // first command: create new student
                out.writeObject(Command.CREATE);
                out.writeObject(new Student(11, "a", "a"));

                // second command: create new student
                out.writeObject(Command.CREATE);
                out.writeObject(new Student(12, "b", "b"));

                // third command: get student by id
                out.writeObject(Command.GET);
                out.writeObject(12);
                Student student = (Student) in.readObject();
                System.out.println("student: " + student);

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);

            }
        }).start();
    }

}
