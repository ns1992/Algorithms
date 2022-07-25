package problems;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstLastPositionSortedArrayTest {

    public static final FirstLastPositionSortedArray UNDER_TEST = new FirstLastPositionSortedArray();

    @Test
    public void whenTargetPresent_returnsTargetIndexRange() {
        Integer[] input = new Integer[]{5, 7, 7, 8, 8, 10};

        Map.Entry<Integer, Integer> result = UNDER_TEST.findFirstAndLastIndexOfTarget(input, 8);
        assertEquals(3, result.getKey());
        assertEquals(4, result.getValue());
    }

    @Test
    public void whenTargetNotPresent_returnsErrorValues() {
        Integer[] input = new Integer[]{5, 7, 7, 8, 8, 10};

        Map.Entry<Integer, Integer> result = UNDER_TEST.findFirstAndLastIndexOfTarget(input, 6);
        assertEquals(-1, result.getKey());
        assertEquals(-1, result.getValue());
    }

    @Test
    public void whenArrayEmpty_returnsErrorValues() {
        Integer[] input = new Integer[]{};

        Map.Entry<Integer, Integer> result = UNDER_TEST.findFirstAndLastIndexOfTarget(input, 6);
        assertEquals(-1, result.getKey());
        assertEquals(-1, result.getValue());
    }
}