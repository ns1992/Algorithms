package problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfRomanNumeralCalculatorTest {
    SumOfRomanNumeralCalculator underTest = new SumOfRomanNumeralCalculator();

    @Test
    public void test() {
        int value = underTest.calculate("III");
        assertEquals(3, value);

        value = underTest.calculate("XIV");
        assertEquals(14, value);

        value = underTest.calculate("LVIII");
        assertEquals(58, value);

        value = underTest.calculate("MCMXCIV");
        assertEquals(1994, value);
    }
}