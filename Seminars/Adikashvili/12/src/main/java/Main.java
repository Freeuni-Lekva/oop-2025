import dao.StudentDAO;
import entity.Student;

public class Main {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentById(1);
        System.out.println(student);
    }
}
