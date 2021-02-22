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


    public static String longestPalindromaticString(final String input) {
        for (int substringLength = input.length(); substringLength >= 0; substringLength--) {

            // 'Slide' the substring over the input string, halting if you run off the end
            for (int i = 0; i < input.length(); i++) {
                int substringEndIndex = i + substringLength;
                if (substringEndIndex > input.length()) {
                    // run off detected - move to the next substring
                    break;
                } else {
                    // If this substring is a palindrome it will be the largest found
                    // Else we need to continue searching...
                    final String substring = input.substring(i, substringEndIndex);
                    if (isPalindrome(substring)) return substring;
                }
            }
        }


        // No palindromes found
        return "";
    }


    public static Map.Entry<Integer, String> longestRepeatingSubstring(final String input) {

        final ArrayList<Character> chars = new ArrayList<>();
        final char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            chars.add(charArray[i]);
        }

        final HashMap<Integer, String> substringMap = new HashMap<>();
        final HashSet<Character> substringChars = new HashSet<>();

        final StringBuilder stringBuilder = new StringBuilder();
        Character currentChar;
        String substring;
        for (int i = 0; i < chars.size(); i++) {
            for (int j = i; j < chars.size(); j++) {
                currentChar = chars.get(j);
                if (substringChars.add(currentChar)) {
                    stringBuilder.append(currentChar);
                } else {
                    break;
                }
            }

            substring = stringBuilder.toString();
            substringMap.putIfAbsent(substring.length(), substring);
            stringBuilder.setLength(0);
            substringChars.clear();
        }

        return substringMap.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getKey))
                .orElse(Map.entry(0, ""));
    }
}
