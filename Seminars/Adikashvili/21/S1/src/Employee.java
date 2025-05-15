public class Employee {

    private final String firstName;

    private final String lastName;

    private final Department department;

    private final int salary;

    public Employee(String firstName, String lastName, Department department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}
