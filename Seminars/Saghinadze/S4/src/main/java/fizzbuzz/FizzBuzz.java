package fizzbuzz;

public final class FizzBuzz {

    public static String Evaluate(int num) {
        String numS = String.valueOf(num);

        if (num % 15 == 0 || numS.contains("5") && numS.contains("3")) {
            return "FizzBuzz";
        }

        if (num % 3 == 0 || numS.contains("3")) {
            return "Fizz";
        }

        if (num % 5 == 0 || numS.contains("5")) {
            return "Buzz";
        }

        return numS;

    }
}
