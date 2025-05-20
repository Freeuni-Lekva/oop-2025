import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.lang.reflect.Method;

public class TestRunner {

    private static void runTests(Class<?>... tests) {
        int totalTests = 0, passed = 0, failed = 0;

        for (Class<?> test : tests) {
            try {
                Object testInstance = test.newInstance(); // test instance
                List<Method> beforeEachMethods = findBeforeEachMethods(test);

                List<Integer> statistics = runTestCases(testInstance, beforeEachMethods);
                totalTests += statistics.get(0);
                passed += statistics.get(1);
                failed += statistics.get(2);

            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println("Couldn't run tests in " + test.getName());
            }
        }

        System.out.printf("Summary: %d tests run. %d passed, %d failed", totalTests, passed, failed);
    }

    private static List<Method> findBeforeEachMethods(Class<?> testClass) {
        List<Method> beforeEachMethods = new ArrayList<>();

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeEach.class)) {
                beforeEachMethods.add(method);
            }
        }

        return beforeEachMethods;
    }

    private static List<Integer> runTestCases(Object testInstace, List<Method> beforeEachMethods) {
        int totalTests = 0, passed = 0, failed = 0;

        for (Method testMethod : testInstace.getClass().getDeclaredMethods()) {
            if (testMethod.isAnnotationPresent(TestCase.class)) { // found test case
                totalTests++;

                try {
                    // run before each methods
                    for (Method beforeEachMethod : beforeEachMethods) {
                        beforeEachMethod.invoke(testInstace);
                    }

                    testMethod.invoke(testInstace);
                    System.out.println("passed: " + testMethod.getName());
                    passed++;
                } catch (Exception e) {
                    System.out.println("failed: " + testMethod.getName() + ", " + e.getCause().getMessage());
                    failed++;
                }
            }
        }

        return Arrays.asList(totalTests, passed, failed);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?>[] classes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            classes[i] = Class.forName(args[i]);
        }

        runTests(classes);
    }
}
