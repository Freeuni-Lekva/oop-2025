import bean.Student;
import dao.StudentDao;
import dao.StudentDaoImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int port;

    private final StudentDao dao;

    public Server(int port) {
        this.port = port;
        this.dao = new StudentDaoImpl();
    }

    public void start() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("connecting to client");

                Socket socket = serverSocket.accept();

                System.out.println("connected");

                processRequest(socket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void processRequest(Socket socket) {
        new Thread(() -> {
            try {
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                while (true) {
                    try {
                        Command command = (Command) in.readObject();

                        System.out.println("command: " + command);

                        switch (command) {
                            case CREATE:
                                Student student = (Student) in.readObject();
                                dao.addStudent(student);
                                System.out.println("added student" + student);
                                break;
                            case GET:
                                int id = (int) in.readObject();
                                Student result = dao.getStudentById(id);
                                out.writeObject(result);
                                break;
                        }
                    } catch (EOFException exception) {
                        System.out.println("client closed connection");
                        break;
                    }
                }

                System.out.println("server finished work");

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
