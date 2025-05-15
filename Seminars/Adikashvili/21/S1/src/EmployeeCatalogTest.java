import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeCatalogTest {

    private static EmployeeCatalog catalog;

    @BeforeAll
    public static void setUp() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("a", "b0", Department.INFRASTRUCTURE, 1100));
        for (int i = 1; i <= 10; i++) {
            employees.add(new Employee("a", "b" + i, Department.INFRASTRUCTURE,
                    new Random().nextInt(1000) + 100));
        }
        employees.add(new Employee("a", "b0", Department.INFRASTRUCTURE, 100));

        employees.add(new Employee("giorgi", "pirveli", Department.HR, 2000));
        employees.add(new Employee("giorgi", "mesame", Department.HR, 0));
        employees.add(new Employee("giorgi", "meore", Department.IT, 20000));

        catalog = new EmployeeCatalog(employees);
    }

    @Test
    public void testFindEmployeeWithHighestSalary() {
        assertEquals("meore", catalog.findEmployeeWithHighestSalary().getLastName());
    }

    @Test
    public void testGetSalaryGapInDepartment() {
        assertEquals(1000, catalog.getSalaryGapInDepartment(Department.INFRASTRUCTURE));
    }

    @Test
    public void testGetSalaryGapInDepartment2() {
        assertEquals(0, catalog.getSalaryGapInDepartment(Department.IT));
    }

    @Test
    public void testFindDepartmentWithHighestCumulativeSalary() {
        assertEquals(Department.IT, catalog.findDepartmentWithHighestCumulativeSalary());
    }
}
