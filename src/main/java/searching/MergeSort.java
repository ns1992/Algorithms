package searching;

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


        int remaining = middle - hL;
        for(int i = 0; i <= remaining; i++) {
            array[current + i] = helper[hL + i];
        }
    }
}
