package filter;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class FilterBuilder {

    public static Filter build(HttpServletRequest request) {
        Enumeration<String> params = request.getParameterNames();

        AndFilter filter = new AndFilter();

        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            String value = request.getParameter(paramName);

            if (paramName.equals("first-name")) {
                filter.addFilter(new FirstNameFilter(value));
            } else if (paramName.equals("last-name")) {
                filter.addFilter(new LastNameFilter(value));
            }
        }

        return filter;
    }
}
