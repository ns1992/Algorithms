package searching;

import static searching.utils.SearchUtils.swap;

public class SelectionSort {

    public void sort(final int[] array) {
        int min;
        for(int i =0; i < array.length; i++) {
            min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }
}
