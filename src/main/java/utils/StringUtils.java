package utils;

import java.util.*;
import java.util.stream.Collectors;

public class StringUtils {

    public static int countChars(final String input, final Character toCount) {
        final char[] chars = input.toCharArray();

        final List<Character> inputAsCharArr = new ArrayList<>();

        for(int i = 0; i < chars.length; i++) {
            inputAsCharArr.add(chars[i]);
        }

        final Map<Character, List<Character>> countMap = inputAsCharArr.stream()
                .collect(Collectors.groupingBy(character -> character));

        final List<Character> groupedByChar = Optional.ofNullable(countMap.get(toCount)).orElse(Collections.emptyList());

        return groupedByChar.size();
    }

    public static boolean endsWith(final String input, final String endingPattern) {
        final int inputLength = input.length();
        final int endingLength = endingPattern.length();
        return endingPattern.equals(input.substring(inputLength - endingLength));
    }

    public static boolean containsSameChars(final String inputA, final String inputB) {
        if(inputA.length() == inputB.length()) {
            final char[] inputAChars = inputA.toCharArray();
            final char[] inputBChars = inputB.toCharArray();
            Arrays.sort(inputAChars);
            Arrays.sort(inputBChars);
            return Arrays.equals(inputAChars, inputBChars);
        } else {
            return false;
        }
    }

    public static boolean isPalindrome(final String inputA) {
        return inputA.equals(new StringBuilder(inputA).reverse().toString());
    }


    public static String fizzBuzz(final int input) {
        if(input % 15 == 0) {
            return "FizzBuzz";
        } else if( input % 3 == 0) {
            return "Fizz";
        } else if(input % 5 == 0){
            return "Buzz";
        }

        return String.valueOf(input);
    }

    public static boolean isPalindrome2(final char[] input) {
        int helperLeft = 0;
        int helperRight = input.length - 1;

        while (helperLeft < helperRight) {
            if(input[helperLeft] != input[helperRight]) {
                return false;
            }
            helperLeft++;
            helperRight--;
        }
        return true;
    }
}
