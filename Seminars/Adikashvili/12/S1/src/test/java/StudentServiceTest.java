import dao.StudentDAO;
import entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    private StudentDAO mockDao;

    private StudentService service;

    @BeforeEach
    public void setUp() {
        mockDao = mock(StudentDAO.class);
        service = new StudentService(mockDao);

        when(mockDao.getStudentById(1)).thenReturn(new Student("Alice", "A"));
    }

    @Test
    public void testGetById() {
        assertEquals("Alice", service.getStudentById(1).getFirstName());
        verify(mockDao, times(1)).getStudentById(1);
    }
}
