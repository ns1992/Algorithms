package searching;

/**
 * The time complexity for Merge sort is O(nlogn) which makes it an efficient algorithm for large datasets.
 * However, the space complexity is O(n) which means it is not the most *memory* efficient for large datasets.
 *
 * Merge sort is also a stable sort (the order of equal elements in the initial input will be preserved).
 *
 *
 * Space: O(n)
 * Best Case: O(nlogn)
 * Average Case: O(nlogn)
 * Worst Case: O(nlogn)
 */
public class MergeSort {


    public void sort(final int[] array) {
        final int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private void mergeSort(final int[] array, final int[] helper, final int low, final int high) {
        if(low < high) {
            final int middle = low + (high - low)/2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    public void merge(final int[] array, final int[] helper, final int low, final int middle, final int high) {
        for(int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int hL = low;
        int hR = middle + 1;
        int current = low;

        while (hL <= middle && hR <= high) {
            if(helper[hL] <= helper[hR]) {
                array[current] = helper[hL];
                hL++;
            } else {
                array[current] = helper[hR];
                hR++;
            }
            current++;
        }


        // Copy the remaining elements
        // Firstly remember that at this point both halves of the array are fully sorted within their own halves.
        // ~~ We have just been choosing which from the left vs the right is smaller to fill the target array.
        // Secondly, remember that we are sorting in place; the helper array is a copy of the target array.
        // Thirdly, an array is sorted in ascending order and filled from 'front' to 'back'.
        //
        // Easiest way to envision why this is needed is to:-
        // 1. Picture every element on the right side of the helper array being less than every element on the left.
        // ~~ In this case, we overwrite the left half of the target array with the right half of the helper array.
        // Then, we have to fill the rest of the target array up with the remaining left half of the helper array.
        //
        // 2. Picture the opposite; every element on the right side of the helper array being greater than the left half.
        // ~~ In this case, all the left elements will be copied to the target array.
        // But as we are sorting in place, all the right elements are already present in order in the target array.
        // Remember the right half will be sorted! So no need for any 'remaining' copies
        int remaining = middle - hL;
        for(int i = 0; i <= remaining; i++) {
            array[current + i] = helper[hL + i];
        }
    }
}
