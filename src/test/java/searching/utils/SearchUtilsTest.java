package searching.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SearchUtilsTest {

    @Test
    public void testSwap() {
        int[] input = new int[]{5, 6, 2, 1, 8};

        SearchUtils.swap(input, 0, 3);
        assertEquals(Arrays.toString(new int[]{1, 6, 2, 5, 8}), Arrays.toString(input));

        SearchUtils.swap(input, 0, 3);
        assertEquals(Arrays.toString(new int[]{5, 6, 2, 1, 8}), Arrays.toString(input));

        SearchUtils.swap(input, 4, 2);
        assertEquals(Arrays.toString(new int[]{5, 6, 8, 1, 2}), Arrays.toString(input));
    }

}