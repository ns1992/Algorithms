package utils;

public final class SearchUtils {

    private SearchUtils() {
        // Private constructor to enforce utility status
    }

    public static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
