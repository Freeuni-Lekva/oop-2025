import bean.Student;
import dao.StudentDao;
import dao.StudentDaoImpl;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private final int port;

    private final StudentDao studentDao;

    public Server(int port) {
        this.port = port;
        this.studentDao = new StudentDaoImpl();
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();

            handleRequest(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleRequest(Socket socket) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            while (true) {
                try {
                    Command command = (Command) in.readObject();
                    System.out.println("command: " + command);

                    switch (command) {
                        case CREATE_STUDENT:
                            Student student = (Student) in.readObject();
                            studentDao.addStudent(student);
                            System.out.println("added new student.");
                            break;
                        case GET_STUDENT:
                            int id = (int) in.readObject();
                            out.writeObject(studentDao.getStudentById(id));
                            break;
                    }
                } catch (EOFException eofException) {
                    System.out.println("client closed connection");
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
