
import model.Course;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Build a SessionFactory from hibernate.cfg.xml
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Retrieve all Student entities
        List<Student> students = session.createQuery("from Student", Student.class).list();

        for (Student s : students) {
            System.out.println("Student: " + s.getFirstName() + " " + s.getLastName());
            System.out.println("ID Number: " + s.getIdNumber());
            System.out.println("Registration Date: " + s.getRegistrationDate());

            // Print each course the student is enrolled in
            for (Course course : s.getCourses()) {
                System.out.println("  Course: " + course.getCourseName() +
                        " | Credit: " + course.getCourseCredit() +
                        " | Type: " + course.getCourseType());
            }
            System.out.println("--------------");
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
