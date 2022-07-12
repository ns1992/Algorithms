package searching;

import static utils.SearchUtils.swap;

/**
 * The basic idea of Bubble sort is to
 * Move through the array examining neighbouring values and swapping them if required
 * Repeat for all elements of the array and repeat until no swaps are required
 *
 * It is a stable sorting algorithm
 *
 * Space: O(1)
 * Best Case: O(n^2)
 * Average Case: O(n^2)
 * Worst Case: O(n^2)
 */
public class BubbleSort {

    public void sort(final int[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }
    }
}
