package searching;

public class BubbleSort {

    public void sort(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for(int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]){
                    swap(arr, i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
