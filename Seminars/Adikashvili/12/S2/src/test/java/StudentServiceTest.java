import dao.StudentDAO;
import dto.StudentDTO;
import entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    private StudentDAO dao;

    private StudentService service;

    @BeforeEach
    public void setUp() {
        dao = mock(StudentDAO.class);
        when(dao.getByStudentId(1)).thenReturn(new Student("shota", "gvinepadze"));

        service = new StudentService(dao);
    }

    @Test
    public void testGetById() {
        StudentDTO student = service.getStudentById(1);
        verify(dao, times(1)).getByStudentId(1);
        assertEquals("gvinepadze", student.getLastName());
    }
}
