package filter;

import table.Student;

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
}
