package searching;

import static utils.SearchUtils.swap;

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
