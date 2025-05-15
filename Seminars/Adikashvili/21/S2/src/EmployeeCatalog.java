import javafx.util.Pair;

import java.util.*;

public class EmployeeCatalog {

    private final List<Employee> employees;

    public EmployeeCatalog(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee findEmployeeWithHighestSalary() {
        return employees
                .stream()
                .reduce((current, next) -> current.getSalary() > next.getSalary() ? current : next)
                .orElseThrow(() -> new NoSuchElementException("No employee found"));
    }

    public int getSalaryGapInDepartment(Department department) {
        Pair<Integer, Integer> maxMin = employees
                .stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .map(employee -> new Pair<>(employee.getSalary(), employee.getSalary()))
                .reduce(new Pair<>(Integer.MIN_VALUE, Integer.MAX_VALUE),
                        (curr, next) -> new Pair<>(
                                Math.max(curr.getKey(), next.getKey()),
                                Math.min(curr.getValue(), next.getValue()))
                );
        return maxMin.getKey() - maxMin.getValue();
    }

    public Department findDepartmentWithHighestCumulativeSalary() {
        return employees
                .stream()
                .map(employee -> {
                    Map<Department, Integer> map = new HashMap<>();
                    map.put(employee.getDepartment(), employee.getSalary());
                    return map;
                })
                .reduce(new HashMap<>(), (curr, next) -> {
                    Map<Department, Integer> map = new HashMap<>(curr);

                    Map.Entry<Department, Integer> entry = next.entrySet().iterator().next();

                    if (map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue() + map.get(entry.getKey()));
                    } else {
                        map.put(entry.getKey(), entry.getValue());
                    }
                    return map;
                })
                .entrySet()
                .stream()
                .reduce((curr, next) -> curr.getValue() > next.getValue() ? curr : next)
                .get()
                .getKey();
    }
}
