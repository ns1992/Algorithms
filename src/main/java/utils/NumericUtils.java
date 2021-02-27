package utils;

import java.util.HashMap;

public class NumericUtils {

    public static int reverseBasicInt(int x) {
        int rev = 0;
        while (x != 0) {
            // Pop last digit from the input
            int pop = x % 10;
            x /= 10;


            // Check for overflow
            // 1) Has room for another digit
            // 2) If so - able to append pop value to max / min
            //            (Max signed int == 2^32/2 = 2,147,483,648 = (-1 to account for 0) 2,147,483,647
            //            (Min signed int == 2^32/2 = -2,147,483,648
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            // Push the pop to the reverse as the last digit
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int reverseBasicAPIInt(int x) {
        final String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    public static double getMedian(final int[] arrayOne, final int[] arrayTwo) {
        final int[] helper = new int[arrayOne.length + arrayTwo.length];
        int currentOne = 0;
        int currentTwo = 0;
        int current = 0;

        while (currentOne < arrayOne.length && currentTwo < arrayTwo.length) {
            if(arrayOne[currentOne] < arrayTwo[currentTwo]) {
                helper[current] = arrayOne[currentOne];
                currentOne++;
            } else {
                helper[current] = arrayTwo[currentTwo];
                currentTwo++;
            }
            current++;
        }

        // Find and sort remainders
        int remainderStartIndex = 0;
        int[] remainderArray;
        if (currentOne == arrayOne.length) {
            remainderStartIndex = currentTwo;
            remainderArray = arrayTwo;
        } else {
            remainderStartIndex = currentOne;
            remainderArray = arrayOne;
        }

        final int remainder = remainderArray.length - remainderStartIndex;
        for(int i = 0; i < remainder; i++ ) {
            helper[current + i] = remainderArray[remainderStartIndex + i];
        }

        if(helper.length % 2 == 0) {
            final int middleIndex = (helper.length - 1) / 2;
            final int middleValueLower = helper[middleIndex];
            final int middleValueHigher = helper[middleIndex + 1];
            final double middleDiff = (middleValueHigher - middleValueLower) / 2.0;
            return middleValueLower + middleDiff;
        } else {
            final int middleIndex = helper.length / 2;
            return helper[middleIndex];
        }
    }


    // On^2

    /**
     * 'twoSum' problem
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     *
     * Brute force solution is O(n^2) time and O(n) space
     *
     * Since there are O(n^2) possible pairs, this takes O(n^2) time in the worst case.
     * This solution uses only O(1) space, since no auxiliary structures are created.
     *
     * @param input input elements
     * @param target target sum
     * @return indices of the two numbers such that they add up to target.
     */
    public static int[] twoSumBrute(final int[] input, final int target) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (target == input[i] + input[j]) {
                    return new int[]{i, j};
                }
            }
        }

        // no solution
        return new int[]{};
    }

    /**
     * Uses a hashmap to achieve O(n) time and space
     *
     * Time O(n): We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
     * Space complexity  O(n): The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
     *
     * @param input input elements
     * @param target target sum
     * @return indices of the two numbers such that they add up to target.
     */
    public static int[] twoSumHash(final int[] input, final int target) {
        final HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            final int complement = target - input[i];
            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            }
            indexMap.put(input[i], i);
        }

        // no solution
        return new int[]{};
    }
}