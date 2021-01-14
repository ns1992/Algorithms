package searching;

public class SelectionSort {

    public void sort(int[] array) {

        for(int i = 0; i < array.length; i++) {
            int min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }

            swap(array, min, i);
        }
    }


    private void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
