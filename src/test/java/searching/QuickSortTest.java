package searching;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSortTest {

    private final QuickSort quickSort = new QuickSort();

    @Test
    public void testSort_whenMixed_ReturnsSorted() {
        int[] input = new int[]{10, 2, 99, 6, 3, 54};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 3, 6, 10, 54, 99}), Arrays.toString(input));
    }

    @Test
    public void testSort_whenContainsEqualElements_ReturnsSorted() {
        int[] input = new int[]{10, 2, 99, 6, 3, 99, 54};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 3, 6, 10, 54, 99, 99}), Arrays.toString(input));
    }

    @Test
    public void testSort_whenContainsContiguousEqualElements_ReturnsSorted() {
        int[] input = new int[]{10, 2, 99, 99, 6, 3, 54};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 3, 6, 10, 54, 99, 99}), Arrays.toString(input));
    }

    @Test
    public void testSort_whenEmpty_ReturnsEmpty() {
        int[] input = new int[]{};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{}), Arrays.toString(input));
    }

    @Test
    public void testSort_whenAscending_ReturnsAscending() {
        int[] input = new int[]{1, 10, 20, 90, 100};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{1, 10, 20, 90, 100}), Arrays.toString(input));
    }

    @Test
    public void testSort_whenDescending_ReturnsAscending() {
        int[] input = new int[]{100, 90, 20, 5, 3};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{3, 5, 20, 90, 100}), Arrays.toString(input));
    }

    @Test
    public void testSort_whenInputNegative_ReturnsSort() {
        int[] input = new int[]{10, 2, 99, 6, 3, 54, -1};
        quickSort.sort(input);

        assertEquals(Arrays.toString(new int[]{-1, 2, 3, 6, 10, 54, 99}), Arrays.toString(input));
    }
}