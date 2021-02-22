package utils;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumericUtilsTest {

    @Test
    public void testReverseInt() {

        Function<Integer, Integer> basicTest = NumericUtils::reverseBasicInt;
        reverseIntTests(basicTest);

        Function<Integer, Integer> apiTest = NumericUtils::reverseBasicAPIInt;
        reverseIntTests(apiTest);
    }

    private void reverseIntTests(final Function<Integer, Integer> toTest) {
        assertEquals(123, toTest.apply(321));
        assertEquals(-123, toTest.apply(-321));

        assertEquals(0, toTest.apply(0));
        assertEquals( 0, toTest.apply(Integer.MAX_VALUE));
        assertEquals(0, toTest.apply(Integer.MIN_VALUE));


        // Max limits
        assertEquals(2147483641, toTest.apply(1463847412));
        assertEquals(1463847412, toTest.apply(2147483641));

        // Min limits
        assertEquals(-2147483641, toTest.apply(-1463847412));
        assertEquals(-1463847412, toTest.apply(-2147483641));
    }

}