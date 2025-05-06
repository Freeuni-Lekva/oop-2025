package filter;

import com.example.Student;

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
        StringBuilder condition = new StringBuilder();

        for (int i = 0; i < filters.size(); i++) {
            if (i > 0) {
                condition.append(" AND ");
            }
            condition.append("(").append(filters.get(i).toString()).append(")");
        }

        String result = condition.toString();
        return result.isEmpty() ? "true" : result;
    }
}
