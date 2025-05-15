import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class EmployeeCatalog {


    private List<Employee> employees;

    public EmployeeCatalog(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee findEmployeeWithHighestSalary() {
        return employees.stream().reduce((current, next) -> {
            if (current.getSalary() > next.getSalary()) {
                return current;
            }
            return next;
        }).orElseThrow(() -> new NoSuchElementException("Employee not found"));
    }

    public int getSalaryGapInDepartment(Department department) {
        Pair<Integer, Integer> gap = employees
                .stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .map(employee -> new Pair<>(employee.getSalary(), employee.getSalary()))
                .reduce(new Pair<>(Integer.MIN_VALUE, Integer.MAX_VALUE),
                        (current, next) -> new Pair<>(
                                Math.max(current.getKey(), next.getKey()),
                                Math.min(current.getValue(), next.getValue())));

        return gap.getKey() - gap.getValue();
    }

    public Department findDepartmentWithHighestCumulativeSalary() {
        Map<Department, Integer> departmentMap = employees
                .stream()
                .map(employee -> {
                    Map<Department, Integer> map = new HashMap<>();
                    map.put(employee.getDepartment(), employee.getSalary());
                    return map;
                })
                .reduce(new HashMap<>(), (curr, next) -> {
                    Map<Department, Integer> map = new HashMap<>(curr);
                    for (Map.Entry<Department, Integer> departmentIntegerEntry : next.entrySet()) {
                        Department dep = departmentIntegerEntry.getKey();
                        map.putIfAbsent(dep, 0);
                        map.put(dep, map.get(dep) + departmentIntegerEntry.getValue());
                    }
                    return map;
                });

        return departmentMap
                .entrySet()
                .stream()
                .reduce((curr, next) -> curr.getValue() > next.getValue() ? curr : next).get().getKey();
    }

}
