import java.util.HashMap;

public class RomanToNumeral {
    private final static int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private int arabicNumber;
    private static final HashMap<String, Integer> letterToNumber;

    static {

        letterToNumber = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            letterToNumber.put(letters[i], numbers[i]);
        }
    }


    RomanToNumeral(int arabicNumber) {
        if (arabicNumber < 1 || arabicNumber > 3999) {
            throw new NumberFormatException("Roman numeral must be in range: [1, 3999]");
        }
        this.arabicNumber = arabicNumber;
    }
    RomanToNumeral(String romanNumber) {
        arabicNumber = 0;
        for (int i = 0; i < romanNumber.length(); i++) {

            int currNumber = stringToNumber(String.valueOf(romanNumber.charAt(i)));
            if (i == romanNumber.length() - 1) {
                arabicNumber += currNumber;
                break;
            }

            int nextNumber = stringToNumber(String.valueOf(romanNumber.charAt(i + 1)));

            if (currNumber >= nextNumber) {
                arabicNumber += currNumber;
            } else {
                arabicNumber -= currNumber;
            }
        }

        if (arabicNumber > 3999) {
            throw new NumberFormatException("Roman numeral must be in range: [1, 3999]");
        }
    }

    String toRoman() {
        int currArabic = arabicNumber;
        String result = "";
        for (int i = 0; i < letters.length; i++) {
            while (currArabic >= numbers[i]) {
                currArabic -= numbers[i];
                result += letters[i];
            }
        }

        return result;
    }

    int toArabic() {
        return arabicNumber;
    }

    int stringToNumber(String s) {
        if (!letterToNumber.containsKey(s)) {
            throw new NumberFormatException("Illegal character in Roman numeral: " + s);
        }

        return letterToNumber.get(s);
    }

}
