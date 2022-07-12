package searching;

import utils.SearchUtils;

/**
 * Selection sort traverses the array, noting the smallest element
 * Once it has finished traversing it moves the smallest element to the sorted section of the array
 * It increments the size of the sorted section and then repeats this until the array is sorted
 *
 * Space: O(1)
 * Best Case: O(n^2)
 * Average Case: O(n^2)
 * Worst Case: O(n^2)
 */
public class SelectionSort {

    public void sort(final int[] array) {
        int minIndex;
        for(int i = 0; i < array.length; i++) {
            minIndex = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            SearchUtils.swap(array, i, minIndex);
        }
    }
}
