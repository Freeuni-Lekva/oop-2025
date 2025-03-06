public class RomanNumeral {

    private static final int MIN = 1;
    private static final int MAX = 3999;

    private static final int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private int arabicNumber;

    /**
     * Saves arabic number
     *
     * @param arabicNumber
     * @throws IllegalArgumentException
     */
    public RomanNumeral(int arabicNumber) {
        if (arabicNumber < MIN || arabicNumber > MAX) {
            throw new IllegalArgumentException("Roman number is out of range");
        }
        this.arabicNumber = arabicNumber;
    }

    /**
     * @param romanNumber
     * @throws IllegalArgumentException when roman number is illegal
     */
    public RomanNumeral(String romanNumber) {
        if (!romanNumber.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            throw new IllegalArgumentException("Illegal roman number");
        }

        int result = 0;

        for (int i = 0; i < romanNumber.length(); i++) {
            if (i == romanNumber.length() - 1) {
                result += charToInt(romanNumber.charAt(i));
                break;
            }
            int curSymbol = charToInt(romanNumber.charAt(i));
            int nextSymbol = charToInt(romanNumber.charAt(i + 1));

            result += curSymbol < nextSymbol ? -curSymbol : curSymbol;
        }

        this.arabicNumber = result;
    }

    public String toString() {
        String result = "";

        int tmp = this.arabicNumber;

        for (int i = 0; i < numbers.length; i++) {
            while (tmp >= numbers[i]) {
                tmp -= numbers[i];
                result += symbols[i];
            }
        }

        return result;
    }

    public int toInt() {
        return this.arabicNumber;
    }

    // XL
    // 95 --> L XL V
    private int charToInt(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new RuntimeException("Illegal number");
        }
    }
}
