package searching;

import static utils.SearchUtils.swap;

public class QuickSortImpl implements QuickSort {

    public void sort(int[] array) {
        if (array.length > 0) {
            sort(array, 0, array.length - 1);
        }
    }

    public void sort(int[] array, int left, int right) {
        int index = partition(array, left, right);

        if (left < index - 1) { //sort left half
            sort(array, left, index - 1);
        }

        if (index < right) { //sort right half
            sort(array, index, right);
        }
    }


    private int partition(int[] array, int left, int right) {
        int pivot = array[left + (right - left) / 2];
        while (left <= right) {
            //Find left element that should be right
            while (array[left] < pivot) left++;

            //Find right element that should be left
            while (array[right] > pivot) right--;

            //Swap and move left/right indices
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}
