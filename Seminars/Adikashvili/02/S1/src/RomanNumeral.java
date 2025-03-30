
public class RomanNumeral {
    private static final int MIN_LIMIT = 1;
    private static final int MAX_LIMIT = 3999;
    private static final int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private int arabicNumber;

    /**
     * @param arabicNumber
     * @throws IllegalArgumentException
     */
    public RomanNumeral(int arabicNumber) {
        if (arabicNumber < MIN_LIMIT || arabicNumber > MAX_LIMIT) {
            throw new IllegalArgumentException("arabic number is out of range");
        }
        this.arabicNumber = arabicNumber;
    }

    /**
     * @param romanNumber
     * @throws IllegalArgumentException when roman number is wrong
     */
    public RomanNumeral(String romanNumber) {
        if (!romanNumber.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            throw new IllegalArgumentException("Illegal roman number");
        }

        String str = romanNumber + 'I';

        int result = 0; // final arabic number

        for (int i = 0; i < str.length() - 1; i++) {
            int currSymbolNumber = symbolToInt(str.charAt(i));
            int nextSymbolNumber = symbolToInt(str.charAt(i + 1));

            result += currSymbolNumber >= nextSymbolNumber ? currSymbolNumber : -currSymbolNumber;
        }

        this.arabicNumber = result;
    }

    /**
     *
     * @return int arabic number
     */
    public int toInt() {
        return this.arabicNumber;
    }

    @Override
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

    private int symbolToInt(char symbol) {
        switch (symbol) {
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
                throw new RuntimeException("Wrong symbol");
        }
    }
}
