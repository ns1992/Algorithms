package searching;

import utils.SearchUtils;

/**
 * Quick Sort is a divide and conquer algorithm that involves picking an element to be
 * the pivot and partitioning the array so all the elements on one side are less than the pivot
 * and on the right are greater than it. It performs this recursively to sort the entire array.
 * <p>
 * In contrast to Merge sort, Quick Sort is an in-place sort so has a space complexity of O(1).
 * It also does not fully sort each sub-array. Merge sort will have a sub-array
 * of {1,2,3,4,5,6} whereas Quick sort may have (pivot of 4) {3,1,2,4,6,5}.
 * <p>
 * This property also means it is not a stable sort as elements can move once the sub-arrays are
 * stitched back together.
 * <p>
 * Space: O(1)
 * Average Case: O(nlogn)
 * Worst Case: O(n^2)
 * <p>
 * This version of QuickSort picks the pivot at the end of the array for simplicity's sake.
 */
public class QuickSortImplv2 implements QuickSort {

    @Override
    public void sort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    private void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partition = partition(arr, begin, end);

            // Once the partition is found, sort the array below and above that point - divide and conquer
            quickSort(arr, begin, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        // i is tracking where the final partition position will be
        // while j is incrementing through the entire array
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                SearchUtils.swap(arr, i, j);
            }
        }

        int finalPartition = i + 1;
        SearchUtils.swap(arr, finalPartition, end);
        return finalPartition;
    }

}
