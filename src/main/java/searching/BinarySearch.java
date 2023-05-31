package searching;

public class BinarySearch {

    public int search(int[] input, int target) {
        return search(input, target, 0, input.length - 1);
    }

    private int search(int[] input, int target, int min, int max) {
        if (max < min) {
            return -1;
        }

        int half = min + (max - min) / 2;
        if (input[half] == target) {
            return half;
        } else if (input[half] > target) { // Search left
            return search(input, target, min, half - 1);
        } else { // Search right
            return search(input, target, half + 1, max);
        }
    }
}
