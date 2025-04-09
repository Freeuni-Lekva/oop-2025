package dao;

import model.Student;
import util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudentsWithCourses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }
}

