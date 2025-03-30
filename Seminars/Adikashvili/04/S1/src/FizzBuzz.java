public class FizzBuzz {

    public String evaluate(int i) {
        if (i % 15 == 0 || (containsDigit(i, 3) && containsDigit(i, 5))) {
            return "FizzBuzz";
        }
        if (i % 3 == 0 || containsDigit(i, 3)) {
            return "Fizz";
        }
        if (i % 5 == 0 || containsDigit(i, 5)) {
            return "Buzz";
        }
        return String.valueOf(i);
    }

    private boolean containsDigit(int i, int digit) {
        return String.valueOf(i).indexOf((char)(digit + '0')) != -1;
    }
}
