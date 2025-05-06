package filter;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class FilterBuilder {

    public static Filter build(HttpServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();

        AndFilter andFilter = new AndFilter();

        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();
            String value = request.getParameter(name);

            switch (name) {
                case "first-name":
                    andFilter.addFilter(new FirstNameFilter(value));
                case "last-name":
                    andFilter.addFilter(new LastNameFilter(value));
            }
        }

        return andFilter;
    }
}
