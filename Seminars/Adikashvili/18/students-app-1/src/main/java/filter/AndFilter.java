package filter;

import bean.Student;

import java.util.ArrayList;
import java.util.List;

public class AndFilter implements Filter {

    private final List<Filter> filters;

    public AndFilter() {
        this.filters = new ArrayList<>();
    }

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    @Override
    public boolean filter(Student student) {
        for (Filter filter : filters) {
            if (!filter.filter(student)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < filters.size(); i++) {
            if (i > 0) {
                result.append(" AND ");
            }
            result.append("(").append(filters.get(i).toString()).append(")");
        }

        return result.toString().isEmpty() ? "true" : result.toString();
    }
}
