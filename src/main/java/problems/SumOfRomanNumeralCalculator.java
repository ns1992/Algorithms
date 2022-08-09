package problems;

/**
 * Given a roman numeral, convert it to an integer.
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class SumOfRomanNumeralCalculator {

    private enum RomanNumeral {
        I(1, 'I'),
        V(5, 'V'),
        X(10, 'X'),
        L(50, 'L'),
        C(100, 'C'),
        D(500, 'D'),
        M(1000, 'M');

        private final int value;
        private final char charValue;

        RomanNumeral(int intValue, char charValue) {
            this.value = intValue;
            this.charValue = charValue;
        }

        public static RomanNumeral valueOf(char c) {
            RomanNumeral[] values = RomanNumeral.values();
            for (RomanNumeral romanNumeral : values) {
                if (romanNumeral.charValue == c) {
                    return romanNumeral;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public int calculate(String romanNumeral) {
        int sum = 0;
        char[] chars = romanNumeral.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int thisNumeralValue = RomanNumeral.valueOf(chars[i]).value;
            int nextNumeralValue = 0;

            if (i + 1 < chars.length) {
                nextNumeralValue = RomanNumeral.valueOf(chars[i + 1]).value;
            }

            // If the next char is greater than the current character, then subtract the current character from the total
            if (nextNumeralValue > thisNumeralValue) {
                sum += nextNumeralValue - thisNumeralValue;
                i++; // Additional increment as we have processed two characters
            } else {
                sum += thisNumeralValue;
            }
        }

        return sum;
    }
}
