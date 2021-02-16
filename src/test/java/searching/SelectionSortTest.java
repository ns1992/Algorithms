package searching;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {
    private final SelectionSort selectionSort = new SelectionSort();

    @Test
    public void testSort_whenMixed_ReturnsSorted() {
        int[] input = new int[]{50, 2, 5, 45, 6};
        selectionSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 5, 6, 45, 50}), Arrays.toString(input));
    }

    @Test
    public void testSort_whenEmpty_ReturnsEmpty() {
        int[] input = new int[]{};
        selectionSort.sort(input);

        assertEquals(Arrays.toString(new int[]{}), Arrays.toString(input));
    }


    @Test
    public void testSort_whenAscending_ReturnsAscending() {
        int[] input = new int[]{2, 5, 6, 45, 50};
        selectionSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 5, 6, 45, 50}), Arrays.toString(input));
    }

    @Test
    public void testSort_whenDescending_ReturnsDecending() {
        int[] input = new int[]{50, 45, 6, 5, 2};
        selectionSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 5, 6, 45, 50}), Arrays.toString(input));
    }


    @Test
    public void testSort_whenContainsEqualElements_ReturnsSorted() {
        int[] input = new int[]{50, 2, 5, 45, 6, 5};
        selectionSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 5, 5, 6, 45, 50}), Arrays.toString(input));
    }

    @Test
    public void testSort_whenContainsContiguousEqualElements_ReturnsSorted() {
        int[] input = new int[]{50, 2, 5, 5, 45, 6};
        selectionSort.sort(input);

        assertEquals(Arrays.toString(new int[]{2, 5, 5, 6, 45, 50}), Arrays.toString(input));
    }

    @Test
    public void testSort_whenInputNegative_ReturnsSort() {
        int[] input = new int[]{10, 2, 99, 6, 3, 54, -1};
        selectionSort.sort(input);

        assertEquals(Arrays.toString(new int[]{-1, 2, 3, 6, 10, 54, 99}), Arrays.toString(input));
    }
}