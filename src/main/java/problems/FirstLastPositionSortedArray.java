package problems;

import java.util.Map;
import java.util.Map.Entry;

public class FirstLastPositionSortedArray {


    /**
     * O(n) average and worst case
     *
     * Can be improved by implementing a bounded binary search which would give us O(logN)
     */
    public Entry<Integer, Integer> findFirstAndLastIndexOfTarget(Integer[] input, int target) {
        int firstIndex = -1;
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals(target)) {
                firstIndex = firstIndex == -1 ? i : firstIndex;
                count++;
            }
        }

        int lastIndex = firstIndex + count - 1;
        return Map.entry(firstIndex, count <= 0 ? -1 : lastIndex);
    }
}
